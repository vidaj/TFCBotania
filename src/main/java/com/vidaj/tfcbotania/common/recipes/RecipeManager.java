package com.vidaj.tfcbotania.common.recipes;

import com.bioxx.tfc.api.TFCBlocks;
import com.bioxx.tfc.api.TFCItems;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.recipe.RecipeManaInfusion;
import vazkii.botania.api.recipe.RecipeRuneAltar;
import vazkii.botania.common.block.ModBlocks;
import vazkii.botania.common.block.ModFluffBlocks;
import vazkii.botania.common.item.ModItems;
import vazkii.botania.common.lib.LibOreDict;

public class RecipeManager {

	private static final int TIER1_MANA_COST = 8500;
	private static final int TIER2_MANA_COST = 4000;
	
	public void setup() {
		addTroddenDirt();
		addPetalApothecary();
		addFloralFertilizer();
		addReedBlock();
		addPortuguesePavement();
		addManaLenses();
		addFireCharge();
		addNetherbrick();
		
		addRunes();
		addSoujournerSash();
		addTectonicGirdle();
		addRingOfChordata();
		addRodOfTheHells();
		addSpark();
		addManaseerMonocle();
		addAlchemyCatalyst();
	}

	private void addAlchemyCatalyst() {
		RecipeBuilder.shaped(ModBlocks.alchemyCatalyst)
		.pattern("SGS", "GPG", "SGS")
		.define('S', LibOreDict.LIVING_ROCK)
		.define('G', "ingotGold")
		.define('P', LibOreDict.MANA_PEARL)
		.register();
	}

	private void addManaseerMonocle() {
		RecipeBuilder.shaped(ModItems.monocle)
		.pattern("GN ", "IN ", " N ")
		.define('G', new ItemStack(ModBlocks.manaGlass))
		.define('I', LibOreDict.MANA_STEEL)
		.define('N', "oreNormalGold")
		.register();
		
		RecipeBuilder.shaped(ModItems.monocle)
		.pattern("GN ", "IN ", " N ")
		.define('G', new ItemStack(ModBlocks.manaGlass))
		.define('I', LibOreDict.MANA_STEEL)
		.define('N', "oreRichGold")
		.register();
		
		RecipeBuilder.shaped(ModItems.monocle)
		.pattern("GN ", "IN ", " N ")
		.define('G', new ItemStack(ModBlocks.manaGlass))
		.define('I', LibOreDict.MANA_STEEL)
		.define('N', "orePoorGold")
		.register();
	}

	private void addSpark() {
		for(int i = 0; i < 16; i++) {
			RecipeBuilder.shaped(ModItems.spark)
			.pattern(" P ", "BNB", " P ")
			.define('P', LibOreDict.MANA_PETAL[i])
			.define('B', "dustSulfur")
			.define('N', "oreNormalGold")
			.register();
		}
		
		for(int i = 0; i < 16; i++) {
			RecipeBuilder.shaped(ModItems.spark)
			.pattern(" P ", "BNB", " P ")
			.define('P', LibOreDict.MANA_PETAL[i])
			.define('B', "dustSulfur")
			.define('N', "oreRichGold")
			.register();
		}
		
		for(int i = 0; i < 16; i++) {
			RecipeBuilder.shaped(ModItems.spark)
			.pattern(" P ", "BNB", " P ")
			.define('P', LibOreDict.MANA_PETAL[i])
			.define('B', "dustSulfur")
			.define('N', "orePoorGold")
			.register();
		}
	}

	private void addRodOfTheHells() {
		RecipeBuilder.shaped(ModItems.fireRod)
		.pattern("  F", " T ", "R  ")
		.define('F', "dustSulfur")
		.define('T', LibOreDict.LIVINGWOOD_TWIG)
		.define('R', LibOreDict.RUNE[1])
		.register();
	}

	private void addRingOfChordata() {		
		RecipeBuilder.shaped(new ItemStack(ModItems.waterRing))
		.pattern("WMF", "M M", "FM ")
		.define('W', LibOreDict.RUNE[0])
		.define('M', LibOreDict.MANA_STEEL)
		.define('F', new ItemStack(TFCItems.fishingRod))
		.register();
	}

	private void addTectonicGirdle() {
		RecipeBuilder.shaped(new ItemStack(ModItems.knockbackBelt))
		.pattern("AL ",  "L L", "SLE")
		.define('E', LibOreDict.RUNE[2])
		.define('A', LibOreDict.RUNE[1])
		.define('S', LibOreDict.MANA_STEEL)
		.define('L', "materialLeather")
		.register();
	}

	private void addSoujournerSash() {
		RecipeBuilder.shaped(new ItemStack(ModItems.travelBelt))
		.pattern("EL ",  "L L", "SLA")
		.define('E', LibOreDict.RUNE[2])
		.define('A', LibOreDict.RUNE[3])
		.define('S', LibOreDict.MANA_STEEL)
		.define('L', "materialLeather")
		.register();
	}

	private void addRunes() {
		addFireRune();
		addWaterRune();
		addAirRune();
		addSpringRune();
		addSummerRune();
		addWinterRune();
	}

	private void addFireRune() {
		ItemStack output = new ItemStack(ModItems.rune, 3, 1);
		Object[] inputs = new Object[] {
				"dustSulfur",
				new ItemStack(Items.gunpowder),
				new ItemStack(Items.netherbrick),
				LibOreDict.MANA_STEEL,
				LibOreDict.MANA_STEEL,
				LibOreDict.MANA_STEEL
		};
		
		BotaniaAPI.runeAltarRecipes.add(new RecipeRuneAltar(output, TIER1_MANA_COST, inputs));
	}
	
	private void addWaterRune() {
		ItemStack output = new ItemStack(ModItems.rune, 3);
		Object[] inputs = new Object[] {
				"itemReed",
				new ItemStack(TFCItems.fishingRod),
				"dyeWhite",
				LibOreDict.MANA_STEEL,
				LibOreDict.MANA_STEEL,
				LibOreDict.MANA_STEEL
		};
		
		BotaniaAPI.runeAltarRecipes.add(new RecipeRuneAltar(output, TIER1_MANA_COST, inputs));
	}
	
	private void addAirRune() {
		ItemStack output = new ItemStack(ModItems.rune, 3, 3);
		Object[] inputs = new Object[] {
				new ItemStack(Items.feather),
				new ItemStack(Items.string),
				"materialCloth",
				LibOreDict.MANA_STEEL,
				LibOreDict.MANA_STEEL,
				LibOreDict.MANA_STEEL
		};
		
		BotaniaAPI.runeAltarRecipes.add(new RecipeRuneAltar(output, TIER1_MANA_COST, inputs));
	}
	
	private void addSpringRune() {
		ItemStack output = new ItemStack(ModItems.rune, 1, 4);
		Object[] inputs = new Object[] {
				"seedBag",
				"treeSapling", 
				"treeSapling", 
				"treeSapling",
				LibOreDict.RUNE[0], 
				LibOreDict.RUNE[1]
		};
		
		BotaniaAPI.runeAltarRecipes.add(new RecipeRuneAltar(output, TIER2_MANA_COST, inputs));
	}
	
	private void addSummerRune() {
		ItemStack output = new ItemStack(ModItems.rune, 1, 5);
		Object[] inputs = new Object[] {
				"dyeGreen",
				new ItemStack(TFCBlocks.pumpkin), 
				"blockSand", 
				"blockSand",
				LibOreDict.RUNE[2], 
				LibOreDict.RUNE[3]
		};
		
		BotaniaAPI.runeAltarRecipes.add(new RecipeRuneAltar(output, TIER2_MANA_COST, inputs));
	}
	
	private void addWinterRune() {
		ItemStack output = new ItemStack(ModItems.rune, 1, 7);
		Object[] inputs = new Object[] {
				"dyeWhite",
				"materialCloth",
				new ItemStack(Blocks.snow), 
				new ItemStack(Blocks.snow),
				LibOreDict.RUNE[0], 
				LibOreDict.RUNE[2]
		};
		
		BotaniaAPI.runeAltarRecipes.add(new RecipeRuneAltar(output, TIER2_MANA_COST, inputs));
	}

	private void addNetherbrick() {
		ItemStack input = new ItemStack(TFCItems.fireBrick, 1, 1);
		ItemStack output = new ItemStack(Items.netherbrick, 1);
		int manacost = 100;
		
		BotaniaAPI.manaInfusionRecipes.add(new RecipeManaInfusion(input, output, manacost));
	}

	private void addFireCharge() {
		RecipeBuilder.shapeless(Items.fire_charge, 3)
		.using("gemCharcoal")
		.using("dustSulfur")
		.using(Items.gunpowder)
		.register();
		
		RecipeBuilder.shapeless(Items.fire_charge, 3)
		.using("gemCoal")
		.using("dustSulfur")
		.using(Items.gunpowder)
		.register();
	}

	private void addManaLenses() {
		RecipeBuilder.shaped(ModItems.lens, 1, 14)
		.pattern(" E ", "WLW", " E ")
		.define('E', LibOreDict.ELEMENTIUM)
		.define('W', "materialCloth")
		.define('L', ModItems.lens)
		.register();
	}

	private void addPortuguesePavement() {
		RecipeBuilder.shapeless(ModFluffBlocks.pavement, 3, 1)
		.using(ModBlocks.livingrock)
		.using("blockGravel")
		.using("cobblestone")
		.using("gemCoal").register();
		
		RecipeBuilder.shapeless(ModFluffBlocks.pavement, 3, 1)
		.using(ModBlocks.livingrock)
		.using("blockGravel")
		.using("cobblestone")
		.using("gemCharcoal").register();
		
		RecipeBuilder.shapeless(ModFluffBlocks.pavement, 3, 1)
		.using(ModBlocks.livingrock)
		.using("blockGravel")
		.using("cobblestone")
		.using("dyeBlack").register();
		
		RecipeBuilder.shapeless(ModFluffBlocks.pavement, 3, 2)
		.using(ModBlocks.livingrock)
		.using("blockGravel")
		.using("cobblestone")
		.using("dyeBlue").register();
		
		RecipeBuilder.shapeless(ModFluffBlocks.pavement, 3, 3)
		.using(ModBlocks.livingrock)
		.using("blockGravel")
		.using("cobblestone")
		.using("dyeRed").register();
		
		RecipeBuilder.shapeless(ModFluffBlocks.pavement, 3, 4)
		.using(ModBlocks.livingrock)
		.using("blockGravel")
		.using("cobblestone")
		.using("dyeYellow").register();
		
		RecipeBuilder.shapeless(ModFluffBlocks.pavement, 3, 5)
		.using(ModBlocks.livingrock)
		.using("blockGravel")
		.using("cobblestone")
		.using("dyeGreen").register();
	}

	private void addReedBlock() {
		RecipeBuilder.shaped(ModBlocks.reedBlock)
		.pattern("RRR", "RRR", "RRR")
		.define('R', "itemReed")
		.register();
	}

	private void addFloralFertilizer() {
		RecipeBuilder.shaped(ModItems.fertilizer)
		.pattern("WY ", "YR ", "R  ")
		.define('W', "dyeWhite")
		.define('Y', "dyeYellow")
		.define('R', "dyeRed")
		.register();
	}

	private void addPetalApothecary() {
		for (int meta = 0; meta < 16; meta++) {
			RecipeBuilder.shaped(ModBlocks.altar)
			.pattern("SPS", " C ", "CCC")
			.define('S', "itemRock")
			.define('P', LibOreDict.PETAL[meta])
			.define('C', "cobblestone")
			.register();
		}
	}

	private void addTroddenDirt() {
		RecipeBuilder.shapeless(ModBlocks.dirtPath, 4)
		.using("blockDirt", 3)
		.using("blockSand")
		.register();
	}
}
