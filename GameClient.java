import java.util.Scanner;
import java.io.*;
import java.net.*;

public class GameClient
{
    public static void main(String[] args) throws IOException 
    {
        try 
        {
            Socket GameSocket = new Socket("localhost", 3446);
            Scanner In = new Scanner(GameSocket.getInputStream());             
            PrintWriter Out = new PrintWriter(GameSocket.getOutputStream(),true); 
            Scanner kbdIn = new Scanner(System.in);
            String res = "";
            System.out.println("Guess the number between 1 and 10. You have 3 attempts.");                               
            while (true) 
            {
                String userInput = kbdIn.nextLine(); 		
                Out.println(userInput); 					             
                res = In.nextLine(); 
                System.out.println(res); 			                
                if (res.equals("correct"))
                    break; 									
                if(res.equals("incorrect 1") || res.equals("incorrect 2") ||
                		res.equals("incorrect 3") || res.equals("incorrect 4") ||
                		res.equals("incorrect 5") || res.equals("incorrect 6") ||
                		res.equals("incorrect 7") || res.equals("incorrect 8") ||
                		res.equals("incorrect 9") || res.equals("incorrect 10")) {
                	break;
                }
            }           
            Out.close();
            kbdIn.close();
            In.close();
            GameSocket.close();
        } 
        catch (ConnectException e) 
        {
        	System.err.println(e);
        } 
        catch (IOException ioe) 	  
        {
        	System.err.println(ioe);
        }
    }
}