package com.vito16.shop.test.service;

import com.google.common.util.concurrent.RateLimiter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * @author 木鱼 muyu@yiji.com
 * @version 2017/12/25
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class VitoTest {


    @Test
    public void t1(){
        RateLimiter limiter = RateLimiter.create(100);

        System.out.println(limiter.acquire(10));
        System.out.println(limiter.acquire(20));
        System.out.println(limiter.acquire(30));
    }
}
