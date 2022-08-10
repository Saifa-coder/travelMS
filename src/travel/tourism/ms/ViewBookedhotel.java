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

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class ViewBookedhotel extends JFrame {
	Connection conn = null;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblAvailability;
	private JLabel lblCleanStatus;
	private JLabel lblNewLabel_1;
	private JLabel lblId;
Choice c1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewBookedhotel frame = new ViewBookedhotel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

        
	public ViewBookedhotel() throws SQLException {
		//conn = Javaconnect.getDBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(70, 120, 1300, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource(""));
                Image i3 = i1.getImage().getScaledInstance(626, 201,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(130,250,626,201);
                add(l1);
               
		
		table = new JTable();
		table.setBounds(0, 40, 1300, 350);
		contentPane.add(table);
                
                try{
                    Conn c = new Conn();
                        String displayCustomersql = "select*from bookHotel";
                        ResultSet rs = c.s.executeQuery(displayCustomersql);
                        table.setModel(DbUtils.resultSetToTableModel(rs));
                }
                catch(Exception e1){
                        e1.printStackTrace();
                }
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setBounds(590, 400, 120, 30);
                btnNewButton.setBackground(Color.BLACK);
                btnNewButton.setForeground(Color.WHITE);
		contentPane.add(btnNewButton);
		
		lblAvailability = new JLabel("Username");
		lblAvailability.setBounds(5, 15, 69, 14);
		contentPane.add(lblAvailability);
		
		lblCleanStatus = new JLabel("Hotel");
		lblCleanStatus.setBounds(120, 15, 76, 14);
		contentPane.add(lblCleanStatus);
		
		
		lblNewLabel_1 = new JLabel("Persons");
		lblNewLabel_1.setBounds(230, 15, 76, 14);
		contentPane.add(lblNewLabel_1);

		
		lblId = new JLabel("Days");
		lblId.setBounds(340, 15, 90, 14);
		contentPane.add(lblId);
                
                JLabel l3 = new JLabel("AC");
		l3.setBounds(439, 15, 90, 14);
		contentPane.add(l3);
               
                
                JLabel l5 = new JLabel("Food");
		l5.setBounds(560, 15, 90, 14);
		contentPane.add(l5);
                
                JLabel l6 = new JLabel("ID");
		l6.setBounds(655, 15, 90, 14);
		contentPane.add(l6);
                
                 JLabel l7 = new JLabel("ID Num");
		l7.setBounds(780, 15, 90, 14);
		contentPane.add(l7);
                
                JLabel l8 = new JLabel("Phone");
		l8.setBounds(890, 15, 90, 14);
		contentPane.add(l8);
                  JLabel l9 = new JLabel("Cost");
		l9.setBounds(990, 15, 90, 14);
		contentPane.add(l9);
                
                 JLabel l10 = new JLabel("Date from");
		l10.setBounds(1090, 15, 90, 14);
		contentPane.add(l10);
                
                  JLabel l11 = new JLabel("Date To");
		l11.setBounds(1190, 15, 90, 14);
		contentPane.add(l11);
                
                
                
                getContentPane().setBackground(Color.WHITE);
	}

}