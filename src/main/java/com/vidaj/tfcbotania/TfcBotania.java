package com.vidaj.tfcbotania;

import com.vidaj.tfcbotania.common.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import vazkii.botania.api.BotaniaAPI;

@Mod(modid = Constants.ModId, version=Constants.Version, dependencies=Constants.Dependencies)
public class TfcBotania {
	@SidedProxy(clientSide="com.vidaj.tfcbotania.client.ClientProxy", serverSide="com.vidaj.tfcbotania.common.CommonProxy")
	public static CommonProxy proxy;
	
	@Instance
	public static TfcBotania instance;

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.registerOreDict();
		proxy.registerRecipes();
		proxy.registerEventHandlers();
		proxy.registerRenderers();
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.registerFluids();
		proxy.registerBlocks();
		proxy.registerItems();
		proxy.registerEntities();
	}
}
