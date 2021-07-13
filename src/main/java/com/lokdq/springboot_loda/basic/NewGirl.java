package com.lokdq.springboot_loda.basic;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class NewGirl {
    private String name;

    public NewGirl(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "NewGirl{" +
                "name='" + name + '\'' +
                '}';
    }
}
