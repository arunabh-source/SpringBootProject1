package sbootproject.service.intrf;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import sbootproject.shared.dto.UserDto;

public interface UserService extends UserDetailsService {

	UserDto createUser(UserDto user);
	// following method is no required since it is already part of UserDetailsService
	//UserDetails loadUserByUsername(String email) throws Exception;

}
