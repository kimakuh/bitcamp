package step07;

//사용자 정의 데이터 타입
//=> 학생 데이터를 담을 새로운 구조의 메모리를 설계한다.
public class Score3 {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float average;
    
    
    public void calculate() {     
        this.sum = this.kor + this.eng + this.math;
        this.average = this.sum / 3f;        
        
    }
    
    
    
}
