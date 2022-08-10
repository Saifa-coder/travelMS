/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.tourism.ms;

import java.awt.FlowLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author tukku
 */
public class Splash {
    
   public static void main(String[] args){
        SplashFrame f1 = new SplashFrame();
        f1.setVisible(true);
        
        
    }
}
class SplashFrame extends JFrame implements Runnable{
    Thread t1;
    SplashFrame(){
       
        setLayout(new FlowLayout());
         setBounds(160, 70, 1000, 600);
        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg"));
        Image i1 = c1.getImage().getScaledInstance(1000,600,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        
        JLabel l1 = new JLabel(i2);
        add(l1);
        setUndecorated(true);
        t1 = new Thread(this);
        t1.start();
    }
    public void run(){
        try{
            Thread.sleep(5000);
            this.setVisible(false);
            
            Login l = new Login();
            l.setVisible(true);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
