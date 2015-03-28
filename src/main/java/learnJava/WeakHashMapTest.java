/*
 * Copyright 2014 Renren.com All right reserved. This software is the
 * confidential and proprietary information of Renren.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Renren.com.
 */
package learnJava;

import java.util.Map;
import java.util.HashMap;  
import java.util.Iterator;  
import java.util.WeakHashMap;  

public class WeakHashMapTest {  
    public static void main(String[] args) throws Exception {  
        String a = new String("a");  
        String b = new String("b");  
        Map<String, String> weakmap = new WeakHashMap<String, String>();  
        Map<String, String> map = new HashMap<String, String>();  
        map.put(a, "aaa");  
        map.put(b, "bbb");  
  
          
        weakmap.put(a, "aaa");  
        weakmap.put(b, "bbb");  
          
        map.remove(a);  
          
        a=null;  
        b=null;  
          
        System.gc();  
        Iterator i = map.entrySet().iterator();  
        while (i.hasNext()) {  
            Map.Entry en = (Map.Entry)i.next();  
            System.out.println("map:"+en.getKey()+":"+en.getValue());  
        }  
  
        Iterator j = weakmap.entrySet().iterator();  
        while (j.hasNext()) {  
            Map.Entry en = (Map.Entry)j.next();  
            System.out.println("weakmap:"+en.getKey()+":"+en.getValue());  
              
        }  
    }  
  
      
}  