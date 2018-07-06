/*
Name:  Bas van Leersum
Date:  2/6/2018
Description:  	taking a file with tweets 
				and have the user search through them by words in the tweet 
				or by date of tweet
Sources Cited: -
*/
package tweetlist;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TweetListSearcher {

	public static void main(String[] args) throws FileNotFoundException {
		//creating a keyboard scanner for user input
		Scanner keyboard = new Scanner(System.in);
		//asks the user to input file name
		System.out.println("Enter the name of the file that you want to use.");
		String fname = keyboard.nextLine();
		
		try
		{
			//opens the file and reads the file
			FileReader file = new FileReader(fname);
			BufferedReader read = new BufferedReader(file);
			//asks the user for a search phrase to look for in the tweets
			System.out.println("Enter a word or phrase to search for: "); 
			String search = keyboard.nextLine();
			String line;
			//creating a tweetlist
			TweetList list = new TweetList();
			boolean stop = false;
			//loops through the file until empty
			while ((line = read.readLine()) != null)
			{
				//puts every line into a tweet in tweet class
				Tweet value = new Tweet(line);
				//checks if the phrase is in the tweet if so puts it in the linked list
				if (value.textContains(search))
					list.prepend(value);			
			}
			//loops until is told to stop
			while (stop == false)
			{
				//tells the user the size of the linked list.
				int size = list.size();
				System.out.println("There are " + size + " tweets in this list.");
				//prompt the user a couple different choices.
				System.out.println("To print the tweets press 'p'");
				System.out.println("To search within these tweets press 's'");
				System.out.println("To stop the program press 'q'");
				//user input
				String input = keyboard.next();
				//checking what was inputted by user
				if (input.equals("p"))
				{
					//printing the list
					list.print();
					
				}
				//checking what was inputted by user
				else if (input.equals("s"))
				{
					//prompting for a specific search
					System.out.println("press 'w' to search by a word or 'd' to search by date");
					//user input
					String input_search = keyboard.next();
					//checking what was inputted by user
					if(input_search.equals("w"))
					{
						//prompt for a word to search for
						System.out.println("Enter a word to search for: "); 
						//user input
						search = keyboard.next();
						//filter list with the word
						list.filter(search);
					}
					//checking what was inputted by user
					else if(input_search.equals("d"))
					{
						//prompting for a specific search
						System.out.println("Enter a date in the format yyyy-mm-dd: (example: 2015-03-22)"); 
						//user input
						search = keyboard.next();
						//filter the list with the date
						list.filterdate(search);
					}
				}
				//checking for user input
				else if (input.equals("q"))
				{
					//stop the while loop by setting stop = true
					stop = true;
				}
				else
				{
					//user had an invalid input
					System.out.println("Your input was not one of the options available");
				}
			}
			//closing read and keyboard
			read.close();
			keyboard.close();
		}
		//when the file was not found	
		catch (FileNotFoundException e)
		{
			System.out.println("The file " + fname + " has not been found.");
		}
		//when an error occurs
		catch (IOException e)
		{
			System.out.println("An error occurred while reading " + fname + ".");
		}


	}

}
