/**
 * Node Interface.
 *
 * @author Wm.Muir
 * @version 2020-21.Q1
 */
package edu.hdsb.gwss.ics4u.u5;

import java.net.URL;

public interface NodeInterface {

    /**
     * The node pointed to by 'next' is returned
     */
    public Node getNext();

    /**
     * The node pointed to by 'next' is changed to node
     */
    public void setNext( Node node );

    /**
     * The node pointed to by 'previous' is returned
     */
    public Node getPrevious();

    /**
     * The node pointed to by 'previous' is changed to node
     */
    public void setPrevious( Node node );

    /**
     * The value (URL Object) of the node.
     */
    public URL getValue();

}
