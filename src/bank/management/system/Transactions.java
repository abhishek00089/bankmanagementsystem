package bank.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Transactions extends JFrame implements ActionListener{
    
    
    JButton deposit, withdrawal, fastCash, miniStatement, pinchange, balenq, exit;
    String pinnumber;
    
    Transactions(String pinnumber){
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Please Select Your Transaction");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawal = new JButton("Cash Withdrawal");
        withdrawal.setBounds(355,415,150,30);
        withdrawal.addActionListener(this);
        image.add(withdrawal);
        
        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(170,450,150,30);
        fastCash.addActionListener(this);
        image.add(fastCash);
        
        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(355,450,150,30);
        miniStatement.addActionListener(this);
        image.add(miniStatement);
        
        pinchange = new JButton("PIN Change");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balenq = new JButton("Balance Enquiry");
        balenq.setBounds(355,485,150,30);
        balenq.addActionListener(this);
        image.add(balenq);
        
        exit = new JButton("Exit");
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
        System.exit(0);
    } else if(ae.getSource()==deposit){
        setVisible(false);
        new Deposit(pinnumber).setVisible(true);
    }
    else if(ae.getSource()==withdrawal){
        setVisible(false);
        new Withdrawal(pinnumber).setVisible(true);
    }
    else if(ae.getSource()==fastCash){
        setVisible(false);
        new FastCash(pinnumber).setVisible(true);
    }
    else if(ae.getSource()==pinchange){
        setVisible(false);
        new PinChange(pinnumber).setVisible(true);
    }
    else if(ae.getSource()==balenq){
        setVisible(false);
        new BalanceEnquiry(pinnumber).setVisible(true);
    }
    else if(ae.getSource()==miniStatement){
        new MiniStatement(pinnumber).setVisible(true);
    }
}

public static void main(String args[]){
new Transactions("");
}
}
