/**
 * Main
 */

 // TREVOR ENGLAND
public class Main {

 //clear

    public static void main(String[] args) throws Exception{
        System.out.println();
        
        // test isEmpty
        System.out.println("IsEmpty test");
        DoublyLinkedList list = new DoublyLinkedList(); // creates new empty list
        System.out.println(list.IsEmpty()); // list is empty, returns true.
        System.out.println();
        System.out.println("--------------------------------------------");

        // test AddFirst
        System.out.println("Add First test");
        list.AddFirst(10);  // adds a value to the beginning of the list
        list.AddFirst(20);// adds a value to the beginning of the list
        list.AddFirst(30); //adds a value to the beginning of the list
        list.Print(); // calls the print method used for displaying the list
        System.out.println("The array is empty?: " + list.IsEmpty()); // testing to see if the IsEmpty method behaves as expected
        list.CurrentHead(); // displays current head
        list.CurrentTail(); // displays the current tail
        System.out.println("----------------------------------------------");

        // test AddLast
        System.out.println("Add Last test");
        list.AddLast(50); // node gets added to the end of the list
        list.AddLast(70); // node gets added to the end of the list
        list.AddLast(23); // node gets added to the end of the list
        list.Print(); // prints list
        list.CurrentHead(); // correct
        list.CurrentTail(); // correct
        System.out.println("-----------------------------------------------");


        // test DeleteFirst
        System.out.println("Delete First test");
        list.DeleteFirst();
        list.Print();
        list.CurrentHead(); // correct
        list.CurrentTail(); // correct
        System.out.println("-----------------------------------------------");

        // testing with only 1 node 

        // DoublyLinkedList testOne = new DoublyLinkedList();
        // testOne.AddFirst(10); // adds 10 to list, head and tail are ten
        // testOne.CurrentHead(testOne);
        // testOne.CurrentTail(testOne);
        // testOne.DeleteFirst();
        // testOne.CurrentHead(testOne); // exception for null value
        // testOne.CurrentTail(testOne); // exception for null value

        // test DeleteLast
        System.out.println("Delete Last test"); 
        list.DeleteLast(); // deletes the last node (currently was 23)
        list.Print(); // prints the updated list
        list.CurrentHead(); // displays the head
        list.CurrentTail(); // displays the tail (now 70, was 23)
        System.out.println("-----------------------------------------------");


        // test DeleteByValue
        System.out.println("Delete By Value test");
        list.DeleteByValue(50); // deletes node given a value of 50
        list.Print(); // prints list
        list.CurrentHead(); // 20
        list.CurrentTail(); // 70
        System.out.println("-----------------------------------------------");

        // test DeleteByNode
        System.out.println("Delete By Node test");
        list.DeleteByNode(list.head.next); // should delete 10 from this list
        list.Print(); // indeed does delete 10
        list.CurrentHead(); // display head
        list.CurrentTail(); // display tail
        System.out.println("-----------------------------------------------");

        // test Reverse
        System.out.println("Reverse List");
        list.AddFirst(88);
        list.AddFirst(25);
        list.Print();
        list.Reverse();
        list.Print();
        list.CurrentHead();
        list.CurrentTail();
        System.out.println("-----------------------------------------------");

        // test Clear
        System.out.println("Clear test");
        list.Clear();
        list.Print();
    }
}