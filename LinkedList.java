class LinkedList{
	static class Node{
		int item;
		Node next;

		Node(int data){
			this.item = data;
			this.next = null;
		}

	}

	Node head = null;
	Node tail = null;

	void insertFirst(int data){
		Node new_node = new Node(data);

		if(head == null){
			head = new_node;
			tail = new_node;
		}

		else{
			new_node.next = head;
			head = new_node;
		}
	}

	void insertLast(int data){
		Node new_node = new Node(data);

		if (tail == null) {
			tail = new_node;
			head = new_node; 
		}

		else{
			tail.next = new_node;
			tail = new_node;
		}
	}

	void showList(){
		Node temp = head;

		while(temp != null){
			System.out.print(temp.item + " ");
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();

		list.insertFirst(3);
		list.insertFirst(4);
		list.insertFirst(5);
		list.insertLast(19);
		list.insertLast(67);

		list.showList();
	}
}