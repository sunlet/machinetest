package net.jplugin.machinetest.kits;

import net.jplugin.machinetest.api.ITestItem;

public class MulThreadKit {

	int count;

	class TestRunnable implements Runnable {
		ITestItem item;

		public void run() {
			item.run();
			
			synchronized (MulThreadKit.this) {
				count --;
				System.out.println(item.getName() + " 还剩余 " + count + " 个线程");
				if (count == 0) {
					MulThreadKit.this.notify();
				}
			}
		}

	}

	public void start(ITestItem item) {
		TestRunnable[] runnables = new TestRunnable[item.getThreadNum()];

		for (int i = 0; i < item.getThreadNum(); i++) {
			runnables[i] = new TestRunnable();
			runnables[i].item = item;
		}

		count = runnables.length;

		for (TestRunnable r : runnables) {
			new Thread(r).start();
		}
	}

}
