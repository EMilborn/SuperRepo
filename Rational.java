// Team Bash-ional -- Elias Milborn, William Xiang
// APCS Pd10
// HW 41 -- In America, the Driver Sits on the Left
// 2015-11-19

public class Rational implements Comparable {
    private int _num, _den; //declare instance vars for numerator and denominator
    
    public Rational() {
        //set default number to 0/1
        _num = 0; 
        _den = 1;
    }
    
    public Rational(int num, int den) {
        this(); //default constructor
        if (den == 0) { //denominator of 0 makes the number undefined
            //Error msg
            String s = "";
            s += "Invalid denominator";
            s += "\nNumber set to 0/1";
            System.out.println(s);
        } else {
            //set instance vars to ints given to constructor
            _num = num;
            _den = den;
        }
    }
    
    // ===== ACCESSOR METHODS =====
    public int getNum() {
        return _num;
    }
    
    public int getDen() {
        return _den;
    }
    // ============================    
    
    public String toString() {
        return _num + "/" + _den; //return "_num/_den" representation
    }
    
    public double floatValue() {
        return (double)_num / _den; //return the quotient of _num and _den as a double
    }
    
    public static int gcdEW(int a, int b){
	if (a==0){
	    return b;}
	if (b==0){
	    return a;}
	while (a != b){
	    if (a > b){
		a -= b;
	    }
	    else{
		b -= a;
	    }
	}
	return a;
    }
    
    public int gcd(){
        return gcdEW(_num, _den);
    }
    
    public void add(Rational r) {
        //constant versions of the num and den that do not change throughout the method
        int num=_num;
        int den=_den;
        _num = (num*r.getDen())+(den*r.getNum());
        _den = (r.getDen()*den);
    }
    
    public void subtract(Rational r) {
        Rational rNeg = new Rational(-r.getNum(), r.getDen());
        //negative version of r
        add(rNeg);
        //just adds the negative of r
    }
    
    public void multiply(Rational r) {
        //multiplies the numerator and denominators of this Rational object and the one given
        _num *= r.getNum();
        _den *= r.getDen();
    }
    
    public void divide(Rational r) {
        //multiplies the numerator and denominators of this Rational object to the reciprocal of the one given
        _num *= r.getDen();
        _den *= r.getNum();
    }
    
    public void reduce(){
        int gcd = gcd();
        //constant gcd that doesnt change

        if (gcd==0){
            _den=1;
        }
        //prevents divison by zero
        else{
            _num/=gcd;
            _den/=gcd;
        }
    }
    
    public int compareTo(Object other) {
        if(other == null)
	    throw new NullPointerException("compareTo() input null");
    			
	if(!(other instanceof Hexadecimal))
	    throw new ClassCastException("compareTo() input not a Binary");	
        
        Rational temp = new Rational(getNum(),getDen());
        temp.subtract((Rational)other);
        
        if (temp._num > 0) {
            return 1;
        } else if (temp._num < 0) {
            return -1;
        } else {
            return 0;
        }
    }
    
    public boolean equals( Object other ) { 
	if(other.equals (null))
	    throw new NullPointerException("equals() input null");
	
	//First, check for aliasing
	if (this == other)
	    return true;
	
	//Next, check if this input and Object are differnet objects
	if  (!(other instanceof Rational))
	    return false;
	
	//Last, check if they are equal in Value
	if (compareTo(other) == 0)
	    return true;
	
	//Otherwise must be false
	return false;
    }
    
    public static void main(String[] args) {
        Rational r = new Rational(2,3); //Stores the rational number 2/3
        Rational s = new Rational(1,2); //Stores the rational number 1/2
        Rational t = new Rational(4,18); //Stores the rational number 4/18
        
        r.multiply(s); //Multiplies r by s, changes r to 2/6.  s remains 1/2
        System.out.println(r + ": should be 2/6");
        System.out.println(s + " : should be 1/2");
        r.divide(s); //Divides r by s, changes r to 4/6.  s remains 1/2
        System.out.println(r + ": should be 4/6");
        System.out.println(s + " : should be 1/2");
        
        r.add(s);  //Adds r to s, changes r to 7/6.  s remains 1/2
        System.out.println(r + ": should be 14/12");
        System.out.println(s + " : should be 1/2");
        
        t.reduce(); //Changes t to 2/9
        System.out.println(t + " : should be 2/9");
        
        System.out.println(r.compareTo(s) + ": should be 1");
        System.out.println(s.compareTo(r) + ": should be -1");
        System.out.println(t.compareTo(t) + ": should be 0");
        
	
    }    
    
    
    
}
