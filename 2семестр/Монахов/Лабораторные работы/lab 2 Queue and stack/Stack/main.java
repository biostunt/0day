import java.util.*;


public class main {
	public static void main(String argv[]){
		Stack mStack = new Stack(1024);
		Scanner scan = new Scanner(System.in);
		int Button;
		String tempButton;
		int Element;
		String tempElement;
		int Status = 1;
		while (Status == 1){
			
			System.out.println	("----------------------OPTIONS----------------------------");
			System.out.println	("|  1. Add Element into Stack;                           |");
			System.out.println	("|  2. Delete top Element from Stack;                    |");
			System.out.println	("|  3. Close program and print all elements from Stack;  |");
			System.out.println	("------------------------END------------------------------");
			System.out.println	("");
			
			System.out.print	("Type number of option: ");
			tempButton = scan.nextLine();
			Button = Integer.parseInt(tempButton);
			
			if (Button == 1){
				System.out.println	("");
				System.out.println	("Type Int Element:");
				tempElement = scan.nextLine();
				Element = Integer.parseInt(tempElement);
				mStack.addElement(Element);
				
				System.out.println	("Adding successful!");
				System.out.println	("");
				
			}
			if (Button == 2){
				System.out.println	("");
				System.out.println	("Deleting top element from Stack...");
				if (mStack.isEmpty()){
					System.out.println ("Error: Stack is Empty");
					System.out.println	("");
				}
				else{
					int value = mStack.deleteElement(); 
					System.out.print ("Deleted Element was: ");
					System.out.println(value); 
					System.out.println	("Deleting successful!");
					System.out.println	("");
				}
			}
			if (Button == 3){
				System.out.println	("");
				
				if (mStack.isEmpty()){
					System.out.println	("Stack is empty.");
				}
				else{
					System.out.print	("Stack: "); 
					while (!mStack.isEmpty()) { 
						int value = mStack.deleteElement(); 
						System.out.print(value); 
						System.out.print(" "); 
					} 
					System.out.println("");
				}
				
				System.out.println	("Exiting...");
				
				Status = 0;
			}		
		}
	}
}
