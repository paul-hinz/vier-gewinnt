package code.communication.game;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * Main-Klasse, die den Server aus GameImpl baut und auf Port 50052 laufen lässt.
 *
 */
public class GameServer {
    public static void main(String[] args) throws InterruptedException, IOException {
        Server server = ServerBuilder.forPort(50052).addService(new GameImpl()).build();
        System.out.println("Server ist gestartet auf port 50052");
        server.start();
        server.awaitTermination();
    }
}
