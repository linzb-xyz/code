/*
 * To execute Java, please define "static void main" on a class
 *
 * If you define many classes, but you must have a class named Main and a public property.
 * The Main class should be the only public class.
 * The Main class must contain a static method (function) named "main"
 * Do not add any package, like "package main"
 *
 * The TestCase is shown below
 * Input : 1 2
 * Output : 3
 */


/*
先序遍历树的字符串,创建树

abdm***n**ew**cf**g**
其中 * 表示 null
 */
public class zuoyebangMianshi1 {
	public static void main(String[] args) {
		String tree = "abdm***n**ew**cf**g**";
		Node root = create_tree(tree);
//		System.out.println(root.c);
//		System.out.println(root.left.c);
//		System.out.println(root.left.left.c);
//		System.out.println(root.left.left.left.c);
//		System.out.println(root.left.left.left.left == null );
//		System.out.println(root.left.left.left.right == null );
//		System.out.println(root.left.left.right == null );
//		System.out.println(root.left.right.c); //n
//
//
//
//
//		System.out.println(root.right.c);

		post_visit(root);

	}
	static class Node{
		char c;
		Node left;
		Node right;

	}
	static final char nullFlag = '*';
	static int cur = 0;
	public static Node create_tree(String input_data){
		if(input_data == null || input_data.length() <=0 || cur >= input_data.length()){
			return null;
		}

		if(input_data.charAt(cur) == nullFlag){
			return null;
		}
		Node root = new Node();
		root.c = input_data.charAt(cur);
		cur++;
		root.left = create_tree(input_data);
		cur++;
		root.right = create_tree(input_data);

		return root;
	}

	public static void post_visit(Node root){
		if (root == null) {
			return;
		}
		post_visit(root.left);
		post_visit(root.right);
		System.out.print(root.c + " ");
	}
}