package com.lokdq.springboot_loda.basic;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor//construct gán giá trị cho toàn bộ các biến
public class info {
    String key;
    String value;
}
