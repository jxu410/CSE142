// Jason ku
// 1/12/19
// CSE143
// TA: Cherie Ruan
// Assingment #1
// 
// This class keeps an inventory of the count of letters in a string
public class LetterInventory {
   public static final int ALL_LETTERS = 26; // 26 is the number of letters in the alphabet
   public static final int ASCII_A = 97; // 97 is the ascii code for 'a'
   private int[] counter; 
   private int size;
   
   // Constructor takes in a string and increments the counter to keep count of 
   // each occurence of a letter
   public LetterInventory(String data) {
      counter = new int[ALL_LETTERS];
      size = 0;
      String s = data.toLowerCase();
      for (int i = 0; i < s.length(); i++) {
         if (Character.isLetter(s.charAt(i))) {
            counter[s.charAt(i) - ASCII_A]++;    
            size++;     
         }
      }
   }
   
   // Takes in a char, if the char contains a non letter character throws a
   // IllegalArguementException, otherwise returns the count of that char
   public int get(char letter) {
      if (!Character.isLetter(letter)) {
         throw new IllegalArgumentException();
      }  
      return counter[(int) Character.toLowerCase(letter) - ASCII_A];
   }
   
   // returns whether this LetterInventory contains a count of any letter
   public boolean isEmpty() {
      return size == 0;
   }
   
   // returns the sum of all counts in LetterInventory
   public int size() {
      return size;
   }
   
   // returns string representation of LetterInventory in alphabetical order
   // beginning with a [ and ending in a ]
   public String toString() {
      String s = "[";
      for (int i = 0; i < ALL_LETTERS; i++) {
         for (int j = 0; j < counter[i]; j++) {
            s += (char) (i + ASCII_A);
         }
      }
      return s + "]";
   }
   
   // Takes in a char and an int, if the char is not a letter, throws
   // an IllegalArguementException, otherwise changes the count of 
   // the char to the value
   public void set(char letter, int value) {
      if (value < 0 || !Character.isLetter(letter)) {
         throw new IllegalArgumentException();
      }
      
      int index = (int) (Character.toLowerCase(letter) - ASCII_A);
      size = size - counter[index] + value;
      counter[index] = value;
   } 
   
   // Calculates the sum of this LetterInventory and another LetterInventory that is taken in
   // and stores that in a new LetterInventory that is returned
   public LetterInventory add(LetterInventory other) {
      LetterInventory result = new LetterInventory("");
      for (int i = ASCII_A; i < ASCII_A + ALL_LETTERS; i++) {
         result.set((char) i, this.get((char) i) + other.get((char) i));      
      }
      return result;
   }
   
   // Takes in a LetterInventory and subtracts the counts from this LetterInventory
   // if difference is negative, returns null, otherwise returns a new LetterInventory
   // containing the difference of counts
   public LetterInventory subtract(LetterInventory other) {
      LetterInventory result = new LetterInventory("");
      int difference = 0;
      for (int i = ASCII_A; i < ASCII_A + ALL_LETTERS; i++) {
         difference = this.get((char) i) - other.get((char) i);
         if (difference < 0) {
            return null;
         }
         result.set((char) i, difference);
      }
      return result; 
   }
}