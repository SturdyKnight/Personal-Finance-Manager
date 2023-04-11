import java.util.*;
import javax.swing.*;
import java.awt.*;	//awt is used to add frame 
import java.awt.event.*;	//awt.event is used to make the closing button working
import java.awt.Font;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/*String url = "jdbc:mysql://localhost/finance_manager";
String username = "system";
String password = "system";

Connection con = DriverManager.getConnection(url, username, password);*/


public class Myframe extends Frame {
	//constructor created
	Myframe(){
		this.setVisible(true);
		this.setSize(1000,700);
		this.setTitle("Personal Finance Manager © Suraj ");
		this.setLocation(300,50);
  		this.setResizable(true);
  		this.setLayout(null);



  		// This Window Listener is used to close the Frames 
  		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});


  		//HEADING
		JLabel l0 = new JLabel("Personal Finance Manager");
		l0.setFont(new Font("Calibri", Font.BOLD, 50));
		l0.setBounds(75, 100, 900, 50);
		this.add(l0);

  		//Label 1 :- Income
		JLabel l1 = new JLabel("Income");
		l1.setFont(new Font("Calibri", Font.BOLD, 30));
		l1.setBounds(100, 200, 200, 50);
		this.add(l1);

		//Label 2 :- Expense
		JLabel l2 = new JLabel("Expense");
		l2.setFont(new Font("Calibri", Font.BOLD, 30));
		l2.setBounds(100, 270, 200, 50);
		this.add(l2);

		//Label 3 :- Investment
		JLabel l3 = new JLabel("Investment");
		l3.setFont(new Font("Calibri", Font.BOLD, 30));
		l3.setBounds(100, 340, 200, 50);
		this.add(l3);

		//Label 4 :- Display Summary
		JLabel l4 = new JLabel("Summary : ");
		l4.setFont(new Font("Calibri", Font.BOLD, 25));
		l4.setBounds(150, 480, 200, 50);
		this.add(l4);

		//Text Box 1 :- Income
		JTextField t1 = new JTextField(100);
		t1.setFont(new Font("Calibri", Font.PLAIN, 20));
		t1.setBounds(300, 200, 200, 30);
		this.add(t1);

		//Text Box 2 :- Expense
		JTextField t2 = new JTextField(100);
		t2.setFont(new Font("Calibri", Font.PLAIN, 20));
		t2.setBounds(300, 270, 200, 30);
		this.add(t2);

		//Text Box 3 :- Investment
		JTextField t3 = new JTextField(100);
		t3.setFont(new Font("Calibri", Font.PLAIN, 20));
		t3.setBounds(300, 340, 200, 30);
		this.add(t3);

		//Enter Button 
		JButton btn = new JButton("Enter");
		btn.setFont(new Font("Calibri", Font.BOLD, 20));
		btn.setBounds(345, 410, 100, 45);
		this.add(btn);

		//TAX Button 
		JButton btn0 = new JButton("TAX Calculator");
		btn0.setFont(new Font("Calibri", Font.BOLD, 20));
		btn0.setBounds(700, 200, 180, 45);
		this.add(btn0);

		//Summary Income
		JLabel result1 = new JLabel("										");
		result1.setFont(new Font("Calibri", Font.BOLD, 20));
        result1.setBounds(300, 480, 200, 45);
		this.add(result1);

		//Summary Expense
		JLabel result2 = new JLabel("										");
		result2.setFont(new Font("Calibri", Font.BOLD, 20));
		result2.setBounds(300, 510, 200, 45);
		this.add(result2);

		//Summary investment
		JLabel result3 = new JLabel("									");
		result3.setFont(new Font("Calibri", Font.BOLD, 20));
		result3.setBounds(300, 540, 200, 45);
		this.add(result3);

		//Summary networth
		JLabel result4 = new JLabel("										");
		result4.setFont(new Font("Calibri", Font.BOLD, 20));
		result4.setBounds(300, 570, 200, 45);
		this.add(result4);

		//Summary credscore
		JLabel result5 = new JLabel("										");
		result5.setFont(new Font("Calibri", Font.BOLD, 20));
		result5.setForeground(Color.RED);
		result5.setBounds(300, 600, 200, 45);
		this.add(result5);


		//Tax Summary
		JLabel result6 = new JLabel("										");
		result6.setFont(new Font("Calibri", Font.BOLD, 20));
		result6.setForeground(Color.RED);
		result6.setBounds(650, 300, 300, 45);
		this.add(result6);





		// This Action Listener is used to function the button
		btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){

				//To accept string as Integer
				double n1 = Double.parseDouble(t1.getText());
				double n2 = Double.parseDouble(t2.getText());
				double n3 = Double.parseDouble(t3.getText());

				//Logic
				double income = n1;
				double expense = n2;
				double investment = n3;
				double creditRatio = n1/n2;
				double networth = n1-n2+n3;
				double creditScore;
				

			    //Credit Score Logic
				if (creditRatio > 4) {
	            creditScore = 100;
 		       } else if (creditRatio > 3.5) {
        	    creditScore = 90;
		       } else if (creditRatio > 3) {
        	    creditScore = 75;
		       } else if (creditRatio > 2.5) {
        	    creditScore = 60;
		       } else if (creditRatio > 2) {
        	    creditScore = 45;
    		   } else if (creditRatio > 1.5) {
        	    creditScore = 30;
		       } else if (creditRatio > 1) {
            	creditScore = 15;
    	       } else {
            	creditScore = 00;
        	   }



				//Result
        	   result1.setText("Income : " + income);
        	   result2.setText("Expense : " + expense);
        	   result3.setText("Investment : " + investment);
        	   result4.setText("Networth : " + networth);
        	   result5.setText("Credit Score : " + creditScore);
			}
		});



		//Action Listener for btn0
		btn0.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){

				double n1 = Double.parseDouble(t1.getText());
				double income = n1;
				double taxAmount = 0.0;



				// Income Tax Calculator
		        if (income <= 250000) {
		            taxAmount = 00.0;
		        } else if (income <= 500000) {
		            taxAmount = (income - 250000) * 0.05;
		        } else if (income <= 750000) {
		            taxAmount = 12500 + (income - 500000) * 0.1;
		        } else if (income <= 1000000) {
		            taxAmount = 37500 + (income - 750000) * 0.15;
		        } else if (income <= 1250000) {
		            taxAmount = 75000 + (income - 1000000) * 0.2;
		        } else if (income <= 1500000) {
		            taxAmount = 125000 + (income - 1250000) * 0.25;
		        } else {
		            taxAmount = 187500 + (income - 1500000) * 0.3;
		        }


				result6.setText("Income Tax Amount : " + taxAmount);

				}
		});

	}


	public static void main(String[] args) {
		//Object called 
		Myframe f = new Myframe();		        
	}
}