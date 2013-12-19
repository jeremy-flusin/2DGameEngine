package com.jflusin.engine.entities;

import java.util.HashMap;
import java.util.Map;

public class TextureMapper {

	private Map<Class<? extends ITexturableEntity>, String> stringTextureMapping = 
			new HashMap<Class<? extends ITexturableEntity>, String>();
	
	private Map<Class<? extends ITexturableEntity>, Integer> integerTextureMapping = 
			new HashMap<Class<? extends ITexturableEntity>, Integer>();

	public void mapTexture(Class<? extends ITexturableEntity> pClass, String pTexturePath){
		stringTextureMapping.put(pClass, pTexturePath);
	}

	public String getTexturePath(Class<? extends ITexturableEntity> pClass){
		return stringTextureMapping.get(pClass);
	}
	
	public void unmapTexture(Class<? extends ITexturableEntity> pClass){
		stringTextureMapping.remove(pClass);
	}
	
	public void setTextureID(Class<? extends ITexturableEntity> pClass, Integer pTextureID){
		integerTextureMapping.put(pClass, pTextureID);
	}

	public int getTextureID(Class<? extends ITexturableEntity> pClass){
		return integerTextureMapping.get(pClass);
	}
	
	public void removeTextureID(Class<? extends ITexturableEntity> pClass){
		integerTextureMapping.remove(pClass);
	}
	
	public Map<Class<? extends ITexturableEntity>, String> getStringTextureMapping(){
		return stringTextureMapping;
	}
}