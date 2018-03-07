package step03;

public class Exam03_3 {
    public static void main(String[] args){

        class Score {
            String name;
            int kor;
            int eng;
            int math;
            int sum;
            float aver;
        }

        Score s1 = new Score();
        Score s2 = s1;







        s1.name = "홍길동";


        System.out.printf("이름: %s\n", s2.name);
    }
}

