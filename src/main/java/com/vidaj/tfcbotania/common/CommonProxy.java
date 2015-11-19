package com.vidaj.tfcbotania.common;

import com.bioxx.tfc.api.TFCBlocks;
import com.vidaj.tfcbotania.common.recipes.RecipeManager;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import vazkii.botania.common.lib.LibOreDict;

public class CommonProxy {
	public void registerRecipes() {
		new RecipeManager().setup();
	}
	
	public void registerEventHandlers() {
		
	}
	
	public void registerBlocks() {
		
	}
	
	public void registerEntities() {
	}
	
	public void registerItems() {
	}
	
	public void registerFluids() {
		
	}

	public void registerOreDict() {
		
		
		if (!OreDictionary.doesOreNameExist("chest")) {
			for (int meta = 0; meta < 16; meta++) {
				OreDictionary.registerOre("chest", new ItemStack(TFCBlocks.chest, 1, meta));
			}
		}
	}
	
	public void registerRenderers() {
		
	}
}
