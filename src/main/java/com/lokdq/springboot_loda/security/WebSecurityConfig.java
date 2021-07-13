package com.lokdq.springboot_loda.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

//gắn vào 1 bean để xác nhận đây là nơi xử lý các thông tin security
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    // tạo user ngay tại code or có thể lưu ở csdl

    //WebSecurityConfigurerAdapter là interface giúp String Secirity các đặt thông tin

    //UserDetailsService công cấp thông tin tạo user override method
    @Bean
    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        // Tạo ra user trong bộ nhớ
        // lưu ý, chỉ sử dụng cách này để minh họa
        // Còn thực tế chúng ta sẽ kiểm tra user trong csdl
        InMemoryUserDetailsManager manager=new InMemoryUserDetailsManager();
        manager.createUser(
                User.withDefaultPasswordEncoder()//mã hóa pass đơn giản
                .username("lok")
                .password("lok")
                .roles("USER")
                .build()
        );
        return manager;
    }

    //Lúc này, vẫn ở trong WebSecurityConfigurerAdapter, chúng ta override lại method
    // protected void configure(HttpSecurity http) để thực hiện việc phân quyền.
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/home").permitAll() // Cho phép tất cả mọi người truy cập vào 2 địa chỉ này
                .anyRequest().authenticated() // Tất cả các request khác đều cần phải xác thực mới được truy cập
                .and()
                .formLogin() // Cho phép người dùng xác thực bằng form login
                .defaultSuccessUrl("/hello")
                .permitAll() // Tất cả đều được truy cập vào địa chỉ này
                .and()
                .logout() // Cho phép logout
                .permitAll();
    }
    //HttpSecurity là obj cho phép cấu hình
    //cho phép .permit(), cấm or yêu cầu xác thực thì .authenticated()
    //.formLogin đăng nhập thông qua /login đây là mặc định có thể custom
    //.logout dùng để logout /logout


    //***************************************************
    // sử dụng khi User được lưu ở DB
//    @Autowired
//    UserService userService;
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        // Password encoder, để Spring Security sử dụng mã hóa mật khẩu người dùng
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth)
//            throws Exception {
//        auth.userDetailsService(userService) // Cung cáp userservice cho spring security
//                .passwordEncoder(passwordEncoder()); // cung cấp password encoder
//    }






}
