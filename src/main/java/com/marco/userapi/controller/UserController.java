package com.marco.userapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marco.userapi.model.User;
import com.marco.userapi.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
    UserService usrService;
	
	@RequestMapping(value="/users", method=RequestMethod.POST)
	public User createUser(@RequestBody User usr) {
	    return usrService.createUser(usr);
	}
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public List<User> readUser() {
	    return usrService.getUsers();
	}
	

	
	@RequestMapping(value="/users/{email}", method=RequestMethod.GET)
	public User usrByEmail(@PathVariable(value = "email") String email) {
	    return usrService.getUserByEmail(email);
	}
	

	@RequestMapping(value="/users/{usrId}", method=RequestMethod.PUT)
	public User readUser(@PathVariable(value = "usrId") Long id, @RequestBody User usrDetails) {
	    return usrService.updateUser(id, usrDetails);
	}

	@RequestMapping(value="/users/{usrId}", method=RequestMethod.DELETE)
	public void deleteUser(@PathVariable(value = "usrId") Long id) {
	    usrService.deleteUser(id);
	}


}
