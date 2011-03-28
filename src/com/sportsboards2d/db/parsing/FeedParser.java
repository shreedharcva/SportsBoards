package com.sportsboards2d.db.parsing;

import java.io.InputStream;
import java.util.List;

import com.sportsboards2d.db.objects.Configuration;
import com.sportsboards2d.db.objects.FormationEntry;

/**
 * Coded by Nathan King
 */

/**
 * Copyright 2011 5807400 Manitoba Inc. All rights reserved.
 */

public interface FeedParser{
	List<FormationEntry> parseFormation(InputStream input);
	Configuration parseConfig(InputStream input);
}