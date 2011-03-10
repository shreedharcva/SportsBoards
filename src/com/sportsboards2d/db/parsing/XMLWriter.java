package com.sportsboards2d.db.parsing;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

import org.xmlpull.v1.XmlSerializer;

import android.content.Context;
import android.util.Xml;

import com.sportsboards2d.db.Configuration;
import com.sportsboards2d.db.Formation;
import com.sportsboards2d.db.PlayerInfo;

/**
 * Coded by Nathan King
 */

/**
 * Copyright 2011 5807400 Manitoba Inc. All rights reserved.
 */

public class XMLWriter{
	
	public XMLWriter(){}
		
	public String writeFormation(final Context context, Formation fn, String path){
		
		FileOutputStream fOut;
		XmlSerializer serializer = Xml.newSerializer();
	    StringWriter writer = new StringWriter();
	    
	    try {
			fOut = context.openFileOutput(path, Context.MODE_PRIVATE);
			
	    	serializer.setOutput(writer);
	    	serializer.startDocument("UTF-8", true);
	    	serializer.startTag("", "form");
	    	serializer.startTag("", "name");
    		serializer.text(fn.getName());
    		serializer.endTag("", "name");

	    	serializer.startTag("", "ball");
    		serializer.attribute("", "x", String.valueOf(fn.getBall().getX()));
    		serializer.attribute("", "y", String.valueOf(fn.getBall().getY()));
    		serializer.endTag("", "ball");
    		serializer.startTag("", "players");

	    	for(PlayerInfo pInfo:fn.getPlayers()){
	    		serializer.startTag("", "player");
	    		
	    		serializer.startTag("", "team");
	    		serializer.text(pInfo.getTeamColor());
	    		serializer.endTag("", "team");
	    		
	    		serializer.startTag("", "type");
	    		serializer.text(pInfo.getType());
	    		serializer.endTag("", "type");
	    		
	    		serializer.startTag("", "pName");
	    		serializer.text(pInfo.getPlayerName());
	    		serializer.endTag("", "pName");
	    		
	    		serializer.startTag("", "coords");
	    		serializer.attribute("", "x", String.valueOf(pInfo.getX()));
	    		serializer.attribute("", "y", String.valueOf(pInfo.getY()));
	    		serializer.endTag("", "coords");

	    		serializer.endTag("", "player");
	    	}
    		serializer.endTag("", "players");

	    	serializer.endTag("", "form");

	    	serializer.endDocument();
	    	
	    	
	    	
			String str = writer.toString();
			fOut.write(str.getBytes());
			fOut.close();
	        
	        return writer.toString();
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    } 

	}
	
	public String writeConfig(final Context context, Configuration config, String path){
		
		FileOutputStream fOut;
		XmlSerializer serializer = Xml.newSerializer();
	    StringWriter writer = new StringWriter();
	    
	    String playerSize = "false";
	    String load = "false";
	    String line = "false";
	    
	    if(config.isLargePlayers()){
	    	playerSize = "true";
	    }
	    if(config.isLastLoaded()){
	    	load = "true";
	    }
	    if(config.isLineEnabled()){
	    	line = "true";
	    }
	    
	    try {
			fOut = context.openFileOutput(path, Context.MODE_PRIVATE);
			
	    	serializer.setOutput(writer);
	    	serializer.startDocument("UTF-8", true);
	    	
	    	serializer.startTag("", "config");
	    	
	    	serializer.startTag("", "player_size");
	    	serializer.text(playerSize);
	    	serializer.endTag("", "player_size");
	    	
	    	serializer.startTag("", "line_enabled");
	    	serializer.text(line);
	    	serializer.endTag("", "line_enabled");
	    	
	    	serializer.startTag("", "last_loaded");
	    	serializer.text(load);
	    	serializer.endTag("", "last_loaded");
	    	
	    	serializer.startTag("", "default_sport");
	    	serializer.text(config.getDefault_sport());
	    	serializer.endTag("", "default_sport");
	    	
	    	serializer.endTag("", "config");
		
	    	String str = writer.toString();
			fOut.write(str.getBytes());
			fOut.close();
	        
	        return writer.toString();
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    } 

	}
	
	@SuppressWarnings("unused")
	private String convertStreamToString(InputStream input) throws IOException{
		
		if(input != null){
			Writer writer = new StringWriter();
			
			char[]buffer = new char[1024];
			
			try{
				Reader reader = new BufferedReader(new InputStreamReader(input, "UTF-8"));
				int n;
				while((n = reader.read(buffer)) != -1){
					writer.write(buffer, 0, n);
				}
			}finally{
				input.close();
			}
			return writer.toString();
		}
		else{
			return "";
		}
	}
	
}