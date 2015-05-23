/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GPIO;

import driverInterface.LampInterface;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vova
 */
public class Locator {
    
    LampInterface lamp = null;
    
    public Locator()
    {   
        inizializeDriver();
    }
    
    private void inizializeDriver()
    {
        Class loaded;
        try {
            loaded = Class.forName("lampDriver.LampDriver");
            
            lamp  = (LampInterface) loaded.newInstance();
             
             
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Locator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Locator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Locator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }
    
    public LampInterface userLamp()
    {
        return lamp;
    }
}
