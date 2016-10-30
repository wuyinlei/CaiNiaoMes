package com.ruolan.cainiaomes.entity;

import com.google.gson.stream.JsonReader;
import com.ruolan.cainiaomes.net.AppException;


/** 
 * @author Stay  
 * @version create time：Sep 16, 2014 12:47:44 PM 
 */
public abstract class BaseEntity {
	public abstract void readFromJson(JsonReader reader) throws AppException;
}
