package CampingApplication.Entites;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Circuit")
//@EntityListeners(AuditingEntityListener.class)
public class Circuit {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long ID;


    @OneToMany(targetEntity =Spot.class , cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private List <Spot> spot;
    public Circuit(){
        this.spot= new ArrayList() ;
    }
    public void AddSpot(Spot spot){
        this.spot.add(spot);
    }
    private Difficulty diff;
    public void setDiff(Difficulty diff) {
        this.diff = diff;
    }
    public Difficulty getDiff() {
        return diff;
    }


    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }
/*
    public List getSpot() {
        return spot;
    }

    public void setSpot(List spot) {
        this.spot = spot;
    }
    */
}
