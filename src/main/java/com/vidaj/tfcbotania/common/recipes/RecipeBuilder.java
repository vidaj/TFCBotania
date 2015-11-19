package com.vidaj.tfcbotania.common.recipes;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RecipeBuilder {
	
	public static ShapedOreBuilder shaped(Block block) {
		return shaped(block, 1);
	}
	
	public static ShapedOreBuilder shaped(Block block, int amount) {
		return new ShapedOreBuilder(new ItemStack(block, amount));
	}
	
	public static ShapedOreBuilder shaped(Block block, int amount, int meta) {
		return new ShapedOreBuilder(new ItemStack(block, amount, meta));
	}
	
	public static ShapedOreBuilder shaped(Item item) {
		return shaped(item, 1);
	}
	
	public static ShapedOreBuilder shaped(Item item, int amount) {
		return new ShapedOreBuilder(new ItemStack(item, amount));
	}
	
	public static ShapedOreBuilder shaped(Item item, int amount, int meta) {
		return new ShapedOreBuilder(new ItemStack(item, amount, meta));
	}
	
	public static ShapedOreBuilder shaped(ItemStack itemStack) {
		return new ShapedOreBuilder(itemStack);
	}
	
	public static ShapelessOreBuilder shapeless(ItemStack itemStack) {
		return new ShapelessOreBuilder(itemStack);
	}
	
	public static ShapelessOreBuilder shapeless(Item item) {
		return new ShapelessOreBuilder(new ItemStack(item, 1));
	}
	
	public static ShapelessOreBuilder shapeless(Item item, int amount) {
		return new ShapelessOreBuilder(new ItemStack(item, amount));
	}
	
	public static ShapelessOreBuilder shapeless(Item item, int amount, int meta) {
		return new ShapelessOreBuilder(new ItemStack(item, amount, meta));
	}
	
	public static ShapelessOreBuilder shapeless(Block block) {
		return new ShapelessOreBuilder(new ItemStack(block, 1));
	}
	
	public static ShapelessOreBuilder shapeless(Block block, int amount) {
		return new ShapelessOreBuilder(new ItemStack(block, amount));
	}
	
	public static ShapelessOreBuilder shapeless(Block block, int amount, int meta) {
		return new ShapelessOreBuilder(new ItemStack(block, amount, meta));
	}
}
