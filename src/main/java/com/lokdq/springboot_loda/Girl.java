package com.lokdq.springboot_loda;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

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

}
