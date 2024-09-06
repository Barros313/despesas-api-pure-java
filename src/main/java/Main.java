import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

import handler.TestHandler;
import utility.input.GetInput;

public class Main {
    public static void main(String[] args) throws IOException {
        // Get PORT number through user input
        GetInput get = new GetInput();
        final int PORT = get.integer("Type PORT value: ");

        // Create server
        InetSocketAddress address = null;
        try {
            // Try assigning address
            address = new InetSocketAddress(PORT);
        } catch (IllegalArgumentException iae) {
            // Print error and return if invalid PORT
            System.err.println("Invalid PORT parameter. Outside range");
            return;
        }

        // Create a new http server
        HttpServer server = HttpServer.create(address, 0);

        // Set test handler address to path /hello
        server.createContext("/hello", new TestHandler());

        // Start server
        server.start();

        // Start success message
        System.out.println("Server started on port 8080");
    }
}
