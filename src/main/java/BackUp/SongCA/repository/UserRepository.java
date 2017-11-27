package BackUp.SongCA.repository;


import java.util.ArrayList;


import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import BackUp.SongCA.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	
	User findByUsernameAndPassword(String username, String password);
	
	
	

}