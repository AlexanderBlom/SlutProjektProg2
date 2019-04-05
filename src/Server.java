import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 2345;
        ServerSocket serverSocket;
        Socket socket;
        System.out.println("Server started");

        try {
            serverSocket = new ServerSocket(port);
            while(true){
                System.out.println("Waiting for connections!");
                socket = serverSocket.accept();

                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String name = in.readLine();

                if (name.equals("Shutdown")){
                    in.close();
                    out.close();
                    socket.close();
                    System.exit(0);
                }

                System.out.println("Client name is " + name);

                out.println("SERVER: Welcome " + name);

                in.close();
                out.close();
                socket.close();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
