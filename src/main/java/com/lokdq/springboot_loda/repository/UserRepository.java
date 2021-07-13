package com.lokdq.springboot_loda.repository;


import com.lokdq.springboot_loda.dto.UserDTO;
import com.lokdq.springboot_loda.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//sử dụng JpaRepository
@Repository// đây là 1 Bean giao tiếp với DB
public interface UserRepository extends JpaRepository<User,Long> {
    UserDTO findUserById(Long id);

    // Khi được gắn @Query, thì tên của method không còn tác dụng nữa
    // Đây là JPQL
    //Cách truyền tham số là gọi theo thứ tự các tham số của method bên dưới ?1, ?2
    // có thể thay ?1 bằng các tham số :id
    @Query("select u from User u where u.id= ?1")
    UserDTO CustomFindUserByID(Long id);

    // Đây là Native SQL
    @Query(value = "select * from User u where u.email_address = ?1", nativeQuery = true)
    UserDTO CustomFindUserByID2(Long id);
}
