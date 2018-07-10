package bitcamp.java106.pms.web.json;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import bitcamp.java106.pms.domain.Notice;
import bitcamp.java106.pms.service.NoticeService;

@RestController
@RequestMapping("/notice")
public class NoticeController {
    
    NoticeService noticeService;
    
    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @RequestMapping("add")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(Notice notice) throws Exception {
        noticeService.add(notice);
    }
    
    @RequestMapping("delete")
    //@ResponseStatus(HttpStatus.OK) // ?��?�� ?��?�� 코드 값의 기본?? "200(OK)" ?��?��.
    public void delete(@RequestParam("no") int no) throws Exception {
        noticeService.delete(no);
    }
    
    @RequestMapping("list{page}")
    public Object list(
            @MatrixVariable(defaultValue="1") int pageNo,
            @MatrixVariable(defaultValue="3") int pageSize) {        
        return noticeService.list(pageNo, pageSize);
    }
    
    @RequestMapping("update")
    @ResponseStatus(HttpStatus.OK) // 기본 값이 OK ?��?��. 
    public void update(Notice notice) throws Exception {
        noticeService.update(notice);
    }
    
    @RequestMapping("{no}")
    public Notice view(@PathVariable int no) throws Exception {
        return noticeService.get(no);
    }

}








