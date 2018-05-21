// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.servlet.teammember;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.servlet.InitServlet;

@WebServlet("/team/member/list")
public class TeamMemberListServlet extends HttpServlet {


    private static final long serialVersionUID = 1L;
    TeamMemberDao teamMemberDao;
    
    @Override
    public void init() throws ServletException {
        teamMemberDao = InitServlet.getApplicationContext().getBean(TeamMemberDao.class);
    }
    
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {

        
        // including 이전 서블릿에서 문자셋을 지정할 것이고
        // 이미 getParameter()를 호출했을 것이기 때문에 다음 코드는 의미가 없다.
        // request.setCharacterEncoding("UTF-8");
        
        String name = request.getParameter("name");
        
        
        
        
        
        // response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>팀 보기</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>팀 보기</h1>");
        
        try {
 
            
            List<Member> members = teamMemberDao.selectListWithEmail(name);
            
            out.println("<h2>회원 목록</h2>");
            out.println("<form action='member/add' method='post'>");
            out.println("<input type='text' name='memberId' placeholder='회원아이디'>");
            out.printf("<input type='hidden' name='teamName' value='%s'>\n", name);
            out.println("<button>추가</button>");
            out.println("</form>");
            out.println("<table border='1'>");
            out.println("<tr><th>아이디</th><th>이메일</th><th> </th></tr>");
            for (Member member : members) {
                out.printf("<tr>"
                        + "<td>%s</td>"
                        + "<td>%s</td>"
                        + "<td><a href='member/delete?teamName=%s&memberId=%s'>삭제</a></td>"
                        + "</tr>\n", 
                        member.getId(), 
                        member.getEmail(),
                        name,
                        member.getId());
            }
            out.println("</table>");
               
        } catch (Exception e) {
            RequestDispatcher 요청배달자 = request.getRequestDispatcher("/error");
            request.setAttribute("error", e);
            request.setAttribute("title", "팀 맴버조회 실패!");
            // 다른 서블릿으로 실행을 위임할 때,
            // 이전까지 버퍼로 출력한 데이터는 버린다.
            요청배달자.forward(request, response);
        }
        out.println("</body>");
        out.println("</html>");
    }
}



// ver 31 - JDBC API가 적용된 DAO 사용
// ver 28 - 네트워크 버전으로 변경
// ver 26 - TeamMemberController에서 list() 메서드를 추출하여 클래스로 정의.
// ver 23 - @Component 애노테이션을 붙인다.
// ver 18 - ArrayList가 적용된 TeamMemberDao를 사용한다.
// ver 17 - TeamMemberDao 클래스를 사용하여 팀 멤버의 아이디를 관리한다.
// ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
// ver 15 - 팀 멤버를 등록, 조회, 삭제할 수 있는 기능 추가.
// ver 14 - TeamDao를 사용하여 팀 데이터를 관리한다.
// ver 13 - 시작일, 종료일을 문자열로 입력 받아 Date 객체로 변환하여 저장.