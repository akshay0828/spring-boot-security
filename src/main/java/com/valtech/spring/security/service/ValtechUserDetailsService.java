package com.valtech.spring.security.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import com.valtech.spring.security.entity.Products;
import com.valtech.spring.security.entity.User;
import com.valtech.spring.security.repo.UserReopsitory;



@Service
public class ValtechUserDetailsService  {

	@Autowired
	private UserReopsitory userRepository;
	
	
	public void  resetUser() {
		userRepository.deleteAll();
		
	}
	
	public void createUser(User user) {
		userRepository.save(user);
	}
	
	

	
	
	
	
 public int LoginValidator(String username) {
		
	 if(userRepository.findByUsername(username)!=null){
		 return 1;
	 }
	 
	 
		return 0;
		
		
	}
 public String  getrole(String username) {
	 
	User u= userRepository.findByUsername(username);
	
	return u.getRole();
}
 
 public int  getId(String username) {
	 
	User u= userRepository.findByUsername(username);
	
	return u.getId();
}
 

 public User getUsername(int id) 
 {
	return userRepository.findUsernameById(id);

 }
 
	
 
 public String findUser(String username) {
	 
	 if(userRepository.findByUsername(username)!=null){
		 
		 return userRepository.findByUsername(username).getUsername();
	 }
	 
	 
		return "false";
		
		
	}
public String findUserPass(String username) {
	 
	 if(userRepository.findByUsername(username)!=null){
		 
		 return userRepository.findByUsername(username).getPass();
	 }
	 
	 
		return "false";
		
		
	}
	 
	

 public  User getuser(int id){
	 
	 return userRepository.findById(id);
 }
 
//@Transactional(propagation = Propagation.REQUIRED)
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	 public List< User> getAlluser(){
		 return userRepository.findByRole("ADMIN");
	 }
 
}
