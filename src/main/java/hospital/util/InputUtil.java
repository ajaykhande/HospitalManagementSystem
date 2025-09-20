package hospital.util;

import java.util.Scanner;

public class InputUtil {
  private static final Scanner sc = new Scanner(System.in);

  public static int readInt(String message){
     while (true){
         System.out.println(message);
         String input = sc.nextLine().trim();

         if(input.matches("\\d+")){
             return Integer.parseInt(input);
         }else {
             System.out.println("Invalid input "+input+"! Please enter a valid number.");
         }
     }
  }

  public static String readString(String message){
      while (true){
          System.out.println(message);
          String input = sc.nextLine().trim();

          if (input.matches("[a-zA-Z ]+")){
              return input;
          }else {
              System.out.println("Invalid input "+input+"! Please enter letters only.");
          }
      }

  }

    public static String readDate(String message){
        while (true){
            System.out.println(message);
            String input = sc.nextLine().trim();

            if (input.matches("\\d{4}-\\d{2}-\\d{2}")){
                return input;
            }else {
                System.out.println("Invalid date "+input+"! Please enter valid format (YYYY-MM-DD).");
            }
        }
    }
}
