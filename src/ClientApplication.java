/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.outtatech.client.*;
import com.outtatech.client.messaging.*;
import com.outtatech.common.*;

/**
 *
 * @author dmangin
 */
public class ClientApplication {
    
    public ClientApplication () {
        ClientController client = new ClientController();
        GUIController gui = new GUIController(client);
        client.getState().addObserver(gui);
        gui.initWindows(gui);
        gui.exitWindow();
    }
    
    public static void main(String[] args) {
        ClientApplication app = new ClientApplication();
    }
}
