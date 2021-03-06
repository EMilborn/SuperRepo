//skeleton file for class Binary
/*
Elias Milborn
APCS1 pd10
HW43 -- This or That
2015-12-08
*/   

public class Binary implements Compareable{

    private int _decNum;
    private String _binNum;
    

    /*=====================================
      default constructor
      pre:  n/a
      post: initializes _decNum to 0, _binNum to "0"
      =====================================*/
    public Binary() { 
	_decNum=0;
	_binNum="0";
    }
    

    /*=====================================
      overloaded constructor
      pre:  n >= 0
      post: sets _decNum to n, _binNum to equiv string of bits
      =====================================*/
    public Binary( int n ) {
	_decNum=n;
	_binNum=decToBin(n);
    }
    

    /*=====================================
      overloaded constructor
      pre:  s is String representing non-negative binary number
      post: sets _binNum to input, _decNum to decimal equiv
      =====================================*/
    public Binary( String s ) {
        _binNum=s;
	_decNum=binToDec(s);
    }
    

    /*=====================================
      String toString() -- returns String representation of this Object
      pre:  n/a
      post: returns String of 1's and 0's representing value of this Object
      =====================================*/
    public String toString() { 
	return _binNum;
    }
    
    
    /*=====================================
      String decToBin(int) -- converts base-10 input to binary
      pre:  n >= 0
      post: returns String of bits
      eg  decToBin(0) -> "0"
      decToBin(1) -> "1"
      decToBin(2) -> "10"
      decToBin(3) -> "11"
      decToBin(14) -> "1110"
      =====================================*/
    public static String decToBin( int n ) {
	String ret = "";
	if (n == 0)
	    ret="0";
	while ( n > 0){
	    ret = (n%2) + ret;
	    n = n / 2; //will automatically be rounded down to quotient
	}
	return ret;
    }
    
    
    /*=====================================
      String decToBinR(int) -- converts base-10 input to binary, recursively
      pre:  n >= 0
      post: returns String of bits
      eg  decToBinR(0) -> "0"
      decToBinR(1) -> "1"
      decToBinR(2) -> "10"
      decToBinR(3) -> "11"
      decToBinR(14) -> "1110"
      =====================================*/
    public static String decToBinR( int n ) {
	String ret = ""; 
	if (n==0)
	    return "0";
	ret = decToBinR(n/2) + (n%2);
	if (ret.substring(0,1).equals("0")) 
	    ret = ret.substring(1);
	return ret;
    }
    
    
    /*=====================================
      String binToDec(String) -- converts base-10 input to binary
      pre:  s represents non-negative binary number
      post: returns decimal equivalent as int
      eg  
      binToDec("0") -> 0
      binToDec("1") -> 1
      binToDec("10") -> 2
      binToDec("11") -> 3
      binToDec("1110") -> 14
      =====================================*/
    public static int binToDec( String s ) {
	int ret=0;
	while (s.length()>0){
	    ret += (int)((Integer.parseInt(s.substring(0,1)))*(Math.pow(2,(s.length()-1))));
	    s=s.substring(1);
	}
	return ret;
    }
    

    /*=====================================
      String binToDecR(String) -- converts base-10 input to binary, recursively
      pre:  s represents non-negative binary number
      post: returns decimal equivalent as int
      eg  
      binToDecR("0") -> 0
      binToDecR("1") -> 1
      binToDecR("10") -> 2
      binToDecR("11") -> 3
      binToDecR("1110") -> 14
      =====================================*/
    public static int binToDecR( String s ) { 
	if (s.equals(""))
	    return 0;
	return (int)((Integer.parseInt(s.substring(0,1)))*(Math.pow(2,(s.length()-1)))) + binToDecR(s.substring(1));
    }
    

    /*=============================================
      boolean equals(Object) -- tells whether 2 Objs are equivalent
      pre:  other is an instance of class Binary
      post: Returns true if this and other are aliases (pointers to same 
      Object), or if this and other represent equal binary values
      =============================================*/
    public boolean equals( Object other ) { 

	//First, check for aliasing
	if (this == other)
	    return true;
	
	//Next, check if this input and Object are differnet objects
	if  (!(other instanceof Binary))
	    return false;
	
	//Last, check if they are equal in Value
	if (compareTo(other) == 0)
	    return true;

	//Otherwise must be false
	return false;
    }
    
    
    /*=============================================
      int compareTo(Object) -- tells which of two Binary objects is greater
      pre:  other is instance of class Binary
      post: Returns 0 if this Object is equal to the input Object,
      negative integer if this<input, positive integer otherwise
      =============================================*/
    public int compareTo( Object other ) {
    	if(other.equals(null))
    		throw new NullPointerException("compareTo() input null");
    	if(!(other instanceof Binary))
    		throw new ClassCastException("compareTo() input not a Binary");
	if (_decNum > ((Binary)other)._decNum)
	    return 1;
	    
	if (_decNum == ((Binary)other)._decNum)
	    return 0;
	
	return -1;
    }
} //end class
