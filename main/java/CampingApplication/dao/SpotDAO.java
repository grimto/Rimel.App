package CampingApplication.dao;
import java.util.List;

import CampingApplication.Entites.Spot;
import CampingApplication.repository.SpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SpotDAO {


    @Autowired
    static
    SpotRepository spotRepository;
    /*to save an employee*/

    public Spot save(Spot emp) {
        return spotRepository.save(emp);
    }


    /* search all employees*/

    public List<Spot> findAll(){
        return spotRepository.findAll();
    }


    /*get an employee by id*/
    public Spot findOne(Long empid) {
        return spotRepository.findOne(empid);
    }


    /*delete an employee*/

    public void delete(Spot emp) {
        spotRepository.delete(emp);
    }
}
