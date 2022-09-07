public class LinkedList {

    Node headNode;

    public void addNode(int x, int y){
        /*With the x and y params, it creates a new node object and sets the nextNode on the
          new node object to the existing headNode object.*/
        Node oNode = new Node();
        oNode.xPosition = x;
        oNode.yPosition = y;
        oNode.nextNode = headNode;

        //It then assigns this new node object to the headNode variable.
        headNode = oNode;
    }

    public Node removeNode(){
        /*changes the current head node to the node that is in the head node's
        nextNode variable; and it needs to return that previous head node to the method
        caller.*/
        Node oTempNode = new Node();
        oTempNode = headNode;

        if (headNode != null){
            headNode = headNode.nextNode;
        }
        return oTempNode;
    }
}
