package T1.T1;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import Model.Polinom;

public class MyTests {

	
	public MyTests() 
	{};
	
Polinom a= new Polinom();
Polinom b=new Polinom();



@Test
public void addTest()
    {
	a=a.crearePolinom("+6x^+5-4x^+4+12x^+1-6x^+0");
	   b=b.crearePolinom("+2x^+7+1x^+5-9x^+3-5x^+2-4x^+1");
	 
	   assertEquals("+2X^7+7X^5-4X^4-9X^3-5X^2+8X^1-6X^0",b.adunare(a, b).toString());
	  
	   assertEquals("-2X^7+5X^5-4X^4+9X^3+5X^2+16X^1-6X^0",b.scadere(a, b).toString());
    }

@Test
public void subTest()
    {
	a=a.crearePolinom("+6x^+5-4x^+4+12x^+1-6x^+0");
	   b=b.crearePolinom("+2x^+7+1x^+5-9x^+3-5x^+2-4x^+1");
	 
	   assertEquals("-2X^7+5X^5-4X^4+9X^3+5X^2+16X^1-6X^0",b.scadere(a, b).toString());
    }


@Test
public void derTest()
    {
		 
		Polinom c=new Polinom();
		c=c.crearePolinom("+6x^5-4x^4+12x^1-6x^0");
		
	    assertEquals("+30X^4-16X^3+12X^0",c.derivare(c).toString());
    }

@Test
public void intTest()
    {
		 
		Polinom c=new Polinom();
		c=c.crearePolinom("+6x^+5-4x^+4+12x^+1-6x^+0");
	
	    assertEquals("+1X^6-0.8X^5+6X^2-6X^1",c.integrare(c).toString());
    }

@Test
public void mulTest()
    {
		 
		Polinom a=new Polinom();
		Polinom b=new Polinom();
		
		a=a.crearePolinom("-3x^6+3x^4-1x^3+5x^1");
		b=b.crearePolinom("+5x^5-1x^4+2x^3+4x^2+2x^0");	
	
	    assertEquals("-15X^11+3X^10+9X^9-20X^8+7X^7+29X^6-9X^5+16X^4+18X^3+10X^1",a.inmultire(a, b).toString());
    }

@Test
public void divTest()
    {
		 
		Polinom a=new Polinom();
		Polinom b=new Polinom();
		
		a=a.crearePolinom("+2x^+4+3x^+3+4x^2+3x^+1+1x^+0");
		b=b.crearePolinom("+1x^+2+4x^+0");	
		
	
	    assertEquals("CAT=+2X^2+3X^1-4X^0   REST=-9X^1+17X^0",a.impartire(a, b).toString());
    }


    
	}