package com.jflusin.testscene;

import com.jflusin.engine.Game;

public class EntryPoint {

	private static int windowWidth = 800;
	private static int windowHeight = 600;
	private static String windowName = "Fenetre OpenGL";
	
	public static void main(String[] args) {
		Game game = new Game(windowWidth, windowHeight, windowName);
		game.getSceneFactory().showScene(new EmptyScene(game.getSceneFactory()));
	}

}
