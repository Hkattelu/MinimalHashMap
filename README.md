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
allows for consisten O(1) lookups. The downside is that it requires slightly more
memory. 

I have decided to make my own implementation of this "Minimal Perfect Hash Map"
called the MinimalHashMap.
