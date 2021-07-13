package com.lokdq.springboot_loda;

import com.lokdq.springboot_loda.controller.ApiController;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
// Bạn cần cung cấp lớp Controller cho @WebMvcTest
@WebMvcTest(ApiController.class)//test controller ko cần khởi động tomcat
public class ControllerTest {
    /**
     * Đối tượng MockMvc do Spring cung cấp
     * Có tác dụng giả lập request, thay thế việc khởi động Server
     */
    @Autowired
    private MockMvc mvc;
}
