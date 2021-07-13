package com.lokdq.springboot_loda.basic.repository;

import com.lokdq.springboot_loda.basic.NewGirl;


public interface NewGirlRepository {
    NewGirl getGirlByName(String name);
}
