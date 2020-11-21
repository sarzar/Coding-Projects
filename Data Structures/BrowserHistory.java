package edu.hdsb.gwss.ics4u.u5;

import java.net.URL;

public class BrowserHistory implements BrowserHistoryInterface {
    //URLSTACKS USED TO MOVE THROUGH VIEWING HISTORY

    private URLStack backHistory;
    private URLStack forwardHistory;

    //CONSTRUCTORS
    //DEFAULT CONSTRUCTOR: NO PARAMATERS
    public BrowserHistory() {
        this(11, 11);
    }

    //PARAMATER CONSTRUCTOR: PASS SIZE OF BACK HISTORY ARRAY & SIZE OF FORWARD HISTORY ARRAY
    public BrowserHistory(int backSize, int forwardSize) {

        if (backSize > 0 && forwardSize > 0) {

            this.backHistory = new URLStack(backSize);

            this.forwardHistory = new URLStack(forwardSize);

        } else {

            this.backHistory = new URLStack(11);
            this.forwardHistory = new URLStack(11);
        }
    }

    // ALLOWS USER TO GO BACK TO A PREVIOUSLY VISITED WEBSITE IF THE USER HAS BEEN TO MORE THAN 1 WEBSITE
    public URL back() {

        if (backHistory.size() > 1) {

            forwardHistory.push(backHistory.peek());

            backHistory.pop();

            return backHistory.peek();
        }
        return null;
    }

    //ALLOWS USER TO GO FORWARD TO A WEBSITE IF THE USER HAS GONE BACK ATLEAST ONCE
    public URL forward() {

        if (forwardHistory.size() > 0) {

            backHistory.push(forwardHistory.peek());

            return forwardHistory.pop();
        }
        return null;
    }

    //ALLOWS USER TO VISIT A WEBSITE AND ADD IT TO THEIR VIEWING HISTORY
    public void visit(URL value) {

        if (value != null) {

            //MAKES FORWARD HISTORY EMPTY WHEN YOU VISIT A NEW WEBSITE
            forwardHistory.makeEmpty();

            backHistory.push(value);
        }
    }

}
