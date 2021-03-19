package T1.T1;

import Controller.Controller;
import Model.Model;
import View.View;
import javax.swing.*  ;

import java.util.*;
public class App {

	
		// TODO Auto-generated method stub
		public static void main(String[] args) {
	        
	        Model      model      = new Model();
	        View       view       = new View(model);
	        Controller controller = new Controller(model, view);
	        
	        view.setVisible(true);
	       
	
	        
	        
		}

		  
	    
	}


