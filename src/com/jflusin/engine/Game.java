package com.jflusin.engine;

import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;

import com.jflusin.engine.listeners.KeyboardListener;
import com.jflusin.engine.listeners.MousepadListener;
import com.jflusin.engine.scenes.SceneFactory;
import com.jogamp.opengl.util.FPSAnimator;

public class Game {

	private final JFrame _window = new JFrame();
	private SceneFactory _sceneFactory = null;
	private KeyboardListener _keyboardListener = null;
	private MousepadListener _mousepadListener = null;
	private GLCanvas _canvas = null;
	
	public Game(int pWindowX, int pWindowY, String pTitle){
		_window.setSize(pWindowX, pWindowY);
		_window.setResizable(false);
		_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_window.setFocusable(true);
		_window.setLocationRelativeTo(null);
		_window.setTitle(pTitle);
		_keyboardListener = new KeyboardListener();
		_window.addKeyListener(_keyboardListener);
		GLProfile glp = GLProfile.getDefault();
		GLCapabilities caps = new GLCapabilities(glp);
		_canvas = new GLCanvas(caps);
		_window.add(_canvas);
		_window.setLocationRelativeTo(null);
		_sceneFactory = new SceneFactory(this);
		FPSAnimator animator = new FPSAnimator(_canvas, 100);
		animator.start();
		
		_window.setVisible(true);
		
	}
	
	public GLCanvas getCanvas(){
		return _canvas;
	}
	
	public JFrame getWindow(){
		return _window;
	}
	
	public SceneFactory getSceneFactory(){
		return _sceneFactory;
	}
	
	public KeyboardListener getKeyboardListener(){
		return _keyboardListener;
	}
	
	public MousepadListener getMousepadListener(){
		return _mousepadListener;
	}
}