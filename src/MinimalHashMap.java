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

    private static class Entry<K,V>{
    	/** The key for this entry **/
    	private K key;
    	
    	/** The value of this entry **/
    	private V value;
    	
    	public Entry(K Key, V Value){
    		key = Key;
    		value = Value;
    	}
    
    }
    
    /** Contains the offsets for searching up elements **/
    private int[] offsets;
    
    /** Contains the entries in the Map **/
    private Entry<K,V>[] entries;
    
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
    
    

}
