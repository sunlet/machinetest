package net.jplugin.machinetest;

import net.jplugin.core.kernel.api.AbstractPlugin;
import net.jplugin.core.kernel.api.ExtensionPoint;
import net.jplugin.core.kernel.api.PluginAnnotation;
import net.jplugin.core.service.ExtensionServiceHelper;
import net.jplugin.core.service.api.BindService;
import net.jplugin.core.service.api.RefService;
import net.jplugin.machinetest.api.ITestItem;
import net.jplugin.machinetest.service.TestManager;
import net.jplugin.machinetest.extensions.ComputeTest;
import net.jplugin.machinetest.extensions.DiskTest;
import net.jplugin.machinetest.extensions.NewObjectTest;

@PluginAnnotation
public class Plugin extends AbstractPlugin
{
	public static final String EP_TEST_ITEM="EP_TEST_ITEM";
	public Plugin(){
//		this.addExtensionPoint(ExtensionPoint.createList("net.jplugin.machinetest.api.ITestItem", ITestItem.class));
//
//		ExtensionMtHelper.addTestItemExtension(this, ComputeTest.class);
//		ExtensionMtHelper.addTestItemExtension(this, NewObjectTest.class);
//		ExtensionMtHelper.addTestItemExtension(this, DiskTest.class);
//
//		ExtensionServiceHelper.addServiceExtension(this,TestManager.class.getName(),TestManager.class);
	}

	@RefService
	TestManager testManager;
	@Override
	public void init() {
		try {
			testManager.doTest();
		} catch (InterruptedException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public int getPrivority() {
		return 0;
	}
}
