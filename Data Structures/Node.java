/**
 * Node.
 *
 * @author Wm.Muir
 * @version 2020-21.Q1
 */
package edu.hdsb.gwss.ics4u.u5;

import java.net.URL;

/**
 * TODO
 */
public class Node implements NodeInterface {
    //INSTANCE VARIABLES
     private URL url;
     private Node previous;
     private Node next;
     
     //DEFAULT CONSTRUCTOR
     public Node(){
         
     }
   //CONSTRUCTOR USED WHEN USER PASSES URL
   public Node(URL url){
       //IF URL IS NOT NULL THEN RUNS
       if(url != null){
       this.url = url;
       this.previous = null;
       this.next = null;
       }
       
   }
    public Node getNext() {
        return this.next;
        
    }

   
    public void setNext(Node node) {
        this.next = node;
    }

    
    public Node getPrevious() {
        return this.previous;
    }

 
    public void setPrevious(Node node) {
        this.previous = node;
      
    }

   
    public URL getValue() {
        return this.url;
    }

}
