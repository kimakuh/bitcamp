package step03.assignment;

public class Test_01_01 {
    public static void main(String[] args){
        
        class Info {
            String name;
            int kor;
            int eng;
            int math;
            int sum;
            float aver;                   
        }
        
        Info[] arr = new Info[3];

            arr[0] = new Info();
            arr[1] = new Info();
            arr[2] = new Info();

            java.io.InputStream keyboard = System.in;
            java.util.Scanner keyScan = new java.util.Scanner(keyboard);

            for (int i = 0; i < 3; i++) {
                System.out.print("입력? "); // ex) 입력? 홍길동 100 90 80

                arr[i].name = keyScan.next();
                arr[i].kor = keyScan.nextInt();
                arr[i].eng = keyScan.nextInt();
                arr[i].math = keyScan.nextInt();
            
                arr[i].sum = arr[i].kor + arr[i].eng + arr[i].math;
                arr[i].aver = arr[i].sum / 3;
            }
    
            System.out.println("------------------------------");
            for (int i = 0; i < 3; i++) {
                System.out.printf("%s %d %d %d %d %.1f\n", 
                arr[i].name, arr[i].kor, arr[i].eng, arr[i].math, arr[i].sum, arr[i].aver);
            } 
    }
}