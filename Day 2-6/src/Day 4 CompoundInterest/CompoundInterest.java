package CompoundInterest;

public class CompoundInterest {
    static double p=10;
    static double r=2;
    static double t=2;
    public static void myMethod1() {
        System.out.println(p*(1+(r/100))*(1+(r/100))-p);
    }
    public static void main(String[] args) {
        myMethod1();
}
}
