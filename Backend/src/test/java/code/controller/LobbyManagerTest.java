package code.controller;

import code.interfaces.IView;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import utils.Lobby;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class LobbyManagerTest {
    @Mock
    private ClientHandler clientHandler;
    @Mock
    private IView mockView;

    @Test
    void testNewLobby() {
        int size = LobbyManager.getLobbys().size();
        Lobby l = LobbyManager.newLobby("name", clientHandler);
        assertNotNull(l);
        assertEquals(size +1, LobbyManager.getLobbys().size());
    }

    @Test
    void testJoinLobby() {
        Lobby mockLobby = mock(Lobby.class);
        LobbyManager.joinLobby(mockLobby, "name", mockView);
        verify(mockLobby, times(1)).addPlayer(anyString(), any());
    }
}
