package com.jflusin.engine.entities;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;

import com.jflusin.engine.scenes.AbstractScene;



public abstract class TexturedRectangleEntity extends AbstractEntity implements ITexturableEntity{

	protected int _textureID = 0;
	
	public TexturedRectangleEntity(int _x, int _y, int _width, int _height, AbstractScene _pScene){
		super(_x, _y, _width, _height, _pScene);
	}
	
	@Override
	public void draw(GLAutoDrawable pDrawable) {
		
		GL2 gl = pDrawable.getGL().getGL2();
		
		int x = getX();
		int y = getY();
		int width = getWidth();
		int height = getHeight();
		
		if(getGLTextureID() != 0){
			//Drawing with texture
			gl.glClearColor(0, 0, 0, 1);
			gl.glClear(GL2.GL_DEPTH_BUFFER_BIT);
			gl.glTexParameteri(GL2.GL_TEXTURE_2D, GL2.GL_TEXTURE_MAG_FILTER,
					GL2.GL_NEAREST);
			gl.glTexParameteri(GL2.GL_TEXTURE_2D, GL2.GL_TEXTURE_MIN_FILTER,
					GL2.GL_NEAREST);
			gl.glBindTexture(GL2.GL_TEXTURE_2D, getGLTextureID());
			gl.glEnable(GL2.GL_BLEND);
			gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
			gl.glEnable(GL2.GL_TEXTURE_2D);
			gl.glColor3f(1.0f, 1.0f, 1.0f);
			gl.glBegin(GL2.GL_QUADS);
				gl.glTexCoord2f(0.0f, 0.0f);
				gl.glVertex2i(x, y + height);
				gl.glTexCoord2f(1.0f, 0.0f);
				gl.glVertex2i(x + width, y + height);
				gl.glTexCoord2f(1.0f, 1.0f);
				gl.glVertex2i(x + width, y);
				gl.glTexCoord2f(0.0f, 1.0f);
				gl.glVertex2i(x, y);
			gl.glEnd();
			gl.glDisable(GL2.GL_BLEND);
			gl.glDisable(GL2.GL_TEXTURE_2D);
		}else{
			//Drawing without texture
			gl.glBegin(GL2.GL_QUADS);
				gl.glVertex2i(x, y);
				gl.glVertex2i(x+width, y);
				gl.glVertex2i(x+width, y+height);
				gl.glVertex2i(x, y+height);
			gl.glEnd();
		}

	}
	
	public void setTextureID(int pTextureId){
		_textureID = pTextureId;
	}
	
	public int getTextureID(){
		return _textureID;
	}	
	
	public int getGLTextureID(){
		return _scene.getTextureMapper().getGLTextureID(this.getClass(), getTextureID());
	}
}
