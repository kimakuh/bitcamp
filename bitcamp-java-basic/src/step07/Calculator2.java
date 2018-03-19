package step07;

//메서드 분류
//=> 관련된 기능을 수행하는 메서드를 한 그룹으로 묶는다.
public class Calculator2 {
    
    static int result;

    public static void plus(int value) {
        result += value;
    }
    public static void minus(int value) {
        result -= value;
    }  
    public static void multiple(int value) {
        result *= value;
    }     
    public static void divide(int value) {
        result /= value;
    }        
    
//    
//    public static int plus(int a, int b) {return a + b;}
//    public static int minus(int a, int b) {return a - b;}
//    public static int multiple(int a, int b) {return a * b;}
//    public static int divide(int a, int b) {return a / b;}
}
