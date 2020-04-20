public class TestStaticMethod {
    public static void main(String[] args) {
        Student1.change();//calling change method

        //creating objects

        Student1 s1 = new Student1(111, "karan");
        Student1 s2 = new Student1(112, "Varun");
        Student1 s3 = new Student1(113, "Neha");

        //calling display method

        s1.display();
        s2.display();
        s3.display();
    }

}
