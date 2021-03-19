package View;

import java.awt.*;
import javax.swing.*;

import Model.Model;

import java.awt.event.*;

public class View extends JFrame {
   
    private static final String INITIAL_VALUE = "0";
    

    private JTextField m_userInputTf = new JTextField(20);
    private JTextField m_userInputTf2 = new JTextField(20);
    private JTextField m_totalTf     = new JTextField(40);
    private JButton    adunare = new JButton("adunare");
    private JButton    scadere = new JButton("scadere");
    private JButton    impartire = new JButton("impartire");
    private JButton    inmultire = new JButton("inmultire");
    private JButton    derivare = new JButton("derivare");
    private JButton    integrare = new JButton("integrare");
    private JButton    m_clearBtn = new JButton("clear");
    
    
    
    
    private Model m_model;
    
   
    public View(Model model) {
      
        m_model = model;
        m_model.setValue(INITIAL_VALUE);
        
        
    
        m_totalTf.setText(m_model.getValue());
        m_totalTf.setEditable(false);
        
              
        JPanel content = new JPanel();
       
        content.setLayout(new FlowLayout());
        content.add(new JLabel("Polinom 1"));
        content.add(m_userInputTf);
        
        content.add(new JLabel("Polinom 2"));
        content.add(m_userInputTf2);
        
        content.add(adunare);
        content.add(scadere);
        content.add(inmultire);
        content.add(impartire);
        content.add(derivare);
        content.add(integrare);
        
        content.add(m_totalTf);
        content.add(m_clearBtn);
        
        
       
        this.setContentPane(content);
        this.pack();
       this.setSize(600,400);
        this.setTitle("Interfata");
       
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void reset() {
        m_totalTf.setText(INITIAL_VALUE);
    }
    
    public String getUserInput() {
        return m_userInputTf.getText();
    }
    public String getUserInput2() {
        return m_userInputTf2.getText();
    }
    
    public void setTotal(String newTotal) {
        m_totalTf.setText(newTotal);
    }
    
    public void showError(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }
    
    public void addMulListener(ActionListener mal) {
        inmultire.addActionListener(mal);
    }
   public void addAddListener(ActionListener mal) {
        adunare.addActionListener(mal);
    }
   public void addSubListener(ActionListener mal) {
        scadere.addActionListener(mal);
    }
   public void addDerListener(ActionListener mal) {
        derivare.addActionListener(mal);
    }
    public void addIntListener(ActionListener mal) {
        integrare.addActionListener(mal);
    }
    public void addImpListener(ActionListener mal) {
        impartire.addActionListener(mal);
    }
    
    
   public void addClearListener(ActionListener cal) {
        m_clearBtn.addActionListener(cal);
    }
}
