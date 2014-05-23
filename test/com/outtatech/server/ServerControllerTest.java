/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.outtatech.server;

import com.lloseng.ocsf.server.ConnectionToClient;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dmangin
 */
public class ServerControllerTest {
    
    public ServerControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of reactToNetwork method, of class ServerController.
     */
    @Test
    public void testReactToNetwork() {
        System.out.println("reactToNetwork");
        Object obj = null;
        ConnectionToClient connection = null;
        ServerController instance = null;
        instance.reactToNetwork(obj, connection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reactToRobot method, of class ServerController.
     */
    @Test
    public void testReactToRobot() {
        System.out.println("reactToRobot");
        Object obj = null;
        AI robot = null;
        ServerController instance = null;
        instance.reactToRobot(obj, robot);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of forwardMessage method, of class ServerController.
     */
    @Test
    public void testForwardMessage() {
        System.out.println("forwardMessage");
        Object obj = null;
        ConnectionToClient connection = null;
        boolean flag = false;
        ServerController instance = null;
        instance.forwardMessage(obj, connection, flag);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
