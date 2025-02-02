/***************************************************************
* file: DataVisualizer.java
* author: Gloriele Mendoza
* class: CS 1400 – Programming and Problem Solving
*
* assignment: program 3
* date last modified: 10/7/2024
*
* purpose: This program takes input from the user about author names and the number of novels. Then it outputs the info in a table and histogram.
*
****************************************************************/

import java.util.Scanner;
import java.util.ArrayList;

public class DataVisualizer {
	public static void main (String [] args) {	
	Scanner scnr = new Scanner(System.in);
	
	//method: System.out.println. This asks the user for input and outputs it.
	System.out.println("Enter a title for the data:");
	//method: scnr.nextLine. This reads the next line of input from the user.
	String bookTitle = scnr.nextLine();
	System.out.println("You entered: " + bookTitle);
	System.out.println();
	
	System.out.println("Enter the column 1 header:");
	String authorName = scnr.nextLine();
	System.out.println("You entered: " + authorName);
	System.out.println();
	
	System.out.println("Enter the column 2 header:");
	String numberOfNovels = scnr.nextLine();
	System.out.println("You entered: " + numberOfNovels);
	System.out.println();
	
	ArrayList<String> authors = new ArrayList<>();
        ArrayList<Integer> novelCounts = new ArrayList<>();
	
	while (true) {
	System.out.println("Enter a data point (-1 to stop input):");
	String str = scnr.nextLine();

		
	if (str.equals("-1")) {
		System.out.println();
            break;
	}
	//method: split. This method splits the inputted string by a comma. The parts of the string are stored into an array.
		String[] array = str.split(",");
			
	if (array.length == 2) {
        String author = array[0];
        String numberStr = array[1];

          Scanner numberScanner = new Scanner(numberStr);
            if (numberScanner.hasNextInt()) {
                int number = numberScanner.nextInt();
                System.out.println("Data string: " + author);
                System.out.println("Data integer: " + number);
				System.out.println();
				//method: .add This method adds the author and number elements to the Array List I created earlier.
				 authors.add(author); 
                 novelCounts.add(number);
                } 
				else {
                    System.out.println("Error: Comma not followed by an integer.");
					System.out.println();
                }
            } 
			else if (array.length > 2) {
                System.out.println("Error: Too many commas in input.");
				System.out.println();
            } 
			else if (array.length < 2) {
                System.out.println("Error: No comma in string.");
				System.out.println();
            }
	}
	
	//This whole section makes the table
	
	//method: system.out.printf. This method formats the info into a table. 
	 System.out.printf("%33s%n", bookTitle);
	 //method: system.out.printf. This method specifically formats the table with a minimum width of 19 and 22 characters. The - before 19 makes it left justified.
        System.out.printf("%-19s | %22s%n", authorName, numberOfNovels);
        System.out.println("--------------------------------------------");
        
        for (int i = 0; i < authors.size(); i++) {
            System.out.printf("%-19s | %22d%n", authors.get(i), novelCounts.get(i));
			
			
	}
	//This whole section makes the histogram
	
		System.out.println(); 
		int i;
		int j; 
    for (i = 0; i < authors.size(); i++) {
		//method: .get This method retrieves each element (authors and number of novels) from the ArrayLists at index i.
           String author = authors.get(i);
           int count = novelCounts.get(i);

           //method: system.out.printf. This formats the output with a minimum of 20 characters as a string.
		   System.out.printf("%20s ", author);

            for (j = 0; j < count; j++) {
                System.out.print("*");
            }
            System.out.println();
		}
	}
}
	
	
	
	