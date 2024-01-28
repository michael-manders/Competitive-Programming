import java.util.*;
import java.io.*;


class template {
     

    class city {
String name; int attr, int crating,int price, int tRating;
    city(String name1; int attr1, int crating1,int price1, int tRating1){
        name=name1;
        attr=attr1;crating=crating1;price=price1;tRating=tRating1;}
    
}
    public static void main(String [] args) throws IOException{
        Scanner in = new Scanner(new File ("template.dat"));
        ArrayList<city> cities=new ArrayList<>();
        int city,flights,price;
        city=city.nextInt();flights=in.nextInt();price=in.nextInt();
        while(city-->0){city x=new city(in.next(),in.nextInt(),in.nextInt()); }

        

    }
}

class city {
String name; int attr, int crating,int price, int tRating;
    city(String name1; int attr1, int crating1,int price1, int tRating1){
        name=name1;
        attr=attr1;crating=crating1;price=price1;tRating=tRating1;}
    
}