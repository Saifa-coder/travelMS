/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.tourism.ms;

/**
 *
 * @author tukku
 */
import java.awt.Choice;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.lang.String;
/**
 *
 * @author tukku
 */
    
public class Invoice extends JFrame {
	private JPanel contentPane;
        JTextField t1,t2;
        Choice c1,c2,c3;
        String username;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Invoice frame = new Invoice();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Invoice() {
                System.out.println(username);
		setBounds(220, 120, 850, 550);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
              
		JLabel lblName = new JLabel("INVOICE");
		lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		lblName.setBounds(118, 11, 300, 53);
		contentPane.add(lblName);
                
                JLabel la2 = new JLabel("Username :");
		la2.setBounds(35, 70, 200, 14);
		contentPane.add(la2);
                
                 t2 = new JTextField();
		t2.setBounds(271, 70, 100, 20);
		contentPane.add(t2);
		t2.setColumns(10);
                
              
                
                JLabel lblId = new JLabel("Package Price :");
		lblId.setBounds(35, 110, 200, 14);
		contentPane.add(lblId);
                
                  JLabel l12 = new JLabel();
		l12.setBounds(271, 110, 200, 14);
		contentPane.add(l12);
               
                JLabel la3 = new JLabel("Hotel Price");
		la3.setBounds(35, 150, 200, 14);
		contentPane.add(la3);
                
                
                  JLabel l13 = new JLabel();
		l13.setBounds(271, 150, 200, 14);
		contentPane.add(l13);
               
   
                
		JLabel lbl1 = new JLabel("ID :");
		lbl1.setBounds(35, 190, 200, 14);
		contentPane.add(lbl1);
                
                JLabel l2 = new JLabel();
		l2.setBounds(271, 190, 200, 14);
		contentPane.add(l2);
		
		JLabel lbl2 = new JLabel("Number :");
		lbl2.setBounds(35, 230, 200, 14);
		contentPane.add(lbl2);
                
                JLabel l3 = new JLabel();
		l3.setBounds(271, 230, 200, 14);
		contentPane.add(l3);
           	
		JLabel lbl3 = new JLabel("Phone :");
		lbl3.setBounds(35, 270, 200, 14);
		contentPane.add(lbl3);
                
                JLabel l4 = new JLabel();
		l4.setBounds(271, 270, 200, 14);
		contentPane.add(l4);

		
		JLabel lblDeposite = new JLabel("Total amount to pay :");
		lblDeposite.setBounds(35, 310, 200, 14);
		contentPane.add(lblDeposite);
		
		JLabel l5 = new JLabel();
		l5.setBounds(271, 310, 200, 14);
                l5.setForeground(Color.RED);
		contentPane.add(l5);
                
                
                JButton b1 = new JButton("Check");
		b1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                  
                try{
                    Conn c = new Conn();
                    String name = t2.getText();
                    ResultSet rs = c.s.executeQuery("select*from customer where username = '"+name+"'");
                    while(rs.next()){
                     
                        l2.setText(rs.getString("id"));
                        l3.setText(rs.getString("number"));
                        l4.setText(rs.getString("phone"));
                        
                    }

                    rs.close();
                }catch(SQLException ee){
                    
                    
                    
                }
                     try{
                    Conn c = new Conn();
                    String name = t2.getText();
                    ResultSet rs = c.s.executeQuery("select*from package where username = '"+name+"'");
                    while(rs.next()){
                     
                        l12.setText(rs.getString("price"));
                      
                    }

                    rs.close();
                }catch(SQLException ee){
                    
                    
                    
                }
                       try{
                    Conn c = new Conn();
                    String name = t2.getText();
                    ResultSet rs = c.s.executeQuery("select*from bookHotel where username = '"+name+"'");
                    while(rs.next()){
                     
                        l13.setText(rs.getString("price"));
                       
                    }

                    rs.close();
                }catch(SQLException ee){
                    
                    
                    
                }
                        }
		});
		b1.setBounds(50, 350, 120, 30);
                b1.setBackground(Color.BLACK);
                b1.setForeground(Color.WHITE);
		contentPane.add(b1);
		

		JButton btnNewButton = new JButton("Amount");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                           
                            //calculate the sum when the Button is pressed
                        int sum = Integer.parseInt(l12.getText())+Integer.parseInt(l13.getText());
                            l5.setText(Integer.toString(sum));
                            
                            
			}
		});
		btnNewButton.setBounds(200, 350, 120, 30);
                btnNewButton.setBackground(Color.GREEN);
                btnNewButton.setForeground(Color.WHITE);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            setVisible(false);
			}
		}); 
		btnExit.setBounds(350, 350, 120, 30);
                btnExit.setBackground(Color.RED);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
                
                getContentPane().setBackground(Color.WHITE);
	}
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    






























