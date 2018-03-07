package bitcamp.java106.pms;

class TeamInfo {
    String teamName;
    String description;
    int maxQty;
    String startDate;
    String endDate;
    String bool;
}

public class App {

    public static void main(String[] args) {

        java.util.Scanner keyScan = new java.util.Scanner(System.in);

        
        TeamInfo[] teaminfo = new TeamInfo[5];

        // 입력 값을 저장할 Score 메모리를 준비한다.
        for (int i = 0; i < teaminfo.length; i++) {
            teaminfo[i] = new TeamInfo();

            System.out.print("팀명? ");
            teaminfo[i].teamName = keyScan.nextLine();
    
            System.out.print("설명? ");
            teaminfo[i].description = keyScan.nextLine();
    
            System.out.print("최대인원? ");
            teaminfo[i].maxQty = keyScan.nextInt();
            keyScan.nextLine(); // 숫자 뒤에 줄바꿈 코드를 읽는다.
                                // 읽고 난 뒤에 아무것도 안하기 때문에 
                                // 일종의 줄바꿈 코드를 제거하는 효과가 있다.
    
            System.out.print("시작일? ");
            teaminfo[i].startDate = keyScan.nextLine();
    
            System.out.print("종료일? ");
            teaminfo[i].endDate = keyScan.nextLine();

            System.out.print("계속 입력하시겠습니까?(Y/N)");
            teaminfo[i].bool = keyScan.nextLine();
            if (teaminfo[i].bool == "Y"){
                System.out.println("--------------------------------");

           
                System.out.printf("%s %s %3d %s %s\n", 
                teaminfo[i].teamName, teaminfo[i].description, teaminfo[i].maxQty, 
                teaminfo[i].startDate, teaminfo[i].endDate);
                
            }else{
                System.out.println("--------------------------------");

           
                    System.out.printf("%s %s %3d %s %s\n", 
                    teaminfo[i].teamName, teaminfo[i].description, teaminfo[i].maxQty, 
                    teaminfo[i].startDate, teaminfo[i].endDate);
                     
            }
            keyScan.nextLine();

        }
        
        // System.out.println("--------------------------------");

        // for (int i = 0; i < teaminfo.length; i++) {
        //     System.out.printf("%s %3d %3d %3d %3d %5.1f\n", 
        //     teaminfo[i].teamName, teaminfo[i].description, teaminfo[i].maxQty, 
        //     teaminfo[i].startDate, teaminfo[i].endDate);
        // }






    }
}