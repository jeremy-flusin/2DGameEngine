package com.jflusin.engine.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MousepadListener implements MouseListener {

	private int _mouseX = 0;
	private int _mouseY = 0;
	private boolean _clicked;
	
	@Override
	public void mouseClicked(MouseEvent pEvent) {
		this._mouseX = pEvent.getX();
		this._mouseY = pEvent.getY();
		this._clicked = true;
	}

	@Override
	public void mouseEntered(MouseEvent pEvent) {

	}

	@Override
	public void mouseExited(MouseEvent pEvent) {

	}

	@Override
	public void mousePressed(MouseEvent pEvent) {
		mouseClicked(pEvent);
	}

	@Override
	public void mouseReleased(MouseEvent pEvent) {
		this._clicked = false;
	}

	public boolean isMousePressed(){
		return _clicked;
	}
	
	public int getX(){
		return _mouseX;
	}

	public int getY(){
		return _mouseY;
	}
}
