package com.lokdq.springboot_loda.TestAnnotation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Girl {
    // hãy tự inject (tiêm) một instance của Outfit,
    // vào thuộc tính này khi khởi tạo Girl.

    //Tất cả những Bean được quản lý trong ApplicationContext đều chỉ được
    // tạo ra một lần duy nhất và khi có Class yêu cầu @Autowired
    // thì nó sẽ lấy đối tượng có sẵn trong ApplicationContext để inject vào.
    @Qualifier("bikini")
    @Autowired
    Outfit outfit;
    // trường hợp có 2 bean là 2 inject cùng implement vao outfit

    public Girl(@Qualifier("bikini") Outfit outfit) {
        this.outfit = outfit;
    }

    public Outfit getOutfit() {
        return outfit;
    }

    //nếu không tìm thấy contructor thòa mã nó sẽ thông qua setter
    //@Autowired
    public void setOutfit(Outfit outfit) {
        this.outfit = outfit;
    }

    //được dánh dấu 1 method duy nhất trong Bean, App_Context sẽ goi hàm này sau khi Bean đc tạo
    @PostConstruct
    public void postConstruct(){
        System.out.println("Đối tượng sau khi khởi tạo xong sẽ chạy hàm này ");
    }

    //được đánh dấy trên 1 method và xóa hoặc ko quản lý khi Bean bị xóa
    @PreDestroy
    public void preDestroy(){
        System.out.println("Đối tượng sau khi bị destroy sẽ chạy hàm này");
    }
}
