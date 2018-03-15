package bitcamp.java106.pms;


import bitcamp.java106.pms.domain.Team;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);

        
        Team[] teams = new Team[1000];
        int teamIndex = 0;


        while (true) {
            System.out.print("Command > ");
            String[] arr = keyScan.nextLine().toLowerCase().split(" ");
            // 입력 받은 문자열을 공백으로 잘라서 명령과 검색어로 구부한다.
            String menu = arr[0];

            if (menu.toLowerCase().equals("quit")) {
                System.out.println("시스템 종료");
                break;
            } else if (menu.equals("help")) {
                System.out.println("팀 등록 명령 : team/add");
                System.out.println("팀 조회 명령 : team/list");
                System.out.println("팀 상세조회 명령 : team/view 팀명");
                System.out.println("회원 등록 명령 : member/add");
                System.out.println("회원 조회 명령 : member/list");
                System.out.println("회원 상세조회 명령 : member/view 아이디");
                System.out.println("종료 : quit");
                System.out.println(); 
                System.out.println(input);  
                continue;                       
            } else if (menu.equals("team/add")) {
                System.out.println("[팀 정보 입력]");
                // 팀 정보를 받을 메모리 준비
                Team team = new Team();
                System.out.print("팀명? ");
                team.name = keyScan.nextLine();
        
                System.out.print("설명? ");
                team.description = keyScan.nextLine();
        
                System.out.print("최대인원? ");
                team.maxQty = keyScan.nextInt();
                keyScan.nextLine();
                
                System.out.print("시작일? ");
                team.startDate = keyScan.nextLine();
        
                System.out.print("종료일? ");
                team.endDate = keyScan.nextLine();    
                
                
                  // 팀 정보가 담겨있는 객체의 주소를 배열에 보관한다.
                  teams[teamIndex++] = team;              
                
                  System.out.println();  
                  continue;

            } else if (menu.equals("team/list")) {
                System.out.println("[팀 목록]");
                    for (int i = 0; i < teamIndex; i++) {
                        System.out.printf("%s, %d명, %s ~ %s\n", 
                        team.name, team.maxQty, team.startDate, team.endDate);
                    }
                    System.out.println();  
                    continue;
            } else if (input.equals("team/view")) {

            }
                System.out.println(menu);
            }
    }
}