package com.github.isberg.types;

public class BooleanExt {
	
	private Boolean bool;
	
	public BooleanExt() {}
	
	public BooleanExt(Boolean bool) {
		this.bool = bool;
	}
	
	public BooleanExt(Integer bool) {
		this.bool = boolIt(bool);
	}
	
	public BooleanExt(String bool) {
		this.bool = boolIt(bool);
	}
	
	/**
	 * 
	 * @return
	 */
	public Boolean getBool() {
		if(bool == null) {
			return false;
		}
		return bool;
	}

	/**
	 * 
	 * @param bool
	 */
	public void setBool(Boolean bool) {
		this.bool = bool;
	}
	
	public void setBool(String boolStr) {
		this.bool = boolIt(boolStr);
	}
	
	public void setBool(Integer boolInt) {
		this.bool = boolIt(boolInt);
	}
	
	/**
	 * XOR Gate
INPUT	OUTPUT
A	B	A XOR B
0	0	0
0	1	1
1	0	1
1	1	0
	 * @param bool
	 * @return
	 */
	public boolean xor(BooleanExt bool) {
		boolean result = false;
		boolean a = this.getBool();
	    boolean b = bool.getBool();
	    result = (a || b);
	    if(a && b) {
	    	result = false;
	    }
	    
		return result;
	}
	
	/**
	 * NOT Gate
	 * 
	 * @param bool
	 * @return
	 */
	public boolean not(BooleanExt bool) {
		boolean result = false;
		boolean a = this.getBool();
	    boolean b = bool.getBool();
	    result = (a != b);
	    
		return result;
	}
	
	/**
	 * AND Gate
	 * 
	 * @param bool
	 * @return
	 */
	public boolean and(BooleanExt bool) {
		boolean result = false;
		boolean a = this.getBool();
	    boolean b = bool.getBool();
	    
		result = (a && b);
		return result;
	}
	
	/**
	 * OR Gate
	 * 
	 * @param bool
	 * @return
	 */
	public boolean or(BooleanExt bool) {
		boolean result = false;
		boolean a = this.getBool();
	    boolean b = bool.getBool();
		result = (a || b);
		
		return result;
	}
	
	/** NAND Gate
INPUT	OUTPUT
A	B	A NAND B
0	0	1
0	1	1
1	0	1
1	1	0
	 * @param bool
	 * @return
	 */
	public boolean nand(BooleanExt bool) {
		boolean result = false;
		boolean a = this.getBool();
	    boolean b = bool.getBool();
	    result = ((!a && !b) ||  (a || b));
	    if(a && b) {
	    	result = false;
	    }
		return result;
	}
	
	/**
	 * NOR Gate
INPUT	OUTPUT
A	B	A NOR B
0	0	1
0	1	0
1	0	0
1	1	0
	 * @param bool
	 * @return
	 */
	public boolean nor(BooleanExt bool) {
		boolean result = false;
		boolean a = this.getBool();
	    boolean b = bool.getBool();
	    result = (!a && !b);
	    
		return result;
	}
	
	/**
	 * XNOR Gate (Exclusive OR)
Input	Output
A	B	A XNOR B
0	0	1
0	1	0
1	0	0
1	1	1
	 * @param bool
	 * @return
	 */
	public boolean xnor(BooleanExt bool) {
		boolean result = false;
		boolean a = this.getBool();
	    boolean b = bool.getBool();
	    result = ((!a && !b) || (a && b));
	    
		return result;
	}
	
    public static boolean boolIt(Integer boolInt) {
    	boolean result = false;
    	if(boolInt == null) {
    		throw new IllegalArgumentException("Int value must not be null");
    	}
    	if(boolInt > 1 || boolInt < 0) {
    		throw new IllegalArgumentException("Int value for boolean has to be 1 or 0");
    	}
    	if(boolInt == 1) {
    		result = true;
    	}
    	return result;
    }
    
	public static boolean boolIt(String boolStr) {
		boolean result = false;
		if (boolStr == null || boolStr.isEmpty()) {
			throw new IllegalArgumentException("String value must have a value");
		}
		if (boolStr.toLowerCase().equals("false") || boolStr.toLowerCase().equals("true")) {
			if (boolStr.toLowerCase().equals("true")) {
				result = true;
			}
		} else {
			throw new IllegalArgumentException("String value for boolean has to be true or false");
		}

		return result;
    }

	public boolean equals(BooleanExt bool) {
		return this.getBool().equals(bool.getBool());
	}
}
