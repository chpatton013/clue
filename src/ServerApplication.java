import com.outtatech.server.*;

/**
 * Version-latenightpizzaparty
 *
 * @author dmangin
 */
public class ServerApplication {

    /**
     * Version-latenightpizzaparty
     *
     */
    public ServerApplication() {
        ServerNetwork network = new ServerNetwork(55555);
        ServerController server = new ServerController(network);
    }

    /**
     * Version-latenightpizzaparty
     *
     * @param args method parameter
     */
    public static void main(String[] args) {
        ServerApplication app = new ServerApplication();
    }
}
