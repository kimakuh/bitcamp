// 요청 핸들러의 리턴 값 - 콘텐트를 직접 리턴하기
package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/exam06_1") 
public class Exam06_1 {
    

    @GetMapping(value="m1")  
    @ResponseBody  
    public String m1() {
        return "Exam06_1.m1()";
    }

}







