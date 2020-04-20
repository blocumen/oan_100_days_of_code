import java.util.*;
public class Application {
    public static void main(String[] args) {
        Maths mathsobj = new Maths();
        Chemistry chemobj = new Chemistry();
        //System.out.println(mathsobj.chapters);
        mathsobj.display(mathsobj.chapters);
		chemobj.display(chemobj.chapters);
		mathsobj.delete("abc");
		mathsobj.delete("123");
		System.out.println("Maths chapters after deleting, abc and 123");
		mathsobj.display(mathsobj.chapters);
		chemobj.delete("xyz");
		chemobj.delete("pqr");
		System.out.println("Chemistry chapters after deleting, xyz and pqr");
		chemobj.display(chemobj.chapters);
    }
}

class Teacher
{
    HashMap<String , String> chapters  = new HashMap<String , String>();
	protected void  add(String chaptername, String difflevel)
    {
        chapters.put(chaptername, difflevel);
    }
   protected  void  delete(String chaptername)
    {
        chapters.remove(chaptername);
    }
}

class Maths extends Teacher
{
   
    Maths()
    {
        add("Numbers","Easy");
        add("Geometry","Medium");
        add("Ratios","Easy");
        add("Integrals","Hard");
        add("Matrix","easy");
        add("abc","easy");
        add("123","easy");;
		
	}
	void display(HashMap<String, String> obj)
	{
		System.out.println(".....Maths Chapters....");
		for( Map.Entry<String, String> entry : obj.entrySet() ){
		System.out.println( entry.getKey() + " => " + entry.getValue() );
	}
	}
}
class Chemistry extends Teacher
{
    Chemistry()
    {
        add("Elements","Easy");
        add("Solutions","Medium");
        add("Electrochemistry","Easy");
        add(" Chemical Kinetics","Hard");
        add("xyz","easy");
        add("pqr","easy");
    }
	void display(HashMap<String, String> obj)
	{
		System.out.println(".....Chemistry Chapters....");
		for( Map.Entry<String, String> entry : obj.entrySet() ){
		System.out.println( entry.getKey() + " => " + entry.getValue() );
		}
	}	

}




