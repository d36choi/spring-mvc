package hello.servlet.basic.request;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 1. param 전송 기능
 * http://localhost:8080/request-param?username=hello&age=20
 */
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    final Enumeration<String> parameterNames = req.getParameterNames();
    System.out.println("[전체 파라미터 조회]");
    parameterNames.asIterator()
        .forEachRemaining(parameterName -> System.out.println(parameterName + "=" + req.getParameter(parameterName) ));
    System.out.println("[단일 파라미터 조회]");
    final String username = req.getParameter("username");
    final String age = req.getParameter("age");
    System.out.println("username = " + username);
    System.out.println("age = " + age);
    System.out.println("[이름이 같은 복수   파라미터 조회]");
    final String[] usernames = req.getParameterValues("username");
    for (String s : usernames) {
      System.out.println("중복 username = " + s);
    }
  }
}
