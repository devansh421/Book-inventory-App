package com.Divyanshu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("bookstore/inventory")
public class HomeController 
{
	@RequestMapping("login")
	public String getLoginView()
	{
		return "home/login.html";
	}
	@RequestMapping("login/validate")
	public String validateLogin(String username,String password,Model model)
	{
		if(username.equals("admin") && password.equals("admin"))
		{
			return "redirect:../home";
		}
		model.addAttribute("msg","User name or pasword is incorrect");
		model.addAttribute("username",username);
		return "home/login.html";
	}
	@RequestMapping("home")
	public String getViewView()
	{
		return "home/home-page";
	}
}
