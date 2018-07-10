package bitcamp.java106.pms.dao;

import java.util.List;
import java.util.Map;

import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.domain.Notice;

public interface NoticeDao {
    int delete(int no) ;
    List<Notice> selectList(Map<String,Object> params);
    int insert(Notice notice);
    int update(Notice notice);
    Notice selectOne(int no);
}




