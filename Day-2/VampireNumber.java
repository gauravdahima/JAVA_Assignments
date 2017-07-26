public class VampireNumber {
 
    public static void main(String args[]) {
    
    	/*
    	 * we are only checking the numbers which are having the
    	 * even number of digits.
    	 */
        int vampCount = 1, start = 10, tens = 1;
        System.out.println("First 100 vampire numbers are : ");
        System.out.print(vampCount + " : ");
        
        mainLoop:
        for (int numDigits = 2; numDigits <= 6; numDigits += 2) {
            int end = start * 10;
            for (int i = start; i < end; i++) {
                if (checkVampire(i, tens)) {
                    if (++vampCount > 100){
                        break mainLoop	;
                    }
                    else{
                    	System.out.print(vampCount + " : ");
                    }
                }
            }
            start *= 100;
            tens *= 10;
        }
        System.out.println();
 
    }
    
    public static boolean checkVampire(int n, int tens) {

        int low = tens;
        
        // the upper bound of the first fang will be minimum 
        // of (n/low) and sqrt(n) 
        int high = Math.min(n / low, (int) (Math.sqrt(n)));
    	
        
        int a, b;	// a and b are two fangs
    	for (a = low; a <= high; a++) {
        	b = n / a; 
        	
        	// if both have trailing zeroes or their products not equal to n,
        	// then skip this number
        	
            if (a * b != n || (a % 10 == 0 && b % 10 == 0))
                continue;
            
            if (helper(n,a,b) == true) {
                System.out.println(n+" ==> ["+a+", "+b+"]");
                return true;
            }
        }
        return false;
    }
    
    /*
     * function to check if the combination of digits in fangs
     * are same as in the original number
     */
    
    public static boolean helper(int n, int a, int b) { 
    	
    	int tempN = n, tempA = a, tempB = b;
        
    	int[] arrN = new int[10];
        int[] arrA = new int[10];
        int[] arrB = new int[10];
        
        for(int i=0;i<10;i++){
        	arrN[i] = arrA[i] = arrB[i] = 0;
        }
        
        while(tempN > 0){
        	arrN[tempN%10]++;
        	tempN /= 10;
        }
        
        while(tempA > 0){
        	arrA[tempA%10]++;
        	tempA /= 10;
        }
        while(tempB > 0){
        	arrB[tempB%10]++;
        	tempB /= 10;
        }
        
        for(int i=0;i<10;i++){
        	if(arrN[i] != (arrA[i] + arrB[i])){
        		return false;
        	}
        }
        return true;
    }
}