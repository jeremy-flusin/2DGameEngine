package com.jflusin.testscene;

import javax.media.opengl.GLAutoDrawable;

import com.jflusin.engine.scenes.AbstractScene;
import com.jflusin.engine.scenes.SceneFactory;

public class EmptyScene extends AbstractScene {

	public EmptyScene(SceneFactory pScreenFactory) {
		super(pScreenFactory);
	}

	//appel� � toute les frames
	@Override
	public void display(GLAutoDrawable pDrawable) {
		//code openGL ici
		super.display(pDrawable);
	}
	
	//appel� avant d'afficher la sc�ne
	@Override
	public void init(GLAutoDrawable pDrawable) {
		//code openGL ici
		super.init(pDrawable);
	}
	
	
	//appel� lors de la destruction de la sc�ne
	@Override
	public void dispose(GLAutoDrawable arg0) {
		//code openGL ici
		super.dispose(arg0);
	}
	
	//appel� lors du redimensionnement de la fen�tre, entre autres
	@Override
	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3,
			int arg4) {
		//code openGL ici
		super.reshape(arg0, arg1, arg2, arg3, arg4);
	}
}
