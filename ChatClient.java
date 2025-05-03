import java.io.*;
import java.net.*;

public class ChatClient {
    private static final String SERVER_IP = "localhost"; // or IP of server
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (
            Socket socket = new Socket(SERVER_IP, SERVER_PORT);
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            System.out.print("Enter your name: ");
            String name = console.readLine();
            out.println(name);

            Thread readThread = new Thread(() -> {
                String msg;
                try {
                    while ((msg = in.readLine()) != null) {
                        System.out.println(msg);
                    }
                } catch (IOException e) {
                    System.out.println("Disconnected from server.");
                }
            });
            readThread.start();

            String userInput;
            while ((userInput = console.readLine()) != null) {
                out.println(userInput);
            }
        } catch (IOException e) {
            System.out.println("Client Error: " + e.getMessage());
        }
    }
}
