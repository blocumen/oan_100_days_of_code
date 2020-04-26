package teacher;
import java.util.HashMap;
public class ChemistryTeacher extends Teacher {
    HashMap<String, String> chapterMap = new HashMap<>();
    public ChemistryTeacher()
    {
        addChapter(chapterMap,"Electrochemistry","okay");
        addChapter(chapterMap,"Solutions","okay");
        addChapter(chapterMap,"Polymers","intersting");
    }

}
