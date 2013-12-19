package com.jflusin.engine.entities;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;

import com.jflusin.engine.scenes.AbstractScene;

public abstract class RectangleEntity extends AbstractEntity implements
		ITexturableEntity {

	public RectangleEntity(int _x, int _y, int _width, int _height,
			AbstractScene _pScene) {
		super(_x, _y, _width, _height, _pScene);
	}

	@Override
	public void draw(GLAutoDrawable pDrawable) {

		GL2 gl = pDrawable.getGL().getGL2();

		int x = getX();
		int y = getY();
		int width = getWidth();
		int height = getHeight();

		// Drawing without texture
		gl.glBegin(GL2.GL_QUADS);
		gl.glVertex2i(x, y);
		gl.glVertex2i(x + width, y);
		gl.glVertex2i(x + width, y + height);
		gl.glVertex2i(x, y + height);
		gl.glEnd();

	}
}
