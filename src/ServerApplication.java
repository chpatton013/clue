import com.outtatech.server.*;

/**
 *
 * @author dmangin
 */
public class ServerApplication {
    
    public ServerApplication() {
        ServerNetwork network = new ServerNetwork(55555);
        ServerController server = new ServerController(network);
    }
    
    public static void main(String[] args) {
        ServerApplication app = new ServerApplication();
    }
}
