package net.jplugin.machinetest.extensions;

import net.jplugin.core.kernel.api.BindExtension;
import net.jplugin.machinetest.api.ITestItem;

/**
 * 评测CPU计算能力
 */
@BindExtension
public class ComputeTest implements ITestItem{

	public String getName() {
		return "计算能力";
	}

	public long getBaseDural() {
		return 14779;
	}

	public void run() {
		long l=0;
		for (int i=0;i<100000;i++){
			for (int j=0;j<100000;j++){
				for (int k=0;k<100000;k++){
					l=l+1;
					l=l-1;
					l=l*1;
					l=l/1;
				}
			}
		}
	}

	public int getThreadNum() {
		return 10;
	}
	
	
}
