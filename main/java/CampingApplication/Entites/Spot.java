package CampingApplication.Entites;

import javax.persistence.*;

@Entity
@Table(name="Spot")
//@EntityListeners(AuditingEntityListener.class)
public class Spot {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long ID;

    private long lat;

    private long longitude;
    // TODO add annotation for relation @OneTomany and manytomany class spot et class circuit
    //TODO check this link and add the necessary config class https://stackoverflow.com/questions/38856488/how-to-log-into-my-new-spring-boot-application
   // private List image;

    @ManyToOne (cascade=CascadeType.ALL)
    private Circuit circuit ;
    public Circuit getCircuit(){
        return circuit;
    }
    public void setCircuit(Circuit circuit){
        this.circuit = circuit;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public long getLat() {
        return lat;
    }

    public void setLat(long lat) {
        this.lat = lat;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

   /* public List getImage() {
        return image;
    }

    public void setImage(List image) {
        this.image = image;
    }
*/

}
