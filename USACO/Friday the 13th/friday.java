/* 
ID: mjmande1
LANG: JAVA
TASK: friday      
*/
import java.io.*;
import java.util.*;

class friday {
  public static void main (String [] args) throws IOException {
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
    BufferedReader br = new BufferedReader(new FileReader("friday.in"));

    int dayOfWeek = 2;
    int years = Integer.parseInt(br.readLine())-1;


    int[] days = {0, 0, 0, 0, 0, 0, 0};
    int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    for (int y = 1900; y <= 1900+years; y++) {
        boolean leap = false;
        if (y % 400 == 0) {
            leap = true;
        } else if (y % 100 == 0) {
            leap = false;
        } else if (y % 4 == 0) {
            leap = true;
        } else {
            leap = false;
        }
        if (leap) {
            month[1] = 29;
        } else {
            month[1] = 28;
        }
        for (int m: month) {
            dayOfWeek+=12;
            dayOfWeek%=7;
            days[dayOfWeek]++;
            dayOfWeek+=m-12;
        }

    }

    
    String output = "";
    for (int num: days) {
        output = output + num + " ";
    }
    out.println(output.substring(0, output.length()- 1));
    out.close();


  }
}