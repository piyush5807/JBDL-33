package com.example.demospring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OtherClassImpl implements OtherClass{
    private static Logger logger = LoggerFactory.getLogger(OtherClass.class);
    @Override
    public int add(int a, int b) {
        logger.info("Adding a and b {}, {}", a, b);
        return a + b;
    }
}
