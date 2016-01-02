import java.util.ArrayList;

/*
 * A special version of a Chained HashMap in which the
 * probing is modified such that lookups for an element are
 * always in constant time. This is done by keeping track of 
 * the offsets in separate collection. The constant time lookups
 * at the cost of extra memory to store these offset values.
 * 
 * @Author: Himanshu Kattelu
 * @Version: 12/26/2015
 */

public class MinimalHashMap<K,V> {

	/*
	 * A class that represents an individual Bucket that
	 * contains Key-value pairs in a Hashmap.
	 */
    private static class Bucket<K,V>{
    	
    	/** The key for this entry **/
    	public K key;
    	
    	/** The value of this entry **/
    	public ArrayList<V> values = new ArrayList<V>();
    	
    	public Bucket(K Key){
    		key = Key;
    	}
    	
    	public void put(V value){
    		values.add(value);
    	}
    
    }
    
    /** Contains the offsets for searching up elements **/
    private int[] salts;
    
    /** Contains the entries in the Map **/
    private Bucket<K,V>[] buckets;
    
    /** The number of elements currently in this Hash Map **/
    private int size = 0;
    
    /*
     * Special Constructor if you know roughly how many
     * elements will be contained in the HashMap before creation.
     */
	public MinimalHashMap(int size){
    	buckets = new Bucket[size];
    	salts = new int[buckets.length];
    }
    
    public MinimalHashMap(){
    	buckets = new Bucket[10];
    	salts = new int[buckets.length];
    }
    
    /**
     * Resize the HashMap to hold a specified number of elements
     * @param size the specified number
     */
    private void resize(int size){
    	
    }
    
    /**
     * Place an element into this Hashmap with Key key
     * @param key The key of the key-value pair to enter
     * @param value The value of the key-value pair to enter
     */
    public void put(K key, V value){
    	if(key == null)
    		return; // null keys not allowed

    	
    	size++;
    }
    
    /**
     * Get the element with Key key from the Map
     * @param key The specified key
     * @return The element with Key key
     */
    public V get(K key){
    	if(key == null)
    		return null;
    	
    	return null;
    }
    
    /**
     * Returns the number of key-value pairs stored
     * in this hash map
     * @return the number of key-value pairs
     */
    public int getNumElements(){
    	return size;
    }
    
    
}
