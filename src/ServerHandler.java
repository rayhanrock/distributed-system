import java.io.*;
import java.net.*;

public class ServerHandler implements Runnable {
    private Socket socket;

    public ServerHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while (true) {
                String message = in.readLine();
                System.out.println("Received message: " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
