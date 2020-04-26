package teacher;
import java.util.HashMap;
public class MathsTeacher extends Teacher{

    HashMap<String, String> chapterMap = new HashMap<>();

    public MathsTeacher()
    {
        addChapter(chapterMap,"Real Numbers","okay");
        addChapter(chapterMap,"Polynomials","okay");
        addChapter(chapterMap,"Quadratic Equations","Good");
    }

}
