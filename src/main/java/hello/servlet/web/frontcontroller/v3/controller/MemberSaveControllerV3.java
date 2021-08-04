package hello.servlet.web.frontcontroller.v3.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.ModelAndView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {

  private MemberRepository memberRepository = MemberRepository.getInstance();

  @Override
  public ModelAndView process(Map<String, String> paramMap) {
    final String username = paramMap.get("username");
    final int age = Integer.parseInt(paramMap.get("age"));
    final Member member = new Member(username, age);
    memberRepository.save(member);
    final ModelAndView modelAndView = new ModelAndView("save-result");
    modelAndView.getModel().put("member", member);
    return modelAndView;
  }
}
