import java.util.*;
class BinarySearchTree{
	static class Node{
		Integer item;
		Node left;
		Node right;

		Node(Integer data){
			this.item = data;
			this.left = null;
			this.right = null;
		}
	}

	Node root = null;

	void insertNode(Integer data){
		Node temp = new Node(data);

		if (root == null) {
			root = temp;
		}
		else{
			Node position = root;

			while(true){
				if(temp.item > position.item){
					if(position.right == null){
						position.right = temp;
						return;
					}
					position = position.right;
				}
				else {
					if (position.left == null) {
						position.left = temp;
						return;
					}
					position = position.left;
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


	Integer maxHeight(Node temp){
		if (temp == null) {
			return 0;
		}
		else{
			Integer leftHeight = maxHeight(temp.left);
			Integer rightHeight = maxHeight(temp.right);
		
			if (leftHeight > rightHeight)
				return (leftHeight + 1);
			else
				return (rightHeight + 1);
		}
	}


	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();

		bst.insertNode(10);
		bst.insertNode(45);
		bst.insertNode(3);
		bst.insertNode(67);
		bst.insertNode(34);
		bst.insertNode(6);
		bst.insertNode(5);
		bst.insertNode(8);
		bst.insertNode(12);
		bst.insertNode(9);

		System.out.println("InOrderTraverse :");
				
		bst.inOrderTraverse();

		System.out.println("\n" + "Height of tree: " + bst.maxHeight(bst.root));
	}
}