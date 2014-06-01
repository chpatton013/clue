
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
public class CreateServerAndClientX3
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
        ClientController client2 = new ClientController();
        GUIController gui2 = new GUIController(client2);
        client2.setGUICtrl(gui2);
        client2.getState().addObserver(gui2);
        gui2.initWindows(gui2);
        gui2.exitWindow();
        ClientController client3 = new ClientController();
        GUIController gui3 = new GUIController(client3);
        client3.setGUICtrl(gui3);
        client3.getState().addObserver(gui3);
        gui3.initWindows(gui3);
        gui3.exitWindow();
    }
    
    public static void main(String[] args) {
        startSetup();
    }
}
