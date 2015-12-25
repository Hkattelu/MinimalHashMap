/*
 * A special version of a Chained HashMap in which the
 * probing is modified such that lookups for an element are
 * always in constant time. This is done by keeping track of 
 * the offsets in separate collection. The constant time lookups
 * at the cost of extra memory to store these offset values.
 * 
 * @Author: Himanshu Kattelu
 * @Version: 12/19/2015
 */

public class MinimalHashMap<K,V> {

	/*
	 * A class that represents an individual Key-Value pair in
	 * this Hashmap.
	 */
    private static class Entry<K,V>{
    	
    	/** The key for this entry **/
    	public K key;
    	
    	/** The value of this entry **/
    	public V value;
    	
    	public Entry(K Key, V Value){
    		key = Key;
    		value = Value;
    	}
    
    }
    
    /** Contains the offsets for searching up elements **/
    private int[] offsets;
    
    /** Contains the entries in the Map **/
    private Entry<K,V>[] entries;
    
    /** The number of elements currently in this Hash Map **/
    private int size = 0;
    
    /*
     * Special Constructor if you know roughly how many
     * elements will be contained in the HashMap before creation.
     */
	public MinimalHashMap(int size){
    	entries = new Entry[size];
    }
    
    public MinimalHashMap(){
    	entries = new Entry[10];
    }
    
    /**
     * Resize the HashMap to hold a specified number of elements
     * @param size the specified number
     */
    private void resize(int size){
    	//rewrite to include all the previous entries
    	Entry<K,V>[] tempEntries = entries;
    	entries = new Entry[size];
    	for(int i = 0;i<tempEntries.length;i++)
    		put((K) tempEntries[i].key,(V) tempEntries[i].value);
    }
    
    /**
     * Place an element into this Hashmap with Key key
     * @param key The key of the key-value pair to enter
     * @param value The value of the key-value pair to enter
     */
    public void put(K key, V value){
    	if(key == null)
    		return; // null keys not allowed
    	if(size >= entries.length){
    		resize(2*entries.length); // Double size if full
    		size = size/2; // Fix the size after replacing elements
    	}
    	int index = key.hashCode() % entries.length;
    	if(entries[index] == null){
    	  entries[index] = new Entry<K, V>(key,value);
    	}else{
    		//Linear probing for now;
    		while(entries[index] != null){
    			index++; 
    			index = index % entries.length; //Probe linearly
    			if(entries[index] == null){
    				if(value == null)
    					break;
    				entries[index] = new Entry<K, V>(key,value);
    				break;
    			}
    			
    		}
    	}
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
    	int index = key.hashCode() % entries.length;
    	int notFoundCount = 0;
    	notFoundCount++;
    	if(entries[index].key == key){ // Simply grab the element at the index
    		if(entries[index].value == null)
    			return null;
    		return entries[index].value;
    	}
    	while(notFoundCount < entries.length){
    		index++; // Probe linearly
    		index = index % entries.length;
    		if(entries[index] !=null && entries[index].key == key){
    			if(entries[index].value == null)
        			return null;
        		return entries[index].value;
    		}
    		notFoundCount++;
    	}
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
