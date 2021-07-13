package com.lokdq.springboot_loda.TestAnnotation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@Primary
@Qualifier("naked")// nếu không sủ dụng @primary thì sử dụng @qualifier
public class Naked implements Outfit{
    @Override
    public void wear() {
        System.out.println("Đang ko mặc gì");
    }
}
