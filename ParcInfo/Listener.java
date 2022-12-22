package listener;
import affichage.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Vector;

public class Listener implements MouseListener{
    MaFenetre fn;
    JButton bt;

/////GET
    public MaFenetre getMaFenetre(){
        return this.fn;
    }
    public JButton getJButton(){
        return this.bt;
    }

/////SET
    public void setMaFenetre(MaFenetre autreFen) throws Exception{
        if(autreFen==null){
            throw new Exception("Ne peut pas etre null");
        }
        else{
            this.fn=autreFen;
        }
    }
    public void setJButton(JButton autreBt) throws Exception{
        if(autreBt==null){
            throw new Exception("Ne peut pas etre null");
        }
        else{
            this.bt=autreBt;
        }
    }

//////CONSTRUCTOR
    public Listener(MaFenetre f,JButton button) throws Exception{
        setMaFenetre(f);
        setJButton(button);
    }


///////FUNCTIONS
    public void mouseClicked(MouseEvent e){
        try{
            if(getJButton().getText().equals("Quit")){
                getMaFenetre().setMessage("Quit");
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        } 
    }
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
}