package Model;
import java.util.ArrayList;
import java.util.Collections;

public class Polinom {
	private int grad;
	private int grad_min;
	private ArrayList<Monom> p = new ArrayList<Monom>();
	public Polinom(){	}
	public void addMonom(Monom m)
	{
		p.add(m);
	}
	public Polinom crearePolinom(String text)
	{
	         text=text.replaceAll("[^0-9+-]+", " ");
	         text=text.replaceAll("[+]", " +");
	         text=text.replaceAll("[-]", " -");
	         text=text.replaceAll("  ", " ");        
	         String[] strgs = text.split(" ");
	         int c=0,p=0;
	         Monom m;
	         Polinom rez = new Polinom();
	         for(int i=1;i<strgs.length;i+=2)
	        {c=Integer.parseInt(strgs[i]);
	         p=Integer.parseInt(strgs[i+1]);
	         m=new Monom(c,p);
	         rez.addMonom(m);
	         }
        rez.sortarePolinom();
		rez.autoGrad();
		return rez;	}
	
	public void sortarePolinom()
	{
		Collections.sort(p, new Cmp());		
	}
	public void eliminareZero( )
	{
		int max=p.size();
		for(int i=0;i<max;i++)
		{
			if(p.get(i).getCoef().doubleValue()==0)
				{p.remove(i);
				max--;
				i--;
	}}}
	public void setGrad(int g,int h)
	{
		grad=g;
		grad_min=h;
	}
	public int getGrad()
	{
		return grad;
	}
	public int getGradMin()
	{
		return grad_min;
	}
	public void autoGrad()
	{
		int ok=0;
		for(Monom m:p)
		{
			if(m.getCoef().doubleValue()!=0 && ok==0)
				{grad= m.getPutere().intValue();
				ok=1;
				}
			if(m.getCoef().doubleValue()!=0)
				grad_min= m.getPutere().intValue();
		}
	}
	public ArrayList<Monom> getList()
	{
		return p;
	}	
	public Monom getElement(int i)
	{	
		if(p.get(i)!=null)
		return p.get(i);
		else return null;
	}
	public Polinom adunare(Polinom a,Polinom b)
	{
		Polinom rez=new Polinom();
		Polinom aux=new Polinom();	
		if(a.getGrad()<b.getGrad())
		{   aux=a;
		    a=b;
			b=aux;
		}
		int max=a.getGrad();
		int min,ok=0;
		int min_a=a.getGradMin();
		int min_b=b.getGradMin();
		if(min_a < min_b) min=min_a;
		else min=min_b;
		Number c=0;
		
		for(int i=max;i>=min;i--) {
		for(Monom m:a.getList())
		{
			if(m.getPutere().intValue()==i)
			{
				c=c.doubleValue()+m.getCoef().doubleValue();
				ok=1;
			}
		}
		for(Monom m:b.getList())
		{
			if(m.getPutere().intValue()==i)
			{
				c=c.doubleValue()+m.getCoef().doubleValue();
				ok=1;
			}
		}
		if(ok==1)rez.addMonom(new Monom(c,i));
		ok=0;
		c=0;
		}
		rez.sortarePolinom();
		return rez;	}
	public Polinom scadere(Polinom a,Polinom b)
	{
		Polinom rez=new Polinom();
		Polinom aux=new Polinom();		
		int max=0;				
		if(a.getGrad()>=b.getGrad())
			 max=a.getGrad();
		else 
			max=b.getGrad();		
		int min,min_a=a.getGradMin(), min_b=b.getGradMin(),ok=0;	
		Number c = 0;
		
		if(min_a < min_b) min=min_a;
		else min=min_b;		
					
		for(int i=max;i>=min;i--) {
		for(Monom m:a.getList())
		{
			if(m.getPutere().intValue()==i)
			{
				c=c.doubleValue()+ m.getCoef().doubleValue();
				ok=1;
			}
		}
		for(Monom m:b.getList())
		{
			if(m.getPutere().intValue()==i)
			{
				c=c.doubleValue()-(m.getCoef().doubleValue());
				ok=1;
			}
		}
		if(ok==1)
		rez.addMonom(new Monom(c,i));
		ok=0; c=0;
		}
		rez.sortarePolinom();
		return rez;	
	}
	
	public Polinom derivare(Polinom a)
	{	
		for(Monom m:a.getList())
		{
			m.setCoef(m.getCoef().doubleValue()*m.getPutere().doubleValue());
			m.setPutere(m.getPutere().doubleValue()-1);
		}
		
		return a;
	}
	public Polinom integrare(Polinom a)
	{
		for(Monom m:a.getList())
		{
			m.setCoef(m.getCoef().doubleValue()/(m.getPutere().doubleValue()+1));
			m.setPutere(m.getPutere().doubleValue()+1);
		}
		
		return a;
	}
	public Polinom inmultire(Polinom a,Polinom b)
	{
		Polinom r=new Polinom();
		Number coef,putere;
		Monom x;
		for(Monom m:a.getList())
		{
			for(Monom n:b.getList())
			{
				coef=m.getCoef().doubleValue()*n.getCoef().doubleValue();
				putere=m.getPutere().doubleValue()+n.getPutere().doubleValue();
				x=new Monom(coef,putere);
				r.addMonom(x);
			}
		}
		r.sortarePolinom();	
		r=r.crearePolinom(r.toString());
		r=r.restrangerePolinom(r);		
		return r;
		}
	public String impartire(Polinom a,Polinom b )
	{
		 Polinom c=new Polinom();
	     Polinom r=new Polinom();
	     Polinom aux=new Polinom();     
         Number coef1,coef2,put1,put2;    
	     coef1=a.getList().get(0).getCoef();
	     coef2=b.getList().get(0).getCoef();
	     put1=a.getList().get(0).getPutere();
	     put2=b.getList().get(0).getPutere();
	     int ok=0;
	     r=a;
	     while(ok==0)
	     {
	    	 coef1=r.getList().get(0).getCoef();
		     coef2=b.getList().get(0).getCoef();	     
		     put1=r.getList().get(0).getPutere();
		     put2=b.getList().get(0).getPutere();
	    	 c.addMonom(new Monom(coef1.floatValue()/coef2.floatValue(),put1.doubleValue()-put2.doubleValue()));
	    	 c.sortarePolinom();
		     c.autoGrad();	    
		     Polinom c1=new Polinom();
		     c1.addMonom(new Monom(coef1.doubleValue()/coef2.doubleValue(),put1.doubleValue()-put2.doubleValue()));
	    	 aux=aux.inmultire(c1,b);
	    	 aux.sortarePolinom();
		     aux.autoGrad();
		     aux.inversareCoef();	     
		    r=aux.adunare(r, aux);
	        r.sortarePolinom();
	    	r.autoGrad();
	    	r.eliminareZero();
	    	if(r.getGrad()<b.getGrad()) ok=1;
	     }
	     return "CAT="+c.toString()+"   REST="+r.toString();	
	}
	
	public Polinom restrangerePolinom(Polinom a)

	{	
		Polinom rez=new Polinom();
		int coef=0;
		int ok=0;
		for(int i=a.getGrad();i>=a.getGradMin();i--)
		{	 coef=0;
		     ok=0;
			for(Monom m:a.getList())
			{
				if(m.getPutere().doubleValue()==i)
					{
					ok++;
					coef+=m.getCoef().doubleValue();		
					}		
				}
			if(ok>=1)
			{Monom x=new Monom(coef,i);
			rez.addMonom(x);
				}}
			rez.sortarePolinom();
			return rez;	}	
	public void inversareCoef()
	{
		for(Monom m:p)
		{
			m.setCoef(-m.getCoef().doubleValue());
		}}	
	public String toString()
	{
		String s="";
		for(Monom m:p)
		{	if(m.getCoef().doubleValue()-m.getCoef().intValue()!=0)	//daca este coeficient cu parte zecimala>0,se afiseaza si partea zecimala
		{
			if(m.getCoef().doubleValue()<0)
			s+=m.getCoef().doubleValue()+"X^"+m.getPutere().intValue();
		else
			if(m.getCoef().doubleValue()!=0)
			s+="+"+m.getCoef()+"X^"+m.getPutere().intValue();
		}
		else //daca este coeficient doar cu 0 dupa virgula, sa nu se afiseze x.0, ci x
		{	
			
			if(m.getCoef().doubleValue()<0)
				s+=m.getCoef().intValue()+"X^"+m.getPutere().intValue();
			else
				if(m.getCoef().doubleValue()!=0)
				s+="+"+m.getCoef().intValue()+"X^"+m.getPutere().intValue();
		}		
		}
		if(s=="")
			return "0";
		return s;}}
