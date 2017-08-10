package linked;
public class LinkedList {
	public Node head;
	public int listCount;

	public LinkedList(){
		head = new Node(0);
		listCount = 0;
	}

	public void show(){
		Node current = head;
		while(current.next!=null){
			System.out.print(current.data+" -> ");
			current = current.next;
		}
		System.out.println(current.data);
	}

    public boolean add(int d){
    	Node end = new Node(d);
    	Node current = head;

    	while(current.next != null){
    		current = current.next;
    	}
    	current.next = end;
    	listCount++;
        System.out.println(d+" appended to tail!");
        return true;
    }

    public boolean add(int d,int index){
    	Node end = new Node(d);
    	Node current = head;
    	int jump;

    	if(index>listCount || index<1){
    		System.out.println("Add Failed: index out of bounds of size of linked list!!");
    		return false;
    	}
    	else{
    		jump = 0;
    		while(jump<index-1){
    			current = current.next;
    			jump++;
    		}
    		end.next = current.next;
    		current.next = end;
    		listCount++;
    		System.out.println("Success! "+d+" added at index "+index);
            return true;
    	}
    }

    public boolean deleteNodeWithData(int d){
    	Node current = head;
        while(current.next!=null){
            if(current.next.data==d){
                current.next = current.next.next;
                listCount--;
                System.out.println("Success! Node with data "+d+" deleted.");
                return true;
            }
            current = current.next;
        }
        System.out.println("Delete Failed: No node found with given data!");
        return false;
    }

    public boolean deleteNodeAtIndex(int index){
    	Node current = head;
    	int jump;
    	if(index>listCount || index<1){
    		System.out.println("Delete Failed: index out of bounds of size of linked list!!");
    		return false;
    	}    	
    	else{
    		jump=0;
    		while(jump<index-1){
    			current = current.next;
    			jump++;
    		}
    		current.next = current.next.next;
    		System.out.println("Success! Node at index "+index+" deleted.");
    		listCount--;
    		return true;
    	}
    }



    public static void main(String[] args) {

    	LinkedList L = new LinkedList();
    	L.add(1);
    	L.show();
    	L.add(2);
    	L.show();
    	L.add(3);
    	L.show();
    	L.deleteNodeWithData(2);
    	L.show();
    	L.deleteNodeAtIndex(3);
    	L.show();
    	L.deleteNodeAtIndex(1);
    	L.show();
    	
    	int []a = new int[]{1,2,3,4};
    	
      /*
      
      < OUTPUT >
      
      1 appended to tail!
      0 -> 1
      2 appended to tail!
      0 -> 1 -> 2
      3 appended to tail!
      0 -> 1 -> 2 -> 3
      Success! Node with data 2 deleted.
      0 -> 1 -> 3
      Delete Failed: index out of bounds of size of linked list!!
      0 -> 1 -> 3
      Success! Node at index 1 deleted.
      0 -> 3
      
      <end of OUTPUT>
      
      */
    }
}