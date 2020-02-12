// you can also use imports, for example:
import java.util.Stack;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");


public class Solution {
    
    
    //Main Stack Data
	private Stack<Integer> stackData;
	// Transactional Stack's 
    private Stack<Solution> stackTransactions;
    
    public Solution() {
        stackData = new Stack<Integer>();
        stackTransactions = new Stack<Solution>();
        stackTransactions.push(this);
    }

    
    public void push(int value) {
        stackTransactions.peek().stackData.push(value);
    }
    
    public int top() {
    	// getting LIFO from Transactional stack
        Stack<Integer> s = stackTransactions.peek().stackData;
        
        // Checking if stack empty then return 0 other wise return topMost element
        if (s.empty())
        	return 0;
        else
        	return s.peek();
    }

    
    
    public void pop() {
    	// getting LIFO from Transactional stack
    	Stack<Integer> s = stackTransactions.peek().stackData;
    	
        // Checking if stack not empty then return pop()
        if (!s.empty())
        	s.pop();
    }

    
    
    public void begin() {
    	//each time we are creating new instance of stack
    	Solution trn = new Solution();
    	trn.stackData = (Stack<Integer>)stackData.clone();
    	stackTransactions.add(trn);
    }

    
    
    public boolean rollback() {
    	Solution lastTrn = stackTransactions.peek();
    	
    	// checking if current Solution = current instance
    	if (lastTrn != this) {
    		// deleting last element
    		stackTransactions.pop();
    		return true; //transaction reversed
    	} else
    		return false; // nothing to reverse
    }

    
    
    public boolean commit() {
    	Solution lastTrn = stackTransactions.peek();
    	
    	// checking if current Solution = current instance
    	if (lastTrn != this) {
    		// deleting last element
    		lastTrn = stackTransactions.pop();
    		stackTransactions.peek().stackData = lastTrn.stackData; 
    		return true; //transaction reversed
    	} else
    		return false; // nothing to reverse
    	
    }

    public static void test() {
        // Define your tests here
        Solution sol = new Solution();
        sol.push(42);
        assert sol.top() == 42 : "top() should be 42";
        
        
        Solution sol2 = new Solution();
        sol2.push(4);
        sol2.begin();                    // start transaction 1
        sol2.push(7);                    // stack: [4,7]
        sol2.begin();                    // start transaction 2
        sol2.push(2);                    // stack: [4,7,2]
        assert sol2.rollback() == true;  // rollback transaction 2
        assert sol2.top() == 7;          // stack: [4,7]
        sol2.begin();                    // start transaction 3
        sol2.push(10);                   // stack: [4,7,10]
        assert sol2.commit() == true;    // transaction 3 is committed
        assert sol2.top() == 10;
        assert sol2.rollback() == true;  // rollback transaction 1
        assert sol2.top() == 4;          // stack: [4]
        assert sol2.commit() == false;   // there is no open transaction
        
        
        Solution sol3 = new Solution();
        sol3.push(1);
        
        sol3.begin();
        sol3.push(2);
        sol3.rollback();
        
        //System.out.println(sol3.top());
        
        sol3.begin();
        sol3.push(3);
        sol3.commit();
        
        sol3.pop();
        assert sol3.top() == 1;
    }
    
};










    
