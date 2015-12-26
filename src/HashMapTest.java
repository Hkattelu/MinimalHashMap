import static org.junit.Assert.*;

import org.junit.Test;

public class HashMapTest {

	/*
	 * Test class that easily allows us to manipulate
	 * hash codes to test the hash map
	 */
	public class TestEntry{
		int num;
		
		public TestEntry(int k){
			num = k;
		}
		
		@Override
		public int hashCode(){
			return num;
		}
	}
	
	@Test
	public void getValue() {
		MinimalHashMap<TestEntry,String> h = new MinimalHashMap<TestEntry,String>();
		TestEntry t = new TestEntry(4);
		h.put(t,"String");
		assertEquals("String",h.get(t));
	}
	
	@Test
	public void nullValue1(){
		MinimalHashMap<TestEntry,String> h = new MinimalHashMap<TestEntry,String>();
		TestEntry t = new TestEntry(4);
		h.put(t,null);
		assertEquals(null, h.get(t));
	}
	
	@Test
	public void nullValue2(){
		MinimalHashMap<TestEntry,String> h = new MinimalHashMap<TestEntry,String>();
		TestEntry t = new TestEntry(4);
		TestEntry r = new TestEntry(4);
		h.put(t,null);
		h.put(r, "Hello");
		assertEquals(null,h.get(t));
		assertEquals("Hello",h.get(r));
	}
	
	@Test
	public void hashCodeMod(){
		MinimalHashMap<TestEntry,String> h = new MinimalHashMap<TestEntry,String>();
		TestEntry mod = new TestEntry(14);
		h.put(mod, "Hello");
		assertEquals("Hello",h.get(mod)); // no null keys allowed
	}
	
	@Test
	public void nullKey(){
		MinimalHashMap<TestEntry,String> h = new MinimalHashMap<TestEntry,String>();
		h.put(null, "Hello");
		assertEquals(null,h.get(null)); // no null keys allowed
	}
	
	@Test
	public void multipleValues1(){
		//1 collision
		MinimalHashMap<TestEntry,String> h = new MinimalHashMap<TestEntry,String>();
		TestEntry a = new TestEntry(1);
		TestEntry b = new TestEntry(1);
		h.put(a, "A");
		h.put(b, "B");
		assertEquals("A",h.get(a));
		assertEquals("B",h.get(b));
	}
	
	@Test
	public void multipleValues2(){
		//1 collision and more values
		MinimalHashMap<TestEntry,String> h = new MinimalHashMap<TestEntry,String>();
		TestEntry a = new TestEntry(1);
		TestEntry b = new TestEntry(3);
		TestEntry c = new TestEntry(5);
		TestEntry d = new TestEntry(4);
		TestEntry e = new TestEntry(4);
		TestEntry f = new TestEntry(9);
		h.put(a,"A");
		h.put(b,"B");
		h.put(c,"C");
		h.put(d,"D");
		h.put(e,"E");
		h.put(f,"F");
		assertEquals("A",h.get(a));
		assertEquals("B",h.get(b));
		assertEquals("C",h.get(c));
		assertEquals("D",h.get(d));
		assertEquals("E",h.get(e));
		assertEquals("F",h.get(f));
	}
	
	@Test
	public void multipleValues3(){
		// Multiple values no collisions
		MinimalHashMap<TestEntry,String> h = new MinimalHashMap<TestEntry,String>();
		TestEntry a = new TestEntry(1);
		TestEntry b = new TestEntry(3);
		TestEntry c = new TestEntry(5);
		TestEntry e = new TestEntry(4);
		TestEntry f = new TestEntry(9);
		h.put(a,"A");
		h.put(b,"B");
		h.put(c,"C");
		h.put(e,"E");
		h.put(f,"F");
		assertEquals("A",h.get(a));
		assertEquals("B",h.get(b));
		assertEquals("C",h.get(c));
		assertEquals("E",h.get(e));
		assertEquals("F",h.get(f));
	}
	
	@Test
	public void invalidKey(){
		MinimalHashMap<TestEntry,String> h = new MinimalHashMap<TestEntry,String>();
		TestEntry one = new TestEntry(1);
		TestEntry eleven = new TestEntry(11);
		h.put(one, "1");
		assertEquals(null, h.get(eleven));
	}
	
	@Test
	public void resize1(){
		MinimalHashMap<TestEntry,String> h = new MinimalHashMap<TestEntry,String>();
		for(int i = 0;i < 12;i++){
			h.put(new TestEntry(i), "" + i);
		}
		TestEntry thirteen = new TestEntry(13);
		h.put(thirteen, "Hello");
		
		assertEquals("Hello",h.get(thirteen));
	}
	
	@Test
	public void resize2(){
		MinimalHashMap<TestEntry,String> h = new MinimalHashMap<TestEntry,String>();
		TestEntry[] keys = new TestEntry[32];
		for(int i = 0;i < 32;i++){
			keys[i] = new TestEntry(i);
			h.put(keys[i], "" + i);
		}
		for(int i = 0;i < 32;i++){
			assertEquals("" + i,h.get(keys[i]));
		}
	}
	
	@Test
	public void numElements1(){
		MinimalHashMap<TestEntry,String> h = new MinimalHashMap<TestEntry,String>();
		for(int i = 0;i < 9;i++){
			h.put(new TestEntry(i), "" + i);
		}
		assertEquals(9,h.getNumElements());
	}
	
	@Test
	public void numElements2(){
		MinimalHashMap<TestEntry,String> h = new MinimalHashMap<TestEntry,String>();
		for(int i = 0;i < 123;i++){
			h.put(new TestEntry(i), "" + i);
		}
		assertEquals(123,h.getNumElements());
	}
	
	@Test
	public void overWrite(){
		MinimalHashMap<TestEntry,String> h = new MinimalHashMap<TestEntry,String>();
		TestEntry entry1 = new TestEntry(4);
		h.put(entry1, "Hello");
		assertEquals("Hello", h.get(entry1));
		h.put(entry1, "OverWritten");
		assertEquals("OverWritten", h.get(entry1));
	}

}
