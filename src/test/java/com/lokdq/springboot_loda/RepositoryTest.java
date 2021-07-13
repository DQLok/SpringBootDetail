package com.lokdq.springboot_loda;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

//test kết nối vs DB thông qua DataJpaTest
@RunWith(SpringRunner.class)
/**
 * Khi đánh dấu một class là @DataJpaTest.
 * Spring Boot sẽ load lên tất cả các Bean có liên quan tới tầng Repository
 * Thay vì load hết tất cả Bean như là @SpringBootTest
 */
@DataJpaTest//tạo ra các bean của repository
public class RepositoryTest {
//    @Autowired
//    private DataSource dataSource;
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//    @Autowired
//    private EntityManager entityManager;
//    @Autowired
//    private TodoRepository todoRepository;
//
//    @Test
//    public void allComponentAreNotNull() {
//        Assertions.assertThat(dataSource).isNotNull();
//        Assertions.assertThat(jdbcTemplate).isNotNull();
//        Assertions.assertThat(entityManager).isNotNull();
//        Assertions.assertThat(todoReposi

    //fake dữ liệu bằng tự insert = repository
//    @Test
//    public void testTodoRepositoryByCode() {
//        todoRepository.save(new Todo(0, "Todo-1", "Detail-1"));
//        todoRepository.save(new Todo(0, "Todo-2", "Detail-2"));
//    }

    //Một cách làm hay hơn để chuẩn bị dữ liệu cho Test đó là
    // sử dụng annotation @Sql

    //@Sql có tác dụng load một hoặc nhiều file scripts
    // sql lên và thực thi.
    @Test
    @Sql("/createTodo.sql")// trong ngoặc là 1 fle sql chứ các câu lệnh
    public void testTodoRepositoryBySqlSchema() {}
}
