package com.jflusin.engine.entities.lights;

import java.awt.Color;
import java.awt.event.KeyEvent;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;

import com.jflusin.engine.entities.AbstractEntity;
import com.jflusin.engine.scenes.AbstractScene;

public class Light extends AbstractEntity {

	int _radius;
	int _precision = 10000;
	float _opacity = 0.1f;
	Color _color;
	AbstractEntity _linkedEntity = null;

	public Light(int pX, int pY, int pRadius, float pOpacity, Color pColor,
			AbstractScene pScene) {
		super(pX, pY, pRadius, pRadius, pScene);
		_radius = pRadius;
		_color = pColor;
		_opacity = pOpacity;
	}

	@Override
	public void draw(GLAutoDrawable pDrawable) {
		GL2 gl = pDrawable.getGL().getGL2();

		gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE);
		gl.glDisable(GL2.GL_DEPTH_TEST);
		gl.glEnable(GL2.GL_BLEND);

		gl.glEnable(GL2.GL_POINT_SMOOTH);
		gl.glHint(GL2.GL_POINT_SMOOTH_HINT, GL2.GL_NICEST);
		gl.glShadeModel(GL2.GL_SMOOTH);
        float incr = (float) (2 * Math.PI / _precision);

        gl.glBegin(GL2.GL_TRIANGLE_FAN);

			 gl.glColor4f((float)_color.getRed()/255,
			 (float)_color.getGreen()/255,
			 (float)_color.getBlue()/255,
			 _opacity);
              gl.glVertex2f(getX(), getY());

 			 gl.glColor4f((float)_color.getRed()/255,
 					 (float)_color.getGreen()/255,
 					 (float)_color.getBlue()/255,
 					 0);

              for(int i = 0; i < _precision; i++)
              {
                    float angle = incr * i;

                    float x = getX()+ (float) Math.cos(angle) * _radius;
                    float y = getY()+(float) Math.sin(angle) * _radius;

                    gl.glVertex2f(x, y);
              }

              gl.glVertex2f(_radius, getY());

        gl.glEnd();
		gl.glDisable(GL2.GL_BLEND);
	}

	@Override
	public void update() {
		if (_scene.getSceneFactory().getGame().getKeyboardListener()
				.isKeyPressed(KeyEvent.VK_ADD)) {
			_opacity+= 0.05f;
		}
		if (_scene.getSceneFactory().getGame().getKeyboardListener()
				.isKeyPressed(KeyEvent.VK_ENTER)) {
			_opacity-= 0.05f;
		}

	}

	void drawCircle(GL2 gl) {

		gl.glShadeModel(GL2.GL_SMOOTH);
		gl.glBegin(GL2.GL_POLYGON);
		for (int i = 0; i < 628; i++) {
			float degInRad = (float) i / 100;
			float realOpacity = _opacity * 100;
			gl.glColor4f((float) _color.getRed() / 255,
					(float) _color.getGreen() / 255,
					(float) _color.getBlue() / 255, realOpacity);
			 gl.glVertex2d(getX(), getY());
//			 gl.glColor4f((float)_color.getRed()/255,
//			 (float)_color.getGreen()/255,
//			 (float)_color.getBlue()/255,
//			 0);
			gl.glVertex2d(getX() + Math.cos(degInRad) * _radius,
					getY() + Math.sin(degInRad) * _radius);
		}
		gl.glEnd();
	}

	@Override
	public int getX() {
		if (_linkedEntity != null) {
			return _linkedEntity.getX() + _linkedEntity.getWidth() / 2;
		} else {
			return super.getX();
		}
	}

	@Override
	public int getY() {
		if (_linkedEntity != null) {
			return _linkedEntity.getY() + _linkedEntity.getHeight() / 2;
		} else {
			return super.getY();
		}
	}

	public void linkToEntity(AbstractEntity pEntity) {
		_linkedEntity = pEntity;
	}

	public void setRadius(int pRadius) {
		_radius = pRadius;
	}

	public int getRadius() {
		return _radius;
	}
}
