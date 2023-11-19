// TREVOR ENGLAND
public class DoublyLinkedList {

     //data -fields
    Node head;
    Node tail;

    //actions - methods
    //AddFirst
    public void AddFirst(int someValue){//O(1)
    
        //create a new node
        Node newNode = new Node(someValue); // using constructor 

        // if the list is empty...
        if(IsEmpty()){
            head = tail = newNode; // the head and the tail exist at the new node
        } 
        // if the list has at least 1 node...
        else{
            //link this node to the head (the beginning of the existing list if not empty)

            newNode.next = head; // inserted newNode before the head, so the next node is still the head at this point...
            head.previous = newNode; // From the head, the previous node is the node we just added
            head = newNode; // assign the newNode to be the head. 
        }
    }
    //Print - traversal
    public void Print(){//O(n)
    
        if(IsEmpty()){
        
            System.out.println("empty list ...");
        }
        else{
        
            //put the finger on the head
            Node finger = head;
    
            //repeat as long as finger does not point to null
            while(finger != null){
            
                //display the value
                System.out.print(finger.value+" -> ");
    
                //move to the next node
                finger = finger.next;
            }
            System.out.println();   
            System.out.println();
        }
    }
    //AddLast
    public void AddLast(int someValue){ //O(1)
    

        // create a new node
        Node newNode = new Node(someValue);

        // if the list is empty
        if(IsEmpty()){
        
            AddFirst(someValue); // if list is empty, the behavior of adding a node to the end of the list is the same as adding a node to the beginning of the list... head and tail will equal to new node, which is the same logic provided in AddFirst
        }
        // if the list is not empty
        else{
        
            //link in the new node - make last node point to newnode
            tail.next = newNode; // add the new node after the current tail
            newNode.previous = tail; // likewise, the current tail is the previous node of the new node, so we provide that logic

            //move the tail
            tail = newNode; // tail gets set to the new node, which is the last node of the list
        }
    }
    //IsEmpty
    public boolean IsEmpty(){ //O(1)
    
        // if(head == null)
        // {
        //     return true;
        // }
        // else
        // {
        //     return false;
        // }
        return head == null;
    }
    //deletes at head
    public void DeleteFirst() throws Exception{  //O(1)
    
        // if list is empty
        if(IsEmpty()){
        
            throw new Exception("You cannot delete from an empty list");
        }
        // if only one node in list
        else if(head.next==null){ //only have one node
        
            head = tail = null; // both head and tail now are null after deleting the node
        }
        // if two or more nodes exist
        else{ 
        
            //move the head
            head = head.next; // new head is the next node in the list
            head.previous = tail; // points to the last node in the list, aka tail.

        }
    }

    public void DeleteLast() throws Exception{ //O(n)
    
        // if list is empty
        if(IsEmpty()){
        
            throw new Exception("You cannot delete from an empty list!");
        }
        // only one node exist in the list
        else if(head.next ==null){
        
            // call delete first method. head and tail are the same node at this point, so the logic remains the same
            DeleteFirst();
        }
        // if more than one node exists in the list
        else{
        
            // create a "finger" to keep track of which node you're pointing to
            Node finger = head;
            
            // Go through each node until null is 2 nodes away from where the finger is pointing
            while(finger.next.next!=null){
            
                finger = finger.next; // points to each node one by one
            }    
    
            //break the link between the last and next to last node
            finger.next = null;

            //move the tail
            tail = finger;
        }
    }

    public void DeleteByValue(int someValue) throws Exception{
        // if list is empty
        if(IsEmpty()){
            throw new Exception("You cannot delete from an empty list!"); // throw exception
            // if only one value
        } else if(head.next.value == someValue && head.next == null){
            DeleteFirst(); 
            // if only one value and the value to be deleted does not exist
        } else if(head.next.value != someValue && head.next == null){
            throw new Exception("The value you entered does not exist in this list!"); // throw exception
            // if theres more than 1 value in the list
        } else {
            // create a temporary node equivalent to head
            Node tmp = head;
            // traverse the list as long as the node does not equal null and the value of the node does not equal the value passed in 
            for(int i = 0; tmp!=null && tmp.value != someValue; tmp = tmp.next);
            // if the value is found in the list and the loop has not completed (to null)
            if(tmp != null){
                // if the value was found at the end of the list (tail)
                if(tmp == tail){
                    // use the DeleteLast logic to delete this node
                    DeleteLast(); 
                    // if the value was found somewhere in the middle
                } else {
                    // confusing.. got an infinite loop a couple of times figuring this one out. the idea is you want to bridge the previous and the next together to fill the gap. 
                   tmp.next.previous = tmp.previous; // this is saying.. where the deleted node is.. the next nodes new previous node is the previous node of the deleted node.
                   tmp.previous.next = tmp.next; // logic in reverse. the tmps previous node's new next node, is the tmps next node. this bridges that gap.
                }
            }
        }
    }

    public void DeleteByNode(Node node) throws Exception{
        if(IsEmpty()){
            throw new Exception("You cannot delete from an empty list!");
        } else if(head.next == node && head.next == null){
            DeleteFirst(); 
            // if only one value and the value to be deleted does not exist
        } else if(head.next != node && head.next == null){
            throw new Exception("The value you entered does not exist in this list!"); // throw exception
            // if theres more than 1 value in the list
        } else {
            // create a temporary node equivalent to head
            Node tmp = head;
            // traverse the list as long as the node does not equal null and the value of the node does not equal the value passed in 
            for(int i = 0; tmp!=null && tmp != node; tmp = tmp.next);
            // if the value is found in the list and the loop has not completed (to null)
            if(tmp != null){
                // if the value was found at the end of the list (tail)
                if(tmp == tail){
                    // use the DeleteLast logic to delete this node
                    DeleteLast(); 
                    // if the value was found somewhere in the middle
                } else {
                    // confusing.. got an infinite loop a couple of times figuring this one out. the idea is you want to bridge the previous and the next together to fill the gap. 
                   tmp.next.previous = tmp.previous; // this is saying.. where the deleted node is.. the next nodes new previous node is the previous node of the deleted node.
                   tmp.previous.next = tmp.next; // logic in reverse. the tmps previous node's new next node, is the tmps next node. this bridges that gap.
                }
            }
        }
    }

    public void Reverse() throws Exception{
        // if list is empty throw exception
        if(IsEmpty()){
             throw new Exception("The value you entered does not exist in this list!");
             // if only one node, let the user know reversing a 1 node list is not helpful
        } else if(head.next == null){
            System.out.println("There is only one value...");
            // if more than one node
        } else {
            Node tmp = null; // create a temp node set to null
            Node finger = head; // create a pointer that starts at the head
            while(finger != null){ // while the finger is not null
                tmp = finger.previous; // store node of finger.previous
                finger.previous = finger.next; // swaps the node with finger.next
                finger.next = tmp; // swaps finger.next with tmp
                finger = finger.previous; // finger now points to finger.previous repeats until finger is null
            }
            tail = head; // the tail should be the original head
            if(tmp != null){ // if tmp is not null (meaninng any value that )
                head = tmp.previous; 
             
            }
        }
    }
    
    // clear method
    public void Clear(){ //O(1)
        // set the head and tail to null
        head = tail = null;
    }
    
    // show current tail
    public void CurrentTail(){
        System.out.println("Current Tail: " + tail.value);
    }

    // show current head
    public void CurrentHead(){
        System.out.println("Current Head: " + head.value);
    }
}

