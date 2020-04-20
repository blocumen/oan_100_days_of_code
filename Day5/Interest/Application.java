import SimpleInterest.*;
import CompoundInterest.*;
import java.util.Scanner;
class Application
{
	public static void main(String[] args)
	{
		SimpleInterest siobj = new SimpleInterest();
		CompoundInterest ciobj = new CompoundInterest();
		Scanner scan = new Scanner(System.in);
		for(int i=0;i<3;i++)
		{
		   double p, t,si, ci;
		   //System.out.print("Enter username");
		   //scan.nextLine();
		   //String user = scan.nextLine();
		   System.out.print("Enter the Principal : ");
		   p = scan.nextDouble();
           System.out.print("Enter the Time period : ");
           t = scan.nextDouble();
		   si = siobj.sInterest(p,t);
		   ci = ciobj.cInterest(p,t);
		   System.out.println("Simple Interest : "+si+"  Compound Interest : "+ci+" @6% rate of interest ");
		   
		}
	}
}