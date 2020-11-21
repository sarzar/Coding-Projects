package edu.hdsb.gwss.ics4u.u5;

import java.net.URL;

public class URLLinkedList implements URLLinkedListInterface {

    //INSTANCE VARIABLES
    private Node head;
    private Node tail;
    private Node node;

    //DEFAULT CONSTRUCTOR
    public URLLinkedList() {

    }

    public void addFirst(URL value) {

        //ONLY RUNS IF VALUE IS NOT NULL
        if (value != null) {
            
            //MAKES NEW NODE
            node = new Node(value);
            //SPECIAL CASE FOR EMPTY LINKED LIST: SETS HEAD AND TAIL EQUAL TO NOD
            if (isEmpty()) {

                this.head = node;
                this.tail = node;

            } //IF NOT SPECIAL CASE, USES THIS TO ADD FIRST
            else {
                node.setNext(head);
                head.setPrevious(node);
                this.head = node;

            }
        }

    }

    public void addLast(URL value) {

        //RUNS OLY IF VALUE ISN'T NULL
        if (value != null) {
            
            //CREATES NEW NODE
            node = new Node(value);
            //SPECIAL CASE FOR EMPTY LINKED LIST
            if (isEmpty()) {
                
                //CALLS ADDFIRST METHOD TO NOT COPY CODE
                addFirst(value);

            } //IF NOT SPECIAL CASE, USES THIS TO ADD LAST
            else {
                
                node.setPrevious(this.tail);
                this.tail.setNext(node);
                this.tail = node;

            }
        }
    }

    public URL removeFirst() {
        //ONLY RUNS IF NOT EMPTY
        if (!this.isEmpty()) {
            
            //CREATES NEW URL
            URL url;
            //SPECIAL CASE FOR IF SIZE IS 1
            if (this.size() == 1) {
                
                //VALUE OF HEAD STORES IN TEMPORARY URL HOLDER
                url = this.head.getValue();
                //CALLS MAKEEMPTY SINCE YOU'RE REMOVING ONLY ELEMENT IN LINKED LIST
                this.makeEmpty();
                //RETURNS TEMPORARY URL HOLDER TO USER
                return url;
            }
            //IF NOT SPECIAL CASE, USES THIS TO REMOVE FIRST

            //TEMPORARY HOLDER VALUE FOR OLD HEAD VALUE
            Node oldhead = this.head;
            this.head.getNext().setPrevious(null);
            //VALUE OF HEAD STORED IN TEMPORARY URL HOLDER
            url = this.head.getValue();
            this.head = this.head.getNext();
            oldhead.setNext(null);
            //RETURNS TEMPORARY URL HOLDER TO USER
            return url;

        }
        //DEFAULT RETURN VALUE IF NOT RETURNED BEFORE 
        return null;
    }

    public URL removeLast() {
        
        //ONLY RUNS IF LINKED LIST IS NOT EMPTY
        if (!this.isEmpty()) {
            
            //CREATES TEMPORARY HOLDER VARIABLE FOR URL
            URL url;
            //SPECIAL CASE IF SIZE IS 1
            if (this.size() == 1) {
                
                //STORES VALUE OF TAIL IN TEMPORARY URL HOLDER
                url = this.tail.getValue();
                //CALLS MAKE EMPTY METHOD SINCE REMOVING LAST ELEMENT IN LINKED LIST
                this.makeEmpty();
                //RETURNS TEMPORARY URL HOLDER VALUE TO USER
                return url;

            }
            //STORES OLD TAIL INTO VARIABLE
            Node oldtail = this.tail;
            this.tail.getPrevious().setNext(null);
            //STORES VALUE OF OLD TAIL IN URL HOLDER VARIABLE
            url = this.tail.getValue();
            this.tail = this.tail.getPrevious();
            oldtail.setPrevious(null);
            //RETURNS URL HOLDER VARIABLE TO USER
            return url;

        }
        //DEFAULT RETURN VALUE IF NOT RETURNED BEFORE
        return null;
    }

    public URL getFirst() {
        //RUNS IF NOT EMPTY OTHERWISE RETURNS NULL
        if (!isEmpty()) {
            return this.head.getValue();
        }
        return null;
    }

    public URL getLast() {
        //RUNS IF NOT EMPTY OTHERWISE RETURNS NULL
        if (!isEmpty()) {
            return this.tail.getValue();
        }
        return null;
    }

    public int size() {
        //HOLDS HEAD IN NODE
        Node i = head;
        //COUNTER VARIABLE 
        int counter = 1;
        //SPECIAL CASE IF LIST IS EMPTY: RETURNS 0
        if (isEmpty()) {
            
            return 0;
            
        }
        //LOOP GOING THROUGH ALL VALUES INSIDE LINKED LIST UNTIL NODE.NEXT = NULL
        while (i.getNext() != null) {
            
            counter++;
            i = i.getNext();
            
        }
        //RETURNS COUNTER VARIABLE TO USER
        return counter;
    }

    public boolean isEmpty() {
        //IF HEAD POINTS TO NULL THEN LIST EMPTY: RETURNS TRUE, OTHERWISE RETURNS FALSE
        if (this.head == null) {
            
            return true;
        }
        return false;
    }

    public void makeEmpty() {
        
        //SETS HEAD AND TAIL TO NULL
        this.head = null;
        this.tail = null;

    }

    public boolean remove(URL value) {
        
        //RUNS ONLY IF VALUE PASSED BY USER IS NOT NULL
        if (value != null) {
            
            //RUNS ONLY IF LINKED LIST IS NOT EMPTY
            if (!this.isEmpty()) {
                
                //SPECIAL CASE IF URL PASSED BY USER IS EQUAL TO THE VALUE OF THE HEAD
                if (value.equals(head.getValue())) {
                    
                    //CALLS REMOVE FIRST METHOD
                    this.removeFirst();
                    //RETURNS TRUE
                    return true;

                }//SPECIAL CASE IF URL PASSED BY USER IS EQUAL TO THE VALUE OF TAIL

                //STORES HEAD INTO NEW NODE VARIABLE
                Node t = head;
                //LOOP THROUGH LINKED LIST LOOKING FOR FIRST INDEX OF URL PASSED BY USER
                for (int i = 0; i < this.size() - 1; i++, t = t.getNext()) {
                    
                    //IF URL PASSED IS EQUAL TO ONE OF THE URL'S IN THE LINKED LIST THEN RUN
                    if (t.getValue().equals(value)) {
                        
                        t.getPrevious().setNext(t.getNext());
                        t.getNext().setPrevious(t.getPrevious());
                        t.setNext(null);
                        t.setPrevious(null);
                        
                        //RETURNS TRUE
                        return true;
                    }
                }
                //IF VALUE IS LAST VALUE THEN USE REMOVE TAIL
                if (value.equals(tail.getValue())) {

                    //CALLS REMOVE LAST METHOD 
                    this.removeLast();

                    //RETURNS TRUE
                    return true;
                }
            }
        }
        //DEFAULT RETURN VALUE IF NOT RETURNED BEFORE
        return false;
    }

    public String toString() {
        
        //RUNS ONLY IF LINKED LIST NOT EMPTY OTHERWISE RETURNS NULL
        if (!isEmpty()) {
            
            //RETURN THE METHOD CALL OF TOSTRING THAT IS A PRIVATE METHOD ONLY ACCESIBLE BY THIS CLASS
            return toString(head);
        }
        
        return null;
    }

    //RECURSIVE TOSTRING METHOD ONLY ACCESSIBLE BY THIS CLASS
    private String toString(Node node) {
        
        //BASE CASE
        if (node == null) {
            
            return "";
            
        }
        //IF NODE EQUALS THE HEAD THEN DOESN'T PRINT ARROW BEFORE THE URL
        if (node == head) {
            
            return "" + node.getValue() + toString(node.getNext());
            
        }
        //ELSE IT PRINTS ARROW BEFORE URL
        return " --> " + node.getValue() + toString(node.getNext());

    }

}
