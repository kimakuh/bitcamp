// 게시판 관리 - 등록 + PreparedStatement 사용
package step25.ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Exam04_insert {

    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        // 사용자로부터 제목, 내용을 입력 받는다.
        System.out.print("팀이름? ");
        String name = keyScan.nextLine();

        System.out.print("설명? ");
        String description = keyScan.nextLine();

        System.out.print("구성인원? ");
        int maxQty = keyScan.nextInt();
        keyScan.nextLine(); 
        
        System.out.print("시작일? ");
        String startDate = keyScan.nextLine();

        System.out.print("종료일? ");
        String endDate = keyScan.nextLine();

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false", "java106", "1111");

        // 값이 들어갈 자리에 in-parameter(?)를 지정한다.
        // => 데이터 타입에 상관없이 ?를 넣는다.
        PreparedStatement stmt = con.prepareStatement("insert into ex_team(name,des,max,startd,endd) values(?,?,?,?,?)");

        // in-parameter에 값을 설정한다.
        // => 설정하는 순서는 상관없다. 하지만 유지보수를 위해 순서대로 나열하라!
        stmt.setString(1, name);
        stmt.setString(2, description);
        stmt.setInt(3, maxQty);
        stmt.setString(4, startDate);
        stmt.setString(5, endDate);

        // 실행할 때는 SQL문을 파라미터로 넘길 필요가 없다.
        int count = stmt.executeUpdate();
        System.out.printf("%d 개 입력 성공!", count);

        stmt.close();
        con.close();
        keyScan.close();
    }
}
