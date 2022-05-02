package com.greatlearning.Ques2;

import java.util.HashSet;


public class BinarySearchTree {
	class Node {
		    int key;
		    Node left, right;

		    public Node(int item) {
		      key = item;
		      left = right = null;
		    }
	 }
	Node insertKey(Node root, int key) {
	    // Return a new node if the tree is empty
	    if (root == null) {
	      root = new Node(key);
	      return root;
	    }

	    // Traverse to the right place and insert the node
	    if (key < root.key)
	      root.left = insertKey(root.left, key);
	    else if (key > root.key)
	      root.right = insertKey(root.right, key);

	    return root;
	  }
	
	public void FindSumPair (int sum, Node root) {
		HashSet<Integer> pair=new HashSet<Integer>();
		if (!FindSumUtil(sum,root, pair)) {
			System.out.println("No pair found");
		}		
	}
	
	static boolean FindSumUtil(int sum, Node root, HashSet<Integer> set) {
		if (root ==null) {
		return false; 
		}
		if (FindSumUtil(sum, root.left, set)){
			return true;			
		} 
		if (set.contains(sum-root.key)) {
			System.out.println("pair found ("+root.key+" ,"+(sum-root.key)+")");
			return true;
		} else {
			set.add(root.key);
		}
		
		return FindSumUtil(sum, root.right, set);
	}

	public static void main(String[] args) {
      BinarySearchTree bst=new BinarySearchTree();
      Node root=null;
      root= bst.insertKey(root, 40);
      root= bst.insertKey(root, 20);
      root= bst.insertKey(root, 60);
      root= bst.insertKey(root, 10);
      root= bst.insertKey(root, 30);
      root= bst.insertKey(root, 50);
      root= bst.insertKey(root, 70);
      
      int sum=60;
      bst.FindSumPair(sum, root);
	}
}
