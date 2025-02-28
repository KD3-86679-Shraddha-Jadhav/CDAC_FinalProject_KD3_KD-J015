package com.rto.dao;



	import java.util.Optional;


	import org.springframework.data.jpa.repository.JpaRepository;

	
import com.rto.pojos.User;

public interface UserDao extends JpaRepository<User, Long> {
	Optional<User> findByEmailAndPassword(String em, String pass);
	
}
