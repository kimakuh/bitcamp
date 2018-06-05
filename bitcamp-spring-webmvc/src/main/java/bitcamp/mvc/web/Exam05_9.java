// 요청 핸들러의 파라미터 - custom property editor 등록하기 II
package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/exam05_9")
public class Exam05_9 {

    // 클라이언트로부터 한 통으로 된 값을 받을 때
    // @RequestBody를 사용한다.

    @PostMapping(value = "post")
    @ResponseBody
    public String m1(String name, int age, String tel) {
        return String.format("m1(): name =s, age=%d , tel=%s", name, age, tel);
    }

    @PostMapping(value = "post", consumes = "text/plain")
    @ResponseBody
    public String m2(String name, @RequestParam(defaultValue="0") int age, String tel) {
        return String.format("m2(): %s", name);
    }

    @PostMapping(value = "post", consumes = "text/json")
    @ResponseBody
    public String m3() {
        return String.format("m3()");
    }

    @PostMapping(value = "post", consumes = "application/json")
    @ResponseBody
    public String m4() {
        return String.format("m4()");
    }

}
