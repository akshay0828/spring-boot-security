package com.valtech.spring.security.controllers;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.valtech.spring.security.entity.CartLine;
import com.valtech.spring.security.entity.Products;
import com.valtech.spring.security.entity.User;
import com.valtech.spring.security.model.RegisterUserModel;
import com.valtech.spring.security.repo.CartLineRepo;
import com.valtech.spring.security.repo.UserReopsitory;
import com.valtech.spring.security.service.CartLineService;

import com.valtech.spring.security.service.ProductService;
import com.valtech.spring.security.service.ValtechUserDetailsService;

//@RestController
@Controller
public class HelloController {
	@Autowired
	private UserReopsitory userRepository;

	/*@Autowired
	private CartService cartService;*/

	@Autowired
	private ValtechUserDetailsService service;

	@Autowired
	private ProductService productservice;
	
	
/*	@Autowired
	private lineItemRepo lineRepo;*/
	
	@Autowired
	private CartLineRepo cartRepo;
	
	
	@Autowired
	private CartLineService cartLineService;

	@GetMapping("/register")
	public String register() {
		return "/register";
	}

	@PostMapping("/register")
	// @ResponseBody
	public String registerUser(@ModelAttribute User user) {

		// if(User.h){
		user.setRole("ADMIN");
		service.createUser(user);
		// service.createUser(User.withUsername(registerUserModel.getEmail()).password(registerUserModel.getPass()).roles("USER").build());
		return "/login";

		// }else{
		// return "register";
		// }

	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("register/login")
	public String login1() {
		return "login";
	}

	@PostMapping("/login")
	// @ResponseBody
	public String loginUser(@ModelAttribute RegisterUserModel registerUserModel) {

		// String us=registerUserModel.getUsername();
		if (service.LoginValidator(registerUserModel.getUsername()) == 1) {
			return "user/home";
		}

		return "failure";
	}

	@GetMapping("/seller")
	public String admin() {
		return "Hello seller";
	}

	@GetMapping("/index")
	public String index() {
		return "Index";
	}

	@GetMapping("/customer")
	public String customer(Model model) {
		model.addAttribute("Products", productservice.getAllProducts());
		return "customer";
	}

	@GetMapping("admin/login")
	public String indexadmin() {
		return "admin/login";

	}

	@PostMapping("/admin/login")
	// @ResponseBody
	public String Loginadmin(@ModelAttribute User registerUserModel, ModelMap model) throws NullPointerException {
		String url;

		// String role=service.getrole(registerUserModel.getUsername());

		// User u= service.findUser(registerUserModel.getUsername());
		// int status= service.LoginValidator(registerUserModel.getUsername());

		// System.out.println(registerUserModel.getUsername() +
		// service.findUser(registerUserModel.getUsername()).getUsername());
		// String u1=u.getUsername();
		// String u2=registerUserModel.getUsername();
		// System.out.println("neww "+u2);
		String s1 = "ADMIN";

		try {

			String s2 = service.getrole(registerUserModel.getUsername());
			if (s1.equals(s2)
					&& registerUserModel.getUsername().equals(service.findUser(registerUserModel.getUsername()))) {
				if (registerUserModel.getPass().equals(service.findUserPass(registerUserModel.getPass()))) {

					System.out.println(
							registerUserModel.getUsername() + service.findUser(registerUserModel.getUsername()));
					System.out.println("PASSWORD");
					System.out.println(registerUserModel.getPass() + service.findUser(registerUserModel.getPass()));

					System.out.println("SUCCESS");
					int id = service.getId(registerUserModel.getUsername());

					// System.out.println(registerUserModel.getUsername() +
					// u.getUsername());

					return url = "redirect:/admin/adminhome/" + id;

				}
				int id = service.getId(registerUserModel.getUsername());
				return url = "redirect:/admin/adminhome/" + id;

			}

			else {
				String message = "Invalid Username and Password";
				System.out.println(message);
				model.addAttribute("mess", message);
				return "admin/login";

			}

		} catch (NullPointerException n) {
			String message = "Invalid Username and Password";
			System.out.println(message);
			model.addAttribute("mess", message);
			return "admin/login";
		}
	}

	@GetMapping("/admin/adminhome/{id}")
	// @ResponseBody
	public String adminhome(@PathVariable("id") int id, ModelMap model) {

		System.out.println(id);

		User u = service.getUsername(id);
		// view.addObject("add",service.getUsername(id));
		System.out.println(service.getUsername(id));
		model.addAttribute("add", u.getName());

		model.addAttribute("user", service.getuser(id));
		// model.addAttribute("add",id);

		return "/admin/adminhome";
	}

	@PostMapping("/admin/adminhome/{id}")
	public String adminhomepost(@PathVariable("id") int id) {

		ModelAndView view = new ModelAndView("admin/adminhome");
		// System.out.println(id);

		return "admin/adminhome";
	}

	@GetMapping("/admin/products/{id}")
	public String adminproducts(@PathVariable("id") int id, Model model) {
		model.addAttribute("user", service.getuser(id));

		return "admin/addproducts";
	}

	@PostMapping("/admin/products/{id}")
	// @ResponseBody
	public String adminadd(@ModelAttribute Products products, @PathVariable("id") int id) {

		int pid = id;

		// products.setUser_id(pid);

		productservice.createProduct(products);

		return "redirect:/admin/adminhome/{id}";
	}

	@GetMapping("/products/prolist")
	public String listpro(Model model) {

		System.out.println("List of Products");

		// model.addAttribute("products", productservice.getProduct(1));
		model.addAttribute("Products", productservice.getAllProducts());

		return "products/prolist"; // prefix/cars/list/suffix=/WEB-INF/views/cars/list.jsp

	}

	@GetMapping("user/login")
	public String indexuser() {
		return "user/login";
	}

	@PostMapping("/user/login")
	// @ResponseBody
	public String LoginUser(@ModelAttribute RegisterUserModel registerUserModel, Model model)
			throws NullPointerException {
		String url;

		// String role=service.getrole(registerUserModel.getUsername());

		// User u= service.findUser(registerUserModel.getUsername());
		// int status= service.LoginValidator(registerUserModel.getUsername());

		// System.out.println(registerUserModel.getUsername() +
		// service.findUser(registerUserModel.getUsername()).getUsername());
		// String u1=u.getUsername();
		// String u2=registerUserModel.getUsername();
		// System.out.println("neww "+u2);
		String s1 = "USER";

		try {

			String s2 = service.getrole(registerUserModel.getUsername());
			if (s1.equals(s2)
					&& registerUserModel.getUsername().equals(service.findUser(registerUserModel.getUsername()))) {
				if (registerUserModel.getPass().equals(service.findUserPass(registerUserModel.getPass()))) {

					System.out.println(
							registerUserModel.getUsername() + service.findUser(registerUserModel.getUsername()));

					System.out.println("SUCCESS");
					int id = service.getId(registerUserModel.getUsername());

					// System.out.println(registerUserModel.getUsername() +
					// u.getUsername());

					return url = "redirect:/user/userhome/" + id;

				}
				int id = service.getId(registerUserModel.getUsername());
				return url = "redirect:/user/userhome/" + id;

			}

			else {
				String message = "Invalid Username and Password";
				System.out.println(message);
				model.addAttribute("mess", message);
				return "user/login";

			}
		} catch (NullPointerException n) {
			String message = "Invalid Username and Password";
			System.out.println(message);
			model.addAttribute("mess", message);
			return "user/login";
		}
	}

	@GetMapping("user/userhome/{id}")
	// @ResponseBody
	public String userhome(@PathVariable("id") int id, ModelMap model) {

		System.out.println(id);

		User u = service.getUsername(id);
		// view.addObject("add",service.getUsername(id));
		System.out.println(service.getUsername(id));
		model.addAttribute("add", u.getName());
		model.addAttribute("user", u.getId());
		// model.addAttribute("add",id);
		model.addAttribute("Products", productservice.getAllProducts());

		// if(registerUserModel.getRole()=="ADMIN")
		model.addAttribute("users", service.getAlluser());

		//model.addAttribute("cartLine",cartLineService.findAll());
		
		
		
		return "user/userhome";
	}

	
	
	

	@GetMapping("user/userhome/{id}/{prod_id}")
	// @ResponseBody
	public String userhome1(@PathVariable("id") int id, @PathVariable("prod_id") int prod_id, ModelMap model,CartLine cartLine) throws ConstraintViolationException,NullPointerException,DataIntegrityViolationException{

		
		try{
		System.out.println(id);

		User u = service.getUsername(id);
		// view.addObject("add",service.getUsername(id));
		System.out.println(service.getUsername(id));
		model.addAttribute("add", u.getName());
		model.addAttribute("user", u.getId());
		
		// model.addAttribute("add",id);
		model.addAttribute("Products", productservice.getAllProducts());

		
		
		// if(registerUserModel.getRole()=="ADMIN")
		model.addAttribute("users", service.getAlluser());

		
		
		
		
	//	System.out.println(cartLineService.findById(103));
		
		
		
		
		
		//CartLine cart=cartLineService.findByProId(prod_id);
		
		Products p= productservice.getProduct(prod_id);
		//p.setQuantity(p.getQuantity()-cart.getQuantity());
		
		cartLine.setProdid(prod_id);
		cartLine.setProductName(p.getProductName());
		 cartLine.setPrice(p.getPrice());
		//cartLine.setQuantity(cart.getQuantity()+1);
		
		cartLineService.createCartLine(cartLine);
		
	
		
		
		model.addAttribute("cartLine",cartLineService.findAll());
		
		
	
		
}
catch(Exception e)
{
	Products p= productservice.getProduct(prod_id);
	CartLine cart=cartLineService.findByProId(prod_id);
	
	//System.out.println();
	
	cartLine.setId(cart.getId());
	cartLine.setProdid(prod_id);
	cartLine.setProductName(p.getProductName());
	cartLine.setPrice(p.getPrice());
	cartLine.setQuantity(cart.getQuantity()+1);
	System.out.println(cartLine.getQuantity());
	
	cartLineService.createCartLine(cartLine);
	
}
		
		
		try{
			CartLine cart=cartLineService.findByProId(prod_id);
			
			Products p= productservice.getProduct(prod_id);
			p.setQuantity(p.getQuantity()-cart.getQuantity());
			
			cartLine.setProdid(prod_id);
			cartLine.setProductName(p.getProductName());
			 cartLine.setPrice(p.getPrice());
			//cartLine.setQuantity(cart.getQuantity()+1);
			
			cartLineService.createCartLine(cartLine);
			
		}
		catch(NullPointerException n){
			
		}
		
		
		return "user/userhome";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("user/cart")
	public String cart( ModelMap model) {
		
		model.addAttribute("cartLine",cartLineService.findAll());
		return "user/cart";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@GetMapping("admin/register")
	public String adminregister() {
		return "admin/register";
	}

	@PostMapping("/admin/register")
	// @ResponseBody
	public String adminregisterasrole(@ModelAttribute User user) {

		user.setRole("ADMIN");
		service.createUser(user);

		return "redirect:/admin/login";
		// return "/admin/success";

	}

	@GetMapping("user/register")
	public String userregister() {
		return "user/register";
	}

	@PostMapping("/user/register")
	// @ResponseBody
	public String userregisterasrole(@ModelAttribute User user) {

		user.setRole("USER");
		service.createUser(user);

		return "redirect:/user/login";

	}

	@GetMapping("/user")
	public String user() {
		return "Hello User";
	}

	@GetMapping("/deliveryPerson")
	public String deliveryPerson() {
		return "Hello DeliveryPerson";
	}

	@PostMapping("/products/updateproduct/{id}")
	public ModelAndView updateProduct(@PathVariable("id") int id, @ModelAttribute Products pro,
			@RequestParam("submit") String submit) {
		ModelAndView view = new ModelAndView("products/prolist");
		if (submit.equals("cancel")) {
			view.addObject("product", productservice.getAllProducts());
			return view;
		}
		productservice.updateProduct(pro);
		view.addObject("Products", productservice.getAllProducts());
		return view;
	}

	@GetMapping("/products/updateproduct/{id}")
	public String updateproduct(@PathVariable("id") int id, Model model) {
		model.addAttribute("product", productservice.getProduct(id));
		return "products/updateproduct";
	}

	@GetMapping("/admin/updateProfile/{id}")
	// @ResponseBody
	public String adminUpdate(@PathVariable("id") int id, Model model) {
		model.addAttribute("user", service.getuser(id));
		return "/admin/updateProfile";
	}

	@PostMapping("/admin/updateProfile/{id}")
	// @ResponseBody
	public String adminUpdateInsert(@PathVariable("id") int id, @ModelAttribute User user,
			@RequestParam("submit") String submit) {
		System.out.println("SUCCESS");
		service.updateUser(user);

		return "redirect:/admin/adminhome/{id}";
	}

}
