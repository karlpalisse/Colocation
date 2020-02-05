package masini.colocation.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Colocation {

	@Id
	private String name;
	private String adress;
	@ManyToMany
	private List<User> members;
	
	public Colocation() {
		
	}
	
	public Colocation(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public List<User> getMembers() {
		return members;
	}

	public void setMembers(List<User> members) {
		this.members = members;
	}
	
	public void addMember(User user) {
		this.members.add(user);
	}

}