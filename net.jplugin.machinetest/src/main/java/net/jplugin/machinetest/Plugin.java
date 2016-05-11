package net.jplugin.machinetest;

import net.jplugin.core.kernel.api.AbstractPlugin;
import net.jplugin.core.kernel.api.ExtensionPoint;
import net.jplugin.machinetest.api.ITestItem;
import net.jplugin.machinetest.api.impl.Item1;
import net.jplugin.machinetest.api.impl.TestManager;

/**
 * Hello world!
 *
 */
public class Plugin extends AbstractPlugin
{
	public static final String EP_TEST_ITEM="EP_TEST_ITEM";
	public Plugin(){
		this.addExtensionPoint(ExtensionPoint.create(EP_TEST_ITEM, ITestItem.class));
		ExtensionMtHelper.addTestItemExtension(this, Item1.class);
	}

	public void init() {
		try {
			TestManager.init();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int getPrivority() {
		return 0;
	}
}
