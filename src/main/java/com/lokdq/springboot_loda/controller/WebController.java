package com.lokdq.springboot_loda.controller;

import com.lokdq.springboot_loda.basic.info;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//đánh dấu là nơi nhận các request từ client,sử dụng template
@Controller
@RequestMapping("api/v1")// mục đích sử dụng rộng hơn các Get,Post,...
public class WebController {
    
    @GetMapping("/")
    public String index(){//request tới
        return "index";//trả về file index.html
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }

    @GetMapping("/hello")
    public String hello(
            //request param "name" giá trị String
            //required = false req có hoặc không
            @RequestParam(name="name",required = false,defaultValue = "")String name,
            //Model là một obj của Springboot, được gắn vào trong mọi req.
            //Model ở đây là một object được Spring Boot đính kém trong mỗi response.
            //Model chứa các thông tin mà bạn muốn trả về và Template Engine
            // sẽ trích xuất thông tin này ra thành html và đưa cho người dùng.
            Model model
    ){
            model.addAttribute("name",name);
            return "hello";// trả về file hello.html & thông tin obj Model
    }

    @GetMapping("/profile")
    public String profile(Model model){
        List<info> profile=new ArrayList<>();
        profile.add(new info("fullname","Diep Quoc Loc"));
        profile.add(new info("nickname","Lok"));

        //đưa thông tin vào Model
        model.addAttribute("lokProfile",profile);

        return "profile";
    }

    //Cần phải chỉ định method khi sử dụng RequestMapping
    // Đường dẫn lúc này là: /api/v1/addTodo và method GET
    @RequestMapping(value = "/addTodo", method = RequestMethod.GET)
    public String addTodo(Model model) {
        return "addTodo";
    }

    // Đường dẫn lúc này là: /api/v1/addTodo và method POST
//    @RequestMapping(value = "/addTodo", method = RequestMethod.POST)
//    public String addTodo(@ModelAttribute Todo todo) {
//        return "success";
//    }
}
