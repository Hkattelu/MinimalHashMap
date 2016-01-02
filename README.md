# MinimalHashMap
A Hashmap with constant time random access

A Hashmap is a clever data structure that allows you to access elements
very quickly by using hashCodes and probing functions. These functions
allow you to skip a lot of the linear searching that would be necessary
in a typical data structure such as a LinkedList. As a result, HashMaps
are the go to data structure if you are looking to search elements constantly.
However, HashMaps are not perfect and in the process of putting and getting
elements, there are "collisions" that can occur which can slow down the
searching process. Because of this, HashMaps realisticly search in O(n) time
as opposed to O(1) time. 

While browsing the internet I came across an article about O(1) Hash map lookups
by using a method called Minimal perfect hashing. You can read about it here:

http://blog.demofox.org/2015/12/14/o1-data-lookups-with-minimal-perfect-hashing/

In short, this is a method that removes collisions entirely from HashMaps which
allows for consistent O(1) lookups. The downside is that it requires more
memory. 

# My Implementation

My Implementation of the Map follows the same idea as in the article although I take
a couple of extra shortcuts and precautions.

HOW TO USE:

To use this hashmap, simply call .put(key,value) to enter a value. Once all values are
entered, call .form() on your hashmap. This essentially finds the perfect hash function
in the way described by the article. Once .form() has been called, you can call .get(key)
to get an item out of it in constant time.

PRECAUTIONS:

There are a couple of things to note about the MinimalHashMap as it is special.
1. You cannot "over write" a value by calling .put() with the same value.
2. You should only use this when you need a fast access data structure and you have
   all of the elements that you are searching over. It is slow to enter new elements and
   in general it is not meant to be resized.
3. It works best when you know the # of elements you are inputting beforehand. There is
   a constructor that specifies the # of elements to hold and you should use this. The default
   size is 10 and the program will cause an infinite loop if you try to enter more than 10
   elements.
4. There is a rare scenario where if two Objects have the exact same hashCode, it will 
   cause an infinite loop. Although this will probably not happen, it is good to know.