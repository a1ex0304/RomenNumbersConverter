import java.util.Scanner;
class Roman{
  //set two arrays, one for numbers and one for roman letters. Making them private will allow it only to be accessed in the Roman class. We make it static as we dont have to make an instance of the arrays and can call the methods alot easier 
  private static final int[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
  private static final String[] romanletters = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
  //this is a method to use indexOf, we will use this during the converttoInt option. This method searches throughout the romanletters array to find a match with the first character of the string the user entered.
  private static int indexOf(String[]arr, char string){
    for (int y = 0; y<romanletters.length;y++){
      if (romanletters[y].equals(Character.toString(string))) {
        return y;//it will return y so it can get the value of the index in the number array and add it to the total 
        }
    }return 0;
  }
  //convertToString part
  //set method to public static String because we will be getting an string as the final answer
  public static String convertToString(int number){
    //conditional statements
    if (number<0){
      return("Number must be over 0");
    }else if (number>3999){
      return("Number must be under 3999");
    }
    String roman = "";
    //we set x to 0, it will go up by 1 until it reaches the index of the highest number in the number array
    for (int x = 0; x<numbers.length;x++){
      while (number>=numbers[x]){
        roman += romanletters[x];//taking the index of the highest value, we will put it into the romanletters array and add it to the roman string for the answer
        number -= numbers[x];//subtract that highest value with the number entered to get the value left. the for loop will repeat the process for this new value
      }
    }
    return roman;
  }
  //convertToInt part
  //set method to public static int because we will be getting an int as the final answer
  public static int convertToInt(String string){
    int num = 0;
    //for loop, this will have y add one as long as it is below the length of the string entered(this will be how many times the indexOf method will have to process a new value)
    for (int y = 0;y<string.length();y++){
      //the index obtained in the indexOf method will be used to find the number in the number array at that index. we will add this value to the num variable
      num += numbers[indexOf(romanletters,string.charAt(y))];
      continue;
    }
    return num;
  }
}

//main class
public class Main {
  public static void main(String[] args) {
    //assign variables
    int number = 0;
    int option = 0;
    String string;
    Scanner scan = new Scanner(System.in);
    System.out.print("1 for convertToString\n2 for convertToInt\nNumber: ");
    option = scan.nextInt();
    //conditonal statements for what option they want to use
    if (option == 1){
      System.out.print("Number: ");
      number = scan.nextInt();
      //print out the result of the convertToString method with the number entered in
      System.out.println(Roman.convertToString(number));
    }else if (option == 2){
      System.out.print("Roman Integers: ");
      string = scan.next();
      //print out the result of the convertToInt method with the string entered in
      System.out.println(Roman.convertToInt(string));
    }else{
      System.out.print("Invalid Input");
    }
  }
}
