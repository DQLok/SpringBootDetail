package com.lokdq.springboot_loda.TestAnnotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// là một Annotation đánh dấu trên một Class
// cho phép Spring Boot biết được đây là nơi định nghĩa ra các Bean.
// sau Component thì sẽ tìm tới Configuration và các method Bean để lấy các Bean đưa và context
@Configuration
public class AppConfig {

    // Lấy giá trị config từ file application.properties
    @Value("${loda.mysql.url}")
    String mysqlUrl;

    //@Bean là một Annotation được đánh dấu trên các method cho phép
    // Spring Boot biết được đây là Bean và sẽ thực hiện
    // đưa Bean này vào Context.
    //
    //@Bean sẽ nằm trong các class có đánh dấu @Configuration
    //biến SimpleBean là class java thành một Component
    @Bean
    SimpleBean simpleBeanConfigure(){
        // Khởi tạo một instance của SimpleBean và trả ra ngoài
        return new SimpleBean("loda");
    }

    //Note sử dụng Configuration và Bean để custom các Bean
    // thay vì sử dụng Component đối với các logic phức tạp



}
