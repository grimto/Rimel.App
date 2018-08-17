package CampingApplication.controller;

import java.util.List;

import javax.validation.Valid;

import CampingApplication.Entites.Circuit;
import CampingApplication.dao.CircuitDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@RestController
//@RequestMapping("/company")
public class CircuitController {

    @Autowired
    CircuitDAO circuitDAO;

    /* to save an employee*/
    @PostMapping("/circuit")
    public Circuit createCircuit(@Valid @RequestBody Circuit emp) {
        return circuitDAO.save(emp);
    }

    /*get all users*/
    @GetMapping("/circuit")
    public List<Circuit> getAllCircuit(){
        return circuitDAO.findAll();
    }

    /*get employee by empid*/
    @GetMapping("/circuit/{id}")
    public ResponseEntity<Circuit> getEmployeeById(@PathVariable(value="id") Long empid){

        Circuit emp= circuitDAO.findOne(empid);

        if(emp==null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(emp);

    }


    /*update an employee by empid*/
    @PutMapping("/circuit/{id}")
    public ResponseEntity<Circuit> updateCircuit(@PathVariable(value="id") Long empid, @Valid @RequestBody Circuit empDetails){

        Circuit emp= CircuitDAO.findOne(empid);
        if(emp==null) {
            return ResponseEntity.notFound().build();
        }

        emp.setID(empDetails.getID());
       // emp.setSpot(empDetails.getSpot());
        emp.setDiff(empDetails.getDiff());

        Circuit updateCircuit = circuitDAO.save(emp);
        return ResponseEntity.ok().body(updateCircuit);



    }

    /*Delete an employee*/
    @DeleteMapping("/circuit/{id}")
    public ResponseEntity<Circuit> deleteCircuit(@PathVariable(value="id") Long empid){

        Circuit emp= circuitDAO.findOne(empid);
        if(emp==null) {
            return ResponseEntity.notFound().build();
        }
        circuitDAO.delete(emp);

        return ResponseEntity.ok().build();


    }



}
