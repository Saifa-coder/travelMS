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



import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Image;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class BookHotel extends JFrame {
	private JPanel contentPane;
        JTextField t1,t2,t3;
        JFormattedTextField t4,t5;
        Choice c1,c2,c3;
         String username;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookHotel frame = new BookHotel("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BookHotel(String username) {
                 System.out.println(username);
		setBounds(120, 60, 1100, 650);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
                Image i3 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel la1 = new JLabel(i2);
                la1.setBounds(450,100,700,300);
                add(la1);
		
		JLabel lblName = new JLabel("BOOK HOTEL");
		lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		lblName.setBounds(118, 11, 300, 53);
		contentPane.add(lblName);
                
                JLabel la2 = new JLabel("Username :");
		la2.setBounds(35, 70, 200, 14);
		contentPane.add(la2);
                
                 t3 = new JTextField();
		t3.setBounds(271, 70, 100, 20);
		contentPane.add(t3);
		t3.setColumns(10);
                
                
                
                
                
                
                JLabel lblId = new JLabel("Select Hotel :");
		lblId.setBounds(35, 110, 200, 14);
		contentPane.add(lblId);
                
                c1 = new Choice();
                
                c1.setBounds(271, 110, 150, 30);
                add(c1);
                
                Conn c = new Conn();
                
                try{
                    ResultSet rs = c.s.executeQuery("select * from hotel");
                    while(rs.next()){
                        c1.add(rs.getString("name"));
                    }

                    rs.close();
                }catch(SQLException ee){}

                c1.setBounds(271, 110, 150, 30);
                add(c1);
                
                JLabel la3 = new JLabel("Total Persons");
		la3.setBounds(35, 150, 200, 14);
		contentPane.add(la3);
                
                t1 = new JTextField();
                t1.setText("0");
		t1.setBounds(271, 150, 150, 20);
		contentPane.add(t1);
		t1.setColumns(10);
                
                JLabel la4 = new JLabel("Number of Days");
                la4.setBounds(35, 190, 200, 14);
		contentPane.add(la4);
		
		t2 = new JTextField();
		t2.setText("0");
		t2.setBounds(271, 190, 150, 20);
		contentPane.add(t2);
		t2.setColumns(10);
		
		JLabel la5 = new JLabel("AC / Non-AC");
		la5.setBounds(35, 230, 200, 14);
		contentPane.add(la5);
                
            
                c2 = new Choice();
                c2.add("AC");
                c2.add("Non-AC");
                c2.setBounds(271, 230, 150, 30);
                add(c2);

                
		JLabel la6 = new JLabel("Food Included :");
		la6.setBounds(35, 270, 200, 14);
		contentPane.add(la6);
                
                c3 = new Choice();
                c3.add("Yes");
                c3.add("No");
                c3.setBounds(271, 270, 150, 30);
                add(c3);
                
		JLabel lbl1 = new JLabel("ID Type :");
		lbl1.setBounds(35, 310, 200, 14);
		contentPane.add(lbl1);
                
                JLabel l2 = new JLabel();
		l2.setBounds(271, 310, 200, 14);
		contentPane.add(l2);
		
		JLabel lbl2 = new JLabel( "ID Number :");
		lbl2.setBounds(35, 350, 200, 14);
		contentPane.add(lbl2);
                
                JLabel l3 = new JLabel();
		l3.setBounds(271, 350, 200, 14);
		contentPane.add(l3);
           	
		JLabel lbl3 = new JLabel("Phone :");
		lbl3.setBounds(35, 390, 200, 14);
		contentPane.add(lbl3);
                
                JLabel l4 = new JLabel();
		l4.setBounds(271, 390, 200, 14);
		contentPane.add(l4);

		
		JLabel lblDeposite = new JLabel("Total Price :");
		lblDeposite.setBounds(35, 430, 200, 14);
		contentPane.add(lblDeposite);
		
		JLabel l5 = new JLabel();
		l5.setBounds(271, 430, 200, 14);
                l5.setForeground(Color.RED);
		contentPane.add(l5);
                
                JLabel from = new JLabel("Date From :");
		from.setBounds(35, 470, 200, 14);
		contentPane.add(from);
                
                 t4 = new JFormattedTextField("YYYY-MM-DD");
		t4.setBounds(271, 470, 100, 20);
		contentPane.add(t4);
		t4.setColumns(10);
                
                 
                JLabel to = new JLabel("Date To :");
		to.setBounds(35, 500, 200, 14);
		contentPane.add(to);
                
                 t5 = new JFormattedTextField("YYYY-MM-DD");
		t5.setBounds(271, 500, 100, 20);
		contentPane.add(t5);
		t5.setColumns(10);
                
                
                
               
                JButton b1 = new JButton("Check Price");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            Conn c = new Conn();
                           
                            try{
	    			String s1 = c1.getSelectedItem(); 
                                
                                String q1 = "select * from hotel where name = '"+c1.getSelectedItem()+"'";
                                ResultSet rs = c.s.executeQuery(q1);
                                if(rs.next()){
                                    
                                    int cost = Integer.parseInt(rs.getString("costperperson"));
                                    int food = Integer.parseInt(rs.getString("foodincluded"));
                                    int ac = Integer.parseInt(rs.getString("acroom"));
                                    
                                    int persons = Integer.parseInt(t1.getText());
                                    int days = Integer.parseInt(t2.getText());
                                    
                                    String acprice = c2.getSelectedItem();
                                    String foodprice = c3.getSelectedItem();
                                    
                                    
                                    if(persons * days > 0) {
                                        int total = 0;
                                        total += acprice.equals("AC") ? ac : 1;
                                        total += foodprice.equals("Yes") ? food : 1;
                                        total += cost;
                                        total = total * persons * days;
                                        l5.setText(" "+total);
                                        
                                        
                   
                    String username = t3.getText();
                    
                                        rs = c.s.executeQuery("select*from customer where username = '"+username+"'");
                    while(rs.next()){
                     
                        l2.setText(rs.getString("id"));
                        l3.setText(rs.getString("number"));
                        l4.setText(rs.getString("phone"));
                        
                    }
                                    }
                                    
                                    
                                }
                                
                            }catch(SQLException ee){
	    			System.out.println(ee.getMessage());
	    		}
                        }
		});
		b1.setBounds(50, 555, 120, 30);
                b1.setBackground(Color.BLACK);
                b1.setForeground(Color.WHITE);
		contentPane.add(b1);
		

		JButton btnNewButton = new JButton("Book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            Conn c = new Conn();
                           
                          
                            try{
	    			String s1 = c1.getSelectedItem(); 
                                
                                String q1 = "insert into bookHotel values('"+t3.getText()+"', '"+c1.getSelectedItem()+"', '"+t1.getText()+"', '"+t2.getText()+"', '"+c2.getSelectedItem()+"', '"+c3.getSelectedItem()+"', '"+l2.getText()+"', '"+l3.getText()+"', '"+l4.getText()+"', '"+l5.getText()+"','"+t4.getText()+"','"+t5.getText()+"')";
                                c.s.executeUpdate(q1);
                                
	    			JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
                                setVisible(false);
                            }catch(Exception ee){
	    			System.out.println(ee.getMessage());
                            }
                            
			}
		});
		btnNewButton.setBounds(200, 555, 120, 30);
                btnNewButton.setBackground(Color.GREEN);
                btnNewButton.setForeground(Color.WHITE);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            setVisible(false);
			}
		}); 
		btnExit.setBounds(350, 555, 120, 30);
                btnExit.setBackground(Color.RED);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
                
                getContentPane().setBackground(Color.YELLOW);
	}
}