/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashmapexample;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author dalemusser
 * 
 * https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html
 * 
 * Google: Java for hashmap
 * http://stackoverflow.com/questions/1066589/iterate-through-a-hashmap
 */
public class HashMapExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HashMap hashMap1 = new HashMap();
        
        hashMap1.put("name", "Mary Smith");
        hashMap1.put("role", "student");
        hashMap1.put("age", 20);
        
        System.out.println(hashMap1);
        
        for (Object key: hashMap1.keySet()) {
            System.out.println(key);
        }
        
        for (Object value: hashMap1.values()) {
            System.out.println(value);
        }
        
        for (Object entry : hashMap1.entrySet()) {
            HashMap.Entry<Object, Object>e = (HashMap.Entry<Object, Object>)entry;
            Object key = e.getKey();
            Object value = e.getValue();
            System.out.println(key + " => " + value);
        }
        
        Iterator it = hashMap1.entrySet().iterator();
        while (it.hasNext()) {
            HashMap.Entry pair = (HashMap.Entry)it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }
        
        System.out.println("After iterator that removed all the items.");
        Iterator it2 = hashMap1.entrySet().iterator();
        while (it2.hasNext()) {
            HashMap.Entry pair = (HashMap.Entry)it2.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
        }
        
    }
    
}
