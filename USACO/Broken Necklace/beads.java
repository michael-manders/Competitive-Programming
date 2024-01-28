/* 
ID: mjmande1
LANG: JAVA
TASK: beads      
*/
import java.io.*;
import java.util.*;

class beads {
  public static void main (String [] args) throws IOException {
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
    BufferedReader br = new BufferedReader(new FileReader("beads.in"));

    int amount = Integer.parseInt(br.readLine());
    String necklanceString = br.readLine();

    int max = 0;

    for (int i = 0; i < necklanceString.length(); i++) {
        if (max < calculateAtIndex(i, necklanceString)) {
            max = calculateAtIndex(i, necklanceString);
        }
    }

   out.println(max);
   out.close();

  }

  private static int calculateAtIndex(int index, String necklanceString) {
    String s2 = necklanceString.substring(0, index);
    String s1 = necklanceString.substring(index);

    String temp = s1;
    s1 = s1+s2;
    s2 = reverseString(s2)+reverseString(temp);

    int amount = calcAmount(s1) + calcAmount(s2); 

    if (amount > necklanceString.length()) {
        amount = necklanceString.length();
        
    }

    return amount;
  }

  private static String reverseString(String toReverse) {
    String reverse = "";

    for (int i = 0; i < toReverse.length(); i++) {
        reverse = toReverse.charAt(i) + reverse;
    };

    return reverse;
  }

  private static char getFirstChar(String necklace) {
    char character = 0;
    for (int i = 0; i < necklace.length(); i++) {
        character = necklace.charAt(i);
        if (character != 'w') {
            break;   
        }
    }   

    return character;
  }

  private static int calcAmount(String string) {
    char firstChar = getFirstChar(string);
    int amount = 0;

    int i = 0;
    while (true) {

        if (i == string.length()) break;

        if (string.charAt(i) == firstChar || string.charAt(i) == 'w') {
            amount++;
        }
        else {
            break;
        }
        i++;
    }
    return amount;
  }

}