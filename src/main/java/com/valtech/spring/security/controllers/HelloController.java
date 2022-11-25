package com.valtech.spring.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.valtech.spring.security.entity.Products;
import com.valtech.spring.security.entity.User;
import com.valtech.spring.security.model.RegisterUserModel;
import com.valtech.spring.security.repo.UserReopsitory;
import com.valtech.spring.security.service.ProductService;
import com.valtech.spring.security.service.ValtechUserDetailsService;

//@RestController
@Controller
public class HelloController {
	@Autowired
	private UserReopsitory userRepository;
	
	@Autowired
	private ValtechUserDetailsService service;
	
	@Autowired
	private ProductService productservice;
	
	int uid;
	
	@GetMapping("/register")
	public String register(){
		return "/register";
	}
	
	
	@PostMapping("/register")
	//@ResponseBody
	public String registerUser(@ModelAttribute User user) {
		
		
		//if(User.h){
		user.setRole("ADMIN");
			service.createUser(user);
			//service.createUser(User.withUsername(registerUserModel.getEmail()).password(registerUserModel.getPass()).roles("USER").build());
			return "/login";
			
		//}else{
		//return "register";
		//}
		
	}
	@GetMapping("/login")
	public String login(){
		return "login";
	}
	
	@GetMapping("register/login")
	public String login1(){
		return "login";
	}
	
	
	
	@PostMapping("/login")
	//@ResponseBody
	public String loginUser(@ModelAttribute RegisterUserModel registerUserModel){
		
		//String us=registerUserModel.getUsername();
		if(service.LoginValidator(registerUserModel.getUsername())==1){
			return "user/home";
		}
		
		return "failure";
	}
	
	
	
	@GetMapping("/seller")
	public String admin(){
		return "Hello seller";
	}
	
	@GetMapping("/index")
	public String index(){
		return "Index";
	}
	
	@GetMapping("/customer")
	public String customer(Model model){
		model.addAttribute("Products", productservice.getAllProducts());
		return "customer";
	}
	
	
	
	@GetMapping("admin/login")
	public String indexadmin(){
		return "admin/login";
		
		
	}
	
	
	
	@PostMapping("/admin/login")
	//@ResponseBody
	public String Loginadmin(@ModelAttribute User registerUserModel,ModelMap model) throws NullPointerException{
		String url;
		
	//	String role=service.getrole(registerUserModel.getUsername());
		
		//User u= service.findUser(registerUserModel.getUsername());
		//int status= service.LoginValidator(registerUserModel.getUsername());
		
		//System.out.println(registerUserModel.getUsername() + service.findUser(registerUserModel.getUsername()).getUsername());
		//String u1=u.getUsername();
		//String u2=registerUserModel.getUsername();
	//	System.out.println("neww     "+u2);
		String s1="ADMIN";

		
		try{
			
			String s2=service.getrole(registerUserModel.getUsername());
			if(s1.equals(s2)  &&  registerUserModel.getUsername().equals(service.findUser(registerUserModel.getUsername()))){
			if(registerUserModel.getPass().equals(service.findUserPass(registerUserModel.getPass())))
			{
				
				System.out.println(registerUserModel.getUsername() + service.findUser(registerUserModel.getUsername()));
				System.out.println("PASSWORD");
				System.out.println(registerUserModel.getPass() + service.findUser(registerUserModel.getPass()));
				
				System.out.println("SUCCESS");
				int id= service.getId(registerUserModel.getUsername());
				
				//System.out.println(registerUserModel.getUsername() + u.getUsername());
				uid= id;
				
				return url="redirect:/admin/adminhome/"+id;
				
			
		}
			int id= service.getId(registerUserModel.getUsername());
			return url="redirect:/admin/adminhome/"+id;
			
			}
			
			else{
				String message="Invalid Username and Password";
				System.out.println(message);
				model.addAttribute("mess",message);
				return "admin/login";
				
				
			}
		
		}
		catch(NullPointerException n){
			String message="Invalid Username and Password";
			System.out.println(message);
			model.addAttribute("mess",message);
			return "admin/login";
		}
	}
	
	@GetMapping("/admin/adminhome/{id}")
	//@ResponseBody
	public String adminhome(@PathVariable("id") int id,ModelMap  model){
		
		 System.out.println(id);
		
		  User u=service.getUsername(id);
		 //view.addObject("add",service.getUsername(id));
		 System.out.println(service.getUsername(id));
		 model.addAttribute("add",u.getName());
		 
		 model.addAttribute("user", service.getuser(id));
		// model.addAttribute("add",id);
		 
		return "/admin/adminhome";
	}
	
	@PostMapping("/admin/adminhome/{id}")
	public String adminhomepost(@PathVariable("id") int id){
		
		 ModelAndView view = new ModelAndView("admin/adminhome");
		 //System.out.println(id);
		 
		return "admin/adminhome";
	}
	
	@GetMapping("/admin/products/{id}")
	public String adminproducts(@PathVariable("id")int user_id,Model model){
		model.addAttribute("user", service.getuser(user_id));
		
		return "admin/addproducts";
	}
	
	@PostMapping("/admin/products/{id}")
//	@ResponseBody
	public String adminadd(@ModelAttribute Products products,@PathVariable("id")int user_id){
		
		//int pid=id;
		
		//products.setUser_id(pid);
		
		Products p = new Products(products.getProductName(),products.getPrice(),products.getWeight(),products.getProductDescription(),products.getQuantity());
		p.setUserid(user_id);
//		products.setUserid(user_id);
		
		productservice.createProduct(p);
		
		System.out.println(productservice.getAllProducts());
		
		return "redirect:/admin/adminhome/{id}";
	}
	
	@GetMapping("/products/prolist/{id}")
	public String listpro(Model model,@PathVariable("id") int user_id) {
		
		
		
		model.addAttribute("user", service.getuser(user_id));
//		if(submit.equals("Delete")){
//			Products p= productservice.getProduct(id);
//			int userid = productservice.1
//		}
		
		//model.addAttribute("products", productservice.getProduct(1));
     	model.addAttribute("Products", productservice.getAllproductsbyuser(user_id));
     	
		return "products/prolist"; // prefix/cars/list/suffix=/WEB-INF/views/cars/list.jsp

	}
	
	@PostMapping("/products/prolist/{id}/{userid}")
	public String DeleteProduct(Model model,@PathVariable("id") int id,@PathVariable("userid") int user_id){
		productservice.deleteProduct(id);
		return "redirect:/products/prolist/"+user_id;
		
	}
	
	

	
	@GetMapping("user/login")
	public String indexuser(){
		return "user/login";
	}
	
	@PostMapping("/user/login")
	//@ResponseBody
	public String LoginUser(@ModelAttribute RegisterUserModel registerUserModel,Model model)throws NullPointerException{
		String url;
		
		//	String role=service.getrole(registerUserModel.getUsername());
			
			//User u= service.findUser(registerUserModel.getUsername());
			//int status= service.LoginValidator(registerUserModel.getUsername());
			
			//System.out.println(registerUserModel.getUsername() + service.findUser(registerUserModel.getUsername()).getUsername());
			//String u1=u.getUsername();
			//String u2=registerUserModel.getUsername();
		//	System.out.println("neww     "+u2);
			String s1="USER";

			
			try{
				
				String s2=service.getrole(registerUserModel.getUsername());
				if(s1.equals(s2)  &&  registerUserModel.getUsername().equals(service.findUser(registerUserModel.getUsername()))){
					if(registerUserModel.getPass().equals(service.findUserPass(registerUserModel.getPass())))
					{
				
					
					System.out.println(registerUserModel.getUsername() + service.findUser(registerUserModel.getUsername()));
					
					System.out.println("SUCCESS");
					int id= service.getId(registerUserModel.getUsername());
					
					//System.out.println(registerUserModel.getUsername() + u.getUsername());
					
					
					return url="redirect:/user/userhome/"+id;
					
				
			}
					int id= service.getId(registerUserModel.getUsername());
					return url="redirect:/user/userhome/"+id;
					
					}
				
				else{
					String message="Invalid Username and Password";
					System.out.println(message);
					model.addAttribute("mess",message);
					return "user/login";
					
					
				}
			}
			catch(NullPointerException n){
				String message="Invalid Username and Password";
				System.out.println(message);
				model.addAttribute("mess",message);
				return "user/login";
			}
		}
		
		
	
	@GetMapping("user/userhome/{id}")
	//@ResponseBody
	public String userhome(@PathVariable("id") int id,ModelMap  model){
		
		 System.out.println(id);
		
		  User u=service.getUsername(id);
		 //view.addObject("add",service.getUsername(id));
		 System.out.println(service.getUsername(id));
		 model.addAttribute("add",u.getName());
		
		// model.addAttribute("add",id);
		 model.addAttribute("Products", productservice.getAllProducts());
	        
//       if(registerUserModel.getRole()=="ADMIN")
       model.addAttribute("users",service.getAlluser());
		 
		return "user/userhome";
	}
	
	
	
	
	
	
	@GetMapping("admin/register")
	public String adminregister(){
		return "admin/register";
	}
	
	
	
	
	
	@PostMapping("/admin/register")
	//@ResponseBody
	public String adminregisterasrole(@ModelAttribute User user,Model model,@RequestParam("username") String username){
		
		user.setRole("ADMIN");
		String u;
		u= service.findUser(username);
		if(u=="false"){
			
		
		if(user.getPass().equals(user.getCnfmpass())){
			service.createUser(user);
			return "redirect:/admin/login";
		}
		 else {
	            model.addAttribute("error", "Password and Confirm Password does not match");
	            
		
		return "admin/register";
//		return "/admin/success";
		 }
		}
		
		model.addAttribute("userna", "Username Already Exists");
		
		return "admin/register";
		
	}
	
	
	
	
	@GetMapping("user/register")
	public String userregister(){
		return "user/register";
	}
	
	
	
	@PostMapping("/user/register")
	//@ResponseBody
	public String userregisterasrole(@ModelAttribute User user,Model model){
		
		user.setRole("USER");
		String u;
		u= service.findUser(user.getUsername());
		if(u=="false"){
		if(user.getPass().equals(user.getCnfmpass())){
			service.createUser(user);
			return "redirect:/user/login";
		}
		 else {
	            model.addAttribute("error", "Password and Confirm Password does not match");
	            
		
		return "user/register";
//		return "/admin/success";
		 }
		}
model.addAttribute("userna", "Username Already Exists");
		
		return "user/register";
		
		
	}
	
	
	
	@GetMapping("/user")
	public String user(){
		return "Hello User";
	}
	
	@GetMapping("/deliveryPerson")
	public String deliveryPerson(){
		return "Hello DeliveryPerson";
	}
	
	
	@PostMapping("/products/updateproduct/{id}")
	public ModelAndView updateProduct(@PathVariable("id") int id, @ModelAttribute Products pro, @RequestParam("submit") String submit,Model model){
		ModelAndView view = new ModelAndView("products/afterupdateprolist");
//		if(submit.equals("Cancel")){
//			view.addObject("Products",productservice.getAllproductsbyuser(pro.getUserid()));
//			return view;
//		}
//		int ui = productservice.getuserid(id);
//		System.out.println(ui);
//		System.out.println(uid);
//		
		productservice.updateProduct(pro);
		pro.setUserid(uid);
		model.addAttribute("add",pro.getUserid());
		view.addObject("Products",productservice.getAllproductsbyuser(pro.getUserid()));
	   
		return view;
	}
	
	@GetMapping("/products/updateproduct/{id}")
	public String updateproduct(@PathVariable("id") int id, Model model){
//		model.addAttribute("user", service.getuser(productservice.getuserid(id)));

		model.addAttribute("product", productservice.getProduct(id));
		
		return "products/updateproduct";
	}

	@GetMapping("/admin/updateProfile/{id}")
	//@ResponseBody
	public String adminUpdate(@PathVariable("id") int id, Model model){
		model.addAttribute("user", service.getuser(id));
		return "/admin/updateProfile";
	}
	
	@PostMapping("/admin/updateProfile/{id}")
	//@ResponseBody
	public String adminUpdateInsert(@PathVariable("id") int id, @ModelAttribute User user, @RequestParam("submit") String submit){
		System.out.println("SUCCESS");
		service.updateUser(user);
		
		return "redirect:/admin/adminhome/{id}";
	}
	
	
}
