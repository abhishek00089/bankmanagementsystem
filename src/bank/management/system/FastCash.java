package bank.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;


public class FastCash extends JFrame implements ActionListener{
    
    
    JButton deposit, withdrawal, fastCash, miniStatement, pinchange, balenq, exit;
    String pinnumber;
    
    FastCash(String pinnumber){
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Please Select Witdrawal Amount");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        deposit = new JButton("Rs 100");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawal = new JButton("Rs 500");
        withdrawal.setBounds(355,415,150,30);
        withdrawal.addActionListener(this);
        image.add(withdrawal);
        
        fastCash = new JButton("Rs 1000");
        fastCash.setBounds(170,450,150,30);
        fastCash.addActionListener(this);
        image.add(fastCash);
        
        miniStatement = new JButton("Rs 2000");
        miniStatement.setBounds(355,450,150,30);
        miniStatement.addActionListener(this);
        image.add(miniStatement);
        
        pinchange = new JButton("Rs 5000");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balenq = new JButton("Rs 10000");
        balenq.setBounds(355,485,150,30);
        balenq.addActionListener(this);
        image.add(balenq);
        
        exit = new JButton("Back");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit);
        
       
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
     
    }

    
    public void actionPerformed(ActionEvent ae) {
    if(ae.getSource()==exit){
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    } else{
          String amount = ((JButton)ae.getSource()).getText().substring(3);
          Conn c = new Conn();
          try{
              java.sql.ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
              int balance =0;
              while(rs.next()){
                  if(rs.getString("type").equals("Deposit")){
                      balance += Integer.parseInt(rs.getString("amount"));
                  }
                  else{
                      balance -= Integer.parseInt(rs.getString("amount"));
                  }
              }
              if(ae.getSource()!= exit && balance < Integer.parseInt(amount)){
                  JOptionPane.showMessageDialog(null,"Insufficient balance");
                  return;
              }
              
              Date date = new Date();
              String query = "Insert into bank values('"+pinnumber+"','"+date+"','Withdrawal','"+amount+"')";
              c.s.executeUpdate(query);
              JOptionPane.showMessageDialog(null,"Rs "+amount+" Debited Successfully");
              setVisible(false);
              new Transactions(pinnumber).setVisible(true);
              
          }catch(Exception e){
              System.out.println(e);
          }
    }
    
}

public static void main(String args[]){
new FastCash("");
}
}

