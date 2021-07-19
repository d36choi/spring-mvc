package hello.servlet.basic.response;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ResponseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.setStatus(HttpServletResponse.SC_OK);
    resp.setHeader("Content-Type", "text/plain");
//    Content-Type : text/plain?charset=utf-8
//    = resp.setContentType("text/plain");
//    = resp.setCharacterEncoding("UTF-8");
    resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    resp.setHeader("Pragma", "no-cache");
    resp.setHeader("my-header", "hello");

    redirect(resp);
    PrintWriter writer = resp.getWriter();
    writer.println("ok");
  }

  private void redirect(HttpServletResponse resp) throws IOException {
    resp.setStatus(HttpServletResponse.SC_FOUND); // 302
    resp.setHeader("location", "/basic/hello-form.html");
//   ==  resp.sendRedirect("/basic/hello-form.html");
  }


}
