package com.lokdq.springboot_loda.controller;

import com.lokdq.springboot_loda.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController//sử dụng gửi nhận API, mặc định dùng Jac
@RequestMapping("/api/v1")
public class ApiController {

    @GetMapping("/todo")
    public List<User> getUserList(){
        return new ArrayList<User>();//chuyển toàn bộ sang Json
    }

    List<User> userList = new CopyOnWriteArrayList<>();

    //@ResponseEntity của Spring cung cấp
    //cha của mọi respone của các obj trả về

    //@RequestBody thông qua springboot chuyển Json trong req thành obj java
    @PostMapping("/todo")
    public ResponseEntity addTodo(@RequestBody User user) {
        userList.add(user);
        // Trả về response với STATUS CODE = 200 (OK)
        // Body sẽ chứa thông tin về đối tượng todo vừa được tạo.
        return ResponseEntity.ok().body(user);
    }

    /*
    phần path URL bạn muốn lấy thông tin sẽ để trong ngoặc kép {}
     */
    @GetMapping("/user/{userId}")
    public User getUser(@PathVariable(name = "userId") Integer userId){
        // @PathVariable lấy ra thông tin trong URL
        // dựa vào tên của thuộc tính đã định nghĩa trong ngoặc kép /user/{userId}
        return userList.get(userId);
    }
}
