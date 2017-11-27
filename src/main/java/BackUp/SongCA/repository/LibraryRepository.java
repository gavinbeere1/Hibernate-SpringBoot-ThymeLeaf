package BackUp.SongCA.repository;


import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

import BackUp.SongCA.model.Library;


@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {
	
	
		
}