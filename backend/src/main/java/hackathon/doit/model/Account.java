package hackathon.doit.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Account extends BaseEntity {

	private String email;

	@OneToMany(cascade=CascadeType.MERGE)
	private List<AccountTask> tasks = new ArrayList<>();

	@ManyToMany
	private List<Achievement> achievements;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Token> tokens;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<AccountTask> getTasks() {
		return tasks;
	}

	public void setTasks(List<AccountTask> tasks) {
		this.tasks = tasks;
	}

	public List<Token> getTokens() {
		return tokens;
	}

	public void setTokens(List<Token> tokens) {
		this.tokens = tokens;
	}

	public List<Achievement> getAchievements() {
		return achievements;
	}

	public void setAchievements(List<Achievement> achievements) {
		this.achievements = achievements;
	}

}
