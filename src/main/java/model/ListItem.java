package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author alexismeis - aameis
 * CIS175 - Fall 2022
 * Sep 29, 2022
 */

@Entity
@Table(name="items")
public class ListItem {

	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="NAME")
	private String name;
	@Column(name="GRADE")
	private String grade;
	
	public ListItem() {
		super();
	}

	public ListItem(String name, String grade) {
		super();
		this.name = name;
		this.grade = grade;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public String returnItemDetails() {
		return this.name + ": " + this.grade;
	}
}
