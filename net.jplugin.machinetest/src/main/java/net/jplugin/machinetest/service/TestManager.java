package net.jplugin.machinetest.service;

import net.jplugin.core.kernel.api.Initializable;
import net.jplugin.core.kernel.api.PluginEnvirement;
import net.jplugin.core.kernel.api.RefExtensions;
import net.jplugin.core.service.api.BindService;
import net.jplugin.machinetest.Plugin;
import net.jplugin.machinetest.api.ITestItem;
import net.jplugin.machinetest.api.TestResult;
import net.jplugin.machinetest.kits.MulThreadKit;

import java.util.List;

@BindService
public class TestManager{

	@RefExtensions
	List<ITestItem> items;

	public void doTest() throws InterruptedException {

//		ITestItem[] items = PluginEnvirement.getInstance().getExtensionObjects("net.jplugin.machinetest.api.ITestItem",ITestItem.class);
		TestResult[] results = new TestResult[items.size()];
		for (int i=0;i<items.size();i++){
			ITestItem item = items.get(i);
			TestResult result = new TestResult(item);
			results[i] = result;

			System.out.println("$$$ 开始测试指标-"+item.getName());
			System.gc();
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
			System.out.println("指标["+result.getName()+"] 得分="+result.getScore()+" 消耗时间="+result.getDural()+" 毫秒");
		}
	}
}
