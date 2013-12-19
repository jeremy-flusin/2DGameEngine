package com.jflusin.engine.entities;

import java.awt.Rectangle;

import javax.media.opengl.GLAutoDrawable;

import com.jflusin.engine.scenes.AbstractScene;

public abstract class AbstractEntity {

	protected int _x = 0;
	protected int _y = 0;
	protected int _width = 0;
	protected int _height = 0;
	protected AbstractScene _scene;
	
	public AbstractEntity(int pX, int pY, int pWidth, int pHeight, AbstractScene pScene) {
		_x = pX;
		_y = pY;
		_width = pWidth;
		_height = pHeight;
		_scene = pScene;
	}
	
	public abstract void draw(GLAutoDrawable pDrawable);
	
	public abstract void update();
	
	public int getX(){
		return _x;
	}
	
	public void setX(int pX){
		_x = pX;
	}
	
	public int getY(){
		return _y;
	}
	
	public void setY(int pY){
		_y = pY;
	}
	
	public int getWidth(){
		return _width;
	}
	
	public void setWidth(int pWidth){
		_width = pWidth;
	}
	
	public int getHeight(){
		return _height;
	}
	
	public void setHeight(int pHeight){
		_height = pHeight;
	}

	public Rectangle getBounds(){
		return new Rectangle(_x, _y, _width, _height);
	}
	
	public AbstractScene getScene(){
		return _scene;
	}
}
