package net.jplugin.machinetest.api.impl;

import net.jplugin.core.kernel.api.PluginEnvirement;
import net.jplugin.machinetest.Plugin;
import net.jplugin.machinetest.api.ITestItem;

public class TestManager {
	public static void init() throws InterruptedException{
		
		ITestItem[] items = PluginEnvirement.getInstance().getExtensionObjects(Plugin.EP_TEST_ITEM,ITestItem.class);
		TestResult[] results = new TestResult[items.length];
		for (int i=0;i<items.length;i++){
			ITestItem item = items[i];
			TestResult result = new TestResult(item);
			results[i] = result;
			
			System.out.println("$$$ 开始测试指标-"+item.getName());
			long t1 = System.currentTimeMillis();
			MulThreadKit mk = new MulThreadKit();
			mk.start(item);
			synchronized (mk) {
				mk.wait();
			}
			
			long dural = System.currentTimeMillis() - t1;
			
			result.setDural(dural);
			result.compute();
		}
		
		//display results
		System.out.println();
		System.out.println();
		
		for (int i=0;i<results.length;i++){
			TestResult result = results[i];
			System.out.println("指标["+result.getName()+"] 得分="+result.getScore()+" 消耗时间="+result.getDural());
		}
	}
}
