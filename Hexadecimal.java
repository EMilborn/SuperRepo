//Team cuddly-octo-barnacle -- Leo Au-Yeung, Elias Milborn
//APCS1 pd10
//HW44 -- This or That or Fourteen Other Things
//2015-12-08

//skeleton file for class Hexadecimal

public class Hexadecimal extends Compareable{
	
    private int _decNum;
    private String _hexNum;
	private final static String HEXDIGITS = "0123456789ABCDEF"; 
	
    /*=====================================
		default constructor
		pre:  n/a
		post: initializes _decNum to 0, _hexNum to "0"
	=====================================*/
    public Hexadecimal() { 
		_decNum = 0;
		_hexNum = "0";
	}
	
	
    /*=====================================
		overloaded constructor
		pre:  n >= 0
		post: sets _decNum to n, _hexNum to equiv string of bits
	=====================================*/
    public Hexadecimal( int n ) {
		_decNum = n;
		_hexNum = decToHex(_decNum);
	}
	
	
    /*=====================================
		overloaded constructor
		pre:  s is String representing non-negative hexadecimal number
		post: sets _hexNum to input, _decNum to decimal equiv
	=====================================*/
    public Hexadecimal( String s ) {
		_hexNum = s;
		_decNum = hexToDec(s);
	}
	
	
    /*=====================================
		String toString() -- returns String representation of this Object
		pre:  n/a
		post: returns String of 1's and 0's representing value of this Object
	=====================================*/
    public String toString() { 
		return _hexNum;
	}
	
	
    /*=====================================
		String decToHex(int) -- converts base-10 input to hexadecimal
		Dec -> Hex conv:
		1. Div decNum by 16, store remainder
		2. Save quotient as new decNum
		3. Repeat 1 & 2 til decNum == 0
		4. Stored remainders constitute hexNum
		pre:  n >= 0
		post: returns String of bits
		eg  decToBin(0) -> "0"
		decToBinR(1) -> "1"
		decToBinR(13) -> "D"
		decToBinR(47) -> "2E"
	=====================================*/
    public static String decToHex( int n ) {
		String ans = "";
		int quotient = n;
		int remainder;
		while ( quotient != 0 ) {
			remainder = quotient % 16;
			quotient = quotient / 16;
			ans = HEXDIGITS.substring(remainder, remainder + 1) + ans;
		}
		return ans;
	}
	
	
	/*=====================================
		String decToBinR(int) -- converts base-10 input to hexadecimal, recursively
		pre:  n >= 0
		post: returns String of bits
		eg  decToBinR(0) -> "0"
		decToBinR(1) -> "1"
		decToBinR(13) -> "D"
		decToBinR(47) -> "2E"
	=====================================*/
	public static String decToHexR( int n ) { 
		String ans = "";
		if (n < 16) {
			ans += HEXDIGITS.substring(n, n + 1);
		}
		else {
			ans = decToHexR(n / 16) + HEXDIGITS.substring((n % 16), (n % 16) + 1);
		}
		return ans;
	}
	
	
	/*=====================================
		String hexToDec(String) -- converts base-10 input to hexadecimal
		pre:  s represents non-negative hexadecimal number
		post: returns decimal equivalent as int
		eg  
		hexToDecR("0") -> 0
		hexToDecR("1") -> 1
		hexToDecR("D") -> 13
		hexToDecR("2E") -> 46
	=====================================*/
	public static int hexToDec( String s ) {
		int ret = 0;
		
		while (s.length() > 0){
	    		ret += (int)(HEXDIGITS.indexOf(s.substring(0,1)) * (Math.pow (16, (s.length()-1) ))); 
	    		//Multiplies the first digit by 16 to the necessary power and then adds that number to the return statement
	    		s = s.substring(1);//shortens the string so that the first digit is the next digit and the previous statement can be done again
		}
		
		return ret;
    	}
	
	
	/*=====================================
		String hexToDecR(String) -- converts base-10 input to hexary, recursively
		pre:  s represents non-negative hexary number
		post: returns decimal equivalent as int
		eg  
		hexToDecR("0") -> 0
		hexToDecR("1") -> 1
		hexToDecR("D") -> 13
		hexToDecR("2E") -> 46
	=====================================*/
	
	public static int hexToDecR( String s ) { 
		if (s.length() == 0)//base case
			return 0;
		return (int)((HEXDIGITS.indexOf(s.substring(0,1)))*(Math.pow(16, (s.length()-1)))) + hexToDecR(s.substring(1));
		//to convert from hex to dec this method multipies the first digit by 16 raised to the necessary power(length-1) 
		//and then adds that quantity to the decimal version of the everything but the first digit
    }
    
	
	
	/*=============================================
		boolean equals(Object) -- tells whether 2 Objs are equivalent
		pre:  other is an instance of class Hexadecimal
		post: Returns true if this and other are aliases (pointers to same 
		Object), or if this and other represent equal hexary values
	=============================================*/
	public boolean equals( Object other ) { 
	if(other == null)
    		throw new nullPointerException("equals() input null");	
		
	//First, check for aliasing
	if (this == other)
	    return true;
	
	//Next, check if this input and Object are differnet objects
	if  (!(other instanceof Hexadecimal))
	    return false;
	
	//Last, check if they are equal in Value
	if (compareTo(other) == 0)
	    return true;

	//Otherwise must be false
	return false;
    }
	
	
	/*=============================================
		int compareTo(Object) -- tells which of two Hexadecimal objects is greater
		pre:  other is instance of class Hexadecimal
		post: Returns 0 if this Object is equal to the input Object,
		negative integer if this<input, positive integer otherwise
	=============================================*/
	public int compareTo( Object other ) {
		
		if(other == null)
    			throw new nullPointerException("compareTo() input null");
    			
    		if(!(other instanceof Hexadecimal))
    			throw new classCastException("compareTo() input not a Binary");	
		
	if (_decNum > ((Hexadecimal)other)._decNum)
	    return 1;
	    
	if (_decNum == ((Hexadecimal)other)._decNum)
	    return 0;
	    
	return -1;
    }
	
	
	//main method for testing
	public static void main( String[] args ) {
		
			System.out.println();
			System.out.println( "Testing ..." );
			
			Hexadecimal b1 = new Hexadecimal(46);
			Hexadecimal b2 = new Hexadecimal("2E");
			Hexadecimal b3 = b1;
			Hexadecimal b4 = new Hexadecimal(27);
			
			System.out.println( b1 );
			System.out.println( b2 );
			System.out.println( b3 );       
			System.out.println( b4 );       
			
			System.out.println( "\n==..." );
			System.out.println( b1 == b2 ); //should be false
			System.out.println( b1 == b3 ); //should be true
			
			System.out.println( "\n.equals()..." );
			System.out.println( b1.equals(b2) ); //should be true
			System.out.println( b1.equals(b3) ); //should be true
			System.out.println( b3.equals(b1) ); //should be true
			System.out.println( b4.equals(b2) ); //should be false
			System.out.println( b1.equals(b4) ); //should be false

			System.out.println( "\n.compareTo..." );
			System.out.println( b1.compareTo(b2) ); //should be 0
			System.out.println( b1.compareTo(b3) ); //should be 0
			System.out.println( b1.compareTo(b4) ); //should be pos
			System.out.println( b4.compareTo(b1) ); //should be neg
			/*=========================================
		=========================================*/
	}//end main()
	
} //end class
