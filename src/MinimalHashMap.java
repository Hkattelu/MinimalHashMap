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
    private static class Bucket<E>{
    	
    	/** The Entries in the bucket **/
    	public ArrayList<E> entries = new ArrayList<E>();
    	
    	/** The number of entries in this bucket **/
    	public int size = 0;
    	
    	public void put(E entry){
    		entries.add(entry);
    		size++;
    	}
    
    }
    
    /*
     * A class that represents a single Key-value pair
     * inside the HashMap
     */
    private static class Entry<K,V>{
    	
    	/** The key of this entry **/
    	public K key;
    	
    	/** The value of this entry **/
    	private V value;
    	
    	public Entry(K Key, V Value){
    		key = Key;
    		value = Value;
    	}
    	
    	/**
    	 * Return the value of this entry
    	 * @return the value of this entry
    	 */
    	public V getValue(){
    		return value;
    	}
    }
    
    /** Contains the offsets for searching up elements **/
    private int[] salts;
    
    /** Contains the entries in the Map **/
    private Bucket<Entry>[] buckets;
    
    /** Contains the entries after a perfect hash function has been found **/
    private V[] elements;
    
    /** The number of elements currently in this Hash Map **/
    private int size = 0;
    
    /**
     * Construct a Minimal Hashmap that contains a specified number of elements
     * @param size the number of elements contained
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
    	int index = key.hashCode() % buckets.length;
    	if (buckets[index] == null)
    		buckets[index] = new Bucket<Entry>();
    	buckets[index].put(new Entry<K,V>(key,value));    	
    	size++;
    }
    
    /**
     * Finds the Hash function that allows for O(1) access. This
     * should be called once after all elements are inserted and 
     * the HashMap is full
     */
    public void form(){
    	
    	
    	//Find the hash function
    	for(int i=0; i< buckets.length;i++){
    		
    		if(buckets[i] == null){
    			// Do nothing and go on to the next bucket
    		}else if( buckets[i].size > 1){
    			for(int j=0; j < buckets[i].entries.size();j++){
    				
    			}
    		}else
    		{
    			// If a bucket has one element, then there was no collision
    			// to begin with and we can simply place it in the original spot
    			salts[i] = 0 - i - 1;
    			elements[i] = (V) buckets[i].entries.get(0).getValue();
    		}
    	}
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
