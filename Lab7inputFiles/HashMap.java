/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

public class HashMap {
   private final static int TABLE_SIZE = 100;

   HashEntry[] table;

   /**
    * Constructor
    */
   HashMap() {
      // Creating the HashMap
      table = new HashEntry[TABLE_SIZE];
   }

   /**
    * Method that will return the description that
    * correlates with teh key ther are searching.
    * If no match is found, it iwill return null
    * 
    * @param key
    * @return
    */
   public String get(int key) {
      int i = key % TABLE_SIZE; // index
      // loop will keep going until it finds a match
      while (table[i] != null && table[i].getKey() != key) {
         i = (7 * i + 1) % TABLE_SIZE; // LINEAR PROBING
      }

      // returning value
      if (table[i] != null) {
         return table[i].getValue();
      } else { //if no match is found
         return null;
      }
   }

   /**
    * Adding a new HashEntry to the HashMap
    * 
    * @param key
    * @param value
    */
   public void put(int key, String value) {
      int i = key % TABLE_SIZE; // index

      while (table[i] != null && table[i].getKey() != key) {
         i = (7 * i + 1) % TABLE_SIZE; // LINEAR PROBING
      }

      table[i] = new HashEntry(key, value);
   }

   /**
    * Adding a new Hash Entry via Linear Probing
    * 
    * @param key
    * @param value
    */
   public void linearProbe(int key, String value) {
      int i = key % TABLE_SIZE; // index

      while (table[i] != null && table[i].getKey() != key) {
         // H(x) + _ + 1
         i = (7 * i + 1) % TABLE_SIZE; // LINEAR PROBING
      }

      // adding new value
      table[i] = new HashEntry(key, value);
   }

   /**
    * Adding a new HashEntry via Quadratic Probing
    * 
    * @param key
    * @param value
    */
   public void quadraticProbe(int key, String value) {
      // Implement
      int i = key % TABLE_SIZE;
      int index = 1;

      while (table[i] != null) {
         // H(x) + _^2
         i = (i + index * index) % TABLE_SIZE; // QUADRATIC PROBING
         index++;
      }
      // adding new value
      table[i] = new HashEntry(key, value);
   }

}
