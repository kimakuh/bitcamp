// 요청 핸들러의 파라미터 - custom property editor 등록하기 II
package bitcamp.mvc.web;

import java.beans.PropertyEditorSupport;
import java.sql.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bitcamp.mvc.vo.Member;

@Controller 
@RequestMapping("/exam05_5") 
public class Exam05_5 {
    
    // 프론트 컨트롤러가 페이지 컨트롤러를 호출할 때 기본적으로 
    // 클라이언트가 보낸 문자열 데이터를 primitive type의 값으로 변환시켜 준다. 
    // 그 외의 타입에 대해서는 개발자가 프로퍼티 값 변환기(property editor)를 등록해야 한다.
    // 테스트:
    // http://localhost:8888/java106-spring-webmvc/mvc/exam05_4/m1?title=aaa&content=bbb&createdDate=2018-06-04
    @GetMapping(value="m1")  
    @ResponseBody  
    public String m1(String title, String content, Date createdDate) {
        return String.format("m1(): %s,%s,%s", title, content, createdDate);
    }
    /*
    @InitBinder 
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(
                java.sql.Date.class, 
                new PropertyEditorSupport() {
                    @Override
                    public void setAsText(String text) throws IllegalArgumentException {
                        this.setValue(Date.valueOf(text));
                    }
                });
    }
    */
}
