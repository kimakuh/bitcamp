package bitcamp.java106.pms;


import bitcamp.java106.pms.*;


public class App {
    public static void main(String[] args) {

        java.util.Scanner keyScan = new java.util.Scanner(System.in);

        

        // Score 메모리(인스턴스)의 주소를 저장할 변수: 레퍼런스 준비
        TeamInfo[] teaminfo = new TeamInfo[5];

        // 입력 값을 저장할 Score 메모리를 준비한다.
        for (int i = 0; i < teaminfo.length; i++) {
            teaminfo[i] = new TeamInfo();

            System.out.print("입력: ");
            teaminfo[i].teamName = keyScan.next();
            teaminfo[i].description = keyScan.nextInt();
            teaminfo[i].maxQty = keyScan.nextInt();
            teaminfo[i].startDate = keyScan.nextInt();
            teaminfo[i].endDate = keyScan.nextInt();

        }
        
        System.out.println("--------------------------------");

        for (int i = 0; i < teaminfo.length; i++) {
            System.out.printf("%s %3d %3d %3d %3d %5.1f\n", 
            teaminfo[i].teamName, teaminfo[i].description, teaminfo[i].maxQty, 
            teaminfo[i].startDate, teaminfo[i].endDate);
        }

    }
}