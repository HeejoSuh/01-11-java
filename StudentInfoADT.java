/****************************************************************************
 *
 * Created by: Heejo Suh
 * Created on: Mar 2018
 * Created for: learning
 * 
 * 
 * An Abstract Data Type (ADT) is 
 * 	a set of values,
 *  a set of operations(which can be applied uniformly to all of the values). 
 * Is not characterized by its data representation
 * (Data representation is private and changeable, with no effect on application code).
 * 
 * 
 * 
 * This program holds student information in an array
 * 	as each new student's info is entered, a new entry is created in the array
 * 	use an ADT to hold the student info
 *     
 *
 ****************************************************************************/




//have to import the following:
import java.util.Scanner;

//---------------------------------------------------------------------------------

//enum showing Grades and grade in String
enum GradesEnum {
	TWELVE("12"), 
	ELEVEN("11"), 
	TEN("10"), 
	NINE("9"), 
	EIGHT("8"), 
	SEVEN("7"); //close off last enum (;)

	private final String grade;
	//need to define specifically what the data type is
	GradesEnum(String grade) {
        this.grade = grade;
    }
}//closing for enum


//---------------------------------------------------------------------------------
/****************************************************************************
	Written by Mr. Coxall
	This class creates a student database and returns values
****************************************************************************/
class Student {
	
	public String _firstName;
	public String _lastName;
	public String _middleInitial;
	public String _dateOfBirth; //dd/mm/yyyy
	//public GradesEnum _grade;
	public String _grade;
	//public boolean _identified;
	public String _identified;
	
	//constructor
	public Student (String firstName, 
			        String lastName, 
			        String middleInitial, 
			        String dateOfBirth, 
			        //GradesEnum grade,  
			        String grade, 
			        //boolean identified
			        String identified) {
		
		//local "this"
		this._firstName = firstName;
		this._lastName = lastName;
		this._middleInitial = middleInitial;
		this._dateOfBirth = dateOfBirth;
		this._grade = grade;
		this._identified = identified;
	}
}



//---------------------------------------------------------------------------------
public class StudentInfoADT {

	public static void main(String args[]) {

		//set up a scanner to get the response from the user
		Scanner scanner = new Scanner(System.in);
	
		//set variables to a default	
		String currentInput;
		//Integer studentNum = 1;

		
		/****************************************************************************
		 * //String[] infoToPutIn;
		 * infoToPutIn = new String[6];// allocates memory for 6 strings
		 *****************************************************************************/
		
		//String firstName, lastName, middleInitial, dateOfBirth, grade;
		String firstName="First name", lastName="Last name", dateOfBirth="Date of Birth", middleInitial="Middle Initial", grade="Grade", identified="if the student is identified";
		
		/****************************************************************************
			List<String> currentStudent = new ArrayList<String>();
			String[] currentStudent;
			String[] currentStudent = new String [] {"First name","Last name","Date of Birth", "Middle Initial", "Grade", "if the student is identified"};
			List<Integer> currentStudent = new ArrayList<>();
		 *****************************************************************************/
				
		String[] currentStudent = new String [] {firstName, lastName, middleInitial, dateOfBirth, grade, identified};
				
		
		//get input
		//while (haveGottenDistance == "") {
		while (true) {
			//get input and put it to array
			
			for ( int index=0; index<currentStudent.length; index++ ) {  
	    		//get correct input
			    getCorrectInput:
			    	while (true) {
						System.out.println("\nEnter "+currentStudent[index]+" for student");
						//---------------------------
						if (currentStudent[index] == "Grade") {
							System.out.print("Options: ");
							//for grades, print possible inputs
							for(GradesEnum grades : GradesEnum.values()) { 
								System.out.print(grades + " ");
							}
						}
						
						currentInput = scanner.nextLine(); // get input
						
						//---------------------------
						if (currentStudent[index] == grade) {
							//if input is in enum
							try {
								Object currentGrade = GradesEnum.valueOf(currentInput.toUpperCase());
								currentStudent[index] = currentGrade.toString();
								break getCorrectInput;
							}catch (IllegalArgumentException x) { 
								System.out.println("Please input a valid grade!\n");
							}
						//---------------------------
						}else if (currentStudent[index] == identified) {
							//if input is yes or no
							//compare **string**
							if (currentInput.equals("y") ||currentInput.equals("Y") || currentInput.equals("n") || currentInput.equals("N") ) {
								currentStudent[index] = currentInput; //add to list
								break getCorrectInput;
							}else {
								System.out.println("Please enter  Y or N for yes or no!\n");
							}
						//---------------------------
						}else {
							currentStudent[index] = currentInput; //add to list
						break getCorrectInput;
						}
			    	}
			}
			//create student
			//firstName, lastName, dateOfBirth, middleInitial, grade, identified
					//Student thisStudent = new Student(firstName, lastName, dateOfBirth, middleInitial, grade, identified);
			Student thisStudent = new Student(currentStudent[0], currentStudent[1], currentStudent[2], currentStudent[3], currentStudent[4], currentStudent[5]);
		    
			
			
			/****************************************************************************
				Good example & explanation for using string formatters (ex. decimal format)
				->  https://dzone.com/articles/java-string-format-examples
			 ****************************************************************************/
			 String stringToPrint = String.format("\n\nStudent named %s %s %s in grade %s saved!\n\n",
			    		thisStudent._firstName, thisStudent._middleInitial, thisStudent._lastName, thisStudent._grade);
			 System.out.println(stringToPrint);
			 break;
			
		}//closing for while
	}//closing for main

} //closing for StudentInfoADT


//---------------------------------------------------------------------------------

		
