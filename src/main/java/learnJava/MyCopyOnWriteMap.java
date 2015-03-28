/*
 * Copyright 2014 Renren.com All right reserved. This software is the
 * confidential and proprietary information of Renren.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Renren.com.
 */
package learnJava;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Descriptions of the class MyCopyOnWriteMap.java's implementation：TODO described the implementation of class
 * @author wmc 2014年3月18日 上午11:01:03
 * @param <V>
 */
public class MyCopyOnWriteMap<K,V> implements Map<K, V>,Cloneable {

	private volatile Map<K, V> internalMap;
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public V get(Object key) {
		// TODO Auto-generated method stub
		return internalMap.get(key);
	}

	@Override
	public V put(K key, V value) {
		// TODO Auto-generated method stub
		synchronized (this) {
			Map<K, V> tempMap = internalMap;
			V result = tempMap.put(key, value);
			internalMap = tempMap;
			return result;
		}
	}

	@Override
	public V remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		synchronized (this) {
			Map<K, V> tempMap = internalMap;
			tempMap.putAll(m);
			internalMap = tempMap;
 		}
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

}
