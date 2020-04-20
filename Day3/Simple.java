/* 
Private modifier
class A
{
   private int data = 40;
   private void msg()
   {
      System.out.println("Hello");
   }
}
class Simple
{
		public static void main(String[] args)
		{
		    A obj = new A();
			System.out.println(obj.data);//Compile Time Error  
			obj.msg();

		}
}
*/
/* private constructor*/
class A
{  
	private A(){}//private constructor  
	void msg(){System.out.println("Hello java");}  
}  
public class Simple
{  
	public static void main(String args[])
	{  
		A obj=new A();//Compile Time Error 
	}		
}  

