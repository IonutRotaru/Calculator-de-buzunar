package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



import Model.Model;
import View.View;

public class Controller {
   
    private Model m_model;
    private View  m_view;
 
    /** Constructor */
    public Controller(Model model, View view) {
        m_model = model;
        m_view  = view;
        
        view.addAddListener(new AddListener());
        view.addSubListener(new SubListener());
        view.addDerListener(new DerListener());
        view.addIntListener(new IntListener());
        view.addMulListener(new MulListener());
        view.addImpListener(new ImpListener());
        view.addClearListener(new ClearListener());
    }
    

    class AddListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput = "";
            String userInput2 = "";
           
                userInput = m_view.getUserInput();
                userInput2 = m_view.getUserInput2();
               
           
                Pattern pattern = Pattern.compile("([+-]??[0-9]+?[x]??['^']{1}[+-]??[0-9]+?)+?");
    	        Matcher m = pattern.matcher(userInput);
    	        Matcher n = pattern.matcher(userInput2);
    	       
    	        if (m.matches() && n.matches() )
    	        {
    	        
    	        m_model.add(userInput, userInput2);
    	        m_view.setTotal(m_model.getValue());}
    	        
    	        else {
    	       
    	        
                m_view.showError("Format polinom gresit");
    	        }
             
                
               
        }
    }
    class SubListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput = "";
            String userInput2 = "";
           
                userInput = m_view.getUserInput();
                userInput2 = m_view.getUserInput2();
               
               
                Pattern pattern = Pattern.compile("([+-]??[0-9]+?[x]??['^']{1}[+-]??[0-9]+?)+?");
    	        Matcher m = pattern.matcher(userInput);
    	        Matcher n = pattern.matcher(userInput2);
    	       
    	        if (m.matches() && n.matches() )
    	        {
    	        
    	        m_model.sub(userInput, userInput2);
    	        m_view.setTotal(m_model.getValue());}
    	        
    	        else {
    	       
    	        
                m_view.showError("Format polinom gresit");
    	        }
             
                
               
        }
    }
    class DerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput = "";
           
           
                userInput = m_view.getUserInput();                   
                Pattern pattern = Pattern.compile("([+-]??[0-9]+?[x]??['^']{1}[+-]??[0-9]+?)+?");
    	        Matcher m = pattern.matcher(userInput);
    	        	       
    	        if (m.matches() )
    	        {
    	       
    	        m_model.der(userInput);
    	        m_view.setTotal(m_model.getValue());}
    	        
    	        else {
    	       
    	        
                m_view.showError("Format polinom gresit");
    	        }
             
                
               
        }
    }
    class IntListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput = "";
           
           
                userInput = m_view.getUserInput();
               
               
              
              Pattern pattern = Pattern.compile("([+-]??[0-9]+?[x]??['^']{1}[+-]??[0-9]+?)+?");
    	        Matcher m = pattern.matcher(userInput);
    	       
    	       
    	        if (m.matches() )
    	        {
    	        
    	        m_model.integrare(userInput);
    	        m_view.setTotal(m_model.getValue());}
    	        
    	        else {
    	       
    	        
                m_view.showError("Format polinom gresit");
    	        }
             
                
               
        }
    }
    class MulListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput = "";
            String userInput2 = "";
           
                userInput = m_view.getUserInput();
                userInput2 = m_view.getUserInput2();
               
               
                Pattern pattern = Pattern.compile("([+-]??[0-9]+?[x]??['^']{1}[+-]??[0-9]+?)+?");
    	        Matcher m = pattern.matcher(userInput);
    	        Matcher n = pattern.matcher(userInput2);
    	       
    	        if (m.matches() && n.matches() )
    	        {
    	        
    	        m_model.mul(userInput, userInput2);
    	        m_view.setTotal(m_model.getValue());}
    	        
    	        else {
    	       
    	        
                m_view.showError("Format polinom gresit");
    	        }
             
                
               
        }
    }
    class ImpListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput = "";
            String userInput2 = "";
           
                userInput = m_view.getUserInput();
                userInput2 = m_view.getUserInput2();
               
              
                Pattern pattern = Pattern.compile("([+-]??[0-9]+?[x]??['^']{1}[+-]??[0-9]+?)+?");
    	        Matcher m = pattern.matcher(userInput);
    	        Matcher n = pattern.matcher(userInput2);
    	       
    	        if (m.matches() && n.matches() )
    	        {
    	        
    	        m_model.imp(userInput, userInput2);
    	        m_view.setTotal(m_model.getValue());}
    	        
    	        else {
    	       
    	        
                m_view.showError("Format polinom gresit");
    	        }
             
                
               
        }
    }
    
 
        
    class ClearListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            m_model.reset();
            m_view.reset();
        }
    }
}
