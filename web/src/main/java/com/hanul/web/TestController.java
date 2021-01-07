package com.hanul.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import member.MemberVO;

@Controller
public class TestController {
	
	@RequestMapping("/first")
	public String aaaa(Model model) {
		model.addAttribute("myName","김종건");
		model.addAttribute("myAge",27);
		
		return "view";
	}
	
	@RequestMapping("/second")
	public String bbbb(Model model) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		String today = sdf.format(new Date());
		
		model.addAttribute("today", today);
		return "view";
	}
	
	@RequestMapping("/third")
	public ModelAndView cccc() {
		ModelAndView model = new ModelAndView();
		SimpleDateFormat df = new SimpleDateFormat("a hh시 mm분 ss초");
		String now = df.format(new Date());
		model.addObject("now", now);
		model.setViewName("view");
		return model;
	}
	
	//회원가입 화면
	@RequestMapping("/member")
	public String member() {
		return "member/join";
	}
	
	//회원가입 제출1(request 방식)
	@RequestMapping("/joinRequest")
	public String join(HttpServletRequest request, Model model) {
		model.addAttribute("name",request.getParameter("name"));
		
		int age = Integer.parseInt(request.getParameter("age"));
		model.addAttribute("age", age);
		
		model.addAttribute("gender",request.getParameter("gender"));
		model.addAttribute("email",request.getParameter("email"));
		model.addAttribute("method","HttpServletRequest");
		return "member/myInfo";
	}
	
	//회원가입 제출2(@RequestParam 방식)
	@RequestMapping("/joinRequestParam")
	public String join(@RequestParam("name") String n, @RequestParam String gender,
						String email, int age, Model model) {
		//@RequestParam 을 꼭 써줄 필요는 없다
		model.addAttribute("name", n);	//다른변수명으로 넣고싶을땐 어떤 name으로 왔는지 표기해줘야함
		model.addAttribute("gender", gender);
		model.addAttribute("email", email);
		model.addAttribute("age", age);
		model.addAttribute("method", "@RequestParam");
		
		return "member/myInfo";
	}
	
	//회원가입 제출3(VO 방식)
	@RequestMapping("/joinDataObject")
	public String join(MemberVO vo, Model model) {
		
		model.addAttribute("vo", vo);
		model.addAttribute("method", "데이터객체");
		
		return "member/myInfo";
	}
	
	//회원가입 제출4(@PathVariable 방식)
	@RequestMapping("/joinPath/{name}/{gender}/{email}/{age}")
	public String join(Model model, @PathVariable String name, @PathVariable String gender, 
						@PathVariable String email, @PathVariable int age) {
		model.addAttribute("name", name);
		model.addAttribute("gender", gender);
		model.addAttribute("email", email);
		model.addAttribute("age", age);
		
		return "member/myInfo";
	}
	
	//로그인 화면
	@RequestMapping("/login")
	public String login() {
		return "member/login";
	}
	
	//로그인 제출
	@RequestMapping("/login_result")
	public String login(Model model,String id, String pw) {
		//hanul / 0000 이면 로그인 성공 아니면 로그인 실패
		//로그인 성공시 홈화면으로 연결
		//	   실패시 로그인화면
		if( id.equals("hanul") && pw.equals("0000")) {
			//return "home";//forward
			return "redirect:/";
		}else {
			//return "member/login";//forward
			return "redirect:login";
		}
		
	}
}
