package CampingApplication.controller;

import CampingApplication.Entites.Spot;
import CampingApplication.dao.SpotDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


//@RestController
//@RequestMapping("/company")


public class SpotController {

        @Autowired
        SpotDAO spotDAO;

        /* to save an User*/
        @PostMapping("/spot")
        public Spot createSpot(@Valid @RequestBody Spot emp) {
            return spotDAO.save(emp);
        }

        /*get all users*/
        @GetMapping("/spot")
        public List<Spot> getAllSpots(){
            return spotDAO.findAll();
        }

        /*get User by empid*/
        @GetMapping("/spot/{id}")
        public ResponseEntity<Spot> getSpotById(@PathVariable(value="id") Long empid){

            Spot emp= spotDAO.findOne(empid);

            if(emp==null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(emp);

        }


        /*update an User by empid*/
        @PutMapping("/spot/{id}")
        public ResponseEntity<Spot> updateSpot(@PathVariable(value="id") Long empid, @Valid @RequestBody Spot empDetails){

            Spot emp= spotDAO.findOne(empid);
            if(emp==null) {
                return ResponseEntity.notFound().build();
            }

            emp.setID(empDetails.getID());
            emp.setLat(empDetails.getLat());
            emp.setLongitude(empDetails.getLongitude());

            Spot updateSpot = spotDAO.save(emp);
            return ResponseEntity.ok().body(updateSpot);
        }

        /*Delete an User*/
        @DeleteMapping("/spot/{id}")
        public ResponseEntity<Spot> deleteSpot(@PathVariable(value="id") Long empid){

            Spot emp= spotDAO.findOne(empid);
            if(emp==null) {
                return ResponseEntity.notFound().build();
            }
            spotDAO.delete(emp);

            return ResponseEntity.ok().build();


        }





}
