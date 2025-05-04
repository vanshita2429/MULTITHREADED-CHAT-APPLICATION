# MULTITHREADED-CHAT-APPLICATION

*COMPANY*: CODETECH IT SOLUTIONS

*NAME*: VANSHITA RATHOD

*INTERN ID*: CT06DA295

*DOMAIN*: JAVA PROGRAMMING

*DURATION*: 6 WEEKS

*MENTOR*: NEELA SANTOSH

# **Client-Server Chat Application Using Java**

For our networking project, we developed a simple client-server chat application using Java Sockets and multithreading. The purpose of this project was to understand how network communication works, and how multiple users can interact with each other in real time through a common server. We built the project using Java in a basic code editor like Notepad, and ran the code from the command line. This helped us learn how Java handles networking, threads, and input/output streams.

The application is divided into two main parts: the **server** and the **clients**. The server is the central point that listens for incoming connections from clients. It accepts multiple clients using ServerSocket and handles each client in a separate thread. This is important because it allows the server to manage multiple users at the same time without blocking communication.

The client side connects to the server using Socket, and allows the user to send messages and receive broadcasts from other users. We used input and output streams (BufferedReader, PrintWriter) to handle the data being sent and received. Whenever a user types a message, it is sent to the server, which then shares it with all other clients connected to the chat.

To handle multiple users, we used **multithreading**. The server creates a new thread for every client that connects. Each thread continuously listens for messages from its respective client and sends them to the server to be shared. This multithreaded setup allows real-time communication between all users without delays.

This type of application can be used in many real-world situations, such as online group chats, customer support systems, or multiplayer games where communication is needed between players. While our project was a simple command-line version, the same concept can be expanded into full-featured chat applications with graphical interfaces, user login systems, and message history.

We used the Java Development Kit (JDK) for compiling and running the code, and wrote all our code in Notepad. This helped us stay close to the basics and understand how everything works without relying on advanced tools. We tested the server by opening multiple command prompt windows and running the client code from each. This way, we could see messages being passed between users and confirm that the multithreaded server was working correctly.

In conclusion, building the client-server chat application using Java sockets and threads gave us a strong understanding of network communication, socket programming, and concurrency. It showed us how servers handle multiple users and how threads can be used to manage multiple tasks at the same time. Even though it was a simple console-based app, it laid the foundation for more complex projects like chat rooms, file sharing applications, and real-time multiplayer platforms. The hands-on experience from writing and testing each part helped me grasp both the theory and the practical aspects of Java networking.

#OUTPUT

![Image](https://github.com/user-attachments/assets/c1d2d590-c513-400e-a368-b7bf98a90e11)
