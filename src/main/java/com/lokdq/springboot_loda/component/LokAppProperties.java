package com.lokdq.springboot_loda.component;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

//ứng dụng có 1 số giá trị toàn cục thì sẽ lưu ở đây khi cần thay đổi
//sử dụng @EnableConfigurationProperties ở Main
@Data
@Component//tạo ra 1 spring bean

//@PropertySources("classpath:lok.yml")//đánh dấu để lấy config từ trong file lok.yml, nếu ko có thì sử dụng file mặc định classpath:application.yml

        @ConfigurationProperties(prefix = "lok")//chỉ lấy các config có tiền tố là "lok"
//@ConfigurationProperties đánh dấu class là 1 properties, các field sẽ dc nạp khi Spring khởi tạo

//Bean này Spring chỉ khởi tạo và quản lý khi môi trường là `local`
@Profile("local")//!local là khác local
public class LokAppProperties {
    private String email;
    private String googleAnalyticsId;
    //spring sẽ tìm các setter là chủ yếu

    //có thể config thêm thuộc tính list,map hay class khác
    //Nested properties
    private List<String> authors;
    private Map<String, String> exampleMap;
}
