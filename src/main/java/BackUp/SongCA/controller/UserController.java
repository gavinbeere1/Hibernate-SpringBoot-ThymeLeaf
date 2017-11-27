package BackUp.SongCA.controller;

import BackUp.SongCA.model.User;
import BackUp.SongCA.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

@Controller
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserRepository userRepository;

 // Get All Notes
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    
//	
//	@GetMapping("/user") //@RequestMapping implements all get, post methods etc
//	public String userForm(Model model) { //uses a model object to expose a new user to the view table
//		
//		model.addAttribute("user", new User());
//		return "user";
//	}
//	
//	@PostMapping("/user")
//	public String userSubmit(@ModelAttribute User user)
//	{
//		return "result";
//	}

    
    
 // Create a new Note
    @PostMapping("/users")
    public User createNote(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

 // Get a Single Note
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId) {
        User user = userRepository.findOne(userId);
        if(user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(user);
    }

 // Update a Note
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId, 
                                           @Valid @RequestBody User userDetails) {
        User user = userRepository.findOne(userId);
        if(user == null) {
            return ResponseEntity.notFound().build();
        }
        user.setUsername(userDetails.getUsername());
        user.setPassword(userDetails.getPassword());
        user.setOnline(userDetails.getOnline());
        
        
        User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }
    


 // Delete a Note
    @DeleteMapping("/users/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable(value = "id") Long userId) {
        User user = userRepository.findOne(userId);
        if(user == null) {
            return ResponseEntity.notFound().build();
        }

        userRepository.delete(user);
        return ResponseEntity.ok().build();
    }		
}