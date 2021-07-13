package com.lokdq.springboot_loda.basic.service;

import com.lokdq.springboot_loda.basic.NewGirl;
import com.lokdq.springboot_loda.basic.repository.NewGirlRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewGirlService {

    @Autowired
    private NewGirlRepository newGirlRepository;

    public NewGirl getRandomGirl(){
        String name=radomNewGirlName(10);
        return newGirlRepository.getGirlByName(name);
    }

    public String radomNewGirlName (int length){
        //org.apache.commons
        return RandomStringUtils.randomAlphanumeric(length).toLowerCase();
    }
}
