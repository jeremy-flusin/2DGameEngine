package com.jflusin.engine.entities;

import java.util.HashMap;
import java.util.Map;

public class TextureMapper {

	private Map<Class<? extends ITexturableEntity>, Map<Integer, String>> _textureMapping; 
	
	private Map<Class<? extends ITexturableEntity>, Map<Integer, Integer>> _glTextureMapping;

	public TextureMapper() {
		_textureMapping = new HashMap<Class<? extends ITexturableEntity>, Map<Integer, String>>();
		_glTextureMapping = new HashMap<Class<? extends ITexturableEntity>, Map<Integer, Integer>>();
	}
	
	public void mapTexture(Class<? extends ITexturableEntity> pClass, String pTexturePath, int pTextureId){
		Map<Integer, String> submap = _textureMapping.get(pClass);
		if(submap == null){
			_textureMapping.put(pClass, new HashMap<Integer, String>());
			submap = _textureMapping.get(pClass);
		}
		submap.put(pTextureId, pTexturePath);
	}

	public String getTexturePath(Class<? extends ITexturableEntity> pClass, int pTextureId){
		return _textureMapping.get(pClass).get(pTextureId);
	}
	
//	//TODO if needed
//	public void unmapTexture(Class<? extends ITexturableEntity> pClass){
//		
//	}
	
	public void setGLTextureID(Class<? extends ITexturableEntity> pClass, Integer pTextureId, Integer pGLTextureId){
		Map<Integer, Integer> submap = _glTextureMapping.get(pClass);
		if(submap == null){
			_glTextureMapping.put(pClass, new HashMap<Integer, Integer>());
			submap = _glTextureMapping.get(pClass);
		}
		submap.put(pTextureId, pGLTextureId);
	}

	public int getGLTextureID(Class<? extends ITexturableEntity> pClass, Integer pTextureId){
		return _glTextureMapping.get(pClass).get(pTextureId);
	}
	
	//TODO if needed
//	public void removeTextureID(Class<? extends ITexturableEntity> pClass){
//		_glTextureMapping.remove(pClass);
//	}
	
	public Map<Class<? extends ITexturableEntity>, Map<Integer, String>> getTextureMapping(){
		return _textureMapping;
	}
}