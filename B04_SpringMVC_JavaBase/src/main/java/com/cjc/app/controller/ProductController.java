package com.cjc.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cjc.app.model.Product;
import com.cjc.app.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService service;

	@RequestMapping("/")
	public String landingPage() {
		System.out.println("In landing page..");

		return "index";
	}

	@RequestMapping("/reg")
	public String regPage() {
		System.out.println("in RegisterPage..");
		return "register";
	}

	@RequestMapping("/log")
	public String logPage() {
		System.out.println("In Login page..");
		return "login";
	}

	@RequestMapping("/login")
	public String loginPage(@RequestParam String uname, @RequestParam String pass) {

		if (uname.equals("admin") && pass.equals("admin@123")) {
			List<Product> plist = service.getAllProducts();

			System.out.println("****PRODUCT LIST***");
			for (Product p : plist) {
				System.out.println("Product ID :" + p.getPid());
				System.out.println("Product Name :" + p.getPname());
				System.out.println("Product Price :" + p.getPrice());
			}

			return "success";
		} else {
			System.out.println("Invalid Credentials");
			return "index";
		}

	}

	@RequestMapping("/register")
	public String registerPage(@ModelAttribute Product product) {
		service.saveProduct(product);

		return "index";
	}
	@RequestMapping("/delete")
	public String deleteProduct(@RequestParam int pid, Model m) {
		System.out.println(pid);

		List<Product> plist = service.deleteProduct(pid);

		m.addAttribute("data", plist);

		return "success";
	}

	@RequestMapping("/edit")
	public String editProduct(@RequestParam int pid,Model m) {

		Product product= service.getProduct(pid);
		
		m.addAttribute("data", product);
		
		return "update";

	}
	
	@RequestMapping("/update")
	public String updateProduct(@ModelAttribute Product product,Model m) {
	
		
	List<Product>plist=service.updateProduct(product);
	
	m.addAttribute("data", plist);
	
	return "success";
	}

}


