/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.outtatech.client;

/**
 *
 * @author bschache
 */
public class CriticalGameErrorException extends Exception {
    
    public CriticalGameErrorException(String msg)
    {
        super(msg);
    }
}
