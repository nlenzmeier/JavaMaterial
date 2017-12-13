/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylistdemo;

import java.util.ArrayList;

/**
 *
 * @author dale
 * https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
 */
public class ArrayListDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      // create an array list
        ArrayList<String> al = new ArrayList<>();
        System.out.println("Initial size of al: " + al.size());

        // add elements to the array list
        al.add("Apple");
        al.add("Banana");
        al.add("Cherry");
        al.add("Date");
        al.add("Elderberry");
        al.add("Fig");
        // display the array list
        System.out.println("Contents of al: " + al);
        
        // add item to array list at position 1
        al.add(1, "Apricot");
        System.out.println("Size of al after additions: " + al.size());
        // display the array list
        System.out.println("Contents of al: " + al);
        
        System.out.println("Iterate throught list and print items.");
        for (String item : al) {
            System.out.println(item);
        }
        
// Remove elements from the array list
        al.remove("Elderberry");
        al.remove(2);
        System.out.println("Size of al after deletions: " + al.size());
        System.out.println("Contents of al: " + al);
        
        String first = (String)al.get(0);
        
        System.out.println(al.get(0).getClass());
    }
    
}
