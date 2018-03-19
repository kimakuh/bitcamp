// 클래스 - 용도 
package step07;


public class Exam03_1 {
    public static void main(String[] args) {

        Score3 score = new Score3();

        // => 클래스로 만든 메모리는 레퍼런스를 통해 접근한다.
        score.name = "홍길동";
        score.kor = 100;
        score.eng = 90;
        score.math = 85;
        
        
        
        
        score.calculate();




        System.out.printf("%s, %d, %d, %d, %d, %.1f\n",
                          score.name, score.kor, score.eng, score.math, score.sum, score.average);  
    }
}

// 클래스 문법의 용도?
// 1) 사용자 정의 데이터 타입 만들 때
//    - 즉 새로운 구조의 메모리를 설계할 때 사용한다.
// 2) 메서드를 묶을 때
//    - 서로 관련된 기능을 관리하기 쉽게 묶고 싶을 때 사용한다.