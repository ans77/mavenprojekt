package de.hfu;

import static org.junit.Assert.*;
import org.junit.Test;


public class UtilTest {
	@Test
	public void istErstesHalbjahr(){
		
		final int eingabe = 1; 
		assertTrue(Util.istErstesHalbjahr(eingabe));
		final int eingabe2 = 7; 
		assertFalse(Util.istErstesHalbjahr(eingabe2));
		
		try{
		Util.istErstesHalbjahr(13);
		fail("Erwartete Ausnahme wurde nicht geworfen");
		} catch(IllegalArgumentException e){
		}
		
		try{
		Util.istErstesHalbjahr(0);
		fail("Erwartete Ausnahme wurde nicht geworfen");
		} catch(IllegalArgumentException e){
		}
	}
}
