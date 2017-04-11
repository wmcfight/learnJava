package leetcode;

/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4


        public:
    LRUCache(int capacity) {
       // nData = new Node[capacity];
        head = new Node;
        tail = new Node;
        head->next = tail;
        head->prev = NULL;
        tail->prev = head;
        tail->next = NULL;
        nSize = capacity;
        mData.clear();

    }

    int get(int key) {
    	int result = -1;
    	Node* node = findNode(key);
        if(node != NULL){
        	detach(node);
        	attach(node);
        	result = node->value;
        }
        return result;

    }

    void set(int key, int value) {

        Node* node = findNode(key);
        if(node != NULL){
        	node->value = value;
        	detach(node);
        	attach(node);
        }else{
        	if(mData.size() >= nSize){
        		node = tail->prev;
        		detach(node);
        		mData.erase(node->key);
        	}
        	node = new Node;
        	node->key = key;
        	node->value = value;
        	attach(node);
        	mData[key] = node;
        }
    }


private:
   //查找结点
   Node* findNode(int key){
   	  Node* data;
   	  map<int,Node*>::iterator iter = mData.find(key);
   	  if(iter != mData.end()){
   	  	 data = iter->second;

   	  }else{
   	  	 data = NULL;

   	  }
   	  return data;

   }

// 分离结点
   void detach(Node* node){
   	  node->prev->next = node->next;
   	  node->next->prev = node->prev;
   }
  // 将结点插入头部
   void attach(Node* node){
   	  node->prev = head;
   	  node->next = head->next;
   	  head->next = node;
   	  node->next->prev = node;

   }
private:
	map<int,Node*> mData;
//	vector<Node*> vData;
	int nSize;
	Node* head, *tail;
//	Node* nData;
 */


public class LRUCache {
}
