package socket;

import affichage.*;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.Vector;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.BufferedInputStream;

public class ServerParc{
    int port;
    Socket socket;
    ServerSocket serversocket;
    DataInputStream dis;

/////GET ET SET
    public int getport(){
        return this.port;
    }
    public Socket getsocket(){
        return this.socket;
    }
    public ServerSocket getserverSocket(){
        return this.serversocket;
    }
    public DataInputStream getInput(){
        return this.dis;
    }

    public void setport(int port){
        this.port=port;
    }
    public void setsocket(Socket socket){
        this.socket=socket;
    }
    public void setserverSocket(ServerSocket serversocket){
        this.serversocket=serversocket;
    }
    public void setInput(DataInputStream in){
        this.dis=in;
    }

/////OPEN AND CLOSE SERVER
    public void openServer() throws IOException{
        this.setsocket(this.getserverSocket().accept());
        this.setInput(new DataInputStream(new BufferedInputStream(this.getsocket().getInputStream())));
    }
    
    public void closeServer() throws IOException{
        this.getsocket().close();
        this.getInput().close();
    }

/////READ MESSAGE
    public String readMessage() throws IOException{
        String message= this.getInput().readUTF();
        return message;
    }
    
/////CONSTRUCTOR
    public ServerParc(int port) throws IOException{
        this.setport(port);
        this.setserverSocket(new ServerSocket(port));
    }

    public String[][] getData(Vector<String> donne){
        String[] info=donne.get(0).split("///");
        String[][] data=new String[donne.size()][info.length];
        for(int i=0;i<donne.size();i++){
            info=donne.get(i).split("///");
            data[i]=info;
        }  
        return data; 
    }

    public boolean inVector(Vector<String> liste,String mess){
        String[] message=mess.split("///");
        for(int i=0;i<liste.size();i++){
            String[] info=liste.get(i).split("///");
            if(info[0].equals(message[0])){
                return true;
            }
        }
        return false;
    }

/////MAIN SERVER
    public static void main(String[] args){
        try{
            ServerParc s=new ServerParc(7777);
            Vector<String> info=new Vector<String>();
            MaFenetre fn=new MaFenetre();
            
            try{
                System.out.println("Loading...................");
                s.openServer();

                while(true){
                    
                    System.out.println("Client Found");
                    
                    String mess=s.readMessage();
                    if(!s.inVector(info,mess)) info.add(mess); 
                    
                    System.out.println(mess);

                    if(info.size()>0){
                        fn.setContentPane(fn.insert(s.getData(info)));
                    }
                    
                    Thread.sleep(2000);
                    System.out.println();
                }
            
            }catch(Exception exe){
                System.out.println(exe.getMessage());
                s.closeServer();
                fn.dispose();
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}