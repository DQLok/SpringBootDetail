package com.lokdq.springboot_loda.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private int hp;
    private int stamina;
    private int atk;
    private int def;
    private int agi;
}
