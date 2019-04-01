/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue;

import java.util.*;

// Class for queue
class Queue 
{
	private int arr[];		// array to store queue elements
	private int front;		// front points to front element in the queue (if any)
	private int rear;		// rear points to last element in the queue
	private int capacity;	// maximum capacity of the queue
	private int count;		// current size of the queue
	private int timeOfEachRequest;
	private int totalTime;
	
	// Constructor to initialize queue
	Queue(int size)
	{
		arr = new int[size];
		capacity = size;
		front = 0;
		rear = -1;
		count = 0;
		totalTime=0;
		timeOfEachRequest = 2;
	}

	// Utility function to remove front element from the queue
	public void dequeue()
	{
		// check for queue underflow
		if (isEmpty())
		{
			System.out.println("Queue is Empty");
			System.exit(1);
		}
		totalTime = timeOfEachRequest * arr[front];

		System.out.println("The number of operation process for first person in the line was " + arr[front]+" operation");
                System.out.println("it took " + timeOfEachRequest * arr[front] +" minute to process");

		front = (front + 1) % capacity;
		count--;
	}

	// Utility function to add an item to the queue
	public void enqueue(int item)
	{
		// check for queue overflow
		if (isFull())
		{
			System.out.println("OverFlow\nProgram Terminated");
			System.exit(1);
		}

		System.out.println("Inserting " + item);

		rear = (rear + 1) % capacity;
		arr[rear] = item;
		count++;
	}

	// Utility function to return front element in the queue
	public int peek()
	{
		if (isEmpty()) 
		{
			System.out.println("UnderFlow\nProgram Terminated");
			System.exit(1);
		}
		return arr[front];
	}

	// Utility function to return the size of the queue
	public int size()
	{
		return count;
	}

	// Utility function to check if the queue is empty or not
	public Boolean isEmpty()
	{
		return (size() == 0);
	}

	// Utility function to check if the queue is empty or not
	public Boolean isFull()
	{
		return (size() == capacity);
	}
	public int getTotalTime(){
		return totalTime;
	}
	
	// main function
	public static void main (String[] args)
	{
		// create a queue of capacity 5
		Queue q = new Queue(5);
		Scanner input = new Scanner(Sytem.in);
		boolean bool = true;
		int person = 1;
		 do{
                       System.out.println("Enter A to add a person to the line \n"
                        + "Enter N to process the line \n"
                        + "Enter Q to quit");
                       
                       System.out.println("-------------------------------------");
                     char c = input.next().charAt(0);
                             if(c =='A'){
                                 System.out.println("How many operation(in integer) do this person on the line number "+person +" need");
                                 int x = input.nextInt();
                                 q.enqueue(x);
                             }
                             else if(c=='N'){
                                 System.out.println("Line is being processed");
                                 
                                 q.dequeue();
                             }
                             else if(c == 'Q'){
                                 bool = false;
                             }
                         person++;
                  }while(bool);
                  
                  System.out.println("The total time of the simulation is " + q.getTotalTime()+ " minutes");
                  System.out.println("The number of people in the line is " + q.size());
		
		if (q.isEmpty())
			System.out.println("Queue Is Empty");
		else
			System.out.println("Queue Is Not Empty");
	}
}
