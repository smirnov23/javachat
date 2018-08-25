import java.io.*;
import java.net.*;

class Connection implements Runnable
{
	private Thread thread;
	private Socket clientSocket;
	
	Connection(Socket client)
	{
		clientSocket = client;
		thread = new Thread(this);
		thread.start();
	}
	
	public void run()
	{
		try {
 		    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		    PrintStream out = new PrintStream(clientSocket.getOutputStream());
		    while (true) {
			    String str = in.readLine();
			    System.out.println("Received message: " + str);
			    out.println("Message received.");
			    if (str.equals("exit")) {
				    break;
			    }
		    }
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
		        clientSocket.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}				
		}
	}
}

class Server
{
    public static void main (String[] args) throws IOException
	{
	    ServerSocket serverSocket = new ServerSocket(1500);
		
		while (true) {
		    Socket clientSocket = serverSocket.accept();
		    System.out.println("Accepted: " + clientSocket);
			Connection conn = new Connection(clientSocket);
		}
	
		//serverSocket.close();
	}
}