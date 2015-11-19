package com.vidaj.tfcbotania.common.recipes;

import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class ShapelessOreBuilder {

	private final ItemStack toCreate;
	
	private final List<Object> items;
	
	public ShapelessOreBuilder(ItemStack toCreate) {
		this.toCreate = toCreate;
		this.items = new ArrayList<Object>();
	}
	
	public ShapelessOreBuilder using(String oredictName) {
		items.add(oredictName);
		return this;
	}
	
	public ShapelessOreBuilder using(String oredictName, int multiplier) {
		for (int i = 0; i < multiplier; i++) {
			items.add(oredictName);
		}
		
		return this;
	}
	
	public ShapelessOreBuilder using(Item item) {
		items.add(new ItemStack(item, 1));
		
		return this;
	}
	
	public ShapelessOreBuilder using(Item item, int meta) {
		items.add(new ItemStack(item, 1, meta));
		
		return this;
	}
	
	public ShapelessOreBuilder using(Block block) {
		items.add(new ItemStack(block, 1));
		
		return this;
	}
	
	public ShapelessOreBuilder using(Block block, int meta) {
		items.add(new ItemStack(block, 1, meta));
		
		return this;
	}
	
	public ShapelessOreBuilder using(ItemStack itemStack) {
		items.add(itemStack);
		
		return this;
	}
	
	public void register() {
		GameRegistry.addRecipe(new ShapelessOreRecipe(toCreate, items.toArray()));
	}
}
