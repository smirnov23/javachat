import java.io.*;
import java.net.*;

class Server
{
    public static void main (String[] args) throws IOException
	{
	    ServerSocket serverSocket = new ServerSocket(1500);
		
		while (true) {
		    Socket clientSocket = serverSocket.accept();
		    System.out.println("Accepted: " + clientSocket);
		
		    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		    PrintStream out = new PrintStream(clientSocket.getOutputStream());
		
		    String str = in.readLine();
		
		    System.out.println(str);
		
			if (str.equals("exit")) {
		        out.println("exit");
		        clientSocket.close();
			} else {
		        out.println("Message received.");
			}
		}
	
		//serverSocket.close();
	}
}