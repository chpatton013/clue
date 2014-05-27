import com.outtatech.server.Lobby;
import com.outtatech.server.messaging.LobbyCreateResponse;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thomas
 */
public class LobbyCreateResponseTest {
    
    /**
     *
     */
    public LobbyCreateResponseTest() {
    }
    
    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }
    
    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getLobby method, of class LobbyCreateResponse.
     */
    @Test
    public void testGetLobby() {
        System.out.println("getLobby");
        Lobby expResult = null;
        LobbyCreateResponse instance = new LobbyCreateResponse(expResult);
        Lobby result = instance.getLobby();
        assertEquals(expResult, result);
    }
    
}
