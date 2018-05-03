package step22.ex3;

import java.io.FileOutputStream;

// 데이터 출력 int값 출력
public class Exam01_3 {
    public static void main(String[] args) throws Exception {
        // 1) 파일로 데이터를 출력하는 객체를 준비한다.
        FileOutputStream out = new FileOutputStream("temp/test3.data");

        int money = 1_3456_7890; // = 0x8057d2

        long money2 = 400_0000_0000_0000L; // 0x016bccc41e90000

        out.write(money >> 24);
        out.write(money >> 16);
        out.write(money >> 8);
        out.write(money);
        
        
        out.write((int) (money2 >> 56));
        out.write((int) (money2 >> 48));
        out.write((int) (money2 >> 40));
        out.write((int) (money2 >> 32));
        out.write((int) (money2 >> 24));
        out.write((int) (money2 >> 16));
        out.write((int) (money2 >> 8));
        out.write((int) money2);

        // 3) 출력 도구를 닫는다.
        // => 항상 입출력 도구를 사용한 후 닫아야 한다.
        // => 어떤 입출력 도구는 닫지 않으면 버퍼(임시메모리)에 남아있는 데이터가
        // 출력되지 않고 버려진다.

        out.close();
        System.out.println("데이터 출력 완료!");

    }
}
