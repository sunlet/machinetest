package net.jplugin.machinetest.extensions;

import java.io.File;
import java.io.FileWriter;

import net.jplugin.common.kits.FileKit;
import net.jplugin.common.kits.UUIDKit;
import net.jplugin.core.kernel.api.BindExtension;
import net.jplugin.core.kernel.api.PluginEnvirement;
import net.jplugin.machinetest.api.ITestItem;

/**
 * 评测磁盘IO能力
 */
@BindExtension
public class DiskTest implements ITestItem {

	public String getName() {
		return "硬盘IO能力";
	}

	public long getBaseDural() {
		return 10000;
	}

	public void run() {
		for (int i=0;i<5;i++)
			testOneTime();
	}

	private void testOneTime() {
		String filename1 = PluginEnvirement.getInstance().getWorkDir()+"/"+UUIDKit.getUUID();
		String filename2 = PluginEnvirement.getInstance().getWorkDir()+"/"+UUIDKit.getUUID();
//		System.out.println(filename1);
//		System.out.println(filename2);
		File f =new File(filename1);
		FileWriter os = null;
		try{
			System.out.println(Thread.currentThread().getName()+" to make file");
			int total = 15000000;
			os = new FileWriter(f);
			for (int i=0;i<total;i++){
				os.write("abcdefg,abcdefg,abcdefg,");
			}
			System.out.println(Thread.currentThread().getName()+" to copy file");
			FileKit.copyFile(filename1, filename2);
			os.close();
			System.out.println(Thread.currentThread().getName()+" to delete file");
			new File(filename1).delete();
			new File(filename2).delete();
		}catch(Exception e){
			try{
				if (os!=null) os.close();
			}catch(Exception th){}
			try{
				new File(filename1).delete();
			}catch(Exception th){}
			try{
				new File(filename2).delete();
			}catch(Exception th){}
			throw new RuntimeException(e);
		}
	}

	public int getThreadNum() {
		return 3;
	}

}
