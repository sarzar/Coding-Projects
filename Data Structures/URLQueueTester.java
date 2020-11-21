/*
 *  Name: Sarim Zia
 *  Description: URL Queue Tester
 */
package edu.hdsb.gwss.ics4u.u5;

import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author sarimzia
 */
public class URLQueueTester {

    public static void main(String[] args) throws MalformedURLException {

        //CONSTANT FOR SIZE OF STACK
        final int QUEUE_SIZE = 7;

        //NEW URL ARRAY
        URL[] url = new URL[QUEUE_SIZE];

        //LOOP TO ADD UNIQUE WEBSITES TO ARRAY
        for (int i = 0; i < QUEUE_SIZE; i++) {
            url[i] = new URL("https://TestWebsite" + i + ".com");

        }

        //CREATES NEW URLQUEUE OBJECT
        URLQueue queue = new URLQueue(QUEUE_SIZE);

        //SPECIAL CASE NULL URL
        URL urlnull = null;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("**************************************************");

        System.out.println("Testing all cases for empty queue....");//Testing cases for empty queue
        
        assert (queue.capacity() == QUEUE_SIZE);
        assert (queue.toString() == null);
        assert (queue.isFull() == false);
        assert (queue.isEmpty() == true);
        assert (queue.peek() == null);
        assert (queue.dequeue() == null);

        System.out.println("Case Passed!");

        System.out.println("Testing all cases for make empty when empty.....");//Testing cases for make empty when already empty
        
        queue.makeEmpty();
        
        assert (queue.isEmpty() == true);
        assert (queue.toString() == null);
        assert (queue.isFull() == false);
        assert (queue.peek() == null);
        assert (queue.dequeue() == null);
        assert (queue.capacity() == QUEUE_SIZE);

        System.out.println("Case Passed!");

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("**************************************************");

        System.out.println("Testing all cases until array is filled.....");//Testing cases while array is filled in loop
        for (int i = 0; i < queue.capacity(); i++) {

            queue.enqueue(url[i]);
            System.out.println("Enque Test: " + queue);
            assert (queue.size() == i + 1);
            assert (queue.peek().equals(url[0]));
            assert (queue.capacity() == QUEUE_SIZE);
            assert (queue.isEmpty() == false);
            if (i < QUEUE_SIZE - 1) {
                
                assert (queue.isFull() == false);

            } 
            else {
                
                assert (queue.isFull() == true);
            }

        }
        
        System.out.println("Case Passed!");
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("**************************************************");

        System.out.println("Testing all cases with overflowing....");//Attempting to overflow queue
        
        queue.enqueue(url[1]);
        
        assert (queue.capacity() == QUEUE_SIZE);
        
        System.out.println("Queue after overflowing: " + queue);
        assert (queue.isFull() == true);
        assert (queue.size() == QUEUE_SIZE);
        assert (queue.isEmpty() == false);
        assert (queue.peek().equals(url[0]));
        
        System.out.println("Case Passed!");

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("**************************************************");

        System.out.println("Testing Make Empty after multiple operations....");//Testing make empty after doing a variety of operations on data
        
        queue.makeEmpty();
        
        assert (queue.size() == 0);
        assert (queue.capacity() == QUEUE_SIZE);
        assert (queue.toString() == null);
        assert (queue.dequeue() == null);
        assert (queue.isEmpty() == true);
        assert (queue.peek() == null);
        assert (queue.isFull() == false);
        
        System.out.println("Case passed!");

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("**************************************************");

        System.out.println("Testing dequeue....");//Testing dequeue method
        for (int i = 0; i < queue.capacity(); i++) {
            
            queue.enqueue(url[i]);

        }
        for (int i = 0; i <= queue.capacity(); i++) {
            
            if (i < queue.capacity()) {
                
                assert (queue.dequeue().equals(url[i]));
            } 
            else {
                
                assert (queue.dequeue() == null);
            }
            System.out.println("Dequeue Test: " + queue);
            
            assert (queue.isFull() == false);

            if (i < queue.capacity() - 1) {
                
                assert (queue.isEmpty() == false);
                
            } 
            else {
                
                assert (queue.isEmpty() == true);
            }
        }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("**************************************************");

        System.out.println("Testing wrapping.....");//Testing wrapping of data
        
        for (int i = 0; i < queue.capacity(); i++) {
            
            queue.enqueue(url[i]);
            
        }

        System.out.println("Queue before wrapping: " + queue);
        
        for (int i = 0; i < queue.capacity() / 2; i++) {
            
            queue.dequeue();
            queue.enqueue(url[i]);
            
        }

        assert (queue.capacity() == QUEUE_SIZE);
        assert (queue.isEmpty() == false);
        assert (queue.isFull() == true);
        assert (queue.peek().equals(url[3]));
        
        System.out.println("Final wrapping result: " + queue);

        for (int i = 0; i < 2; i++) {
            
            queue.dequeue();
            queue.enqueue(url[i]);
            
        }
        System.out.println("Final wrapping result: " + queue);

        System.out.println("Case passed!");

        System.out.println("Testing all cases for make empty after wrapping.....");//Testing make empty after wrapping data
        
        queue.makeEmpty();
        
        assert (queue.isEmpty() == true);
        assert (queue.toString() == null);
        assert (queue.isFull() == false);
        assert (queue.peek() == null);
        assert (queue.dequeue() == null);
        assert (queue.capacity() == QUEUE_SIZE);

        System.out.println("Case Passed!");
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("**************************************************");

        System.out.println("SPECIAL CASE: TRYING TO STORE NULL URL IN QUEUE....");//Trying to store null url in queue
        
        queue.enqueue(urlnull);
        
        assert (queue.size() == 0);
        assert (queue.capacity() == QUEUE_SIZE);
        assert (queue.toString() == null);
        assert (queue.peek() == null);
        assert (queue.isFull() == false);
        assert (queue.isEmpty() == true);
        assert (queue.dequeue() == null);
        
        System.out.println("Case passed!");
        
        System.out.println("**************************************************");

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }

}
