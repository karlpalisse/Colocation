package masini.colocation.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Service {

	@Id
	private Colocation colocation;
	private String title;
	private String description;
	private int cost;
	
	public Service(Colocation colocation, String title, String description, int cost) {
		super();
		this.colocation = colocation;
		this.title = title;
		this.description = description;
		this.cost = cost;
	}
	
	public Service() {
		super();
	}

	public Colocation getColocation() {
		return colocation;
	}

	public void setColocation(Colocation colocation) {
		this.colocation = colocation;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	
	@Override
	
	public String toString() {
		return "Service [ colocation=" + colocation + ", title=" + title + ", description=" + description + ", cost=" + cost + "]" ;
	}
	
}
