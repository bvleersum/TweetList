/*
Name:  Bas van Leersum
Date:  2/6/2018
Description:  	taking a file with tweets 
				and have the user search through them by words in the tweet 
				or by date of tweet
Sources Cited: -
*/

package tweetlist;

import java.util.Scanner;

public class Tweet {
	//declaring different variables
	private double lat, lon;
	int year, month, day;
	String time, text, date;
	
	public Tweet(String s)
	{
		//making a new scanner called scan
		Scanner scan = new Scanner(s);
		//setting lat to next double
		lat = scan.nextDouble();
		//setting lon to next double
		lon = scan.nextDouble();
		//reading next int
		scan.nextInt();
		//set date to next string up until space
		date = scan.next();
		//splitting the date by "-"
		String[] d = date.split("-");
		//taking the first part of the split as year
		year = Integer.parseInt(d[0]);
		//taking the second part of the split as month
		month = Integer.parseInt(d[1]);
		//taking the third part of the split as day
		day = Integer.parseInt(d[2]);
		//setting the time to next string until space
		time = scan.next();
		//setting the text to rest of the string
		text = scan.nextLine();
		//close scanner
		scan.close();
	}
	
	public void print()
	{
		//print out the tweet with the different variables
		System.out.println("Text: " + text);
		System.out.println("Location: " + lat + ", " + lon);
		System.out.println("Date: " + month + "/" + day + "/" + year);
		System.out.println("Time " + time);
		System.out.println();
	}
	
	public boolean textContains(String searchTerm)
	{
		//checking if a certain word is in the text
		return !(text.indexOf(searchTerm) == -1);
	}
	
	public boolean dateContains(String searchTerm)
	{
		//checking for the date to be equal to the 
		return !(date.indexOf(searchTerm) == -1);
	}
}
