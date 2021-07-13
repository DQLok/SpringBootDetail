package com.lokdq.springboot_loda.basic.repository.imp;

import com.lokdq.springboot_loda.basic.NewGirl;
import com.lokdq.springboot_loda.basic.repository.NewGirlRepository;
import org.springframework.stereotype.Repository;

//giao tiếp với DB
@Repository
public class NewGirlRepositoryImpl implements NewGirlRepository {

    @Override
    public NewGirl getGirlByName(String name) {
        return new NewGirl(name);
    }
}
