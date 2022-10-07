import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.ListDetailsHelper;
import model.Classroom;
import model.ListDetails;
import model.ListItem;

/**
 * @author alexismeis - aameis
 * CIS175 - Fall 2022
 * Oct 6, 2022
 */
public class ListDetailsTester {

	public static void main(String[] args) {
		Classroom math = new Classroom("Math");
		
		ListDetailsHelper ldh = new ListDetailsHelper();
		
		ListItem bgrade = new ListItem("Alexis", "B");
		ListItem dgrade = new ListItem("Jared", "D");
		
		List<ListItem> mathGrades = new ArrayList<ListItem>();
		mathGrades.add(bgrade);
		mathGrades.add(dgrade);
		
		ListDetails mathList = new ListDetails("Math List", LocalDate.now(), math);
		mathList.setListOfGrades(mathGrades);
		
		ldh.insertNewListDetails(mathList);
		
		List<ListDetails> allLists = ldh.getLists();
		for(ListDetails a : allLists) {
			System.out.println(a.toString());
		}
		
	}

}
