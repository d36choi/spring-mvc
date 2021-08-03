package hello.servlet.web.frontcontroller.v1;

import hello.servlet.web.frontcontroller.v1.controller.MemberFormControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberListControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberSaveControllerV1;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FrontControllerServletV1", urlPatterns = "/front-controller/v1/*")
public class FrontControllerServletV1 extends HttpServlet {

  private Map<String, ControllerV1> controllerV1Map = new HashMap<>();

  public FrontControllerServletV1() {
    controllerV1Map.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());
    controllerV1Map.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
    controllerV1Map.put("/front-controller/v1/members", new MemberListControllerV1());
  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("FrontControllerServletV1.service");

    final String requestURI = req.getRequestURI();

    final ControllerV1 controller = controllerV1Map.get(requestURI);
    if (controller == null) {
      resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return;
    }
    controller.process(req, resp);
  }
}
