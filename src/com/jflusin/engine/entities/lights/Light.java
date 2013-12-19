package  com.jflusin.engine.entities.lights;

import java.awt.Color;
import java.awt.event.KeyEvent;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;

import com.jflusin.engine.entities.AbstractEntity;
import com.jflusin.engine.scenes.AbstractScene;

public class Light extends AbstractEntity {

	int _radius;
	int _precision = 350;
	Color _color;
	AbstractEntity linkedEntity = null;
	
	public Light(int pX, int pY, int pRadius, Color pColor,
			AbstractScene pScene) {
		super(pX, pY, pRadius, pRadius, pScene);
		_radius = pRadius;
		_color = pColor;
	}

	@Override
	public void draw(GLAutoDrawable pDrawable) {
		GL2 gl = pDrawable.getGL().getGL2();
		
		gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE);
		gl.glDisable(GL2.GL_DEPTH_TEST);
		gl.glEnable(GL2.GL_BLEND);
		
		gl.glEnable(GL2.GL_POINT_SMOOTH);
		gl.glHint(GL2.GL_POINT_SMOOTH_HINT, GL2.GL_NICEST);
		
		for(int i = 0; i < _precision; i++){
			float alpha = 0.5f - (float)0.5f/_precision * (float)i;
			gl.glColor4f((float)_color.getRed()/255,
					(float)_color.getGreen()/255,
					(float)_color.getBlue()/255,
					alpha);
			drawCircle((double)_radius/_precision * i, gl);
		}
		gl.glDisable(GL2.GL_BLEND);
	}

	@Override
	public void update() {
		if(_scene.getSceneFactory().getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_D)){
			setX(getX()+5);
		}
		if(_scene.getSceneFactory().getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_Q)){
			setX(getX()-5);
		}
		if(_scene.getSceneFactory().getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_ADD)){
			_precision++;
		}
		if(_scene.getSceneFactory().getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_ENTER)){
			_precision--;
		}
		
	}

	void drawCircle(double pseudoRadius, GL2 gl)
	{
	   gl.glBegin(GL2.GL_LINE_LOOP);
	 
	   for (int i=0; i < 360; i++)
	   {
	      float degInRad = (float)i * (float)(Math.PI/180);
	      gl.glVertex2d(getX()+ Math.cos(degInRad)*pseudoRadius, getY() + Math.sin(degInRad)*pseudoRadius);
	   }
	 
	   gl.glEnd();
	}
	
	@Override
	public int getX() {
		if(linkedEntity != null){
			return linkedEntity.getX() + linkedEntity.getWidth()/2;
		}else{
			return super.getX();
		}
	}
	
	@Override
	public int getY() {
		if(linkedEntity != null){
			return linkedEntity.getY() + linkedEntity.getHeight()/2;
		}else{
			return super.getY();
		}
	}
	
	
	public void linkToEntity(AbstractEntity pEntity){
		linkedEntity = pEntity;
	}
	
	public void setRadius(int pRadius){
		_radius = pRadius;
	}
	
	public int getRadius(){
		return _radius;
	}
}
