package com.github.isberg;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Rule;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import com.github.isberg.types.BooleanExt;

@RunWith(JUnitPlatform.class)
public class BooleanExtTest {

	private static BooleanExt classUnderTest;
		
	public BooleanExtTest() {}
	
	@BeforeEach
	void before() {
		classUnderTest = new BooleanExt();
	}
	
    @Test
    public void getBoolTest() {
    	assertEquals(false, classUnderTest.getBool());
    }
    
    @Test
    public void setBoolTrueTest() {
    	classUnderTest.setBool(true);
    	assertEquals(true, classUnderTest.getBool());
    }
    
    @Test
    public void setBoolAsStrTest() {
    	classUnderTest.setBool(new String("true"));
    	assertEquals(true, classUnderTest.getBool());
    }
    
	@Test
	public void setBoolAsStrFaultyInputTest() {

		String expectedMessage = "String value for boolean has to be true or false";
		boolean hasThrowException = false;

		try {
			classUnderTest.setBool(new String("fffffffffffffalse"));
		}
		catch(IllegalArgumentException iae) {
			hasThrowException = true;
			assertEquals(expectedMessage, iae.getMessage());
		}
		
		assertTrue(hasThrowException);
	}
    
	@Test
	public void setBoolAsStrEmptyInputTest() {
		boolean hasThrowException = false;
		String expectedMessage = "String value must have a value";
		
		try {
			classUnderTest.setBool(new String(""));
		}
		catch(IllegalArgumentException iae) {
			hasThrowException = true;
			assertEquals(expectedMessage, iae.getMessage());
		}
		
		assertTrue(hasThrowException);

	}
    
    @Test
    public void setBoolAsIntTest() {
    	classUnderTest.setBool(new Integer(1));
    	assertEquals(true, classUnderTest.getBool());
    }
    
	@Test
	public void setBoolAsIntFaultyInputTest() {
		String expectedMessage = "Int value for boolean has to be 1 or 0";
		boolean hasThrowException = false;
		
		try {
			classUnderTest.setBool(new Integer(-1));
		}
		catch(IllegalArgumentException iae) {
			hasThrowException = true;
			assertEquals(expectedMessage, iae.getMessage());
		}
		
		assertTrue(hasThrowException);
	}
    
    
    @ParameterizedTest(name = "#{index} - a={0} b={1} result={2}")
    @CsvSource({
        "0, 0, 	 0",
        "1, 0,	 0",
        "0, 1,   0",
        "1, 1,   1"
    })
    public void andTest(int a, int b, int result) {
    	classUnderTest.setBool(BooleanExt.boolIt(a));
    	assertEquals(new BooleanExt(result).getBool(), classUnderTest.and(new BooleanExt(b)));
    }
    
    @ParameterizedTest(name = "#{index} - a={0} b={1} result={2}")
    @CsvSource({
        "0, 0, 	 0",
        "1, 0,	 1",
        "0, 1,   1",
        "1, 1,   1"
    })
    public void orTest(int a, int b, int result) {
    	classUnderTest.setBool(BooleanExt.boolIt(a));
    	assertEquals(new BooleanExt(result).getBool(), classUnderTest.or(new BooleanExt(b)));
    }
    
    @ParameterizedTest(name = "#{index} - a={0} b={1} result={2}")
    @CsvSource({
        "0, 0, 	 0",
        "1, 0,	 1",
        "0, 1,   1",
        "1, 1,   0"
    })
    public void xorTest(int a, int b, int result) {
    	classUnderTest.setBool(BooleanExt.boolIt(a));
    	assertEquals(new BooleanExt(result).getBool(), classUnderTest.xor(new BooleanExt(b)));
    }
    
    @ParameterizedTest(name = "#{index} - a={0} b={1} result={2}")
    @CsvSource({
        "0, 0, 	 1",
        "1, 0,	 1",
        "0, 1,   1",
        "1, 1,   0"
    })
    public void nandTest(int a, int b, int result) {
    	classUnderTest.setBool(BooleanExt.boolIt(a));
    	assertEquals(new BooleanExt(result).getBool(), classUnderTest.nand(new BooleanExt(b)));
    }
    
    @ParameterizedTest(name = "#{index} - a={0} b={1} result={2}")
    @CsvSource({
        "0, 0, 	 1",
        "1, 0,	 0",
        "0, 1,   0",
        "1, 1,   0"
    })
    public void norTest(int a, int b, int result) {
    	classUnderTest.setBool(BooleanExt.boolIt(a));
    	assertEquals(new BooleanExt(result).getBool(), classUnderTest.nor(new BooleanExt(b)));
    }
    
    @ParameterizedTest(name = "#{index} - a={0} b={1} result={2}")
    @CsvSource({
        "0, 0, 	 0",
        "1, 0,	 1",
        "0, 1,   1",
        "1, 1,   0"
    })
    public void notTest(int a, int b, int result) {
    	classUnderTest.setBool(BooleanExt.boolIt(a));
    	assertEquals(new BooleanExt(result).getBool(), classUnderTest.not(new BooleanExt(b)));
    }

    @ParameterizedTest(name = "#{index} - a={0} b={1} result={2}")
    @CsvSource({
        "0, 0, 	 1",
        "1, 0,	 0",
        "0, 1,   0",
        "1, 1,   1"
    })
    public void xnorTest(int a, int b, int result) {
    	classUnderTest.setBool(BooleanExt.boolIt(a));
    	assertEquals(new BooleanExt(result).getBool(), classUnderTest.xnor(new BooleanExt(b)));
    }

}