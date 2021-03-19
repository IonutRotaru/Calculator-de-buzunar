package Model;

public class Monom implements Comparable<Monom> {
	
	private Number coef;
	private Number putere;
	
	public Monom(Number  c,Number p)
	{
		coef=c;
		putere=p;
	}
	
	public Number getCoef()
	{
		return coef;
	}
	
	public Number getPutere()
	{
		return putere;
	}
	public void setPutere(Number a)
	{
		putere=a;
	}
	public void setCoef(Number a)
	{
		coef=a;
	}
	
	public String toString()
	{
		return coef+"X^"+putere; 
	}

	public int compareTo(Monom o) {
		if(this.getPutere().intValue() < o.getPutere().intValue())
			return 1;
		else return 0;
		
	}
	

}
