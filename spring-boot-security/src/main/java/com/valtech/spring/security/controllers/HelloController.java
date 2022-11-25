package com.valtech.spring.security.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.valtech.spring.security.entity.Products;
import com.valtech.spring.security.entity.User;
import com.valtech.spring.security.model.RegisterUserModel;
import com.valtech.spring.security.service.ProductService;
import com.valtech.spring.security.service.ValtechUserDetailsService;
import com.valtech.spring.security.service.product;

//@RestController
@Controller
public class HelloController {
	
	@Autowired
	private ValtechUserDetailsService service;
	
	@Autowired
	private ProductService productservice;
	
	@GetMapping("/register")
	public String register(){
		return "register";
	}
	
	
	@PostMapping("/register")
	//@ResponseBody
	public String registerUser(@ModelAttribute User user) {
		
		
		//if(User.h){
			service.createUser(user);
			//service.createUser(User.withUsername(registerUserModel.getEmail()).password(registerUserModel.getPass()).roles("USER").build());
			return "login";
			
		//}else{
		//return "register";
		//}
		
	}
	@GetMapping("/login")
	public String login(){
		return "login";
	}
	
	
	@PostMapping("/login")
	@ResponseBody
	public String loginUser(@ModelAttribute RegisterUserModel registerUserModel){
		
		//String us=registerUserModel.getUsername();
		if(service.LoginValidator(registerUserModel.getUsername())==1){
			return "user/home";
		}
		
		return "user/failure";
	}
	
	
	
	@GetMapping("/seller")
	public String admin(){
		return "Hello seller";
	}
	
	@GetMapping("/index")
	public String index(){
		return "Index";
	}
	
	@GetMapping("/update")
	public String update(){
		return "update";
	}
	
	@GetMapping("/adminhome")
	public String adminhome(){
		return "admin/adminhome";
	}
	@GetMapping("/home")
	public String home(){
		return "home";
	}
	@PostMapping("/admin/products")
//	@ResponseBody
	public String adminadd(@ModelAttribute Products products){
		productservice.createProduct(products);
		return "admin/adminhome";
	}
	
	@GetMapping("/admin/products")
	public String adminproducts(){
		return "admin/addproducts";
	}
	
	@GetMapping("admin/listproducts")
	public Products getProducts() {
		return productservice.getProduct(1);
	}
	
	@GetMapping("/adminpro")
	public Products adminallproducts(){
		return productservice.getProduct(1);
	}
	@GetMapping("/user")
	public String user(){
		return "Hello User";
	}
	
	@GetMapping("/products/plist")
//	@ResponseBody
	public String list(Model model) {
		System.out.println("List of Products");
		model.addAttribute("pro", productservice.getAllProducts());
		
		//return productservice.getAllProducts(); // prefix/cars/list/suffix=/WEB-INF/views/cars/list.jsp
		return "products/plist";
	}
	
	@GetMapping("/products/prolist")
	public String listpro(Model model) {
		
		System.out.println("List of Productss");
		
//		model.addAttribute("products", productservice.getProduct(1));
     	model.addAttribute("Products", productservice.getAllProducts());
     	
		return "products/prolist"; // prefix/cars/list/suffix=/WEB-INF/views/cars/list.jsp

	}
	
//	@GetMapping("/products/prolist")
//	public String listpro(Model model) {
//		System.out.println("List of Products");
////		model.addAttribute("pro", productservice.getProduct(1));
////     	model.addAttribute("pro", productservice.getAllProducts());
//	
//		System.out.println(model.addAttribute("pro", productservice.getAllProducts()));// prefix/cars/list/suffix=/WEB-INF/views/cars/list.jsp
//		return "s";

//	}
	
	
	@GetMapping("/list")
	public String deliveryPerson(){
		return "list";
	}
	
//	@PutMapping("/products/updateproduct/{id}")
//	public ModelAndView updateProduct(@PathVariable("id") int id, @ModelAttribute Products products,@RequestParam("submit") String submit){
//		ModelAndView view = new ModelAndView("products/prolist");
//		if(submit.equals("Cancel")){
//			view.addObject("Products",productservice.getAllProducts());
//			return view;
//		}
//		productservice.createProduct(products);
//		view.addObject("Products",productservice.getAllProducts());
//		return view;
//	}
	
	@PostMapping("/products/updateproduct/{id}")
	public ModelAndView updateProduct(@PathVariable("id") int id, @ModelAttribute Products pro, @RequestParam("submit") String submit){
		ModelAndView view = new ModelAndView("products/prolist");
		if(submit.equals("cancel")){
			view.addObject("product",productservice.getAllProducts());
			return view;
		}
		productservice.updateProduct(pro);
		view.addObject("Products",productservice.getAllProducts());
		return view;
	}
	
	@GetMapping("/products/updateproduct/{id}")
	public String updateproduct(@PathVariable("id") int id, Model model){
		model.addAttribute("product", productservice.getProduct(id));
		return "products/updateproduct";
	}

}
