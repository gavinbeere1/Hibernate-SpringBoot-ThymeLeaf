package BackUp.SongCA.controller;



import BackUp.SongCA.model.Tracks;
import BackUp.SongCA.repository.TracksRepository;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TracksController {

    @Autowired
    TracksRepository tracksRepository;

 // Get All Notes
    @GetMapping("/tracks")
    public List<Tracks> getAllTrackss() {
        return tracksRepository.findAll();
    }
    
 // Create a new Note
    @PostMapping("/tracks")
    public Tracks createTracks(@Valid @RequestBody Tracks tracks) {
        return tracksRepository.save(tracks);
    }

 // Get a Single Note
    @GetMapping("/tracks/{id}")
    public ResponseEntity<Tracks> getTracksById(@PathVariable(value = "id") Long tracksId) {
        Tracks tracks = tracksRepository.findOne(tracksId);
        if(tracks == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(tracks);
    }

 // Update a Note
    @PutMapping("/tracks/{id}")
    public ResponseEntity<Tracks> updateTracks(@PathVariable(value = "id") Long tracksId, 
                                        
    		
    		@Valid @RequestBody Tracks tracksDetails) {
        Tracks tracks = tracksRepository.findOne(tracksId);
        if(tracks == null) {
            return ResponseEntity.notFound().build();
        }
        tracks.setName(tracksDetails.getName());
        tracks.setArtist(tracksDetails.getArtist());
        tracks.setAlbum(tracksDetails.getAlbum());
        tracks.setGenre(tracksDetails.getGenre());
        tracks.setTotalTime(tracksDetails.getTotalTime());
        tracks.setTrackCount(tracksDetails.getTrackCount());
        
       
        
        
        Tracks updatedTracks = tracksRepository.save(tracks);
        return ResponseEntity.ok(updatedTracks);
    }
    


 // Delete a Note
    @DeleteMapping("/tracks/{id}")
    public ResponseEntity<Tracks> deleteTracks(@PathVariable(value = "id") Long tracksId) {
        Tracks tracks = tracksRepository.findOne(tracksId);
        if(tracks == null) {
            return ResponseEntity.notFound().build();
        }

        tracksRepository.delete(tracks);
        return ResponseEntity.ok().build();
    }		
}