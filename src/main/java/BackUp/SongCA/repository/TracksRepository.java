package BackUp.SongCA.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import BackUp.SongCA.model.Tracks;


@Repository
public interface TracksRepository extends JpaRepository<Tracks, Long> {

}
