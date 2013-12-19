package com.jflusin.engine.scenes;

import com.jflusin.engine.Game;

public class SceneFactory {

	private final Game _game;
	private AbstractScene _scene;
	
	public SceneFactory(Game pGame){
		this._game = pGame;
	}
	
	public void showScene(AbstractScene pScene){
		_game.getCanvas().removeGLEventListener(_scene);
		this._scene = pScene;
		_game.getCanvas().addGLEventListener(pScene);
	}
	
	public AbstractScene getCurrentScene(){
		return _scene;
	}
	
	public Game getGame(){
		return _game;
	}
}
