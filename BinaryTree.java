import java.util.*;
class BinaryTree{
	static class Node{
		int item;
		Node left;
		Node right;

		Node(int data){
			this.item = data;
			this.left = null;
			this.right = null;
		}
	}

	Node root = null;

	void insertNode(int data){
		
		Node new_node = new Node(data);

		if (root == null) {
			root = new_node;
		}
		else {
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(root);

			while(!queue.isEmpty()){
				Node temp = queue.remove();
				
				if (temp.left == null) {
					temp.left = new_node;
					break;
				}
				else{
					queue.add(temp.left);
				}

				if (temp.right == null) {
					temp.right = new_node;
					break;
				}
				else{
					queue.add(temp.right);
				}
			}	
		}
	}

	void postOrderTraverse(){
		if (root == null) {
			return;
		}
		else{
			Stack<Node> stack = new Stack<Node>();
			Node temp = root;

			while(true){
				while(temp != null){
					if (temp.right != null)
						stack.push(temp.right);
					stack.push(temp);
					temp = temp.left;
				}

				if (stack.empty()) return;

				temp = stack.pop();

				if( temp.right != null && ! stack.isEmpty( ) && temp.right == stack.peek( ) ) {
					stack.pop( );
					stack.push( temp );
					temp = temp.right;
				} 
				else {
					System.out.print( temp.item + " " );
					temp = null;
				}
			}
		}
	}

	void inOrderTraverse(){
		if (root == null) {
			return;
		}
		else {
			
			Stack<Node> stack = new Stack<Node>();
			Node temp = root;

			while(!stack.empty() || temp != null){
				if (temp != null) {
					stack.push(temp);
					temp = temp.left;
				}
				else {
					Node out = stack.pop();
					System.out.print(out.item + " ");
					temp = out.right;
				}
			}
		}
	}

	void preOrderTraverse(){
		if (root == null) {
			return;
		}
		else{

			Stack<Node> stack = new Stack<Node>();
			stack.push(root);

			while(!stack.empty()){
				Node temp = stack.pop();

				while(temp != null){
					System.out.print(temp.item + " ");

					if(temp.right != null){
						stack.push(temp.right);
					}

					temp = temp.left;
				}

			}

		}
	}

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();

		tree.insertNode(1);
		tree.insertNode(2);
		tree.insertNode(3);
		tree.insertNode(4);
		tree.insertNode(5);
		tree.insertNode(6);
		tree.insertNode(7);
		tree.insertNode(8);
		tree.insertNode(9);
		tree.insertNode(10);


		System.out.println("PreOrderTraverse: ");
		tree.preOrderTraverse();
		System.out.println("\n" + "InOrderTraverse: ");
		tree.inOrderTraverse();
		System.out.println( "\n" + "PostOrderTraverse: ");
		tree.postOrderTraverse();
	}
}