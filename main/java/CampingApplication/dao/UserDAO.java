package CampingApplication.dao;

import java.util.List;

import CampingApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CampingApplication.Entites.User;

@Service
public class UserDAO {
	
	@Autowired
	UserRepository userRepository ;
	
	/*to save an employee*/
	
	public User save(User emp) {
		return userRepository.save(emp);
	}
	
	
	/* search all employees*/
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	
	/*get an employee by id*/
	public User findOne(Long empid) {
		return userRepository.findOne(empid);
	}
	
	
	/*delete an employee*/
	
	public void delete(User emp) {
		userRepository.delete(emp);
	}
	

}
