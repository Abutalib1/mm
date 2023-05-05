package javaapplication140;
public class JavaApplication140 {
    public static void main(String[] args) {
        int n = 9;
        print(9,1);
        
        
    }
    public static void spaces(int n){
        if (n != 0){
            System.out.print(" ");
            spaces(n-1); // recursive calling
        }
    }
    public static void stars(int n){
        if (n != 0){
            System.out.print("* ");
            stars(n-1); // recursive calling
        }
    }
    public static void print(int n,int i){
        if ( n != 0 ){
            spaces(n-1);
            stars(i);
            System.out.println("");
            print(n-1,i+1); // recursive calling
        }
    }
    
}
