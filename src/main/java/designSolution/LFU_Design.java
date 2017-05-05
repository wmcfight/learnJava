package designSolution;

public class LFU_Design {
/**
 *
 * http://stackoverflow.com/questions/17759560/what-is-the-difference-between-lru-and-lfu
 *
 *
 * Let's consider a constant stream of cache requests with a cache capacity of 3, see below:

 A, B, C, A, A, A, A, A, A, A, A, A, A, A, B, C, D
 If we just consider a Least Recently Used (LRU) cache with a HashMap + doubly linked list
 implementation with O(1) eviction time and O(1) load time, we would have the following elements
 cached while processing the caching requests as mentioned above.

 [A]
 [A, B]
 [A, B, C]
 [B, C, A] <- a stream of As keeps A at the head of the list.
 [C, A, B]
 [A, B, C]
 [B, C, D] <- here, we evict A, we can do better!


 */


/**
 * for LRU, use HaspMap + double linked list
 * LRU : http://gogole.iteye.com/blog/692103
 *
 * LFU:
 * LFU is a cache eviction algorithm called least frequently used cache.

 It requires three data structures. One is a hash table which is used to cache the key/values so that given
 a key we can retrieve the cache entry at O(1). Second one is a double linked list for each frequency of access.
 The max frequency is capped at the cache size to avoid creating more and more frequency list entries.
 If we have a cache of max size 4 then we will end up with 4 different frequencies.
 Each frequency will have a double linked list to keep track of the cache entries belonging to that particular
 frequency. The third data structure would be to somehow link these frequencies lists.
 It can be either an array or another linked list so that on accessing a cache entry it can be easily
 promoted to the next frequency list in time O(1).

 http://ju.outofmemory.cn/entry/50447


 */

}
