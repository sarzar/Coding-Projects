package edu.hdsb.gwss.ics4u.u5;

import java.lang.reflect.Array;
import java.net.URL;

public class URLStack implements URLStackInterface {

    //INSTANCE VARIABLES
    int current;
    URL weburl;
    URL[] url;

    //DEFAULT CONSTRUCTOR WITH VALUE OF 11 PASSED TO MAIN CONSTRUCTOR WITH PARAMATER
    public URLStack() {
        this(11);

    }
    //CONSTRUCTOR WITH PARAMATER THAT SETS SIZE OF URL ARRAY AND SETS CURRENT AS -1

    public URLStack(int size) {
        this.url = new URL[size];
        this.current = -1;
    }

    public URL peek() {

        //ONLY RUNS IF STACK IS NOT EMPTY
        if (!isEmpty()) {

            return url[current];
        }

        //DEFAULT RETURN VALUE
        return null;
    }

    public URL pop() {

        //ONLY RUNS IF STACK IS NOT EMPTY
        if (!isEmpty()) {

            current = current - 1;

            //RETURNS URL THAT IS POPPED
            return url[current + 1];
        }

        //DEFAULT RETURN VALUE
        return null;
    }

    public void push(URL value) {

        //ONLY RUNS IF VALUE ISN'T NULL
        if (value != null) {

            //ONLY RUNS IF STACK IS NOT FULL
            if (!isFull()) {

                current++;
                this.url[this.current] = value;

            }
        }
    }

    public int size() {

        //RETURNS SIZE OF STACK USING CURRENT VALUE + 1
        return current + 1;
    }

    public int capacity() {

        //RETURNS CAPACITY USING LENGTH OF  ARRAY
        return url.length;
    }

    public boolean isEmpty() {

        //RETURNS TRUE IF CURRENT IS -1, ELSE IT RETURNS FALSE
        if (current == -1) {

            return true;
        }
        return false;
    }

    public boolean isFull() {

        //RETURNS TRUE IF CURRENT IS LESS THAN LENGTH OF URL - 1
        if (this.current < url.length - 1) {

            return false;
        }
        return true;
    }

    public void makeEmpty() {
        //SETS CURRENT VALUE AS -1
        current = -1;
    }

}
