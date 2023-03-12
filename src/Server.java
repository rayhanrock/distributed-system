import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);
        ArrayList<Socket> clientSockets = new ArrayList<>();

        while (true) {
            // Accept a client connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connected to " + clientSocket);

            // Add the client socket to the list of client sockets
            clientSockets.add(clientSocket);

            // Create a new thread to handle messages from this client
            Thread t = new Thread(new ClientHandler(clientSocket, clientSockets));
            t.start();
        }
    }
}
