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
		model.addAttribute("myName","������");
		model.addAttribute("myAge",27);
		
		return "view";
	}
	
	@RequestMapping("/second")
	public String bbbb(Model model) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd��");
		String today = sdf.format(new Date());
		
		model.addAttribute("today", today);
		return "view";
	}
	
	@RequestMapping("/third")
	public ModelAndView cccc() {
		ModelAndView model = new ModelAndView();
		SimpleDateFormat df = new SimpleDateFormat("a hh�� mm�� ss��");
		String now = df.format(new Date());
		model.addObject("now", now);
		model.setViewName("view");
		return model;
	}
	
	//ȸ������ ȭ��
	@RequestMapping("/member")
	public String member() {
		return "member/join";
	}
	
	//ȸ������ ����1(request ���)
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
	
	//ȸ������ ����2(@RequestParam ���)
	@RequestMapping("/joinRequestParam")
	public String join(@RequestParam("name") String n, @RequestParam String gender,
						String email, int age, Model model) {
		//@RequestParam �� �� ���� �ʿ�� ����
		model.addAttribute("name", n);	//�ٸ����������� �ְ������ � name���� �Դ��� ǥ���������
		model.addAttribute("gender", gender);
		model.addAttribute("email", email);
		model.addAttribute("age", age);
		model.addAttribute("method", "@RequestParam");
		
		return "member/myInfo";
	}
	
	//ȸ������ ����3(VO ���)
	@RequestMapping("/joinDataObject")
	public String join(MemberVO vo, Model model) {
		
		model.addAttribute("vo", vo);
		model.addAttribute("method", "�����Ͱ�ü");
		
		return "member/myInfo";
	}
	
	//ȸ������ ����4(@PathVariable ���)
	@RequestMapping("/joinPath/{name}/{gender}/{email}/{age}")
	public String join(Model model, @PathVariable String name, @PathVariable String gender, 
						@PathVariable String email, @PathVariable int age) {
		model.addAttribute("name", name);
		model.addAttribute("gender", gender);
		model.addAttribute("email", email);
		model.addAttribute("age", age);
		
		return "member/myInfo";
	}
	
	//�α��� ȭ��
	@RequestMapping("/login")
	public String login() {
		return "member/login";
	}
	
	//�α��� ����
	@RequestMapping("/login_result")
	public String login(Model model,String id, String pw) {
		//hanul / 0000 �̸� �α��� ���� �ƴϸ� �α��� ����
		//�α��� ������ Ȩȭ������ ����
		//	   ���н� �α���ȭ��
		if( id.equals("hanul") && pw.equals("0000")) {
			//return "home";//forward
			return "redirect:/";
		}else {
			//return "member/login";//forward
			return "redirect:login";
		}
		
	}
}
