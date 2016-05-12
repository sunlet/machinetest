package net.jplugin.machinetest.items;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;

import org.apache.log4j.helpers.FileWatchdog;

import net.jplugin.common.kits.FileKit;
import net.jplugin.common.kits.UUIDKit;
import net.jplugin.core.kernel.api.PluginEnvirement;
import net.jplugin.machinetest.api.ITestItem;

public class DiskTest implements ITestItem {

	public String getName() {
		return "硬盘IO能力";
	}

	public long getBaseDural() {
		return 32579;
	}

	public void run() {
		String filename1 = PluginEnvirement.getInstance().getWorkDir()+"/"+UUIDKit.getUUID();
		String filename2 = PluginEnvirement.getInstance().getWorkDir()+"/"+UUIDKit.getUUID();
		System.out.println(filename1);
		System.out.println(filename2);
		File f =new File(filename1);
		FileWriter os = null;
		try{
			os = new FileWriter(f);
			for (int i=0;i<15000000;i++){
				os.write("abcdefg,abcdefg,abcdefg,");
			}
			FileKit.copyFile(filename1, filename2);
			os.close();
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
