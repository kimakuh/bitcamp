package bitcamp.java106.pms.domain;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Notice implements Serializable {
    private static final long serialVersionUID = 1L;

    private int no;
    private String title;
    private String content;
    private String name;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date createdDate;
    private int count;
    private String down;
    
    
   
    @Override
    public String toString() {
        return "Notice [no=" + no + ", title=" + title + ", content=" + content + ", name=" + name + ", createdDate="
                + createdDate + ", count=" + count + ", down=" + down + "]";
    }
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public String getDown() {
        return down;
    }
    public void setDown(String down) {
        this.down = down;
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
   
    
}







