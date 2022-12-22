package affichage;

import java.awt.*;
import javax.swing.*;
import java.util.Vector;

public class Parc extends JPanel{
    public Parc(String[][] info){
        String[] column={"OS","Architecture","Version","User" , "Max Memory", "Free Memory", "Used Memory"};
        
        JLabel label=new JLabel("Liste des connectes: "+info.length+" Clients");
        label.setFont(new Font("Arial",Font.TRUETYPE_FONT,25));

        JTable jt=new JTable(info,column);
        JScrollPane scroll=new JScrollPane(jt);
        
        ////Style Jtable
        jt.setRowHeight(40);
        jt.getTableHeader().setBackground(Color.pink);
        jt.getTableHeader().setFont(new Font("Arial",Font.TRUETYPE_FONT,14));
        jt.setFont(new Font("Arial",Font.TRUETYPE_FONT,12));
        
        
        scroll.setPreferredSize(new Dimension(800,500));
        this.add(label,BorderLayout.PAGE_START);
        this.add(scroll,BorderLayout.CENTER);
        this.setVisible(true);
        this.setSize(900,900);  
    }
}