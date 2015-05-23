package com.volodymyr.bereziuk.server.transmit;


public enum Command {
        USEREXIST,
    
        ADDDEVICE,
        SHOWALLDEVICES,
        DELETEDEVICE,
        
        ADDROOM,
        SHOWALLROOM,
        DELETEROOM,
        
        SHOWALLUSER,
        DELETEUSER,
        
        SHOWALLMEASURE,
        DELETEMEASURE,
        
	INITIALIZATION,
	CONFIRM,
	END
}
