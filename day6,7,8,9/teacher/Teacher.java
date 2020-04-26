package teacher;
import java.util.*;

public class Teacher {

    public void addChapter(HashMap<String, String> map, String NameofChapter, String toughness){

        map.put(NameofChapter,toughness);
    }


    public void removeChapter(HashMap<String, String> map, String NameofChapter){

        map.remove(NameofChapter);
    }

    public void display(HashMap<String, String> map)
    {
        for (Map.Entry<String, String> entryValue : map.entrySet())
        {
            System.out.println("Enter name of the chapter :" +entryValue.getKey() +" , Difficulty is "+ entryValue.getValue() );
        }
    }

    public static void main(String[] args) {
        teacher.ChemistryTeacher subchem = new teacher.ChemistryTeacher();
        teacher.MathsTeacher submath = new teacher.MathsTeacher();
        subchem.display(subchem.chapterMap);
        System.out.println("\n");
        submath.display(submath.chapterMap);

        submath.removeChapter(submath.chapterMap,"Real Numbers");
        subchem.removeChapter(subchem.chapterMap,"Solutions");
        System.out.println("\nAfter deleting wrong chapters \n");
        subchem.display(subchem.chapterMap);
        System.out.println("\n");

        submath.display(submath.chapterMap);
        System.out.println("\n");

    }
}
