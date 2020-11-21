/*
 *  Name: Sarim Zia
 *  Description: Browser History Tester
 */
package edu.hdsb.gwss.ics4u.u5;

import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author sarimzia
 */
public class BrowserHistoryTester {

    public static void main(String[] args) throws MalformedURLException {

        //CREATING MULTIPLE URLS
        URL url = new URL("https://google.com");
        URL url1 = new URL("https://howtogettoharvard.com");
        URL url2 = new URL("https://googlewantsmeidontwantthem.com");

        //CREATING NEW OBEJCT FOR BROWSER HISTORY
        BrowserHistory myHistory = new BrowserHistory();

        //SPECIAL CASE
        URL nullUrl = null;

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("*********************************************");
        //TESTING BACK AND FORWARD WITH EMPTY VIEW HISTORY
        System.out.println("Testing Back and Forward With empty view history....");

        assert (myHistory.back() == null);
        assert (myHistory.forward() == null);

        System.out.println("Case Passed!");

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
        System.out.println("*********************************************");
        //TRYING TO VISIT A NULL URL
        System.out.println("SPECIAL CASE: Testing Visitng null url.....");

        myHistory.visit(nullUrl);

        assert (myHistory.forward() == null);
        assert (myHistory.back() == null);

        System.out.println("Case Passed!");

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("*********************************************");
        //TESTING BACK AND FORWARD WITH ONE WEBSITE IN VIEW HISTORY
        System.out.println("Testing Back and Forward with one website in view history....");

        myHistory.visit(url);

        assert (myHistory.back() == null);
        assert (myHistory.forward() == null);

        System.out.println("Case Passed!");

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("*********************************************");
        //TESTING BACK AND FORWARD WITH MULTIPLE WEBSITES IN VIEW HISTORY
        System.out.println("Testing Back and Forward with multiple websites in view history....");

        myHistory.visit(url1);
        myHistory.visit(url2);

        assert (myHistory.back().equals(url1));
        assert (myHistory.back().equals(url));
        assert (myHistory.back() == null);
        assert (myHistory.forward().equals(url1));
        assert (myHistory.forward().equals(url2));
        assert (myHistory.forward() == null);
        assert (myHistory.forward() == null);
        assert (myHistory.back().equals(url1));

        System.out.println("Case Passed!");

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("*********************************************");
        //TESTING IF FRONT HISTORY GETS ELIMINATED WHEN VISITING NEW SITE AFTER HAVING PREVIOUS HISTORY
        System.out.println("Testing if front history gets eliminated when visiting new site after previous history....");
        
        myHistory.visit(url2);
        
        assert(myHistory.forward() == null);
        
        System.out.println("Case Passed!");
        System.out.println("*********************************************");

    }

}
