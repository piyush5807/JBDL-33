package com.example.wallet.wallet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

@Transactional
public interface WalletRepository extends JpaRepository<Wallet, Integer> {

    Wallet findByPhoneNumber(String phoneNumber);

    @Modifying
    @Query("update Wallet w set w.balance = w.balance + ?2 where w.phoneNumber = ?1")
    void updateWallet(String phoneNumber, Double amount);


    /**
     * S -- 70 Rs
     * R -- 30 Rs
     * updateWallet(S, -10) --> 70 + (-10) = 60
     * updateWallet(R, +10) --> 30 + (+10) = 40
     */




}
