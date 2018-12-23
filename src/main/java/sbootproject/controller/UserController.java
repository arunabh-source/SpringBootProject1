package sbootproject.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

		@GetMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public UserRest getUser(@PathVariable String id) throws Exception {
			UserRest returnValue = new UserRest();
			
			UserDto userDto = userService.getUserByUserId(id);
			BeanUtils.copyProperties(userDto, returnValue);
			
			return returnValue;
		}
	
//	    @CrossOrigin(origins = "http://localhost:3000")
//	    @PostMapping(path="/postMethod")
//		@PostMapping
//	    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) {	
//	    	UserRest returnValue = new UserRest();
//	    	
//	    	UserDto userDto = new UserDto();
//	        BeanUtils.copyProperties(userDetails, userDto);
//	    	
//	    	UserDto createdUser = userService.createUser(userDto);
//	    	BeanUtils.copyProperties(createdUser, returnValue);
//	    	
//	    	return returnValue;
//	    }
		
		
		@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
		public UserRest updateUser(@PathVariable String id, @RequestBody UserDetailsRequestModel userDetails) {
			UserRest returnValue = new UserRest();

			UserDto userDto = new UserDto();
			userDto = new ModelMapper().map(userDetails, UserDto.class);

			UserDto updateUser = userService.updateUser(id, userDto);
			returnValue = new ModelMapper().map(updateUser, UserRest.class);

			return returnValue;
		}

}
