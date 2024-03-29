package net.jplugin.machinetest.extensions;

import java.util.HashMap;

import net.jplugin.core.kernel.api.BindExtension;
import net.jplugin.machinetest.api.ITestItem;

/**
 * 评测内存分配能力
 */
@BindExtension
public class NewObjectTest implements ITestItem{

	public String getName() {
		return "内存分配";
	}

	public long getBaseDural() {
		return 16186;
	}

	public void run() {
		HashMap o;
		for (int i=0;i<220;i++){
			for (int j=0;j<1000;j++){
				o=new HashMap();
				for (int k=0;k<100;k++){
					String s = "a"+"b"+"c"+"d"+"e"+"f"+"g";
					o.put(k, s);
				}
			}
		}
	}

	public int getThreadNum() {
		return 200;
	}

}
