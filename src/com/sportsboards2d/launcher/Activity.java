package com.sportsboards2d.launcher;

import org.anddev.andengine.ui.activity.BaseGameActivity;

import com.sportsboards2d.R;
import com.sportsboards2d.boards.BBallBoard;
import com.sportsboards2d.boards.SoccerBoard;

/**
 * Coded by Nathan King
 */

/**
 * Copyright 2011 5807400 Manitoba Inc. All rights reserved.
 */

enum Activity{

	/*
	 * List of Activities (aka sports)
	 */
	
	SOCCER(SoccerBoard.class, R.string.soccer_string),
	//FOOTBALL(FootBallBoard.class, R.string.football_string),
	BBALL(BBallBoard.class, R.string.basketball_string);
	//XMLPARSETEST(XMLParseTest.class, R.string.xmltest_string);

	public final Class<? extends BaseGameActivity> Class;
	public final int id;
	
	private Activity(final Class<? extends BaseGameActivity> pActClass, final int pName){
		this.Class = pActClass;
		this.id = pName;
	}
	
}
