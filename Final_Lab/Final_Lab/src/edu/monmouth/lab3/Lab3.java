package edu.monmouth.lab3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Lab3 {
	public static void main(String args[]) {
		//1. Verify one and only one command line argument If not print a error message and exit 
		if (args.length != Lab3Constants.NUM_OF_ARGS) {
			System.out.println("Incorrect number of arguments");
			System.exit(Lab3Constants.LENGTH_NOT_1);
		}
		String fileName = args[0];
		//2. Redirect stdout and stderr to “Lab3.txt”
		
		try {
			PrintStream newIO = new
			PrintStream(fileName);
			System.setOut(newIO);
			System.setErr(newIO);
			} catch (FileNotFoundException e) {
			System.err.println(e.getMessage() + " Cannot redirect STDERR or STDOUT ");
			e.printStackTrace();
			System.exit(Lab3Constants.REDIRECT_FAILURE);
			}
		
		//3. Declare an array that can house 10 references to Competitor objects
		Competitor[] competitors = new Competitor[Lab3Constants.ARRAY_SIZE];
		
		//4. Open the golf.txt data file. Ensure proper exception handling is performed
		File file;
		Scanner myReader;
		try {
			//and open golf.txt file 
			 file = new File(Lab3Constants.GOLF_FILE);
			 myReader = new Scanner(file);
			int i =0;
			//5. Read each line from the data file.
		      while (myReader.hasNextLine()) {
		        String line = myReader.nextLine();
		        String fields[] = line.split(Lab3Constants.DELIMITER);

		        //Create a Competitor object for each line
		        if(fields.length == Lab3Constants.LEN_OF_GOLF_ARGS) {
		        	//add object to the array
		        	competitors[i++] = new Competitor(fields[Lab3Constants.NAMEOFFSET], Integer.parseInt(fields[Lab3Constants.SCOREOFFSET]));
	  		      	}
	  		      }
	  		      //6. Close the file
	  		      myReader.close();
	  		    } catch (FileNotFoundException e) {
	  		      System.out.println("Can not open or read file");
	  		      e.printStackTrace();
	  		    }
		
		//for(Competitor i : competitors) {
		//	System.out.println(i);
		//} 
		//System.out.println("\n");
		
		//7. Sort the array in ascending order.
		 Arrays.sort(competitors);
		//Print out the sorted array in ascending order.
		 for(Competitor i : competitors) {
				System.out.println(i);
			}
		 System.out.println("\n");
		//8. Declare a PriorityQueue that can house Competitor objects named “golfers”:
		PriorityQueue<Competitor> golfers = new PriorityQueue<Competitor>();
		//9. Iterate through the array-adding the Competitor objects to the PriorityQueue:
		for(Competitor i : competitors) {
		golfers.add(i);
		}
		//for(Competitor c : golfers) {
		//	System.out.println(c);
		//}
		//System.out.println("\n");
		//10. Print the single Competitor with the lowest score by using the poll() method. This will be the leader of the golfers.
		System.out.println(golfers.poll());
		System.out.println("\n");
		
		//12. Declare a second PriorityQueue that can house Competitor objects named “bowlers”.
		//This PriorityQueue will not use the Competitor’s natural ordering. Instead supply it with the BowlerComparator class. 
		PriorityQueue<Competitor> bowlers = new PriorityQueue<Competitor>(Lab3Constants.SIZE, new BowlerComparator());
		//13. Open the bowling.txt data file. Ensure proper exception handling is performed.
		try {
			//and open golf.txt file 
			 file = new File(Lab3Constants.BOWLING_FILE);
			 myReader = new Scanner(file);
			int i =0;
			//14. Read each line as with the golf.txt file
		      while (myReader.hasNextLine()) {
		        String line = myReader.nextLine();
		        String fields[] = line.split(Lab3Constants.DELIMITER);
		        //Create a Competitor object for each line
		        if(fields.length == Lab3Constants.LEN_OF_GOLF_ARGS) {
		        	//the PriorityQueue.
		        	bowlers.add(new Competitor(fields[Lab3Constants.NAMEOFFSET],Integer.parseInt(fields[Lab3Constants.SCOREOFFSET])));
	  		      	}
	  		      }
		    //15. Close the file.
	  		      myReader.close();
	  		    } catch (FileNotFoundException e) {
	  		      System.out.println("Can not open or read file");
	  		      e.printStackTrace();
	  		    }
		// for(Competitor i : bowlers) {
		//		System.out.println(i);
		//	}
		// System.out.println("\n");
		
		//16. Print the single Competitor with the greatest score by using the poll() method. This will
		//be the leader of the bowlers.
		System.out.println(bowlers.poll());
		System.out.println("\n");
		//17. Submit your all source code and Lab3.txt output file to eCampus, proving your code
		//satisfies all requirements. Ensure proper use of constants and exception handling
		
		       
	}

}
