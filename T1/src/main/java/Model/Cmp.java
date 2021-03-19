package Model;


import java.util.Comparator;

public class Cmp implements Comparator<Monom> {

	
	 public int compare(Monom a, Monom b) 
	    { 
	        return  (b.getPutere().intValue()-a.getPutere().intValue()); 
	    } 
	
}