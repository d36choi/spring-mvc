package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelAndView;
import hello.servlet.web.frontcontroller.MyView;

import hello.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FrontControllerServletV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {

  private Map<String, ControllerV3> controllerV3Map = new HashMap<>();

  public FrontControllerServletV3() {
    controllerV3Map.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
    controllerV3Map.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
    controllerV3Map.put("/front-controller/v3/members", new MemberListControllerV3());
  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("FrontControllerServletV3.service");

    final String requestURI = req.getRequestURI();

    final ControllerV3 controller = controllerV3Map.get(requestURI);
    if (controller == null) {
      resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return;
    }
    Map<String, String> paramMap = createParamMap(req);
    final ModelAndView mv = controller.process(paramMap);

    final String viewName = mv.getViewName();
    final MyView view = viewResolver(viewName);

    view.render(mv.getModel(), req, resp);
  }

  private MyView viewResolver(String viewName) {
    return new MyView("/WEB-INF/views/" + viewName + ".jsp");
  }

  private Map<String, String> createParamMap(HttpServletRequest req) {
    Map<String, String> paramMap = new HashMap<>();
    req.getParameterNames().asIterator()
        .forEachRemaining(paramName -> paramMap.put(paramName, req.getParameter(paramName)));
    return paramMap;
  }
}
