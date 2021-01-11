import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ServerThread extends Thread
{
	private Socket sok = null;					
	public ServerThread(Socket socket)
	{
		sok = socket;
	}	
	public void run()
	{				
		String inputLine;			
		int guess;			
		int c = 3;						
		int Random =(int) ((Math.random() * 9) +1); 		
		try
		{
			Scanner in = new Scanner(sok.getInputStream());			
			PrintWriter out = new PrintWriter(sok.getOutputStream(), true);			
			while (true)
			{
				inputLine = in.nextLine();					
				guess = Integer.parseInt(inputLine);	
				System.out.println("Incoming variable from client: "+guess);	
				System.out.println("Random variable:"+Random);
				if (guess == Random)					
				{
					System.out.println("correct");
					out.println("correct");
					break;					
				}
				else if(c==1) {
					System.out.println("incorrect "+Random);
					out.println("incorrect "+Random);
					break;
				}
				else if (guess < Random)					
				{
					System.out.println("asc"); //ascending
					out.println("asc");
					c--;									
				}
				else if (guess > Random)					
				{
					System.out.println("dsc"); //descending
					out.println("dsc");
					c--;									
				}
			}			
			out.close();			
			in.close();
			sok.close();
		}
		catch (Exception e)											
		{
			System.err.println(e);
		}
	}
}