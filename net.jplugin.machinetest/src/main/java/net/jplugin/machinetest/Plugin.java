package net.jplugin.machinetest;

import net.jplugin.core.kernel.api.AbstractPlugin;
import net.jplugin.core.kernel.api.PluginAnnotation;
import net.jplugin.core.service.api.RefService;
import net.jplugin.machinetest.service.TestManager;

@PluginAnnotation
public class Plugin extends AbstractPlugin
{
	public static final String EP_TEST_ITEM="EP_TEST_ITEM";
	public Plugin(){
		/* 本项目通过标注实现，以下5行代码分别有四个类级别标注(一个BindExtensionPoint，三个BindExtension，一个BindService)替代了，
		也可以不使用标注，同时取消以下代码注释，效果一样。

		this.addExtensionPoint(ExtensionPoint.createList("net.jplugin.machinetest.api.ITestItem", ITestItem.class));

		ExtensionMtHelper.addTestItemExtension(this, ComputeTest.class);
		ExtensionMtHelper.addTestItemExtension(this, NewObjectTest.class);
		ExtensionMtHelper.addTestItemExtension(this, DiskTest.class);

		ExtensionServiceHelper.addServiceExtension(this,TestManager.class.getName(),TestManager.class);
		*/

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
