package code.controller.communication.game;

import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import io.grpc.testing.GrpcCleanupRule;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import code.communication.game.GameImpl;


import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class GameServerTest {
    @Rule
    public final GrpcCleanupRule grpcCleanup = new GrpcCleanupRule();


    @Test
    public void gameImpl_joinLobby() throws Exception{
        String serverName = InProcessServerBuilder.generateName();

        grpcCleanup.register(InProcessServerBuilder.
                forName(serverName).directExecutor().addService(new GameImpl()).build().start());

        GameGrpc.GameBlockingStub blockingStub = GameGrpc.newBlockingStub(
                grpcCleanup.register(InProcessChannelBuilder.forName(serverName).directExecutor().build()));

        JoinLobbyResponse response = blockingStub.joinLobby(JoinLobbyRequest.newBuilder().setLobbyID(5).build());
        assertNotNull(response);
        assertFalse(response.getSuccess()); // keinen lobby gibt
    }

    @Test
    public void gameImpl_createLobby() throws Exception{
        String serverName = InProcessServerBuilder.generateName();

        grpcCleanup.register(InProcessServerBuilder.
                forName(serverName).directExecutor().addService(new GameImpl()).build().start());

        GameGrpc.GameBlockingStub blockingStub = GameGrpc.newBlockingStub(
                grpcCleanup.register(InProcessChannelBuilder.forName(serverName).directExecutor().build()));
        CreateLobbyResponse response = blockingStub.createLobby(CreateLobbyRequest.newBuilder().setOwnName("kai").build());

        assertTrue(response.getSuccess());
        assertNotNull(response);
    }

    @Test
    public void gameImpl_stream() throws Exception{
        String serverName = InProcessServerBuilder.generateName();

        grpcCleanup.register(InProcessServerBuilder.
                forName(serverName).directExecutor().addService(new GameImpl()).build().start());

        GameGrpc.GameBlockingStub blockingStub = GameGrpc.newBlockingStub(
                grpcCleanup.register(InProcessChannelBuilder.forName(serverName).directExecutor().build()));
        Iterator<ResponseStream> response = blockingStub.pollGameData(PollRequest.newBuilder().build());

        assertNotNull(response);

    }

}
