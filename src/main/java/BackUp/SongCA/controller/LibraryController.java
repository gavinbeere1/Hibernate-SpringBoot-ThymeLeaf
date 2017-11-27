package BackUp.SongCA.controller;



import BackUp.SongCA.model.Library;
import BackUp.SongCA.repository.LibraryRepository;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LibraryController {

    @Autowired
    LibraryRepository libraryRepository;

 // Get All Notes
    @GetMapping("/librarys")
    public List<Library> getAllLibrarys() {
        return libraryRepository.findAll();
    }
    
 // Create a new Note
    @PostMapping("/librarys")
    public Library createLibrary(@Valid @RequestBody Library library) {
        return libraryRepository.save(library);
    }

 // Get a Single Note
    @GetMapping("/librarys/{id}")
    public ResponseEntity<Library> getLibraryById(@PathVariable(value = "id") Long libraryId) {
        Library library = libraryRepository.findOne(libraryId);
        if(library == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(library);
    }

 // Update a Note
    @PutMapping("/librarys/{id}")
    public ResponseEntity<Library> updateLibrary(@PathVariable(value = "id") Long libraryId, 
                                           @Valid @RequestBody Library libraryDetails) {
        Library library = libraryRepository.findOne(libraryId);
        if(library == null) {
            return ResponseEntity.notFound().build();
        }
        library.setId(libraryDetails.getId());
      
        
        Library updatedLibrary = libraryRepository.save(library);
        return ResponseEntity.ok(updatedLibrary);
    }
    


 // Delete a Note
    @DeleteMapping("/librarys/{id}")
    public ResponseEntity<Library> deleteLibrary(@PathVariable(value = "id") Long libraryId) {
        Library library = libraryRepository.findOne(libraryId);
        if(library == null) {
            return ResponseEntity.notFound().build();
        }

        libraryRepository.delete(library);
        return ResponseEntity.ok().build();
    }		
}