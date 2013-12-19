package com.jflusin.engine.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {

	private boolean[] _keys = new boolean[1024];
	
	@Override
	public void keyPressed(KeyEvent pEvent) {
		_keys[pEvent.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent pEvent) {
		_keys[pEvent.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent pEvent) {

	}
	
	public boolean isKeyPressed(int pKey){
		return _keys[pKey];
	}
	
	public boolean isKeyReleased(int pKey){
		return !_keys[pKey];
	}
}
