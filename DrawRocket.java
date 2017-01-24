//Jason Ku
//10/11/2016
//TA: Claire Johansen
//Assignment 2: RocketShip.java

//This program will print a rocket ship with size scaling with a class constant.
public class DrawRocket {
   public static final int SIZE = 6;
   public static void main(String[] args) {
      cone();
      connector();
      upBody();
      downBody();
      connector();
      downBody();
      upBody();
      connector();
      cone();
   }
   
   //prints the pointed portion for the top and base of the rocket
   public static void cone() {
      for (int i = 0; i < 2 * SIZE - 1; i++) {
         for (int j = 2 * SIZE - 1; j > i; j--) {
            System.out.print(" ");
         }
         for (int k = 0; k <= i; k++) {
            System.out.print("/");
         }
         System.out.print("**");
         for (int l = 0; l <= i; l++) {
            System.out.print("\\");
         }
         System.out.println();  
      }
   }
   
   //prints the line between cone and body
   public static void connector() {
      System.out.print("+");
      for (int i = 0; i < 2* SIZE; i ++) {
         System.out.print("=*");
      }
      System.out.println("+");
   }
   
   //prints main body with triangles pointing upwards 
   public static void upBody() {
      for (int i = 0; i < SIZE; i++) {
         System.out.print("|");
         for (int m = 0; m < 2; m++) { //repeats the body for symmetry 
            for (int j = 0; j < SIZE - 1 - i; j++) {
               System.out.print(".");
            }
            for (int k = 0; k <= i; k++) {
               System.out.print("/\\");
            }
            for (int l = 0; l < SIZE - 1 - i; l++) {
               System.out.print(".");
            }
         }
         System.out.println("|");
      }
   }
   
   //prints main body with triangles pointing downwards
   public static void downBody() {
      for (int i = SIZE; i > 0; i--) {
         System.out.print("|");
         for (int m = 0; m < 2; m++) { //repeats the body for symmetry 
            for (int j = SIZE; j > i; j--) {
               System.out.print(".");
            }
            for (int k = i; k > 0; k--) {
               System.out.print("\\/");
            }
            for (int l = SIZE; l > i; l--) {
               System.out.print(".");
            }
         }
         System.out.println("|");
      }
   }
}
 