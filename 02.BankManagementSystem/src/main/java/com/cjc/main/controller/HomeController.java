package com.cjc.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cjc.main.model.Account;

import com.cjc.main.service.AccService;

@Controller
public class HomeController {

	@Autowired
	AccService asi;
	
	
	@RequestMapping("/")
	public String prelogin()
	{
		return "login";
	}
	@RequestMapping("/opensignup")
	public String opensingupPage()
	{
		return "signup";
	}
	
	@RequestMapping("/save")
	public String saveUser(@ModelAttribute Account a, Model m)
	{
		asi.saveUser(a);
		return "login";
	}
	
	@RequestMapping("/log")
	public String loginCheck(@RequestParam long accno, @RequestParam String name, Model m)
	{
		Account ac=asi.loginCheck(accno,name);
		Iterable<Account>list=asi.dispalyAllData();
		m.addAttribute("data",list);
		return "success";
	}
	
	@RequestMapping("/delete")
	public String deleteAcc(@ModelAttribute Account a, Model m)
	{
		asi.deleteAcc(a);
		Iterable<Account>list=asi.dispalyAllData();
		m.addAttribute("data",list);
		return "success";
	}
	
	@RequestMapping("/edit")
	public String editData(@RequestParam long accno,Model m)
	{
		Account u=asi.editAcc(accno);
	     m.addAttribute("data",u);
		return "edit";
	}
	
	
//	@RequestMapping("/opensignup")
//
//	public String addData(@ModelAttribute Account u,Model m)
//	{
//		asi.saveUser(u);
//		Iterable<Account>list=asi.dispalyAllData();
//		m.addAttribute("data",list);
//		return "signup";
//	}
	
//	@RequestMapping("/opensignup")
//	public String addUser()
//	{
//		return "addUser";
//	}
//
//	@RequestMapping("/addUser")
//	public String addSaveUser(@ModelAttribute Account a,Model m)
//	{
//		asi.saveUser(a);
//		return "success";
//	}
	
	@RequestMapping("/deposite")
	public String deposite(@RequestParam long accno, Model m)
	{
		Account a=asi.depositeMoney(accno);
		m.addAttribute("data",a);
		return "deposite";
	}
	
	
	@RequestMapping("/add")
	public String addBal(@ModelAttribute Account a,@RequestParam double dp,Model m)
	{
		asi.addBal(dp,a);
		asi.saveUser(a);
		Iterable<Account>list=asi.dispalyAllData();
		m.addAttribute("data",list);
		return "success";
	}
	
	@RequestMapping("/withdraw")
	public String withdraw(@RequestParam long accno,Model m)
	{
		Account ac=asi.withdraw(accno);
		m.addAttribute("data",ac);
		return "withdraw";
	}
	
	@RequestMapping("/sub")
	public String subBalence(@ModelAttribute Account a, @RequestParam double wd,Model m)
	{
		asi.subBal(wd,a);
		asi.saveUser(a);
		Iterable<Account>list=asi.dispalyAllData();
		m.addAttribute("data",list);
		return "success";
	}
}
