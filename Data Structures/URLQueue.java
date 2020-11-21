
package edu.hdsb.gwss.ics4u.u5;

import java.net.URL;

public class URLQueue implements URLQueueInterface {

    //INSTANCE VARIABLES
    private URL[] url;
    private int head;
    private int back;

    //DEFAULT CONSTRUCTOR
    public URLQueue() {

        this(11);

    }

    //CONSTRUCTOR WITH PARAMETER OF SIZE OF ARRAY
    public URLQueue(int size) {

        this.url = new URL[size];

        //SETS DEFAULT HEAD AND BACK VALUE AS -1
        this.head = -1;
        this.back = -1;
    }

    public URL peek() {

        //ONLY RUNS IF IT IS NOT EMPTY
        if (!this.isEmpty()) {

            //RETURNS URL AT LOCATION [HEAD]
            return this.url[this.head];
        }
        //DEAFAULT RETURN VALUE
        return null;
    }

    public void enqueue(URL value) {

        //ONLY RUNS IF ITS NOT FULL
        if (!this.isFull()) {

            //ONLY RUNS IF VALUE ISN'T NULL
            if (value != null) {

                //SPECIAL CASE WHEN QUEUE IS EMPTY 
                if (this.isEmpty()) {
                    this.head = 0;
                    this.back = 0;

                    //STORES VALUE OF URL PASSED BY USER IN URL[HEAD]
                    this.url[head] = value;

                } else {
                    //FORMULA FOR CHANGING BACK VALUE
                    this.back = ((this.back + 1) % this.capacity());

                    //STORES VALUE OF URL PASSED BY USER IN URL[HEAD]
                    this.url[back] = value;
                }
            }
        }

    }

    public URL dequeue() {
        //ONLY RUNS IF QUEUE IS NOT EMPTY
        if (!this.isEmpty()) {

            //TEMPORARY HOLDING VARIABLE
            URL temp;

            //HOLDS THE URL AT [HEAD]
            temp = url[head];

            //SPECIAL CASE WHEN SIZE IS ONE AND YOU CAN JUST CALL MAKE EMPTY
            if (this.size() == 1) {

                this.makeEmpty();

                //RETURNS TEMPORARY HOLDING VARIABLE TO USER
                return temp;
            }
            //FORMULA FOR CHANGING HEAD VALUE
            this.head = ((this.head + 1) % this.capacity());

            //RETURNS TEMPORARY HOLDING VARIABLE TO USER
            return temp;

        }
        //DEFAULT RETURN VALUE IF NOT RETURNED BEFORE
        return null;
    }

    public int size() {

        //RUNS ONLY WHEN QUEUE IS NOT EMPTY OTHERWISE RETURNS 0
        if (!this.isEmpty()) {

            if (this.back >= this.head) {

                //FORMULA FOR FINDING SIZE IF BACK >= HEAD
                return this.back - this.head + 1;
            }
            if (this.head > this.back) {

                //FORMULA FOR FINDING SIZE IF HEAD > BACK
                return this.capacity() - this.head + this.back + 1;
            }
        }
        //DEFAULT RETURN VALUE IF NOT RETURNED BEFORE
        return 0;
    }

    public int capacity() {

        //RETURS LENGTH OF URL ARRAY 
        return this.url.length;
    }

    public boolean isEmpty() {

        //CHECKS IF HEAD VALUE IS -1 AND RETURNS TRUE IF SO, OTHERWISE RETURNS FALSE
        if (this.head == -1) {

            return true;
        }
        return false;
    }

    public boolean isFull() {

        //COMPARES SIZE TO CAPACITY, AND IF EQUAL RETURNS TRUE, OTHERWISE RETURNS FALSE
        if (this.size() == this.capacity()) {

            return true;
        }
        return false;
    }

    public void makeEmpty() {

        //SETS HEAD AND BACK -1
        this.head = -1;
        this.back = -1;

    }

    public String toString() {

        //ONLY RUNS IF NOT EMPTY OTHERWISE RETURNS NULL
        if (!isEmpty()) {

            //STRING VARIABLE TO STORE THE QUEUE
            String s = "";
            int i = -1;
            int counter = 0;

            //LOOPS UNTIL THE VALUE IS EQUAL TO THE BACK
            do {
                counter++;

                i = (i + 1) % capacity();

                if (i == head && i == back) {
                    s += url[i] + "<--HEAD & BACK, ";
                } else if (i == head) {
                    s += url[i] + "<--HEAD, ";
                } else if (i == back) {
                    s += url[i] + "<--BACK, ";
                } else {
                    s += url[i] + ", ";
                }

            } while (counter < capacity());

            //RETURNS STRING
            return s;
        }
        //DEFAULT RETURN VALUE OF NULL IF NOT RETURNED BEFORE
        return null;
    }

}
