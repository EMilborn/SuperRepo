/*****************************
 * Team 5MinHW - Elias "RzrWire" Milborn, William "Dub X" Xiang
 * APCS1 pd10
 * HW42 -- Array of Titanium
 * 2015-12-05  
 * 
 * SKELETON for
 * class SuperArray --  A wrapper class for an array. 
 * Maintains functionality:
 *  access value at index
 *  overwrite value at index
 *  report number of meaningful items
 * Adds functionality to std Java array:
 *  resizability
 *  ability to print meaningfully
 *  add item (at end)
 *  insert item
 *  remove item (while maintaining "left-justification")
 *****************************/

public class SuperArray{
 
    //~~~~~INSTANCE VARS~~~~~
    //underlying container, or "core" of this data structure:
    private Compareable[] _data;

    //position of last meaningful value
    private int _lastPos;

    //size of this instance of SuperArray
    private int _size;

		
    //~~~~~METHODS~~~~~
    //default constructor â€“ initializes 10-item array
    public SuperArray() 
    { 
	_data = new Compareable[10];
	_lastPos = -1; //flag to indicate no lastpos yet
	_size = 0;	
    }

		
    //output array in [a,b,c] format, eg
    // {1,2,3}.toString() -> "[1,2,3]"
    public String toString() { 
	String foo = "[";
	for( int i = 0; i < _size; i++ ) {
	    foo += _data[i] + ",";
	}
	//shave off trailing comma
	if ( foo.length() > 1 )
	    foo = foo.substring( 0, foo.length()-1 );
	foo += "]";
	return foo;
    }


    //double capacity of this SuperArray
    private void expand() 
    { 
	Compareable[] temp = new Compareable[ _data.length * 2 ];
	for( int i = 0; i < _data.length; i++ )
	    temp[i] = _data[i];
	_data = temp;
    }

		
    //accessor -- return value at specified index
    public Compareable get( int index ) { return _data[index]; }

		
    //mutator -- set value at index to newVal, 
    //           return old value at index
    public Compareable set( int index, Compareable newVal ) 
    { 
 	Compareable temp = _data[index];
	_data[index] = newVal;
	return temp;
    }


    // ~~~~~~~~~~~~~~ PHASE II ~~~~~~~~~~~~~~
    //adds an item after the last item
    public void add( Compareable newVal ) {
        add(_size, newVal);
    }


    //inserts an item at index
    //shifts existing elements to the right
    public void add( int index, Compareable newVal ) {
        if (index <= _size && index >= 0){
            _size += 1;
            _lastPos += 1;
        
            if (_size>_data.length)
                expand();

            for (int i = _lastPos ; i > index; i--){
                _data[i]=_data[i-1];
            }
        
            _data[index]=newVal;
        } else {
            System.out.println("Error: Index out of range");
        }
    }

    //removes the item at index
    //shifts elements left to fill in newly-empted slot
    public void remove( int index ) {
        if (index <= _size && index >= 0){
    	    _size-=1;
    	    _lastPos-=1;
    	
            for (int i=index; i <= _lastPos; i++){
        	    _data[i]=_data[i+1];
            }
        }   
    }


    //return number of meaningful items in _data
    public int size() { 
        return _size;
    }
    
    
    public int linSearch(Compareable c){
    	int retInt = -1;//default return statement if Compareable c is not found
    	
    	for(int i = 0; i <= _lastPos && retInt == -1; i++){//will stop once it has searched meaningul values or c has already been found
	    if (_data[i].equals(c))
    			retInt = i;
    	}
    	
    	return retInt;
    }
    
    public boolean isSorted(){
    	boolean retBool = true;
    	
    	for (int i=0; (i < _lastPos) && (retBool); i++){//stops as soon as it sees that the array is unsorted
	    if (_data[i].compareTo(_data[i+1]) == 1)
		retBool=false;
    	}
    	
    	return retBool;
    }


    //main method for testing
    public static void main( String[] args ) {
	Compareable mal = new Binary(36);
	Compareable jayne = new Binary(37);
	Compareable inara = new Binary(2);
	Compareable river = new Hexadecimal(38);
	Compareable kaylee = new Rational(1, 3);
	Compareable book = new Rational(1, 2);
	Compareable simon = new Rational(2, 3);

    	SuperArray serenity1 = new SuperArray();
	//will be unordered SuperArray of all Binaries
	serenity1.add(mal);
	serenity1.add(jayne);
	serenity1.add(inara);

	SuperArray serenity2 = new SuperArray();
	//ordered SuperArray of different compareables
	serenity2.add(kaylee);
	serenity2.add(inara);
	serenity2.add(river);

	SuperArray serenity3 = new SuperArray();
	//ordered SuperArray of all Rationals
	serenity3.add(kaylee);
	serenity3.add(book);
	serenity3.add(simon);

	int test1 = serenity2.linSearch(simon);//should be -1
	int test2 = serenity2.linSearch(river);//should be 2
	boolean test3 = serenity1.isSorted();//should be false
	boolean test4 = serenity3.isSorted();//should be true

	System.out.println(serenity2);
	System.out.println(test1);
	System.out.println(test2);
	System.out.println(test3);
	System.out.println(test4);
	System.out.println(serenity2.isSorted());//intended to cause error
    }//end main
		
}//end class
