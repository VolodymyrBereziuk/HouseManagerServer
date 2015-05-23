package com.volodymyr.bereziuk.server.transmit;

import java.io.Serializable;

public class TransmitObject implements Serializable{
        private static final long serialVersionUID = 140605814607823206L; 
	private Command command = null;
	private Object object = null;

	public TransmitObject(Command command)
	{
		this.command = command;
	}
	
	public TransmitObject(Command command, Object object) {
		this.command = command;
		this.object = object;
	}

	public void setCommand(Command command) {
		this.command = command;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public Command getCommand() {
		return command;
	}

	public Object getObject() {
		return object;
	}

}
