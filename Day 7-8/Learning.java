import java.util.HashMap;

class Learning {
        int rollno;//instance variable
        String name;
        static String college = "ITS";//static variable

        //constructor
        Learning(int r, String n) {
            rollno = r;
            name = n;
        }

        void display() {
            System.out.println(rollno + " " + name + " " + college);
        }

    public static class Test{
        public static void main(String[] args){
        Maths mathsobj=new Maths();
        Chemistry chemobj=new Chemistry();
        mathsobj.add("Number","Easy");
        mathsobj.add("Ratios","Medium");
        mathsobj.add("Matrix","Hard");
        mathsobj.add("Ratios","Easy");
        mathsobj.add("abc","Medium");
        mathsobj.add("123","Easy");
        chemobj.add("Kinetics","Easy");
        chemobj.add("Solutions","Hard");
        chemobj.add("xyz","Hard");
        chemobj.add("pqr","Easy");
       System.out.println(".......Maths Chapters......");
       for(String i: mathsobj.chapters.keySet())
       {
       System.out.println(i+" : "+mathsobj.chapters.get(i));
        }
            System.out.println(".......Chemistry Chapters......");
            for(String i: chemobj.chapters.keySet())
            {
                System.out.println(i+" : "+chemobj.chapters.get(i));
            }
            mathsobj.delete("abc");
            mathsobj.delete("123");
            System.out.println(".......Maths Deleted Chapters......");
            for(String i: mathsobj.chapters.keySet())
            {
                System.out.println(i+" : "+mathsobj.chapters.get(i));
            }
            chemobj.delete("xyz");
            chemobj.delete("pqr");
            System.out.println(".......Chemistry Deleted Chapters......");
            for(String i: chemobj.chapters.keySet())
            {
                System.out.println(i+" : "+chemobj.chapters.get(i));
            }
    }
    abstract class Teacher {
        HashMap<String ,String> chapters= new HashMap<String,String>();
        String chaptername;
        String difflevel;
            void add(String chaptername, String difflevel);
        {
            chapters.put(chaptername,difflevel);
        }
           void delete(String chaptername){
             chapters.remove(chaptername);
            }
    }
    abstract class Maths extends Teacher
    {abstract void display();
    }

    abstract class Chemistry extends Teacher
    {
    abstract void display();
    }
}

    //Learning.Test class to show the values of objects
    class TestStaticVariable1 {
        public static void main(String[] args) {
            Learning s1 = new Learning(111, "Karan");
            Learning s2 = new Learning(222, "Aryan");
//we can change the college of all objects by the single line of code
//Student.college="BBDIT";
            s1.display();
            s2.display();
        }
    }
