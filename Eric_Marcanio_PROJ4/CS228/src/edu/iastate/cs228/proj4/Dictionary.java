package edu.iastate.cs228.proj4;

import java.util.*;
import java.io.*;

/**
 * @author Eric Marcanio
 * 
 * 
 * An application class that uses EntryTree class to process a file of
 * commands (one per line). Each command line consists of the name of
 * a public method of the EntryTree class followed by its arguments in
 * string form if the method has arguments. The name of the file is 
 * available to the main method from its String[] parameter at index 0.
 * You can assume that the command file is always in correct format. The 
 * main method creates an object of the EntryTree class with K being 
 * Character and V being String, reads each line from the command file, 
 * decodes the line by splitting into String parts, forms the corresponding 
 * arguments, and calls the public method from the EntryTree object with 
 * the arguments, and prints out the result on the console. Note that the 
 * name of a public method in the EntryTree class on each command line 
 * specifies that the public method should be called from the EntryTree 
 * object. A sample input file of commands and a sample output file are 
 * provided. 
 * 
 * The sample output file was produced by redirecting the console output
 * to a file, i.e.,
 * 
 * java Dictionary infile.txt > outfile.txt
 *  
 * 
 * NOTE that all methods of EntryTree class can be present as commands
 * except for getAll method inside the input file.
 * 
 * 
 */
public class Dictionary 
{
 public static void main(String[] args) 
 {
	 FileReader nFile = null;
	 EntryTree<Character,String> entryTree = new EntryTree<>();
	 
	 try {//Check if the file is where its supposed to be 
		 nFile = new FileReader(args[0]);
	 }catch(FileNotFoundException error) {
	 }
	 
	 Scanner s = new Scanner(nFile);
	 
	 while(s.hasNextLine()) {
		String line = s.nextLine(); //Scans each line as a string
		String[] arr = line.split("\\s+"); //Stackoverflow says this will detect spaces
		//Now look for each case that the user could ask us to do and call methods based on that
		//NOTE- 0- Instruction, 1- Key, 2- Value
		if(arr[0].equals("add")) {//Add method
			System.out.println("Command: " + arr[0] + " "+ arr[1] +" "+ arr[2]);
			System.out.println("Result from add: " + entryTree.add(charArr(arr[1]), arr[2]));
			System.out.println("");
		}
		if(arr[0].equals("remove")) {//Remove method
			System.out.println("Command " + arr[0] + ": "+ arr[1]);
			System.out.println("Result from remove: " + entryTree.remove(charArr(arr[1])));
			System.out.println("");
		}
		if(arr[0].equals("search")) {//Search method
			System.out.println("Command " + arr[0] + ": "+ arr[1]);
			System.out.println("Result from search: " + entryTree.search(charArr(arr[1])));
			System.out.println("");
		}
		if(arr[0].equals("prefix")) {//Prefix method
			System.out.println("Command " + arr[0] + ": "+ arr[1]);
			
			System.out.print("Result from prefix: ");
			Character[] carr = entryTree.prefix(charArr(arr[1]));
			for(int i = 0; i< carr.length; i++) {
				System.out.print(carr[i]);
			}
			System.out.println("");
		}
		if(arr[0].equals("showTree")) {//Show tree method
			System.out.println("Command " + arr[0]);
			System.out.println("Result from showTree");
			entryTree.showTree();
			System.out.println("");
		}
		if(arr[0].equals("getAll")) {//Show getAll method
			System.out.println("Command " + arr[0]);
			System.out.println("Result from getAll");
			entryTree.getAll();
			System.out.println("");
		}
	 }
	 
 }
 /**
  * All the methods i am calling requries an array so i will put the string into a char arr in order to call methods from EntryTree
  * @param s
  * The string i am turning into a array
  * @return
  * A char array of String
  */
 private static Character[] charArr(String line) {
	 Character[] arr = new Character[line.length()];
	 
	 for(int i = 0; i< line.length(); i++) {
		 arr[i] = new Character(line.charAt(i));//Taking each spot in string and making it a char
	 }
	 
	 return arr;
	 
 }
}
