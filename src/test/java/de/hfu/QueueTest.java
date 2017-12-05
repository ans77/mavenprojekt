package de.hfu;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueueTest {
	
	@Test
	public void dequeue(){
		
		final int eingabe = 3; 
		Queue q = new Queue(eingabe);

		try{
			q.dequeue();
			fail("Erwartete Ausnahme wurde nicht geworfen");
		} catch(Exception e){
		}
	}
	
	@Test
	public void nullQueue(){
		try{
			@SuppressWarnings("unused")
			Queue qu = new Queue(0);
			fail("Erwartete Ausnahme wurde nicht geworfen");
		} catch(Exception e){
		}
	}
	
	@Test
	public void enqueue(){
		
		final int eingabe = 3; 
		Queue q = new Queue(eingabe);
		
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		
		assertEquals(1,q.dequeue());
		assertEquals(2,q.dequeue());
		assertEquals(4,q.dequeue());
	}
	@Test
	public void enqueue2(){
		
		final int eingabe = 3; 
		Queue q = new Queue(eingabe);
		
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.dequeue();
		q.dequeue();
		q.dequeue();
		
		q.enqueue(4);
		assertEquals(4,q.dequeue());
	}
}
