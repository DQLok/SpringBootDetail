package com.lokdq.springboot_loda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

//nơi nó khởi tạo lần ddaaud để cài đặt mọi thứ
//các Anotation là các chú thích để cung cấp hoặc bổ sung thông tin ko ảnh hưởng đến code
@SpringBootApplication
public class SpringbootLodaApplication {

    public static void main(String[] args) {
        //Tạo một container và tiềm các dependency đưa vào
        //ApplicationContext chứ toàn bộ dependency trong project
        // các dependency là Bean
        ApplicationContext context=SpringApplication.run(SpringbootLodaApplication.class, args);

        // Khi chạy xong, lúc này context sẽ chứa các Bean có đánh
        // dấu @Component.

        // Lấy Bean ra bằng cách
        Outfit outfit = context.getBean(Outfit.class);

        // In ra để xem thử nó là gì
        System.out.println("Instance: " + outfit);
        // xài hàm wear()
        outfit.wear();
        
        //Girl được tạo trong appcontext
        Girl girl=context.getBean(Girl.class);
        System.out.println("Girl Instance: "+girl);
        System.out.println("Girl Out: "+girl.outfit);
        girl.outfit.wear();
    }

}
