
public class CodilityT2 {

    public static String solution(String message, int K) {
        
    	
    	int len = message.length();
    	if (len <= K)
    		return message;
    	
    	String a[] = message.split(" ");
    	int n = 0;
    	int j = 0;

    	String s = "";
    	for (String str : a) {
			n = str.length();			
			j += n;			
			if (j <= K) {
				s = s + " " + str;
			}
			j += 1;
		}
    	s = s.trim();
    	
    	return s;
    	
    	
    }	
    
	public static void main(String[] args) {		

	
        
        System.out.println(solution("Codility We test coders", 14));
        System.out.println(solution("The quick brown fox jumps over the lazy dog", 39));
        
        
    }     
}
