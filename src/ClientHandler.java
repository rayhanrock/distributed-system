import java.io.*;
import java.net.*;
import java.util.*;

public class ClientHandler implements Runnable {
    private Socket clientSocket;
    private ArrayList<Socket> clientSockets;

    public ClientHandler(Socket clientSocket, ArrayList<Socket> clientSockets) {
        this.clientSocket = clientSocket;
        this.clientSockets = clientSockets;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            while (true) {
                String message = in.readLine();

                // Send the message to all other clients
                for (Socket client : clientSockets) {
                    if (client != clientSocket) {
                        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                        out.println(message);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
