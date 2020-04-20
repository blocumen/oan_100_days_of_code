package SimpleInterest;
public class SimpleInterest {
    public double sInterest(double principle,double time)
    {
        int r = 6;
        double simple;
        simple = (principle*time*r)/100;
        return simple;
    }
}
