import java.util.HashMap;
import java.util.HashSet;
import java.util.Vector;

// A generic n-ary tree
public class Tree<T> {
	

//stores mapping for parent with children
// HashMap is a Key:value datastructure
	HashMap<T, Vector<T>> ParenChildrenMapping; 
	
	Vector<T> open;
	
	//Hashset DataStructure forbids duplicate values
	HashSet<T> close;
	
	// Reference for children Nodes
	Vector<T> Children;
	
	public Tree() {
		ParenChildrenMapping = new HashMap<>();
		open = new Vector<>();
		close = new HashSet<>();
	}
	
	public void addParentChildren(T Parent, T... children){
		Children = new Vector<>();
		for(T child : children)
			this.Children.add(child);
		
		ParenChildrenMapping.put(Parent, Children);
	}
	
	public void addParentChildren(T Parent){
		
		ParenChildrenMapping.put(Parent, null);
	}
	
	//Displays parent children mapping		
	public void show(){
		
		for(T Parent : ParenChildrenMapping.keySet()){
			
			System.out.println(Parent + "->" + ParenChildrenMapping.get(Parent));
		}
	}

	// finds goal from given Root using Depth First Search Algorithm
	public void findGoal( T goal, T Root){
			
			open.add( Root ); //open must contain initial element for entering loop
			
			while(!open.isEmpty()){
			
// get the left most element from open and store it in X				T X = open.elementAt(0); 
			
// if X is already in close then remove first element from open and 
// then check loop condition
			if(close.contains(X)){
				open.removeElementAt(0);
				continue;
			}
			
			System.out.println("X = " + X + " open = " + open + " close = " + close);
			
			//if X is goal then SUCCESS 
			if(X.equals(goal)){
				
				System.out.println("goal : " + goal + " found");
				return;
			}
		
			else{ // if X is not a goal then replace X with its children and add X to close
				open.removeElementAt(0);
				
				// if X is not a last node then add children
				if(ParenChildrenMapping.get(X)!=null){
					open.addAll(0, ParenChildrenMapping.get(X));
					close.add(X);
					
				}
					
				close.add(X); 
			
					
			}
			
			
			}
			
			System.out.println("goal : " + goal + " not found");
		
		
	}

} 

