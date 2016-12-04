package realization;

import java.lang.*;

public class Entrance {

	static public Window_Console WD_Console;
	private static final boolean T = true,F=false; 

	static final boolean[][] obst_bool1 = {
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, }};
	static final boolean[][] obst_bool2 = {
			{ F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, T, F, F, F, F, },
			{ F, F, F, T, T, T, F, F, F, F, F, T, F, F, F, T, T, F, F, F, F, F, },
			{ F, F, T, T, F, F, T, T, T, F, F, T, F, F, T, F, F, F, T, F, F, F, },
			{ F, F, T, F, F, F, F, F, F, F, T, F, F, T, F, F, F, F, F, T, F, F, },
			{ F, F, T, F, F, F, T, F, F, F, F, T, F, F, F, F, F, F, F, F, T, F, },
			{ F, F, T, T, T, T, T, T, T, F, F, F, F, F, F, F, F, T, T, F, T, F, },
			{ F, F, F, T, F, F, F, F, T, F, F, F, T, T, F, F, T, F, F, F, T, F, },
			{ F, F, F, T, F, F, F, F, T, F, F, T, F, F, T, T, F, F, F, T, F, F, },
			{ F, F, F, T, F, F, F, F, T, F, F, T, F, F, F, F, T, F, F, T, F, F, },
			{ F, F, F, T, F, F, F, F, T, T, T, F, F, F, F, F, T, F, T, F, T, F, },
			{ F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, F, F, T, T, F, F, },
			{ F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, },
			{ F, F, F, T, F, F, F, F, F, F, F, F, F, F, T, T, T, T, F, F, F, F, },
			{ F, F, F, T, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, },
			{ F, F, F, T, F, F, T, T, T, T, T, T, T, F, T, F, F, F, F, F, F, F, },
			{ F, F, F, T, F, F, T, F, F, F, F, F, T, F, T, F, F, F, F, F, F, F, },
			{ F, F, F, T, T, T, T, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, }};
	static final boolean[][] obst_bool3 = {
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, T, T, T, T, T, T, T, T, T, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, T, T, T, T, T, T, T, T, T, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, }};
	static final boolean[][] obst_bool4 = {
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, T, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, T, T, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, T, T, T, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, T, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, T, F, F, T, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, T, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, T, F, F, F, T, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, T, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, T, T, F, T, T, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, T, F, T, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, T, F, F, F, F, T, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, T, F, F, F, F, T, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, T, F, F, F, F, T, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, T, F, F, F, T, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, T, F, F, F, F, T, F, F, F, F, F, F, F, F, F, },
			{ F, T, T, F, F, F, T, F, F, T, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, T, T, F, F, },
			{ F, F, T, F, F, F, T, T, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, T, F, F, F, },
			{ F, T, T, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, T, T, F, F, },
			{ F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, T, F, F, T, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, T, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, T, T, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, T, T, T, F, F, F, F, F, F, F, F, T, F, F, T, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, T, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, T, F, F, F, T, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, T, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, T, F, F, F, F, F, F, T, F, F, F, F, F, T, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, T, T, T, T, T, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, }};
	static final boolean[][] obst_bool5 = {
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, T, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, T, F, F, F, T, T, T, T, T, T, T, T, T, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, T, T, F, F, T, F, T, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, T, F, F, T, T, T, T, T, T, T, T, T, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, T, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, T, T, T, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, T, F, F, F, F, T, F, F, F, T, T, T, T, T, T, T, T, T, F, },
			{ F, F, F, T, F, F, T, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, T, F, F, F, F, F, F, T, F, T, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, T, F, F, F, T, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, T, F, F, F, F, F, F, F, T, F, F, T, F, T, T, T, T, T, T, T, T, },
			{ F, F, F, F, T, T, F, T, T, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, T, F, F, T, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, T, F, T, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, T, T, T, T, T, T, T, T, F, },
			{ F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, T, F, F, F, T, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, T, F, F, F, T, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, T, F, F, F, F, T, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, T, F, F, F, F, T, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, T, F, F, F, F, T, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, T, F, F, F, T, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, T, F, F, F, F, T, F, F, F, F, F, F, F, F, F, },
			{ F, T, T, F, F, F, T, F, F, T, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, T, T, F, F, },
			{ F, F, T, F, F, F, T, T, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, T, F, F, F, },
			{ F, T, T, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, T, T, F, F, },
			{ F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, T, F, F, T, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, T, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, T, T, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, T, T, T, F, F, F, F, F, F, F, F, T, F, F, T, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, T, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, T, F, F, F, T, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, T, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, T, F, F, F, F, F, F, T, F, F, F, F, F, T, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, T, T, T, T, T, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, }};
	static final boolean[][] obst_bool6 = {
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, T, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, T, F, F, F, T, T, T, T, T, T, T, T, T, F, F, T, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, T, T, F, F, T, F, T, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, T, F, F, T, T, T, T, T, T, T, T, T, T, T, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, T, T, T, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, T, F, F, F, F, T, F, F, F, T, T, T, T, T, T, T, T, T, F, F, T, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, T, F, F, T, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, T, F, F, F, F, F, F, T, F, T, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, T, F, F, F, T, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, T, F, F, F, F, F, F, F, T, F, F, T, F, T, T, T, T, T, T, T, T, T, F, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, T, T, F, T, T, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, T, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, T, F, T, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, T, T, T, T, T, T, T, T, T, T, T, T, T, T, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, T, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, T, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, T, F, F, F, F, T, F, F, F, T, T, T, T, T, F, F, F, F, F, F, F, T, F, F, F, F, F, },
			{ F, F, F, F, F, F, T, F, F, F, F, T, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, T, F, F, F, F, T, F, F, T, F, F, F, F, F, T, F, F, F, F, F, F, T, F, F, F, F, F, },
			{ F, F, F, F, F, F, T, F, F, F, T, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, T, F, F, F, F, T, F, F, F, T, F, F, F, F, F, F, T, F, F, F, F, F, T, F, F, F, F, F, },
			{ F, T, T, F, F, F, T, F, F, T, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, T, F, F, F, F, T, F, F, F, T, F, T, T, T, F, F, F, T, F, F, F, F, T, F, F, F, F, F, },
			{ F, F, T, F, F, F, T, T, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, T, F, F, F, F, F, T, F, F, T, F, F, T, F, F, T, F, F, T, F, F, F, F, T, F, F, F, F, F, },
			{ F, T, T, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, T, F, F, F, F, F, T, F, F, T, F, F, T, T, F, F, T, F, T, F, F, F, F, T, F, F, F, F, F, },
			{ F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, T, F, F, F, F, F, F, T, F, F, T, F, F, F, T, F, F, T, F, T, F, F, F, F, T, F, F, F, F, F, },
			{ F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, T, F, F, F, F, F, T, F, F, F, T, F, F, T, F, F, F, T, F, T, F, F, F, F, T, T, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, T, F, F, F, F, F, F, T, F, F, F, T, F, F, T, F, F, T, F, F, T, F, F, F, F, F, T, F, F, F, F, },
			{ F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, T, F, F, F, F, F, F, F, T, F, F, F, T, F, F, T, F, F, T, F, F, T, F, F, F, F, F, T, F, F, F, F, },
			{ F, F, F, F, F, F, T, F, F, T, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, T, F, F, F, F, F, F, F, T, F, F, F, T, F, F, T, F, F, T, T, F, T, F, F, F, F, F, T, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, T, F, F, F, F, F, F, F, F, T, F, F, F, T, F, F, T, F, F, F, F, F, T, F, F, F, F, T, F, F, F, F, F, },
			{ F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, T, F, F, T, F, F, F, T, F, F, F, T, F, F, F, F, F, T, F, F, F, F, F, },
			{ F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, T, F, F, T, F, F, F, F, T, T, T, F, F, F, F, F, F, T, F, F, F, F, F, },
			{ F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, T, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, },
			{ F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, T, T, F, F, F, F, F, F, F, F, F, T, F, T, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, },
			{ F, F, F, F, T, F, F, F, F, F, F, F, T, T, T, F, F, F, F, F, F, F, F, T, F, F, T, F, F, F, F, F, F, F, F, T, F, F, T, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, },
			{ F, F, F, T, F, F, T, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, T, F, F, F, T, F, F, F, F, F, F, F, F, T, F, F, F, T, F, F, F, F, F, F, T, T, T, F, F, F, F, F, F, F, F, },
			{ F, F, F, T, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, T, T, T, T, T, T, T, F, F, T, F, F, F, T, T, T, T, T, T, F, F, F, F, F, F, F, F, F, F, F, },
			{ T, T, T, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, T, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, F, F, F, F, T, F, F, F, T, F, F, F, F, F, F, F, T, F, F, F, F, T, F, F, T, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, T, T, F, F, T, T, F, F, F, F, F, T, F, F, F, F, F, T, F, F, F, F, T, F, F, F, T, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, T, F, F, T, F, F, F, F, F, F, F, F, T, T, T, T, T, F, F, F, F, T, F, F, F, T, T, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, T, F, T, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, F, T, T, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, T, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, },
			{ F, T, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, }};
	public static ObstacleMap Obst1;
	public static ObstacleMap Obst2;
	public static ObstacleMap Obst3;
	public static ObstacleMap Obst4;
	public static ObstacleMap Obst5;
	public static ObstacleMap Obst6;
	
	public static void main(String[] args) {
		Obst1 = new ObstacleMap(obst_bool1,14,22,4,5,11,18);
		Obst2 = new ObstacleMap(obst_bool2,18,22,12,3,12,5);
		Obst3 = new ObstacleMap(obst_bool3,14,22,7,4,12,17);
		Obst4 = new ObstacleMap(obst_bool4,38,44,17,2,17,42);
		Obst5 = new ObstacleMap(obst_bool5,38,44,17,2,17,42);
		Obst6 = new ObstacleMap(obst_bool6,38,57,17,2,17,42);
		System.out.println();
		WD_Console = new Window_Console();
		System.out.println("Debug>> Start to run.");

	}
}
