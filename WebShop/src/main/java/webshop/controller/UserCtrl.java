package webshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import webshop.service.UserService;

@RestController
@RequestMapping("/user")
public class UserCtrl {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(path = "/login/{username}/{password}")
	public ResponseEntity<?> login(@PathVariable("username") String username, @PathVariable("password") String password) {
		return userService.login(username, password);
	}
	
	@DeleteMapping(path = "/logout/{id}")
	public void logout(@PathVariable("id") Integer id) {
		userService.logout(id);
	}

}
