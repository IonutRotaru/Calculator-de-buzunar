package Model;
import java.math.BigInteger;


public class Model {
    
    private static final String INITIAL_VALUE = "0";
   
    private String m_total;  
    
    
    public Model() {
        reset();
    }
    
   
    public void reset() {
        m_total = "0";
    }
    
  
    public void mul(String operand1,String operand2) {
    	Polinom p=new Polinom();
    	p=p.crearePolinom(operand1);
    	p.sortarePolinom();
    	Polinom q=p.crearePolinom(operand2);
    	q.sortarePolinom();
    	Polinom rez=p.inmultire(p,q);
    	 m_total = rez.toString();
    }
    public void imp(String operand1,String operand2) {
    	Polinom p=new Polinom();
    	p=p.crearePolinom(operand1);
    	p.sortarePolinom();
    	Polinom q=p.crearePolinom(operand2);
    	q.sortarePolinom();
    	String rez=p.impartire(p,q);
    	m_total =rez ;
    }
    public void add(String operand1, String operand2) {
    	
    	Polinom p=new Polinom();
    	Polinom a=p.crearePolinom(operand1);
    	p=p.crearePolinom(operand2);
    	p.sortarePolinom();
    	Polinom q=p;
    	a.sortarePolinom();
    	Polinom rez=p.adunare(q, a);
        m_total = rez.toString();
    }
public void sub(String operand1, String operand2) {
    	
    	Polinom p=new Polinom();
    	Polinom a=p.crearePolinom(operand1);
    	p=p.crearePolinom(operand2);
    	p.sortarePolinom();
    	Polinom q=p;
    	a.sortarePolinom();
    	Polinom rez=p.scadere(a, q);
        m_total = rez.toString();
    }
public void der(String operand1) {
	Polinom p=new Polinom();
	p=p.crearePolinom(operand1);
	p.sortarePolinom();
	
	Polinom rez=p.derivare(p);
	
    m_total = rez.toString();
}
public void integrare(String operand1) {
	Polinom p=new Polinom();
	p=p.crearePolinom(operand1);
	p.sortarePolinom();
	
	Polinom rez=p.integrare(p);
	
    m_total = rez.toString();
}
   
    public void setValue(String value) {
        m_total = value;
    }
    
    public String getValue() {
        return m_total.toString();
    }
}
