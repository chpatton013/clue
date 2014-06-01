
import com.outtatech.client.ClientController;
import com.outtatech.client.GUIController;
import com.outtatech.server.ServerController;
import com.outtatech.server.ServerNetwork;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dmangin
 */
public class StartServerAndClient
{
    public static void startSetup() {
        ServerNetwork network = new ServerNetwork(55555);
        ServerController server = new ServerController(network);
        ClientController client = new ClientController();
        GUIController gui = new GUIController(client);
        client.setGUICtrl(gui);
        client.getState().addObserver(gui);
        gui.initWindows(gui);
        gui.exitWindow();
    }
    
    public static void main(String[] args) {
        startSetup();
    }
}
