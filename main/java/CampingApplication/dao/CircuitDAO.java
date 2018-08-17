package CampingApplication.dao;
import java.util.List;

import CampingApplication.Entites.Circuit;
import CampingApplication.repository.CircuitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CircuitDAO {

    @Autowired
    static
    CircuitRepository circuitRepository;
    /*to save an employee*/

    public Circuit save(Circuit emp) {
        return circuitRepository.save(emp);
    }


    /* search all employees*/

    public List<Circuit> findAll(){
        return circuitRepository.findAll();
    }


    /*get an employee by id*/
    public static Circuit findOne(Long empid) {
        return circuitRepository.findOne(empid);
    }


    /*delete an employee*/

    public void delete(Circuit emp) {
        circuitRepository.delete(emp);
    }
}
