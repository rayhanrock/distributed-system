import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client4 {
    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket("localhost", 9000);

        // Create a new thread to handle messages from the server
        Thread t = new Thread(new ServerHandler(clientSocket));
        t.start();

        // Send messages to the server
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a message: ");
            String message = scanner.nextLine();

            out.println(message);
        }
    }
}
