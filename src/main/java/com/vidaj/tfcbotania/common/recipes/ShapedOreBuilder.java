package com.vidaj.tfcbotania.common.recipes;

import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class ShapedOreBuilder {
	private ItemStack toCreate;
	
	private String[] pattern;
	
	private List<Object> definitions = new ArrayList<Object>();
	
	public ShapedOreBuilder(ItemStack toCreate) {
		this.toCreate = toCreate;
	}
	
	public ShapedOreBuilder pattern(String first, String second, String third) {
		pattern = new String[] { first, second, third };
		
		return this;
	}
	
	public ShapedOreBuilder pattern(String first, String second) {
		pattern = new String[] { first, second };
		
		return this;
	}
	
	public ShapedOreBuilder define(char code, String oredictName) {
		definitions.add(code);
		definitions.add(oredictName);
		
		return this;
	}
	
	public ShapedOreBuilder define(char code, Item item) {
		definitions.add(code);
		definitions.add(new ItemStack(item, 1));
		
		return this;
	}
	
	public ShapedOreBuilder define(char code, Block block) {
		definitions.add(code);
		definitions.add(new ItemStack(block, 1));
		
		return this;
	}
	
	public ShapedOreBuilder define(char code, ItemStack itemstack) {
		definitions.add(code);
		definitions.add(itemstack);
		
		return this;
	}
	
	public void register() {
		List<Object> params = new ArrayList<Object>();
		
		for(String patternline : pattern) {
			params.add(patternline);
		}
		
		params.addAll(definitions);
		
		GameRegistry.addRecipe(new ShapedOreRecipe(toCreate, params.toArray()));
	}
}
