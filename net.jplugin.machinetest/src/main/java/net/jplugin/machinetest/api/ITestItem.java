package net.jplugin.machinetest.api;

public interface ITestItem {
	public String getName();
	
	public long getBaseDural();
	
	public void run();
	
	public int getThreadNum();
}
