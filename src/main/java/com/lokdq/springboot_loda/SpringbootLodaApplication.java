package com.lokdq.springboot_loda;

import com.lokdq.springboot_loda.component.LokAppProperties;
import com.lokdq.springboot_loda.entity.User;
import com.lokdq.springboot_loda.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;

//nơi nó khởi tạo lần ddaaud để cài đặt mọi thứ
//các Anotation là các chú thích để cung cấp hoặc bổ sung thông tin ko ảnh hưởng đến code
@SpringBootApplication
// cách 1 : @ComponentScan chỉ kiểm tra các bean trong package này
//@ComponentScan({"com.lokdq.springboot_loda.TestAnnotation",..,..}) sử dụng nhiều package trong ngoặc {}
// cách 2 :
//@SpringBootApplication(scanBasePackages = {"com.lokdq.springboot_loda.TestAnnotation" , .., .. } )
@EnableConfigurationProperties//sử dụng khi có ComponentConfig
//CommandLineRunner giao diện springboot được sử dụng đẻ chạy khối mã chỉ 1 lần trong vòng đời của ứng dụng
// - sau khi ứng dụng được khởi tạo
public class SpringbootLodaApplication implements CommandLineRunner {

    public static void main(String[] args) {
        ApplicationContext context=SpringApplication.run(SpringbootLodaApplication.class, args);
        //***********************************************
//         I) Component AND Autowired
//
//        //Tạo một container và tiềm các dependency đưa vào
//        //ApplicationContext chứ toàn bộ dependency trong project
//        // các dependency là Bean
//        ApplicationContext context=SpringApplication.run(SpringbootLodaApplication.class, args);
//
//        // Khi chạy xong, lúc này context sẽ chứa các Bean có đánh
//        // dấu @Component.
//
//        // Lấy Bean ra bằng cách
//        Outfit outfit = context.getBean(Outfit.class);
//
//        // In ra để xem thử nó là gì
//        System.out.println("Instance: " + outfit);
//        // xài hàm wear()
//        outfit.wear();
//
//        //Girl được tạo trong appcontext
//        Girl girl=context.getBean(Girl.class);
//        System.out.println("Girl Instance: "+girl);
//        System.out.println("Girl Out: "+girl.outfit);
//        girl.outfit.wear();
        //**************************************************
//        // II) @PostConstruct and PreDestroy (Girl)
//        // ApplicationContext chính là container, chứa toàn bộ các Bean
//        System.out.println("> Trước khi IoC Container được khởi tạo");
//        ApplicationContext context=SpringApplication.run(SpringbootLodaApplication.class, args);
//        System.out.println("> Sau khi IoC Container được khởi tạo");
//
//        // Khi chạy xong, lúc này context sẽ chứa các Bean có đánh
//        // dấu @Component.
//
//        Girl girl = context.getBean(Girl.class);
//
//        System.out.println("> Trước khi IoC Container destroy Girl");
//        ((ConfigurableApplicationContext) context).getBeanFactory().destroyBean(girl);
//        System.out.println("> Sau khi IoC Container destroy Girl");
        //***************************************************
//        //III) Service & Repository
//        ApplicationContext context=SpringApplication.run(SpringbootLodaApplication.class, args);
//        // Lấy ra bean GirlService
//        NewGirlService newgirlService = context.getBean(NewGirlService.class);
//        // Lấu ra random một cô gái từ tầng service
//        NewGirl newGirl = newgirlService.getRandomGirl();
//        // In ra màn hình
//        System.out.println(newGirl);
        //****************************************************
//        //IV) Config and Bean (simpleBean)
//        ApplicationContext context=SpringApplication.run(SpringbootLodaApplication.class, args);
//        // Lấy ra bean SimpleBean trong Context
//        SimpleBean simpleBean = context.getBean(SimpleBean.class);
//        // In ra màn hình
//        System.out.println("Simple Bean Example: " + simpleBean.toString());
        //*****************************************************
//         // V) Sử dụng JPA
//
//        //lấy Bean U_R trong context
//        UserRepository userRepository=context.getBean(UserRepository.class);
//        //lấy toàn bộ user trong db
//        userRepository.findAll().forEach(System.out::println);
//        // lưu user xuống db
//        User user=userRepository.save(new User());
//        //khi lưu xong nó trả về User kèm ID
//        System.out.println("User of ID saved: "+user.getId());
//        Long userId=user.getId();
//        //cập nhật user
//        user.setAgi(100);
//        //update vào user có ID này
//
//        // Query lấy ra user vừa xong để kiểm tra xem.
//        User user2 = userRepository.findById(userId).get();
//        System.out.println("User: " + user);
//        System.out.println("User2: " + user2);
//
//        // Xóa User khỏi DB
//        userRepository.delete(user);
//
//        // In ra kiểm tra xem userId còn tồn tại trong DB không
//        User user3 = userRepository.findById(userId).orElse(null);
//        System.out.println("User3: " + user2);
    }

    //********************************************************
    // VI) @EnableConfigurationProperties và component/LokAppProperties

    //khi cần lấy các thông tin config thì sử dụng
    @Autowired
    LokAppProperties lokAppProperties;


    //sau khi implement CommandLineRunner
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Global variable:");
        System.out.println("\t Email: "+lokAppProperties.getEmail());
        System.out.println("\t GA ID: "+lokAppProperties.getGoogleAnalyticsId());
        System.out.println("\t Authors: " + lokAppProperties.getAuthors());
        System.out.println("\t Example Map: " + lokAppProperties.getExampleMap());
    }
}
