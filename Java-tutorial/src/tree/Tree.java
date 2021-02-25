package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Tree {

	Node root;

	public static void preOrder(Node root) {
		if (root == null) {
			return;
		}
		// start from root
		System.out.print(root.data + " ");
		// then go the left till left is end
		preOrder(root.left);
		// then call right node
		preOrder(root.right);
	}

	public static void inOrder(Node root) {
		if (root == null) {
			return;
		}
		/// start from left node of tree till left -end and then print when it is return
		preOrder(root.left);
		// the go the root node
		System.out.print(root.data + " ");
		preOrder(root.right);
	}

	public static void PostOrder(Node root) {
		if (root == null) {
			return;
		}

		preOrder(root.left);

		preOrder(root.right);
		System.out.print(root.data + " ");
	}

	public static int height(Node root) {
		if (root == null) {
			return 0;
		}
		int left = height(root.left);
		int right = height(root.right);
		return Math.max(left, right) + 1;
	}

	public static int left(Node root, int number) {
		if (root == null || root.left == null) {
			return -1;
		}
		if (root.data == number) {
			return root.left.data;
		}
		int fromleft = left(root.left, number);
		int fromright = left(root.right, number);

		return fromleft != -1 ? fromleft : fromright;
	}

	public static void levelTraverse(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			Node curr = queue.poll();
			System.out.print(curr.data + " ");
			if (curr.left != null) {
				queue.add(curr.left);
			}
			if (curr.right != null) {
				queue.add(curr.right);
			}
		}

	}

	public static void levelOrderTraverse(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		while (!queue.isEmpty()) {
			Node curr = queue.poll();
			if (curr == null) {
				System.out.println();

				if (queue.size() != 0) {
					queue.add(null);
				}
				continue;

			}

			System.out.print(curr.data + " ");
			if (curr.left != null) {
				queue.add(curr.left);
			}
			if (curr.right != null) {
				queue.add(curr.right);
			}
		}

	}

	public static Node find(Node root, int number) {
		if (root == null) {
			return null;
		}
		if (root.data == number) {
			return root;
		}
		Node left = find(root.left, number);
		Node right = find(root.right, number);
		return left != null ? left : right;
	}

	public static void add(Node node, int where, Node root, char position) {
		if (root == null) {
			root = node;
			return;
		}
		Node temp = find(root, where);
		if (position == 'L' && temp.left == null) {

			temp.left = node;
			return;
		} else if (position == 'R' && temp.right == null) {
			temp.right = node;
			return;
		}
		throw new RuntimeException("Already node is present");
	}

	public static void display(Node root) {
		if (root == null) {
			return;
		}
		String str = "";
		str += root.left != null ? root.left.data + "->" : ".->";
		str += root.right != null ? root.data + "<-" + root.right.data : root.data + "<-.";
		System.out.println(str);
		display(root.left);
		display(root.right);
	}

	public static int max(Node root) {

		if (root == null) {
			return 0;
		}

		int left = max(root.left);
		int right = max(root.right);
		int mlr = Math.max(left, right);
		return Math.max(root.data, mlr);
	}

	public static int min(Node root) {

		if (root == null) {
			return Integer.MAX_VALUE;
		}

		int left = min(root.left);
		int right = min(root.right);
		int mlr = Math.min(left, right);
		return Math.min(root.data, mlr);
	}

	public static int size(Node root) {
		if (root == null) {
			return 0;
		}
		int left = size(root.left);
		int right = size(root.right);
		return left + right + 1;
	}

	public static void removeLeaf(Node root, Node child) {
		if (child == null) {
			return;
		}

		if (child.left == null && child.right == null) {
			if (root.left == child) {
				root.left = null;

			} else {
				root.right = null;
			}
			return;
		}

		removeLeaf(child, child.left);
		removeLeaf(child, child.right);
	}

//	public static void removeLeaf(Node root) {
//		// TODO Auto-generated method stub
//		if(root==null)
//		{
//			return;
//			
//		}
//		if((root.left.left==null) && (root.left.right==null) && (root.right.left==null) && root.right.right==null)
//		{
//			root.left=null;
//			root.right=null;
//			return;
//		}
//		else if((root.left.left==null) && (root.left.right==null))
//		{
//			root.left=null;
//			return;
//		}
//		else if(root.right.left==null && root.right.right==null)
//		{
//			root.right=null;
//			return;
//		}
//		removeLeaf(root.left);
//		removeLeaf(root.right);
//	}

	public static void singleChild(Node parent) {
		if (parent == null) {
			return;
		}
		if ((parent.left == null && parent.right != null) || (parent.left != null && parent.right == null)) {
			if (parent.left != null) {
				System.out.println(parent.left.data);
			} else {
				System.out.println(parent.right.data);
			}

		}
		singleChild(parent.left);
		singleChild(parent.right);

	}

	public static void printPath(Node root, int low, int high, int sum, String str) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			sum += root.data;
			str += root.data;
			if (sum <= high && sum >= low) {

				System.out.println(str);

			}
			return;
		}

		printPath(root.left, low, high, sum + root.data, str + root.data + " ");
		printPath(root.right, low, high, sum + root.data, str + root.data + " ");

	}

	public static ArrayList<Node> nodeToRoot(Node root, int val) {
		if (root == null) {
			ArrayList<Node> br = new ArrayList<Node>();
			return br;

		}
		if (root.data == val) {

			ArrayList<Node> br = new ArrayList<Node>();
			br.add(root);
			return br;
		}

		ArrayList<Node> res = nodeToRoot(root.left, val);
		if (res.size() > 0) {
			res.add(root);
			return res;
		}
		ArrayList<Node> res1 = nodeToRoot(root.right, val);
		if (res1.size() > 0) {
			res1.add(root);
			return res1;
		}
		return new ArrayList<Node>();
	}
	
	
	public static ArrayList<Node> NodeToRoot(Node root,int val)
	{
		if(root==null)
		{
			ArrayList<Node>br=new ArrayList<>();
			return br;
		}
		if(root.data==val)
		{
			ArrayList<Node>br=new ArrayList<>();
			br.add(root);
			return br;
		}
		ArrayList<Node>res=NodeToRoot(root.left,val);
		if(res.size()>0)
		{
			res.add(root);
			return res;
		}
		ArrayList<Node>res1=NodeToRoot(root.right,val);
		if(res1.size()>0)
		{
			res1.add(root);
			return res1;
		}
		return new ArrayList<Node>();
	}

	static int max_level=-1;
	public static void leftView(Node root,int level)
	{
		if(root==null)
		{
			return;
		}
		if(max_level<level)
		{
			System.out.println(root.data);
			max_level=level;
		}
		leftView(root.left,level+1);
		leftView(root.right,level+1);
	}
	
	public static void rightView(Node root,int level)
	{
		if(root==null)
		{
			return;
		}
		if(max_level<level)
		{
			System.out.println(root.data);
			max_level=level;
		}
		rightView(root.right,level+1);
		rightView(root.left,level+1);
	
	}
	public static void rightViewQ(Node root)
	{
		Queue<Node>queue=new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty())
		{
			int n=queue.size();
			while(n!=0)
			{
				Node temp=queue.poll();
				if(n==1)
				{
					System.out.println(temp.data);
				}
				if(temp.left!=null)
				{
					queue.add(temp.left);
				}
				if(temp.right!=null)
				{
					queue.add(temp.right);
				}
				
				n--;
			}
		}
	}
	public static void leftViewQ(Node root)
	{
		Queue<Node>queue=new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty())
		{
			int n=queue.size();
			while(n!=0)
			{
				Node temp=queue.poll();
				if(n==1)
				{
					System.out.println(temp.data);
				}
				if(temp.right!=null)
				{
					queue.add(temp.right);
				}
				if(temp.left!=null)
				{
					queue.add(temp.left);
				}
				n--;
			}
		}
	}
	
	// lower common Ancentor
	public static int commonParent(Node root,int n1,int n2)
	{
		ArrayList<Node>arr1=NodeToRoot(root,n1);
		ArrayList<Node>arr2=NodeToRoot(root,n2);
		
		int i=arr1.size()-1;
		int j=arr2.size()-1;
		while(arr1.get(i)==arr2.get(j))
		{
			if(arr1.get(i).data==n2 || arr2.get(j).data==n1)
			{
				return arr1.get(i+1).data;
				
			}
			i--;
			j--;
		}
		return arr1.get(i+1).data;
	}
	
	
}




	