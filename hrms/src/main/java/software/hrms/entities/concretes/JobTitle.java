package software.hrms.entities.concretes;

import javax.persistence.*;

@Entity
@Table(name = "job_titles")
public class JobTitle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "title")
	private String title;

	public JobTitle(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

	public JobTitle() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}