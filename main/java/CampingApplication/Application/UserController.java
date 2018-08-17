package CampingApplication.Application;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CampingApplication.dao.UserDAO;
import CampingApplication.Entites.User;

@RestController
//@RequestMapping("/")
public class UserController {
		@Autowired
	 UserDAO userDAO;

	/* to save an User*/
	@RequestMapping("/")
	public String bonjours (){
		return "bonjour";
	}
	@PostMapping("/user")
	public User createUser(@Valid @RequestBody User emp) {
		return userDAO.save(emp);
	}
	
	/*get all user*/
	@GetMapping("/user")
	public List<User> getAllUser(){
		return userDAO.findAll();
	}
	
	/*get User by empid*/
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value="id") Long empid){
		
		User emp= userDAO.findOne(empid);
		
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);
		
	}
	
	
	/*update an User by empid*/
	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value="id") Long empid, @Valid @RequestBody User empDetails){
		
		User emp= userDAO.findOne(empid);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		
		emp.setfirstName(empDetails.getfirstName());
		emp.setlastName(empDetails.getlastName());
		emp.setrole(empDetails.getrole());
		
		User updateUser = userDAO.save(emp);
		return ResponseEntity.ok().body(updateUser);
		
		
		
	}
	
	/*Delete an User*/
	@DeleteMapping("/user/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable(value="id") Long empid){
		
		User emp= userDAO.findOne(empid);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		userDAO.delete(emp);
		
		return ResponseEntity.ok().build();
		
		
	}
	
	

}
