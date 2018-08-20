import java.io.*;
import java.net.*;

class Client
{
    public static void main(String[] args) throws IOException
	{
	    Socket socket = new Socket("localhost", 1500);
		
		BufferedReader inStd = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintStream out = new PrintStream(socket.getOutputStream());
		
		while (true) {
		    String str = inStd.readLine();
		
		    out.println(str);
		    str = in.readLine();

		    System.out.println(str);
			if (str.equals("exit")) {
				break;
			}
		}
		
		socket.close();
	}
}