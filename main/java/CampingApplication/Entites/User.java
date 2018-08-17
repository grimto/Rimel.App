package CampingApplication.Entites;

//import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="Users")
@EntityListeners(AuditingEntityListener.class)

public class User  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	

	private String firstName;

	private String lastName;

	private String role;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	//private Date createdAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getfirstName() {
		return firstName;
	}

	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getlastName() {
		return lastName;
	}

	public void setlastName(String lastName) {
		this.lastName = lastName;
	}

	public String getrole() {
		return role;
	}

	public void setrole(String role) {
		this.role = role;
	}

	//public Date getCreatedAt() {
	//	return createdAt;
	//}

	/*public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}*/

}
