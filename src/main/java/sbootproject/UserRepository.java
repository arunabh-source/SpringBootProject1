package sbootproject;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sbootproject.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

	UserEntity findByEmail(String email);
	
	

}
	
