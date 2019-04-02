package com.pack.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pack.entity.Admin;
import com.pack.entity.BatchAllocation;
import com.pack.entity.Login;
import com.pack.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;

	@RequestMapping(value = "/logOption", method = RequestMethod.GET)
	public String loginoption(ModelMap model) {
		System.out.println("aasaasasas");
		System.err.println("Inside login controller");
		model.addAttribute("login", new Login());
		return "LogOption";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(ModelMap model) {
		System.err.println("Inside login controller");
		model.addAttribute("login", new Login());
		model.addAttribute("addadmin", new Admin());
		return "SignUp";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		System.err.println("Inside login controller");
		model.addAttribute("login", new Login());
		return "login";
	}

	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public String validate(@ModelAttribute(value = "login") Login login, ModelMap model) {

		System.out.println("Inside admin controller");
		String l = null;
		l = adminService.loginAdmin(login);
		return l;
	}

	@RequestMapping(value = "/BatchAllocation", method = RequestMethod.GET)
	public String batchAllocation(ModelMap model) {
		System.err.println("Inside batchAllocation controller");
		model.addAttribute("batchAllocation", new BatchAllocation());
		return "BatchAllocation";
	}

	@RequestMapping(value = "/addBatch", method = RequestMethod.POST)
	public String addBatch(@ModelAttribute(value = "batchAllocation") BatchAllocation batchAllocation, ModelMap model,
			BindingResult result, final HttpServletRequest request) {
		System.err.println("Inside addBatch controller");
		model.addAttribute("batchAllocation", new BatchAllocation());
		String startDatestr = request.getParameter("nday");
		String endDatestr = request.getParameter("eday");
		String closeDatestr = request.getParameter("cday");
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
		/*
		 * Date startDate = sdf. parse(startDatestr); Date
		 * endDate=sdf.parse(endDatestr); Date
		 * closeDate=sdf.parse(closeDatestr);
		 */
		adminService.addBatch(batchAllocation);
		return "BatchAllocation";
	}
	@RequestMapping(value="/addadmin", method= RequestMethod.POST)
	public String addAdmin(	@ModelAttribute(value = "addadmin") Admin admin1)
	{
		adminService.addAdmin(admin1);
		System.out.println("HELLO SUUCESSFULLY ADDED");
		return "redirect:/login";
		
}
}