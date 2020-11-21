/*
 *  Name: Sarim Zia
 *  Description: URL Linked List Tester
 */
package edu.hdsb.gwss.ics4u.u5;

import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author sarimzia
 */
public class URLLinkedListTester {

    public static void main(String[] args) throws MalformedURLException {

        //CREATES NEW URLLINKEDLIST
        URLLinkedList list = new URLLinkedList();

        //CONSTANT FOR LIST SIZE
        final int LIST_SIZE = 10;

        //CREATES NEW URL ARRAY
        URL[] url = new URL[LIST_SIZE];

        //LOOP TO ADD UNIQUE WEBSITES TO ARRAY
        for (int i = 0; i < LIST_SIZE; i++) {

            url[i] = new URL("https://TestWebsite" + i + ".com");

        }

        //SPECIAL CASE NULL URL
        URL urlnull = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
        System.out.println("**************************************************");

        System.out.println("Testing empty list.....");//Testing cases on empty list
        
        assert (list.isEmpty() == true);
        assert (list.remove(url[0]) == false);
        assert (list.getFirst() == null);
        assert (list.getLast() == null);
        assert (list.size() == 0);
        assert (list.toString() == null);
        assert (list.removeFirst() == null);
        assert (list.removeLast() == null);
        
        System.out.println("Case Passed!");

        
        System.out.println("Testing makeEmpty on emptyList....");//Tests makeEmpty on emptyList
        
        list.makeEmpty();
        
        assert (list.isEmpty() == true);
        assert (list.isEmpty() == true);
        assert (list.remove(url[0]) == false);
        assert (list.getFirst() == null);
        assert (list.getLast() == null);
        assert (list.size() == 0);
        assert (list.toString() == null);
        assert (list.removeFirst() == null);
        assert (list.removeLast() == null);
        
        System.out.println("Case passed!");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("**************************************************");

        System.out.println("Testing addFirst method....");//Tests addFirst
        for (int i = 0; i < url.length; i++) {

            list.addFirst(url[i]);

            assert (list.getFirst().equals(url[i]) );
            assert (list.getLast().equals(url[0]));
            assert (list.size() == i + 1);
            assert (list.isEmpty() == false);

        }

        System.out.println("After addFirst: " + list);
        System.out.println("Case Passed!");

        System.out.println("Testing makeEmpty after addFirst....");//Tests makeEmpty after addFirst
        
        list.makeEmpty();
        
        assert (list.isEmpty() == true);
        assert (list.isEmpty() == true);
        assert (list.remove(url[0]) == false);
        assert (list.getFirst() == null);
        assert (list.getLast() == null);
        assert (list.size() == 0);
        assert (list.toString() == null);
        assert (list.removeFirst() == null);
        assert (list.removeLast() == null);
        
        System.out.println("Case passed!");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("**************************************************");

        System.out.println("Testing addLast method....");//Tests addLast method
        for (int i = 0; i < url.length; i++) {

            list.addLast(url[i]);

            assert (list.getFirst().equals(url[0]));
            assert (list.getLast().equals(url[i]));
            assert (list.size() == i + 1);
            assert (list.isEmpty() == false);

        }

        System.out.println("After addLast: " + list);
        System.out.println("Case passed!");

        System.out.println("Testing makeEmpty after addLast....");//Tests makeEmpty after addLast
        
        list.makeEmpty();
        
        assert (list.isEmpty() == true);
        assert (list.isEmpty() == true);
        assert (list.remove(url[0]) == false);
        assert (list.getFirst() == null);
        assert (list.getLast() == null);
        assert (list.size() == 0);
        assert (list.toString() == null);
        assert (list.removeFirst() == null);
        assert (list.removeLast() == null);
        
        System.out.println("Case passed!");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("**************************************************");

        System.out.println("Testing removeFirst method....");//Tests removeFirst
        for (int i = 0; i < url.length; i++) {

            list.addLast(url[i]);

        }
        System.out.println("Before removeFirst: " + list);
        
        for (int i = list.size(); i >= 1; i--) {

            assert (list.removeFirst().equals(url[url.length - i]) );
            System.out.println("After removeFirst: " + list);
            
            assert (list.size() == i - 1);
            if (i > 1) {
                
                assert (list.isEmpty() == false);
                assert (list.getFirst().equals(url[url.length - i + 1]) );
                assert (list.getLast().equals(url[url.length - 1]) );
                
            } 
            else {
                
                assert (list.isEmpty() == true);
                assert (list.getFirst() == null);
                assert (list.getLast() == null);
                
            }
            

        }
        System.out.println("Case passed!");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("**************************************************");

        System.out.println("Testing removeLast method....");//Tests removeLast
        for (int i = 0; i < url.length; i++) {
            
            list.addLast(url[i]);

        }

        System.out.println("Before removeLast: " + list);
        
        for (int i = url.length; i >= 1; i--) {
            
            assert (list.removeLast().equals(url[i - 1]));
            System.out.println("After removeLast: " + list);
            
            assert (list.size() == i - 1);
            
            if (i > 1) {
                
                assert (list.isEmpty() == false);
                assert (list.getFirst().equals(url[0]));
                assert (list.getLast().equals(url[list.size() - 1]));
                
            } 
            
            else {
                
                assert (list.isEmpty() == true);
                assert (list.getFirst() == null);
                assert (list.getLast() == null);
                
            }
        }
        System.out.println("Case passed!");
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 

        System.out.println("**************************************************");

        System.out.println("Testing remove method.....");//Tests remove method with all possible scenarios
        
        for (int i = 0; i < url.length; i++) {
            
            list.addLast(url[i]);
        }

        System.out.println("List before removeMethod: " + list);
        
        for (int i = url.length; i > 0; i--) {
            
            assert (list.remove(url[i - 1]) == true);
            System.out.println("List after removeMethod: " + list);
            assert (list.size() == i - 1);
            if (i > 1) {
                
                assert (list.isEmpty() == false);
                assert (list.getFirst().equals(url[0]));
                assert (list.getLast().equals(url[list.size() - 1]));
            } 
            else {
                assert (list.isEmpty() == true);
                assert (list.getFirst() == null);
                assert (list.getLast() == null);
            }

        }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("**************************************************");

        System.out.println("SPECIAL CASE 1: STORING NULL URL USING ADDFIRST.....");//Trying to store null url in linked list using addfirst
        
        list.addFirst(urlnull);
        
        assert (list.getFirst() == null);
        assert (list.getLast() == null);
        assert (list.size() == 0);
        assert (list.isEmpty() == true);

        System.out.println("Case passed!");

        System.out.println("**************************************************");

        System.out.println("SPECIAL CASE 2: STORING NULL URL USING ADDLAST.....");//Trying to store null url in linked list using addlast
        
        list.addLast(urlnull);
        
        assert (list.getFirst() == null);
        assert (list.getLast() == null);
        assert (list.size() == 0);
        assert (list.isEmpty() == true);
        
        System.out.println("Case passed!");

        System.out.println("**************************************************");

        System.out.println("SPECIAL CASE 3: REMOVING NULL URL.....");//Trying to remove  null url from linked list
        
        list.addFirst(url[0]);
        list.remove(urlnull);
        
        assert (list.getFirst().equals(url[0]));
        assert (list.getLast().equals(url[0]));
        assert (list.size() == 1);
        assert (list.isEmpty() == false);
        
        System.out.println("Case passed!");

        System.out.println("**************************************************");

        System.out.println("SPECIAL CASE 4: TRYING TO REMOVE ITEM NOT IN LIST.....");//Trying to remove item not in list
        
        for (int i = 0; i < 3; i++) {
            
            list.addLast(url[i]);
        }
        assert (list.remove(url[5]) == false);
        
        System.out.println("Case passed!");

        System.out.println("**************************************************");

        System.out.println("SPECIAL CASE 5: REMOVING FIRST INDEX OF REPETITIVE URL....");//Removing first index of repetitive url
        
        list.makeEmpty();
        
        list.addLast(url[1]);
        list.addLast(url[1]);
        System.out.println("List before: " + list);
        assert (list.remove(url[1]) == true);
        System.out.println("List after: " + list);
        assert (list.getFirst().equals(url[1]));
        assert (list.getLast().equals(url[1]));
        assert (list.size() == 1);
        
        System.out.println("Case Passed!");

        System.out.println("**************************************************");
       
        
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    }

}
