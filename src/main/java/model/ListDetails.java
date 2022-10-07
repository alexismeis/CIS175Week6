package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author alexismeis - aameis
 * CIS175 - Fall 2022
 * Oct 6, 2022
 */

@Entity
public class ListDetails {
	@Id
	@GeneratedValue
	private int id;
	private String listName;
	private LocalDate startDate;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Classroom classroom;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<ListItem> listOfGrades;
	
	public ListDetails() {
		super();
	}
	
	public ListDetails(int id, String listName, LocalDate startDate, Classroom classroom, List<ListItem> listOfGrades) {
		super();
		this.id = id;
		this.listName = listName;
		this.startDate = startDate;
		this.classroom = classroom;
		this.listOfGrades = listOfGrades;
	}
	
	public ListDetails(String listName, LocalDate startDate, Classroom classroom, List<ListItem> listOfGrades) {
		super();
		this.listName = listName;
		this.startDate = startDate;
		this.classroom = classroom;
		this.listOfGrades = listOfGrades;
	}
	
	public ListDetails(String listName, LocalDate startDate, Classroom classroom) {
		super();
		this.listName = listName;
		this.startDate = startDate;
		this.classroom = classroom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

	public List<ListItem> getListOfGrades() {
		return listOfGrades;
	}

	public void setListOfGrades(List<ListItem> listOfGrades) {
		this.listOfGrades = listOfGrades;
	}

	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", listName=" + listName + ", startDate=" + startDate + ", classroom="
				+ classroom + ", listOfGrades=" + listOfGrades + "]";
	}
	
	
}
