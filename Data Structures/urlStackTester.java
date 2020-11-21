/*
 *  Name: Sarim Zia
 *  Description: URL Stack Tester
 */
package edu.hdsb.gwss.ics4u.u5;

import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author sarimzia
 */
public class urlStackTester {

    public static void main(String[] args) throws MalformedURLException {

        //CONSTANT FOR SIZE OF STACK
        final int STACK_SIZE = 10;

        //NEW URL ARRAY
        URL[] url = new URL[STACK_SIZE + 1];

        //LOOP TO ADD UNIQUE WEBSITES TO ARRAY
        for (int i = 0; i < STACK_SIZE + 1; i++) {
            url[i] = new URL("https://TestWebsite" + i + ".com");

        }
        //CREATES NEW URLSTACK
        URLStack stack = new URLStack(STACK_SIZE);

        //NULL URL
        URL urlnull = null;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("*********************************************");

        //TESTS EMPTY URLSTACK
        System.out.println("Testing an empty URL Stack........"); //Testing cases for an empty stack

        assert (stack.current == -1);
        assert (stack.capacity() == STACK_SIZE);
        assert (stack.isEmpty() == true);
        assert (stack.pop() == null);
        assert (stack.size() == 0);
        assert (stack.isFull() == false);
        assert (stack.peek() == null);

        System.out.println("Case passed!");

        //TESTS MAKE EMPTY
        System.out.println("Testing Make Empty method on empty URL stack........");//Testing make empty method on empty stack

        stack.push(url[0]);

        assert (stack.isEmpty() == false);
        stack.makeEmpty();
        assert (stack.capacity() == STACK_SIZE);
        assert (stack.current == -1);

        System.out.println("Case passed!");
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("*********************************************");

        //TESTS FOR ALL OTHER CASES.....
        System.out.println("Testing insertion of values till full........"); //Testing insertion of values till full
        for (int i = 0; i <= STACK_SIZE; i++) {

            stack.push(url[i]);

            if (i < STACK_SIZE) {

                assert (stack.peek().equals(url[i]));
                assert (stack.current == i);
                assert (stack.size() == i + 1);

            } else {

                assert (stack.peek().equals(url[i - 1]));
                assert (stack.current == i - 1);
                assert (stack.size() == i);

            }
            assert (stack.capacity() == STACK_SIZE);
            assert (stack.isEmpty() == false);
            if (i < STACK_SIZE - 1) {

                assert (stack.isFull() == false);

            } else {

                assert (stack.isFull() == true);
            }
        }
        System.out.println("Case passed!");
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("*********************************************");

        //POPS STACK IN LOOP
        System.out.println("Testing Popping of URL stack till empty........"); //Testing popping of stack till empty
        for (int i = STACK_SIZE - 1; i >= 0; i--) {
            assert (stack.pop().equals(url[i]));
            if (i > 0) {
                assert (stack.isEmpty() == false);
                assert (stack.peek().equals(url[i - 1]));
            } else {

                assert (stack.isEmpty() == true);
                assert (stack.peek() == null);
            }
            assert (stack.current == i - 1);
            assert (stack.capacity() == STACK_SIZE);
            assert (stack.size() == i);
            assert (stack.isFull() == false);
        }
        System.out.println("Case passed!");
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("*********************************************");

        System.out.println("SPECIAL CASE: TRYING TO PUT NULL URL IN STACK......"); //Trying to put null url in stack

        stack.push(urlnull);

        assert (stack.isEmpty() == true);
        assert (stack.size() == 0);
        assert (stack.pop() == null);
        assert (stack.peek() == null);
        assert (stack.capacity() == STACK_SIZE);
        assert (stack.isFull() == false);

        System.out.println("Case passed!");

        System.out.println("*********************************************");
    }

}
