package sbootproject.service.intrf;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import sbootproject.shared.dto.UserDto;

public interface UserService extends UserDetailsService {

	UserDto createUser(UserDto user);
	
	UserDto getUser(String email);

	UserDto getUserByUserId(String userId) throws Exception;
	
	UserDto updateUser(String userId, UserDto user);

	void deleteUser(String userId);

	List<UserDto> getUsers(int page, int limit);
	
}
