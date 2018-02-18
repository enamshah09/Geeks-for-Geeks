/**
 * Topic: Binary Tree
 * 
 * Question:
 * Convert a Binary Tree to a Circular Doubly Link List
 * 
 * Given a Binary Tree, convert it to a Circular Doubly Linked List (In-Place).
 * 
 * The left and right pointers in nodes are to be used as previous and next pointers respectively in converted Circular Linked List.
 * The order of nodes in List must be same as Inorder of the given Binary Tree.
 * The first node of Inorder traversal must be head node of the Circular List.
 *      10
 *    /   \
 *   12    15
 *  /  \   /
 * 25  30 36
 * 
 * Return
 * --> 25 <-> 12 <-> 30 <-> 10 <->36 <->15 <--
 * |_________________________________________|
 */

//Code:

class Node
{
	int val;
	Node prev,next;

	public Node(int val)
	{
		this.val = val;
		prev = next = null;
	}
}

// A class to represent a tree
class Tree
{
	Node root;
	static Node prevElement = null;
	static Node head = null;
	public Tree()
	{
		root = null;
	}
	
	public Node bTreeToCList(Node root)
	{
		if (root == null)
			return null;

        bTreeToCList(root.prev);
        Node temp = new Node(root.val);
        
        if(prevElement == null)
        {
            head = temp;
        }
        else
        {
            prevElement.next = temp;
            temp.prev = prevElement;
        }
        
        prevElement = temp;
        bTreeToCList(root.next);
        
        head.prev = prevElement;
	prevElement.next = head;
        
        return head;

	}

	// Display Circular Link List
	public void display(Node head)
	{
		System.out.println("Circular Linked List is :");
		Node itr = head;
		do
		{
			System.out.print(itr.val+ " " );
			itr = itr.next;
		}
		while (itr != head);
		System.out.println();
	}
}

class Main
{
    
	public static void main(String args[])
	{
		// Build the tree
		Tree tree = new Tree();
		tree.root = new Node(10);
		tree.root.prev = new Node(12);
		tree.root.next = new Node(15);
		tree.root.prev.prev = new Node(25);
		tree.root.prev.next = new Node(30);
		tree.root.next.prev = new Node(36);

		// head refers to the head of the Link List
		Node head = tree.bTreeToCList(tree.root);

		// Display the Circular LinkedList
		tree.display(head);
	}
}
