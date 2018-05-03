// 게시물 관리 - 목록 + PreparedStatement
package step25.ex2;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Exam05_list {

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        java.sql.Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false", "java106", "1111");
        // 당장 select 할 때 파라미터 값을 넣지 않는다 하더라도,
        // 나중에 넣을 것을 대비해서 그냥 PreparedStatement를 사용하라!
        PreparedStatement stmt = con.prepareStatement("select cno,titl,startd,endd,room from ex_classroom");

        // SQL을 실행할 때는 파라미터로 SQL문을 넘겨주지 않는다.
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            System.out.printf("%d,%s,%s,%s,%s\n", rs.getInt("cno"), rs.getString("titl"), 
                    rs.getDate("startd"), rs.getDate("endd"),rs.getString("room"));
        }

        rs.close();
        stmt.close();
        con.close();
    }
}
