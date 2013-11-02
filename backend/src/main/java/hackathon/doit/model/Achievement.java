package hackathon.doit.model;

import javax.persistence.Entity;


@Entity
public class Achievement extends BaseEntity{

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
