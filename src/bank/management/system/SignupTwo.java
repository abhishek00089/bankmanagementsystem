package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;

import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{

//    private String formno;

    public SignupTwo() {
    }
   
    JTextField panTextField,aadharTextField;
    JButton next;
    JRadioButton scyes,scno,eyes,eno;
    
    JComboBox religion,category,income,education,occupation;
    String formno;
    
    SignupTwo(String formno){
        this.formno = formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        
        
        JLabel additionalDetals = new JLabel("Page 2: Additional Details");
        additionalDetals.setFont(new Font("Raleway", Font.BOLD,22));
        additionalDetals.setBounds(290,80,400,30);
        add(additionalDetals);
        
        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Raleway", Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);
        
        String valReligion[] ={"Hindu","Muslim","Sikh","Christian","Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.white);
        religion.setForeground(Color.black);
        add(religion);
 
        
        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("Raleway", Font.BOLD,22));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        String valCategory[] ={"UR","SC","ST","OBC-A","OBC-B"};
        category = new JComboBox(valCategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.white);
        category.setForeground(Color.black);
        add(category);
       
        
        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("Raleway", Font.BOLD,22));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        String incomeCategory[] ={"NIL","< 1,50,000","< 2,50,000","< 5,00,000","Upto 10,00,000"};
        income = new JComboBox(incomeCategory);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.white);
        income.setForeground(Color.black);
        add(income);
       
        
        JLabel gender = new JLabel("Educational");
        gender.setFont(new Font("Raleway", Font.BOLD,22));
        gender.setBounds(100,290,200,30);
        add(gender);
        
        JLabel email = new JLabel("Qualifiaction:");
        email.setFont(new Font("Raleway", Font.BOLD,22));
        email.setBounds(100,330,200,30);
        add(email);
        
        String educationVal[] ={"Non-Graduate","Graduate","Post Graduate","Doctrate","Other"};
        education = new JComboBox(educationVal);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.white);
        education.setForeground(Color.black);
        add(education);
        
        
        JLabel maritalStatus = new JLabel("Occupation:");
        maritalStatus.setFont(new Font("Raleway", Font.BOLD,22));
        maritalStatus.setBounds(100,390,200,30);
        add(maritalStatus);
        
        String occupationVal[] ={"Salaried","Self Employed","Buisnessman","Student","Retired"};
        occupation = new JComboBox(occupationVal);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.white);
        occupation.setForeground(Color.black);
        add(occupation);
   
        
        JLabel address = new JLabel("PAN Number:");
        address.setFont(new Font("Raleway", Font.BOLD,22));
        address.setBounds(100,440,200,30);
        add(address);
        
        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway",Font.BOLD,14));
        panTextField.setBounds(300,440,400,30);
        add(panTextField);
        
        JLabel city = new JLabel("Aadhar Number:");
        city.setFont(new Font("Raleway", Font.BOLD,22));
        city.setBounds(100,490,200,30);
        add(city);
        
        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway",Font.BOLD,14));
        aadharTextField.setBounds(300,490,400,30);
        add(aadharTextField);
        
        JLabel state = new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway", Font.BOLD,22));
        state.setBounds(100,540,200,30);
        add(state);
        
        scyes = new JRadioButton("Yes");
        scyes.setBounds(300,540,100,30);
        scyes.setBackground(Color.white);
        add(scyes);
        
        scno = new JRadioButton("NO");
        scno.setBounds(450,540,100,30);
        scno.setBackground(Color.white);
        add(scno);
        
        ButtonGroup sc = new ButtonGroup();
        sc.add(scyes);
        sc.add(scno);
        
        
        
        JLabel pincode = new JLabel("Existing A/C:");
        pincode.setFont(new Font("Raleway", Font.BOLD,22));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.white);
        add(eyes);
        
        eno = new JRadioButton("NO");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.white);
        add(eno);
        
        ButtonGroup ea = new ButtonGroup();
        ea.add(eyes);
        ea.add(eno);
        
        
        
        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD,14));
        next.setBounds(450,660,80,30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.white);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
}
     public void actionPerformed(ActionEvent ae){
        
         String sreligion = (String)religion.getSelectedItem();
         String scategory = (String)category.getSelectedItem();
         String sincome = (String)income.getSelectedItem();
         String seducation = (String)education.getSelectedItem();
         String soccupation = (String)occupation.getSelectedItem();
         
         String seniorcitizen = null;
         if(scyes.isSelected()){
             seniorcitizen="Yes";
         }else if(scno.isSelected()){
             seniorcitizen="No";
         }
         
  
         String existingaccount = null;
         if(eyes.isSelected()){
             existingaccount="Yes";
         }
         else if(eno.isSelected()){
             existingaccount="No";
         }
         String span = panTextField.getText();
         String saadhar = aadharTextField.getText();
         
            try{
                 Conn c = new Conn();
                 String query = "insert into signuptwo values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingaccount+"')" ;
                 c.s.executeUpdate(query);
                 
                 //signup 3
                 setVisible(false);
                 new SignupThree(formno).setVisible(true);
                 
                 
         }catch(Exception e){
             System.out.println(e);
         }
         
}

    
public static void main(String args[]){
new SignupTwo("");
}
}

