package com.rto.dao;



	import java.util.Optional;

	import org.springframework.data.jpa.repository.JpaRepository;

	import com.rto.pojos.Registeration;

	public interface UserDao extends JpaRepository<Registeration, Long> {
		Optional<Registeration> findByEmailAndPassword(String em, String pass);
	
}
