
package bitcamp.java106.pms.service;

import java.util.List;

import bitcamp.java106.pms.domain.Notice;

public interface NoticeService {

    List<Notice> list(int pageNo, int pageSize);
    Notice get(int no);
    int add(Notice notice);
    int update(Notice notice);
    int delete(int no);
}









