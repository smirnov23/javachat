import java.io.*;
import java.net.*;

class Client
{
    public static void main(String[] args) throws IOException
	{
	    Socket socket = new Socket("localhost", 1500);
		
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintStream out = new PrintStream(socket.getOutputStream());
		
		while (true) {
		    String str = stdin.readLine();
		
		    out.println(str);
			if (str.equals("exit")) {
				break;
			} else {
		        str = in.readLine();
		        System.out.println(str);
			}
		}
		System.out.println("Client work done.");
		socket.close();
	}
}