package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author alexismeis - aameis
 * CIS175 - Fall 2022
 * Oct 6, 2022
 */

@Entity
@Table(name="shopper")
public class Classroom {
	@Id
	@GeneratedValue
	private int id;
	private String classroomName;
	
	public Classroom() {
		super();
	}
	
	public Classroom(int id, String classroomName) {
		super();
		this.id = id;
		this.classroomName = classroomName;
	}
	
	public Classroom(String classroomName) {
		super();
		this.classroomName = classroomName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClassroomName() {
		return classroomName;
	}

	public void setClassroomName(String classroomName) {
		this.classroomName = classroomName;
	}

	@Override
	public String toString() {
		return "Classroom [id=" + id + ", classroomName=" + classroomName + "]";
	}
	
	
	
}
