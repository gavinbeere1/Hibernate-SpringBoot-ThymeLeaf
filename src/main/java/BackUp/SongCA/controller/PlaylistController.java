package BackUp.SongCA.controller;





import BackUp.SongCA.model.Playlist;
import BackUp.SongCA.repository.PlaylistRepository;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PlaylistController {

    @Autowired
    PlaylistRepository playlistRepository;

 // Get All Notes
    @GetMapping("/playlists")
    public List<Playlist> getAllPlaylists() {
        return playlistRepository.findAll();
    }
    
 // Create a new Note
    @PostMapping("/playlists")
    public Playlist createNote(@Valid @RequestBody Playlist playlist) {
        return playlistRepository.save(playlist);
    }

 // Get a Single Note
    @GetMapping("/playlists/{id}")
    public ResponseEntity<Playlist> getPlaylistById(@PathVariable(value = "id") Long playlistId) {
        Playlist playlist = playlistRepository.findOne(playlistId);
        if(playlist == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(playlist);
    }

 // Update a Note
    @PutMapping("/playlists/{id}")
    public ResponseEntity<Playlist> updatePlaylist(@PathVariable(value = "id") Long playlistId, 
                                           @Valid @RequestBody Playlist playlistDetails) {
        Playlist playlist = playlistRepository.findOne(playlistId);
        if(playlist == null) {
            return ResponseEntity.notFound().build();
        }
        playlist.setId(playlistDetails.getId());
      
        
        Playlist updatedPlaylist = playlistRepository.save(playlist);
        return ResponseEntity.ok(updatedPlaylist);
    }
    


 // Delete a Note
    @DeleteMapping("/playlists/{id}")
    public ResponseEntity<Playlist> deletePlaylist(@PathVariable(value = "id") Long playlistId) {
        Playlist playlist = playlistRepository.findOne(playlistId);
        if(playlist == null) {
            return ResponseEntity.notFound().build();
        }

        playlistRepository.delete(playlist);
        return ResponseEntity.ok().build();
    }		
}