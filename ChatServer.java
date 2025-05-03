import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static final int PORT = 12345;
    private static final Set<ClientHandler> clients = Collections.synchronizedSet(new HashSet<>());

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Chat server started on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                ClientHandler clientThread = new ClientHandler(socket);
                clients.add(clientThread);
                clientThread.start();
            }
        } catch (IOException e) {
            System.out.println("Server Error: " + e.getMessage());
        }
    }

    static void broadcast(String message, ClientHandler sender) {
        synchronized (clients) {
            for (ClientHandler ch : clients) {
                if (ch != sender) {
                    ch.sendMessage(message);
                }
            }
        }
    }

    static void removeClient(ClientHandler client) {
        clients.remove(client);
    }

    static class ClientHandler extends Thread {
        private final Socket socket;
        private PrintWriter out;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try (
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
            ) {
                out = new PrintWriter(socket.getOutputStream(), true);
                String name = in.readLine();
                broadcast(name + " has joined the chat.", this);
                String msg;
                while ((msg = in.readLine()) != null) {
                    broadcast(name + ": " + msg, this);
                }
            } catch (IOException e) {
                System.out.println("Client disconnected: " + e.getMessage());
            } finally {
                ChatServer.removeClient(this);
                broadcast("A user has left the chat.", this);
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println("Error closing socket");
                }
            }
        }

        void sendMessage(String message) {
            out.println(message);
        }
    }
}
