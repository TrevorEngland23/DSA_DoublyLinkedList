// TREVOR ENGLAND
public class Node {
    //data - fields
    // value at the given node
    int value;
    // for both single and doubly linked list
    Node next;
    // for doubly linked list 
    Node previous;

    //actions - methods

    //init - ctor(s)
    public Node(int initialValue, Node next, Node previous) {
       this.value = initialValue;
       this.next = next;
       this.previous = previous;
    }

    public Node(int initialValue){
        this.value = initialValue;
        this.next = null;
        this.previous = null;
    }
}
