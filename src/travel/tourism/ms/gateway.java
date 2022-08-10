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
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class gateway extends JFrame{
    gateway(){
        JEditorPane j = new JEditorPane();
        j.setEditable(false);   

        try {
           String url= "https://www.bkash.com";
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
        }catch (Exception ee) {
            j.setContentType("text/html");
            j.setText("<html>Could not load</html>");
        } 

        JScrollPane scrollPane = new JScrollPane(j);     
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(scrollPane);
        setPreferredSize(new Dimension(800,600));
        
        JButton back=new JButton("Back");
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        back.setBounds(610, 20, 80, 40);
        j.add(back);
        
        setSize(800,600);
        setLocation(600,220);
        setVisible(true);
    }
    public static void main(String[] args){
        new gateway().setVisible(true);
    }
}