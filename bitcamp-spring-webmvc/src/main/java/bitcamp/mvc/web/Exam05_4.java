// 요청 핸들러의 파라미터 - 클라이언트가 보낸 데이터를 객체로 받기
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
@RequestMapping("/exam05_4")
public class Exam05_4 {

    // 프론트 컨트롤러로부터 클라이언트가 보낸 값들을 객체에 담아서 받을 수 있다.
    @GetMapping(value = "m1")
    @ResponseBody
    public String m1(Date startDate, Date endDate) {
        return String.format("m1(): %s ~ %s", startDate, endDate);
    }
    
    
    
    @GetMapping(value = "m2")
    @ResponseBody
    public String m2(@RequestParam Member member) {
        return String.format("m2(): id");
    }
    
    // java.lang.String ==> java.sql.Date 변환시켜주는 프로퍼니 에디터 등록
    @InitBinder
    public void 오호라(WebDataBinder binder) {
        System.out.println("Exam05_4().오호라()");
        binder.registerCustomEditor(java.sql.Date.class, new PropertyEditorSupport() {

            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                this.setValue(Date.valueOf(text));
            }
        });
        
        
        
        binder.registerCustomEditor(bitcamp.mvc.vo.Member.class, new PropertyEditorSupport() {

            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                String[] values = text.split(",");
                Member obj = new Member();
                obj.setId(values[0]);
                obj.setEmail(values[1]);
                obj.setPassword(values[2]);
               this.setValue(obj);
            }
        });
        
        
        
        
    }

}
