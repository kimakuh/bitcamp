// 요청 핸들러의 파라미터 - custom property editor 등록하기 II
package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/exam05_6")
public class Exam05_6 {

    // @RequestHeader("헤더명") 을 사용하면 HTTP
    @GetMapping(value = "m1")
    @ResponseBody
    public String m1(@RequestHeader("User-Agent") String userAgent,
            @RequestHeader(required = false, value = "Content-Type") String contentType,
            @RequestHeader("Accept") String accept) {

        return String.format("m1(): \n%s,%s\n,%s\n", userAgent, contentType, accept);
    }

}
