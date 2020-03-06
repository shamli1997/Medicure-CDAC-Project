package com.app.controller;

import java.util.List;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IUserDao;
import com.app.pojos.QualificationType;
import com.app.pojos.User;
import com.app.pojos.UserType;

@RestController
@RequestMapping("/user")
@CrossOrigin(allowedHeaders = ("*"))
public class UserController {
	
	@Autowired
	IUserDao iuserdao;
	
	@Autowired
	private JavaMailSender mailSender;
	
	public UserController() {
		System.out.println("In User Controller");
	}
	
	@PostMapping("/register")
	public User register(@RequestBody User user) {
		System.out.println(user);
		if(iuserdao.registerUser(user)!=0)
		{
			String msg="You are registered successfully!!!";
			SimpleMailMessage mailMessage=new SimpleMailMessage();
			mailMessage.setTo(user.getEmail());
			mailMessage.setSubject("Registration.");
			mailMessage.setText(msg);
			try
			{
				mailSender.send(mailMessage);
				return  user;
			}
			catch (MailException e) {
				System.out.println("inside mail exception");
				e.printStackTrace();
			}
			
		}
		return null;
		
	}
	
	@PostMapping("/login")
	public User login(@RequestBody User user) {
		System.out.println(user);
		return iuserdao.login(user);
	}
	
	@PostMapping("/forgot")
	public Integer processForgotPassword(@RequestBody User user,HttpServletRequest request,Model map,HttpSession hs)
	{
		
		try
		{
			System.out.println("inside processForgotPassword "+user);
			user = iuserdao.findByEmail(user);
			System.out.println("findByEmail  "+user);
			//hs.setAttribute("user", user);
			if(user !=null)
			{
				int otp = iuserdao.generateOtp();
				user.setOtp(otp);
				iuserdao.updateOtp(user);
				
				System.out.println("storing in session "+otp);
				String msg="Your one time password for forgot password is = "+otp;
				SimpleMailMessage mailMessage = new SimpleMailMessage();
				mailMessage.setTo(user.getEmail());
				mailMessage.setSubject("One Time Password");
				mailMessage.setText(msg);
				try
				{
					mailSender.send(mailMessage);
				}
				catch (MailException e) 
				{
					System.out.println("inside mail exception");
					e.printStackTrace();
				}
				return 1;
			}
		} catch (NoResultException e) 
		{
			map.addAttribute("msg", "Please enter valid email address");
			e.printStackTrace();
		}
		return 0;
	}
	
	@PostMapping("/otp")
	public Integer confirmOtp(@RequestParam("email") String email,@RequestBody User u)
	{
		System.out.println("Email is"+email);
		User user = iuserdao.findByEmail(email);
		System.out.println("1 user otp "+user.getOtp());
		
		System.out.println("=============");
		System.out.println(u.getOtp());
		System.out.println("=============");
		System.out.println("==================");
		System.out.println(user.getOtp());
		System.out.println("==================");
			
		
		if(user.getOtp().equals(u.getOtp()))
		{
			System.out.println("otp checked");
			return 1;
		}
		else
			return 0;
	}
	
	@PostMapping("/change")
	public Integer setPassword(@RequestParam("email") String email,@RequestBody User u)
	{
		System.out.println("=============");
		System.out.println("from user enterd pass"+u.getPassword());
		System.out.println("=================");
		System.out.println(email);
		String pass = u.getPassword();
		System.out.println("Password we get "+pass);
		iuserdao.resetpassword(email,pass);
		return 1;
	
	}
	
	@GetMapping("/role")
	public List<UserType> displayRoles(){
		return iuserdao.listUserRoles();
	}
}
