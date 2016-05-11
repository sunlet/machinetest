package net.jplugin.machinetest;

import net.jplugin.core.kernel.api.AbstractPlugin;
import net.jplugin.core.kernel.api.Extension;

public class ExtensionMtHelper {
	public static void addTestItemExtension(AbstractPlugin p,Class c){
		p.addExtension(Extension.create(Plugin.EP_TEST_ITEM, c));
	}
}
