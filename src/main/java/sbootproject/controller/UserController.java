package sbootproject.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sbootproject.model.request.UserDetailsRequestModel;
import sbootproject.model.response.UserRest;
import sbootproject.service.intrf.UserService;
import sbootproject.shared.dto.UserDto;

@RestController   
@RequestMapping(path="/users")
public class UserController {
		
	@Autowired
	UserService userService;	

//		@RequestMapping(path="/getReq")
		public String something() {
			return "hello from something";
		}
	
//	    @CrossOrigin(origins = "http://localhost:3000")
//	    @PostMapping(path="/postMethod")
		@PostMapping
	    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) {	
	    	UserRest returnValue = new UserRest();
	    	
	    	UserDto userDto = new UserDto();
	        BeanUtils.copyProperties(userDetails, userDto);
	    	
	    	UserDto createdUser = userService.createUser(userDto);
	    	BeanUtils.copyProperties(createdUser, returnValue);
	    	
	    	return returnValue;
	    }

}
