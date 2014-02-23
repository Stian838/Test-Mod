package stian838.testmod.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class TestModCommonProxy implements IGuiHandler{ //THIS IS IMPORTANT, CANNOT BE A PROXY/GUI HANDLER WITHOUT THIS!!
	
	public void registerRenderInformation() { //Client side texture registering
	}
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) { //For GUI's
		return null;
	}
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) { //For GUI's
		return null;
	}
	
	public void registerTiles() { //For registering TileEntities
	}
	
	public void registerBlocks() { //For registering Blocks
		
		//Limestone
		GameRegistry.registerBlock(TestMod.Limestone, "Limestone"); //Needed for all blocks
		LanguageRegistry.addName(TestMod.Limestone, "Limestone Block"); //In-game name
		GameRegistry.addRecipe(new ItemStack(TestMod.Limestone), "   ", " AA", " AA", Character.valueOf('A'), TestMod.Lime);
		GameRegistry.addSmelting(TestMod.Limestone.blockID, new ItemStack(TestMod.Lime), 0.1F);
		
		//Brynjar
		GameRegistry.registerBlock(TestMod.Brynjar, "Brynjar");
		LanguageRegistry.addName(TestMod.Brynjar, "Bryjar Ore");
		GameRegistry.addSmelting(TestMod.Brynjar.blockID, new ItemStack(TestMod.brynjarBar), 1.0F);
		
		
	}
	
	public void registerItems() { //For registering Items
		//Lime
		LanguageRegistry.addName(TestMod.Lime, "Lime");
		GameRegistry.addRecipe(new ItemStack(TestMod.Lime), "  ", " D ", "  ", Character.valueOf('D'), Item.appleRed);

		//Brynjar Bar
		LanguageRegistry.addName(TestMod.brynjarBar, "Brynjar Bar");
		
		//Brynjar Chest
		LanguageRegistry.addName(TestMod.brynjarChest, "Brynjar Chestplate");
		GameRegistry.addRecipe(new ItemStack(TestMod.brynjarChest), "A A", "AAA", "AAA", Character.valueOf('A'), TestMod.brynjarBar);
		
		LanguageRegistry.addName(TestMod.brynjarHead, "Brynjar Helmet");
		GameRegistry.addRecipe(new ItemStack(TestMod.brynjarChest), "AAA", "A A", "  ", Character.valueOf('A'), TestMod.brynjarBar);

		LanguageRegistry.addName(TestMod.brynjarFoot, "Brynjar Shoes");
		GameRegistry.addRecipe(new ItemStack(TestMod.brynjarChest), "   ", "A A", "A  A", Character.valueOf('A'), TestMod.brynjarBar);
		
		LanguageRegistry.addName(TestMod.brynjarLeg, "Brynjar Legs");
		GameRegistry.addRecipe(new ItemStack(TestMod.brynjarChest), "AAA", "A A", "A A", Character.valueOf('A'), TestMod.brynjarBar);
	}
}