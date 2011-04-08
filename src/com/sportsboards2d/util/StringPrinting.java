/**
 * 
 */
package com.sportsboards2d.util;

import java.util.List;

import com.sportsboards2d.db.objects.FormationObject;
import com.sportsboards2d.db.objects.PlayerEntry;
import com.sportsboards2d.db.objects.PlayerInfo;
import com.sportsboards2d.db.objects.PlayerObject;

/**
 * Coded by Nathan King
 */

/**
 * Copyright 2011 5807400 Manitoba Inc. All rights reserved.
 */
public class StringPrinting {
	
	
	public static void printAllFormation(List<FormationObject> forms){
		
		for(FormationObject fn:forms){
			System.out.println(fn.getfName());
			System.out.println(fn.getBall().getX() + " " + fn.getBall().getY());
			
			for(PlayerObject p:fn.getPlayers()){
				System.out.println(((PlayerEntry) p).getCoords().getX());
				System.out.println(((PlayerEntry) p).getpID());
			}
			
			System.out.println(fn.getPlayers().size());
		}
	}
	
	public static void printPlayerInfo(PlayerInfo player){
		
		System.out.println("Player name: " + player.getPName());
		System.out.println("Player ID: " + player.getpID());
		System.out.println("Player jersey#: " + player.getjNum());
		System.out.println("Player position: " + player.getType());
	}

}
