/*
Name:  Bas van Leersum
Date:  2/6/2018
Description:  	taking a file with tweets 
				and have the user search through them by words in the tweet 
				or by date of tweet
Sources Cited: -
*/
package tweetlist;

public class TweetList {
    private class Node
    {
        Tweet value;   
        Node next;      
        
        // Constructor for a node.
        Node(Tweet val, Node n)
        {
            value = val;
            next = n;
        } 
        
    }	
	 
    private Node head;
    
    public TweetList()
    {
    		//set the head to null
    		head = null;
    }
    
    public void print()
    {
    		//set the head to the current node
    		Node curr = head;
    		//loop through until curr = null
    		while (curr != null)
    		{
    			//print the tweet
    			curr.value.print();
    			//move to the next node
    			curr = curr.next;
    		}
    }
    
    public void prepend(Tweet newValue)
    {
    		//adding a new node to the list
    		Node newNode = new Node(newValue, head);
        head = newNode;
    }
    
    public int size()
    {
    		//setting count variable
    		int count = 0;
    		//setting node p to head
    		Node p = head;
    		//looping through the list 
    		while (p != null)
    		{
    	        // There is an element at p
    			count ++;
    			//go to the next node
    			p = p.next;
    		}
    		//return count
    	    return count;
    }
    
    public void filter(String keyword)
    {
    		//set curr to head
    		Node curr = head;
    		//set prev to null
    		Node prev = null;
    		
    		//loop through list 
    		while(curr != null)
    		{
    			//check if the keyword is in the text of tweet
    			if (!(curr.value.textContains(keyword)))
    			{
    				//if the curr is the head then move the head
    				if (curr == head)
    					head = head.next;
    				else
    					//move both prev and curr
    					prev.next = curr.next;
    			}
    			else
    				//set prev to curr
    				prev = curr;
    			
    			//move curr to next
    			curr = curr.next;
    		}
    }
    
    public void filterdate(String keyword)
    {
    		//set curr to head
    		Node curr = head;
    		//set prev to null
    		Node prev = null;
    		
    		//loop through list 
    		while(curr != null)
    		{
    			//check if the keyword is in the date of tweet
    			if (!(curr.value.dateContains(keyword)))
    			{
    				//if the curr is the head then move the head
    				if (curr == head)
    					head = head.next;
    				else
    					//move both prev and curr
    					prev.next = curr.next;
    			}
    			else
    				//set prev to curr
    				prev = curr;
    			
    			//move curr to next
    			curr = curr.next;
    		}
    }
}
