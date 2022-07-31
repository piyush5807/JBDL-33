package com.example.minor1.services;

import com.example.minor1.models.MyUser;
import com.example.minor1.repositories.MyUserCacheRepository;
import com.example.minor1.repositories.MyUserRepository;
import com.example.minor1.request.UserCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class MyUserDetailsService implements UserDetailsService {

    // 1. GET data from cache
    // 2. If not found, fetch from db
    // 3. If found from db, insert in cache again
    // 4. Return the data to the client

    @Autowired
    MyUserCacheRepository myUserCacheRepository;

    @Autowired
    MyUserRepository myUserRepository;

    @Value("${users.student.authority}")
    String studentAuthority;

    @Value("${users.admin.authority}")
    String adminAuthority;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        MyUser myUser = myUserCacheRepository.get(username);
        if(myUser == null){
            myUser = myUserRepository.findByUsername(username);
            if(myUser != null){
                myUserCacheRepository.set(myUser); // This call can be made parallel or async
            }
        }

        return myUser;
    }

    public MyUser createUser(UserCreateRequest userCreateRequest){

        MyUser.MyUserBuilder myUserBuilder = MyUser.builder()
                .username(userCreateRequest.getUsername())
                .password(passwordEncoder.encode(userCreateRequest.getPassword()));

        if(userCreateRequest.getStudent() != null){
            myUserBuilder.authority(studentAuthority);
        }else{
            myUserBuilder.authority(adminAuthority);
        }

        return myUserRepository.save(myUserBuilder.build());
    }
}
