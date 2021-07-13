package com.lokdq.springboot_loda.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

//xen vào xử lý của @RestController
@RestControllerAdvice//Thường được kết hợp với @ExceptionHandler
public class ApiExceptionHandler {

    /**
     * Tất cả các Exception không được khai báo sẽ được xử lý tại đây
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessages handleAllException(Exception ex, WebRequest request) {
        // quá trình kiểm soat lỗi diễn ra ở đây
        return new ErrorMessages(10000, ex.getLocalizedMessage());
    }

    /**
     * IndexOutOfBoundsException sẽ được xử lý riêng tại đây
     */

    //Controller đang hoạt động ném Exception thì sử dụng @Exce và @Rest
    //đón và xử lý trả về thông tin cụ thể
    @ExceptionHandler(IndexOutOfBoundsException.class)
    //@ResponStatus là định nghĩa Status trả về người dùng
    //không dùng ResponseEntity thì có thể dùng @ResponStatus để đánh dấu obj trả về
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessages UserException(Exception ex, WebRequest request){
        return new ErrorMessages(10100,"Đối tượng không tồn tại");
    }
}
