package javaapplication140;
public class JavaApplication140 {
    public static void main(String[] args) {
        int n = 9;
        PrintPyramid(n,1);       
    }
    public static void PrintPyramid(int n,int i){
        if ( n != 0 ){
            spaces(n-1); // (n-1) because the left spaces will be for the stars
            stars(i);
            System.out.println(""); // to jump to the next row
            PrintPyramid(n-1,i+1); // recursive calling
        }
    }
    public static void spaces(int n){
        // base case is when n = 0
        if (n != 0){
            System.out.print(" ");
            spaces(n-1); // recursive calling
        }
    }
    public static void stars(int n){
        // base case is when n = 0
        if (n != 0){
            System.out.print("* ");
            stars(n-1); // recursive calling
        }
    }
    
}
