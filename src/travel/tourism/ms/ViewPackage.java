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
public class ViewPackage extends JFrame {
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
					ViewPackage frame = new ViewPackage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

        
	public ViewPackage() throws SQLException {
		//conn = Javaconnect.getDBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(260, 120, 910, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
              
		
		table = new JTable();
		table.setBounds(0, 40, 900, 350);
		contentPane.add(table);
                
                try{
                    Conn c = new Conn();
                        String displayCustomersql = "select * from package";
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
		btnNewButton.setBounds(390, 400, 120, 30);
                btnNewButton.setBackground(Color.RED);
                btnNewButton.setForeground(Color.WHITE);
		contentPane.add(btnNewButton);
		
		lblAvailability = new JLabel("Username");
		lblAvailability.setBounds(10, 15, 69, 14);
		contentPane.add(lblAvailability);
		
		lblCleanStatus = new JLabel("Package");
		lblCleanStatus.setBounds(140, 15, 76, 14);
		contentPane.add(lblCleanStatus);
		
		
		lblNewLabel_1 = new JLabel("Persons");
		lblNewLabel_1.setBounds(280, 15, 76, 14);
		contentPane.add(lblNewLabel_1);

		
		lblId = new JLabel("ID");
		lblId.setBounds(420, 15, 90, 14);
		contentPane.add(lblId);
                
                JLabel l3 = new JLabel("ID Number");
		l3.setBounds(525, 15, 90, 14);
		contentPane.add(l3);
               
                
                JLabel l5 = new JLabel("Phone");
		l5.setBounds(660, 15, 90, 14);
		contentPane.add(l5);
                
                JLabel l6 = new JLabel("Total Cost");
		l6.setBounds(820, 15, 90, 14);
		contentPane.add(l6);
                
                getContentPane().setBackground(Color.WHITE);
	}

}