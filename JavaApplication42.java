package javaapplication42;
import java.util.*;
public class JavaApplication42 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("1) Play game");
            System.out.println("2) Print the Sequence");
            System.out.println("3) Exit");
            int choice =sc.nextInt();
            if (choice==1){playGame();}
            else if (choice==2){printSequence();}
            else if (choice==3){break;}
            else {System.out.println("Wrong choice! Please enter your choice again");}}}
    public static void playGame(){
        int random = (int) (Math.random()*899) + 100;
        int a = random /100,b = (random/10)-((random /100)*10);
        int c = random - (a*100) - (b*10);
        int right =0,wrong =0;
        Scanner sc = new Scanner(System.in);
        while (right != 3){
                System.out.println("Enter the guess number : ");
                int guss=sc.nextInt();
                if (guss == a || guss == b || guss == c){
                    if (guss == a) System.out.println(a+" - -");
                    else if (guss == b)System.out.println("- "+b+" -");
                    else if (guss == c)System.out.println("- - "+c);
                    right++;}
                else {
                    System.out.println(guss+" is wrong!...try again");
                    wrong++;}
                if (right==3){
                    System.out.println("*** GREAT !!! YOU GUESSED THE NUMBER CORRECTLY.");
                    System.out.println("THE NUMBER WAS "+random);
                    System.out.println("YOU MISSED "+wrong);}}}
    public static void printSequence(){
        Scanner sc = new Scanner(System.in);
                int x =1;
                while (x != 0){
                    System.out.println("Enter a number between 1 and 7 : ");
                    int num= sc.nextInt();
                    String z="";
                    if (num >=1 && num <=6){
                        switch(num){
                            case 1:z="4/2! = ";break;
                            case 2:z="4/2! -6/3! =";break;
                            case 3:z="4/2! -6/3! + 10/5! = ";break;
                            case 4:z="4/2! -6/3! + 10/5! - 16/8! = ";break;
                            case 5:z="4/2! -6/3! + 10/5! -16/8! + 26/13! = ";break;
                            case 6:z="4/2! -6/3! + 10/5! -16/8! + 26/13! -42/21! = ";break;}
                        double A[]={4.0,6.0,10.0,16.0,26.0,42.0};
                        double in=0;
                        double frrr=0;
                        for (int i=0;i<num;i++){
                            int Hnum = (int) A[i] / 2;
                             in = A[i] / factNumber(Hnum);
                             if ((i%2)!=0 || i==1 )
                                frrr +=in;
                            else if ((i%2)==0 && i !=1)
                                frrr -=in;}
                        System.out.println(z+frrr*-1);
                        break;}
                    else{
                        System.out.println("THE NUMBER YOU ENTERED NOT IN RANGE FROM 1 TO 7");
                        continue;}}}
    public static long factNumber(int x){
        long fac = 1;
        for (int j=1;j<=x;j++){
              fac *= j;}
        return fac;}}
