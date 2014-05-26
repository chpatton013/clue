/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.outtatech.server.*;

/**
 *
 * @author dmangin
 */
public class ServerApplication {
    
    public ServerApplication() {
        ServerNetwork network = new ServerNetwork(55555);
        ServerController server = new ServerController(network);
        network.setServerController(server);
    }
    
    public static void main(String[] args) {
        ServerApplication app = new ServerApplication();
    }
}
