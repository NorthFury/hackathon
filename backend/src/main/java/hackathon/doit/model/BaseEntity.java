package hackathon.doit.model;

import javax.annotation.Generated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public boolean equals(Object object) {
		return this.getId().equals(id);
	}
	
	public int hashCode() {
		if (id != null) {
			return id.hashCode();
		}
		
		return super.hashCode();
	}

}
