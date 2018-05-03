package step11.ex14;

public class B extends A{
    @Override
    public void m() {
        System.out.println("B의 m() 호출!");
    }
    
    
    public void x() {
        System.out.println("B에서 추가한 메서드x()");
    }

}
