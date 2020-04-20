import java.util.Scanner;
class Factorial
{
   public static int fact(int n)
   {
       if (n == 0)    
		return 1;    
		else    
		return(n * fact(n-1));    
   }
   public static void main(String[] args)
   {
		System.out.println("Enter a number");
		Scanner scan = new Scanner(System.in);
		int n  = scan.nextInt();
		int f = fact(n);   
		System.out.println("Factorial of "+n+" is: "+f); 
	
   
   }
}