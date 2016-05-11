package net.jplugin.machinetest.api.impl;

import net.jplugin.machinetest.api.ITestItem;

public class TestResult {
	static final int STD_SCORE = 10;
	
	String name;
	long baseDural;
	long dural;
	int score;
	TestResult (ITestItem item){
		this.name = item.getName();
		this.baseDural = item.getBaseDural();
	}
	
	public void compute(){
		 this.score = (int) Math.round(((this.baseDural * STD_SCORE) * 1.0/this.dural));
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getBaseDural() {
		return baseDural;
	}
	public void setBaseDural(long baseDural) {
		this.baseDural = baseDural;
	}
	public long getDural() {
		return dural;
	}
	public void setDural(long dural) {
		this.dural = dural;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
	
}
