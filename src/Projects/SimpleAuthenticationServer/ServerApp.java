package Projects.SimpleAuthenticationServer;

import com.sun.net.httpserver.*;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;

public class ServerApp {

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

        HttpContext contextA = server.createContext("/");
        contextA.setHandler(ServerApp::handleRequestA);

        HttpContext contextB = server.createContext("/example");
        contextB.setHandler(ServerApp::handleRequestB);

        server.start();
        System.out.println("Server running on http://localhost:8000/");
    }

    private static void handleRequestA(HttpExchange exchange) throws IOException {
        String response = "Hi there!";
        exchange.sendResponseHeaders(200,response.getBytes().length);
        OutputStream outputStream = exchange.getResponseBody();

        outputStream.write(response.getBytes());
        outputStream.close();
    }

    private static void handleRequestB(HttpExchange exchange) throws IOException {
        URI requestURI = exchange.getRequestURI();
        printRequestInfo(exchange);

        String response = "This is the response at " + requestURI;
        exchange.sendResponseHeaders(200, response.getBytes().length);
        OutputStream outputStream = exchange.getResponseBody();
        outputStream.write(response.getBytes());
        outputStream.close();

    }

    private static void printRequestInfo(HttpExchange exchange) {
        System.out.println("--- headers ---");
        Headers requestHeaders = exchange.getRequestHeaders();
        requestHeaders.entrySet().forEach(System.out::println);

        System.out.println("-- principle --");
        HttpPrincipal principal = exchange.getPrincipal();
        System.out.println(principal);

        System.out.println("--- HTTP method ---");
        String requestMethod = exchange.getRequestMethod();
        System.out.println(requestMethod);

        System.out.println("--- Query ---");
        URI requestURI = exchange.getRequestURI();
        String query = requestURI.getQuery();
        System.out.println(query);
    }
}
