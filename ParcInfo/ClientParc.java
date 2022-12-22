package socket;

import java.net.*;
import java.io.*;
import java.util.Scanner;
import info.Info;

public class ClientParc extends Thread{
    Socket socket;
    DataOutputStream out;

//////CONSTRUCTOR
    public ClientParc(){}

/////GET ET SET
    public Socket getsocket(){
        return this.socket;
    }
    public DataOutputStream getoutput(){
        return this.out;
    }

    public void setsocket(Socket socket){
        this.socket=socket;
    }
    public void setoutput(DataOutputStream out){
        this.out=out;
    }

//////CONNECT AND CLOSE CLIENT
    public void connectClient(String adresse, int port) throws Exception{
        this.setsocket(new Socket(adresse, port));
        this.setoutput(new DataOutputStream(this.getsocket().getOutputStream()));
    }

    public void closeClient() throws IOException{
        this.getsocket().close();
        this.getoutput().close();
    }

/////SEND MESSAGE 
    public void sendmessage(String message) throws IOException{
        this.getoutput().writeUTF(message);
    }

    public void run(){
        try{
            ClientParc c = new ClientParc();
            try{
                Info info=new Info();
                String info1=info.getGeneralInfo();
                c.connectClient("localhost", 7777);

                while(true){
                    c.sendmessage(info1);
                    Thread.sleep(5000);        
                }
            }catch(Exception ex){
                System.out.println(ex.getMessage());
                c.closeClient();
            }
        }catch(Exception e){
            System.out.println(e.getMessage()+"oooooooooooooooooooooooooo");
        }
    }

/////MAIN CLIENT
    public static void main(String[] args) {
		try {
			System.out.println("Envoi du message");
			ClientParc client = new ClientParc();
			client.start();
		} catch(Exception e) {
			e.printStackTrace();
		}   
	}
}