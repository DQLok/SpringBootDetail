package com.lokdq.springboot_loda.TestAnnotation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*
 Đánh dấu class bằng @Component
 Class này sẽ được Spring Boot hiểu là một Bean (hoặc dependency)
 Và sẽ được Spring Boot quản lý
*/
//Trong trường hợp bạn muốn mỗi lần sử dụng là một instance(vd book: sach giao kho, sach tham khao) hoàn toàn mới.
// Thì hãy đánh dấu @Component đó bằng @Scope("prototype")
@Component
@Scope("prototype")
//@Primary//đánh dấu sự ưu tiên khi có 2 bean là 2 inject implement vào outfit
@Qualifier("bikini")
public class Bikini implements Outfit{
    @Override
    public void wear() {
        System.out.println("Mặc bikini");
    }
}
