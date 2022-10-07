import java.util.List;

import controller.ClassroomHelper;
import model.Classroom;

/**
 * @author alexismeis - aameis
 * CIS175 - Fall 2022
 * Oct 6, 2022
 */
public class ClassroomTester {
	
	public static void main(String[] args) {
		Classroom science = new Classroom("Science");
		
		ClassroomHelper ch = new ClassroomHelper();
		
		ch.insertClassroom(science);
		
		List<Classroom> allClassrooms = ch.showAllClassrooms();
		for(Classroom a : allClassrooms) {
			System.out.println(a.toString());
		}
	}
}
