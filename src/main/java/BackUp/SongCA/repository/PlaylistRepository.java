package BackUp.SongCA.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import BackUp.SongCA.model.Playlist;


@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {

}
