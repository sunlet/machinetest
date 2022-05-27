package net.jplugin.machinetest;

import net.jplugin.core.kernel.api.AbstractPlugin;
import net.jplugin.core.kernel.api.Extension;
import net.jplugin.machinetest.api.ITestItem;

public class ExtensionMtHelper {
	public static void addTestItemExtension(AbstractPlugin p,Class c){
		p.addExtension(Extension.create(ITestItem.class.getName(), c));
	}
}
