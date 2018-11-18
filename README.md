# DEPTH FIRST SEARCH

Depth first search algorithm and java implementation

# ALGORITHM
<pre>

begin 
open := [Start];
closed := [ ];
 while open # [ ] do
 begin
 remove leftmost state from open, call it X; 
 if X is a goal then return SUCCESS
   else begin
        generate children of X;
        put X on closed; 
        discard children of X if already on open or closed;
        put remaining children on left end of open
    end 
  end; 
 return FAIL 
end. 

</pre>

# Given tree
![Tree](https://github.com/umer0586/depth-first-search/blob/master/tree.png)

# Applying alogrithm on above tree
finding goal **G** from root **A**
<pre>
1. open = [A]; closed = [ ] 
2. open = [B,C,D]; closed = [A] 
3. open = [E,F,C,D]; closed = [B,A] 
4. open = [K,L,F,C,D]; closed = [E,B,A]
5. open = [S,L,F,C,D]; closed = [K,E,B,A]
6. open = [L,F,C,D]; closed = [S,K,E,B,A] 
7. open = [T,F,C,D]; closed = [L,S,K,E,B,A] 
8. open = [F,C,D]; closed = [T,L,S,K,E,B,A]
9. open = [M,C,D], as L is already on closed; closed = [F,T,L,S,K,E,B,A] 
10. open = [C,D]; closed = [M,F,T,L,S,K,E,B,A] 
11. open = [G,H,D]; closed = [C,M,F,T,L,S,K,E,B,A] 
goal <bold>G</bold> found
</pre>

# Java example
```java
		Tree<Character> tree = new Tree<Character>();
```	
![Tree](https://github.com/umer0586/depth-first-search/blob/master/tree.png)
    
```java		
		tree.addParentChildren('A','B','C','D'); // A is parent of B, C and D
		tree.addParentChildren('B', 'E','F'); // B is parent of E and F
		tree.addParentChildren('E', 'K','L');
		tree.addParentChildren('K', 'S');
		tree.addParentChildren('L', 'T');
		tree.addParentChildren('F', 'L','M');
		tree.addParentChildren('C', 'G','H');
		tree.addParentChildren('G', 'N');
		tree.addParentChildren('H', 'O','P');
		tree.addParentChildren('D', 'I','J');
		tree.addParentChildren('I', 'P','Q');
		tree.addParentChildren('P', 'U');
		tree.addParentChildren('J', 'R');
		
		//Now for Terminal or leaf nodes no children are specified
		tree.addParentChildren('S'); 
		tree.addParentChildren('T');
		tree.addParentChildren('M');
		tree.addParentChildren('N');
		tree.addParentChildren('O');
		tree.addParentChildren('U');
		tree.addParentChildren('Q');
		tree.addParentChildren('R');
		
	
		tree.findGoal('G','A'); // find goal 'G' from 'A'
```
# Console output
<pre>
Console Output:-
X = A open = [A] close = []
X = B open = [B, C, D] close = [A]
X = E open = [E, F, C, D] close = [A, B]
X = K open = [K, L, F, C, D] close = [A, B, E]
X = S open = [S, L, F, C, D] close = [A, B, E, K]
X = L open = [L, F, C, D] close = [A, B, S, E, K]
X = T open = [T, F, C, D] close = [A, B, S, E, K, L]
X = F open = [F, C, D] close = [A, B, S, T, E, K, L]
X = M open = [M, C, D] close = [A, B, S, T, E, F, K, L]
X = C open = [C, D] close = [A, B, S, T, E, F, K, L, M]
X = G open = [G, H, D] close = [A, B, S, C, T, E, F, K, L, M]
goal : G found

</pre>
