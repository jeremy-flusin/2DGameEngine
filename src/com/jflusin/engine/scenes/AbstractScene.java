package com.jflusin.engine.scenes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLException;
import javax.media.opengl.glu.GLU;

import com.jflusin.engine.entities.AbstractEntity;
import com.jflusin.engine.entities.ITexturableEntity;
import com.jflusin.engine.entities.TextureMapper;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

public abstract class AbstractScene  implements GLEventListener{

	private final SceneFactory _sceneFactory;
	
	private ArrayList<AbstractEntity> _entities;
	private TextureMapper _textureMapper;
	
	public AbstractScene(SceneFactory pScreenFactory) {
		this._sceneFactory = pScreenFactory;
		this._entities = new ArrayList<AbstractEntity>();
		this._textureMapper = new TextureMapper();
	}
	
	public void addEntity(AbstractEntity pEntity){
		_entities.add(pEntity);
	}	
	
	@Override
	public void display(GLAutoDrawable pDrawable) {
		final GL2 gl = pDrawable.getGL().getGL2();
		//clear screen
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT);		
		update();
		render(pDrawable);
	}
	
	protected void update(){
		for (AbstractEntity entity : _entities){
			entity.update();
		}
	}
	
	protected void render(GLAutoDrawable pDrawable){
		//drawing every object
		for (AbstractEntity entity : _entities){
			entity.draw(pDrawable);
		}
	}
	
	@Override
	public void init(GLAutoDrawable pDrawable) {
		
		GL2 gl = pDrawable.getGL().getGL2();
		GLU glu = new GLU();
		
		double screenWidth = _sceneFactory.getGame().getWindow().getWidth();
		double screenHeight = _sceneFactory.getGame().getWindow().getHeight();
		
		gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
		gl.glViewport(0, 0, (int)screenWidth, (int)screenHeight);
		
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		glu.gluOrtho2D(0.0, screenWidth, 0.0, screenHeight);
		
		loadTextures(pDrawable);
		
	}
	
	@Override
	public void dispose(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3,
			int arg4) {
		// TODO Auto-generated method stub

	}

	public void mapTexture(Class<? extends ITexturableEntity> pClass, String pString){
		_textureMapper.mapTexture(pClass, pString);
	}
	
	public void unmapTexture(Class<? extends ITexturableEntity> pClass){
		_textureMapper.unmapTexture(pClass);
	}
	
	private void loadTextures(GLAutoDrawable pDrawable) {

		final GL2 gl = pDrawable.getGL().getGL2();
		gl.glShadeModel(GL2.GL_SMOOTH);
		gl.glClearColor(0f, 0f, 0f, 0f);
		gl.glClearDepth(1.0f);
		gl.glEnable(GL2.GL_DEPTH_TEST);
		gl.glDepthFunc(GL2.GL_LEQUAL);
		gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST);

		try {	

			for (Class<? extends ITexturableEntity> iClass : _textureMapper.getStringTextureMapping().keySet()) {
				String texturePath = _textureMapper.getTexturePath(iClass);
				if(texturePath != null && !texturePath.isEmpty()){
					File im = new File(texturePath);
					Texture t = TextureIO.newTexture(im, true);
					int textureId = t.getTextureObject(gl);
					_textureMapper.setTextureID(iClass, textureId);
				}
			}

		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (GLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void removeEntity(AbstractEntity pEntity){
		_entities.remove(pEntity);
		pEntity.setX(Integer.MAX_VALUE); // losing the object in the abyss of the game
		pEntity.setY(Integer.MAX_VALUE);
	}
	
	public SceneFactory getSceneFactory(){
		return _sceneFactory;
	}
	
	public TextureMapper getTextureMapper(){
		return _textureMapper;
	}
}
