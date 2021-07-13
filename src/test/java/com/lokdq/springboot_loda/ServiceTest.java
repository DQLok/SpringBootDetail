package com.lokdq.springboot_loda;

import com.lokdq.springboot_loda.basic.NewGirl;
import com.lokdq.springboot_loda.basic.service.NewGirlService;
import com.lokdq.springboot_loda.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {
    /**
     * Cách này sử dụng @SpringBootTest
     * Nó sẽ load toàn bộ Bean trong app của bạn lên,
     * Giống với việc chạy App.java vậy
     */

    /**
     * Đối tượng UserRepository sẽ được mock, chứ không phải bean trong context
     */
    @MockBean
    UserRepository userRepository;

    @Autowired // inject bean vào một context test riêng
    private NewGirlService newGirlService;

//    @Before
//    public void setUp() {
//        Mockito.when(userRepository.findAll())
//                .thenReturn(IntStream.range(0, 10)
//                        .mapToObj(new NewGirl())
//                        .collect(Collectors.toList()));
//
//
//    }

    @Test
    public void testCount() {
        Assert.assertEquals(10, newGirlService.getRandomGirl());
    }

    /**
     * Cách này sử dụng @TestConfiguration
     * Nó chỉ tạo ra Bean trong Context test này mà thôi
     * Tiết kiệm thời gian hơn khi sử dụng @SpringBootTest (vì phải load hết Bean lên mà không dùng đến)
     */
    @TestConfiguration
    public static class TodoServiceTest2Configuration{

        /*
        Tạo ra trong Context một Bean TodoService
         */
        @Bean
        NewGirlService newGirlService(){
            return new NewGirlService();
        }
    }
}
