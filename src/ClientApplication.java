import com.outtatech.client.*;
import com.outtatech.client.messaging.*;
import com.outtatech.common.*;

/**
 * Version-latenightpizzaparty
 *
 * @author dmangin
 */
public class ClientApplication {

    /**
     * Version-latenightpizzaparty
     *
     */
    public ClientApplication () {
        ClientController client = new ClientController();
        GUIController gui = new GUIController(client);
        client.setGUICtrl(gui);
        client.getState().addObserver(gui);
        gui.initWindows(gui);
        gui.exitWindow();
    }

    /**
     * Version-latenightpizzaparty
     *
     * @param args method parameter
     */
    public static void main(String[] args) {
        ClientApplication app = new ClientApplication();
    }
}
