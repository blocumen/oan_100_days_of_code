public class AnnotationTest {
    public static void main(String[] args)
    {
        B obj = new B();
        obj.test();
    }

}

class A
{
    
    void display ()
   {
       System.out.println("In class a");
   }
}
class B extends  A
{
    @Override
    void display()
    {
        System.out.println("In class B");
    }
    void test()
    {
        System.out.println("test");
    }
}
