// 요청 핸들러의 파라미터 - custom property editor 등록하기 II
package bitcamp.mvc.web;

import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/exam05_8")
public class Exam05_8 {

    @GetMapping(value = "m1", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String m1(HttpServletResponse response) {
        try {
            Cookie c1 = new Cookie("name", URLEncoder.encode("홍길동", "UTF-8"));
            Cookie c2 = new Cookie("age", "20");

            response.addCookie(c1);
            response.addCookie(c2);
            
            return "쿠키값보냄";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping(value = "m2",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String m2(@CookieValue(value = "name", defaultValue = "") Cookie name,
            @CookieValue(value = "age", defaultValue = "0") int age) {
        try {
            System.out.println(name.getValue());
            return String.format("m2(): name =%s, age=%d", URLDecoder.decode(name.getValue(), "UTF-8"), age);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
