package net.jplugin.machinetest.api;

import net.jplugin.core.kernel.api.BindExtensionPoint;
import net.jplugin.core.kernel.api.PointType;

@BindExtensionPoint(type = PointType.LIST)
public interface ITestItem {
	public String getName();
	
	public long getBaseDural();
	
	public void run();
	
	public int getThreadNum();
}
