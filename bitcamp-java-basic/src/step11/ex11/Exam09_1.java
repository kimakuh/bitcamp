// 오버라이딩(overriding) - 응용 예 
package step11.ex11;

public class Exam09_1 {
    
    //int i; // 인스턴스 변수
    // 인스턴스 주소가 있어야 호출가능
    
    
    static class Member {
        String name;
        int age;
        
        //생성자
        public Member(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
    }
    public static void main(String[] args) {
        // Object 클래스?
        Member m1 = new Member("홍길동", 20);
        Member m2 = new Member("홍길동", 20);
        
        if (m1 == m2) {
            System.out.println("m1==m2");
        } else {
            System.out.println("me1!=m2");
        }
        
        
        
        
        System.out.println(m1.toString());
        System.out.println(m1.equals(m2));
        System.out.println(m1.hashCode());
        
        
        
        
    }
}








