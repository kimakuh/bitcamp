// 버퍼 사용 전 - 파일 복사 및 시간 측정
package step22.ex5;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Exam02_test1 {

    public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream("temp/jls8.pdf");
        FileOutputStream out = new FileOutputStream("temp/jls8_2_test.pdf");

        int data;
        
        long startTime = System.currentTimeMillis(); // 밀리초
        
        while ((data = in.read()) != -1) {
            out.write(data);
        }; // 파일을 끝까지 읽는다.

        long endTime = System.currentTimeMillis();

        System.out.println(endTime - startTime);
        System.out.println("File is copied successful!");
        
        in.close();
    }

}
