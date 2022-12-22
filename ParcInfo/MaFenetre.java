package affichage;
import listener.Listener;
import java.io.*;  
import java.net.*;
import java.util.Vector;
import java.awt.*;
import javax.swing.*;

public class MaFenetre extends JFrame {
    String mess="haha";
    public String getMessage(){
        return this.mess;
    }
    public void setMessage(String otherMess){
        this.mess=otherMess;
    }

    public MaFenetre(){
        this.setLayout(null);
        this.setContentPane(insertWrite());
        this.setSize(900,600);
        this.setVisible(true);
        this.setTitle("Parc Informatique");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);  
    }

    public Parc insert(String[][] info){
        Parc p=new Parc(info);
        return p;
    }

	public JPanel insertWrite(){
        JPanel panel=new JPanel();
        try{
            panel.setLayout(null);

            JLabel label1=new JLabel("Parc Informatique");
            JLabel label2=new JLabel("Aucun Client connecter pour le moment");
            JLabel label3=new JLabel("Loading...........");

            JButton jb=new JButton("Quit");

            panel.setBackground(Color.black);

            label1.setFont(new Font("Arial",Font.TRUETYPE_FONT,35));
            label1.setForeground(Color.white);
        
            label2.setFont(new Font("Arial",Font.TRUETYPE_FONT,35));
            label2.setForeground(Color.white);

            label3.setFont(new Font("Arial",Font.TRUETYPE_FONT,35));
            label3.setForeground(Color.white);

            label1.setBounds(300,50,400,60);
            label2.setBounds(150,100,800,60);
            label3.setBounds(350,400,200,60);

            jb.setBounds(350,450,200,40);
            jb.setFont(new Font("Arial",Font.TRUETYPE_FONT,20));
            jb.addMouseListener(new Listener(this,jb));

            panel.add(label1);
            panel.add(label2);
            panel.add(label3);
            // panel.add(jb);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
		return panel;
	}      
}