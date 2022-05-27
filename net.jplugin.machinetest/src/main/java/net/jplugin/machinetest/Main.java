package net.jplugin.machinetest;

import net.jplugin.core.kernel.PluginApp;
import net.jplugin.core.kernel.api.PluginAutoDetect;
import net.jplugin.core.kernel.api.PluginEnvirement;

public class Main {
	public static void main(String[] args) {
		PluginAutoDetect.addAutoDetectPackage("net.jplugin.machinetest");
		PluginApp.main(null);
	}
}
