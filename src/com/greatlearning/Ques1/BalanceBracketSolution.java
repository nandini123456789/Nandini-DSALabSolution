package com.greatlearning.Ques1;

import java.util.Scanner;
import java.util.Stack;

public class BalanceBracketSolution {

	public boolean CheckBalancedBrackets(String st) {
		//converting the bracket string to
		char[] bracketString=st.toCharArray();
		Stack<Character> bracketStack=new Stack<>();
		for ( char x: bracketString) {
			if (x == '(' || x == '[' || x == '{'){
				bracketStack.push(x);
				continue;
			}
			
			// the stack cannot be empty at this point as its the starting point
			// if the stack is empty that means first bracket is not opening bracket
			// and its a closing bracket. Thus making the string unbalanced
			if (bracketStack.isEmpty())
				return false;
			
			char a;
			switch (x) {
			   case ')':
				   a=bracketStack.pop();
				   if (a=='[' || a=='{')
					   return false;
				   break;
				   
			   case '}':
				   a=bracketStack.pop();
				   if (a=='[' || a=='(')
					   return false;
				   break;
				   
			   case ']':
				   a=bracketStack.pop();
				   if (a=='(' || a=='{')
					   return false;
				   break;
			}
						
		}
		//check if stack is empty and does not have 
		return (bracketStack.isEmpty());
	}
	
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the String of Bracket");
		String st=sc.nextLine();
		BalanceBracketSolution bbs=new BalanceBracketSolution();
		if (st=="")
			System.out.println("no bracket string entered");
		else {
			if (bbs.CheckBalancedBrackets(st)) {
			System.out.println("The entered String has Balanced Brackets");
			} else  {
			System.out.println("The entered Strings do not contain Balanced Brackets");
			}
		}
		sc.close();

	  }
	

}
