package CompoundInterest;
public class CompoundInterest {
    public double cInterest(double principle,double time)
    {
        double  r = 0.06;
		int n = 12;
        double compound,cinterest;
		compound = principle * Math.pow(1+(r/n),n * time);
        cinterest = compound - principle;
        return cinterest;
    }
}
