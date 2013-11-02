package hackathon.doit.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Activity extends BaseEntity {

	private static final long serialVersionUID = -4005479010028032916L;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="activity")
	private List<Task> tasks = new ArrayList<>();
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

}
