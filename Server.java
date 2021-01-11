import java.net.*;

public class Server
{
	public static void main(String[] args) throws Exception
	{
		ServerSocket ser = new ServerSocket(3446);
		System.out.println("");		
		new ServerThread(ser.accept()).start();				
		ser.close();
	}
}