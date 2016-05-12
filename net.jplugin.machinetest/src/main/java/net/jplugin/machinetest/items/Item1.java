package net.jplugin.machinetest.items;

import net.jplugin.machinetest.api.ITestItem;

public class Item1 implements ITestItem {

	public String getName() {
		return "测试";
	}

	public long getBaseDural() {
		return 10000;
	}

	public void run() {
		try {
			Thread.sleep(6000);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	public int getThreadNum() {
		return 5;
	}

}
