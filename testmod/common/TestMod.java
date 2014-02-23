package stian838.testmod.common;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import stian838.testmod.common.blocks.BlockBrynjar;
import stian838.testmod.common.blocks.BlockLimestone;
import stian838.testmod.common.handlers.TestModClientPacketHandler;
import stian838.testmod.common.handlers.TestModServerPacketHandler;
import stian838.testmod.common.items.ItemLime;
import stian838.testmod.common.items.ItembrynjarBar;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

@NetworkMod(clientSideRequired=true,serverSideRequired=true, //Whether client side and server side are needed
clientPacketHandlerSpec = @SidedPacketHandler(channels = {"TestMod"}, packetHandler = TestModClientPacketHandler.class), //For clientside packet handling
serverPacketHandlerSpec = @SidedPacketHandler(channels = {"TestMod"}, packetHandler = TestModServerPacketHandler.class)) //For serverside packet handling

//MOD BASICS
@Mod(modid="TestMod",name="Test Mod",version="0.1.0")

public class TestMod {

	@Instance("TestMod") //The instance, this is very important later on
	public static TestMod instance = new TestMod();
	
	@SidedProxy(clientSide = "stian838.testmod.client.TestModClientProxy", serverSide = "stian838.testmod.common.TestModCommonProxy") //Tells Forge the location of your proxies
	public static TestModCommonProxy proxy;
	
	//BLOCKS
	public static Block Limestone;
	
	public static Block Brynjar;
	
	//ITEMS
	public static Item Lime;
	
	public static Item brynjarBar;
	
	//ITEMARMOR
	public static ItemArmor brynjarHead;
	public static ItemArmor brynjarChest;
	public static ItemArmor brynjarLeg;
	public static ItemArmor brynjarFoot;
	
	@PreInit
	public void PreInit(FMLPreInitializationEvent e){
		
		//BLOCKS
		Limestone = new BlockLimestone(3000).setUnlocalizedName("Limestone").setCreativeTab(CreativeTabs.tabMisc); //3000 is its ID
		
		Brynjar = new BlockBrynjar(3001).setUnlocalizedName("Brynjar").setCreativeTab(CreativeTabs.tabMisc);
		
		//ITEMS
		Lime = new ItemLime(5000).setUnlocalizedName("Lime").setCreativeTab(CreativeTabs.tabMisc);
		
		brynjarBar = new ItembrynjarBar(4100).setUnlocalizedName("brynjarBar").setCreativeTab(CreativeTabs.tabMisc);
		
		//ITEMARMOR
		brynjarHead = (ItemArmor) new ItemArmor(4101, EnumArmorMaterial.IRON, 2, 0).setUnlocalizedName("BrynjarHead").setTextureName("testmod:BHead").setCreativeTab(CreativeTabs.tabCombat);
		brynjarChest = (ItemArmor) new ItemArmor(4102, EnumArmorMaterial.IRON, 2, 1).setUnlocalizedName("BrynjarChest").setTextureName("testmod:BChest").setCreativeTab(CreativeTabs.tabCombat);
		brynjarLeg = (ItemArmor) new ItemArmor(4103, EnumArmorMaterial.IRON,2, 2).setUnlocalizedName("BrynjarLeg").setTextureName("testmod:BLeg").setCreativeTab(CreativeTabs.tabCombat);
		brynjarFoot = (ItemArmor) new ItemArmor(4104, EnumArmorMaterial.IRON, 2, 3).setUnlocalizedName("BrynjarFoot").setTextureName("testmod:BFoot").setCreativeTab(CreativeTabs.tabCombat);
	}
	
	@Init
	public void InitTestMod(FMLInitializationEvent event){ //Your main initialization method
		
		//BLOCKS (METHOD)
		proxy.registerBlocks(); //Calls the registerBlocks method -- This wasn't here before, so don't skip over this!
		
		//ITEMS (METHOD)
		proxy.registerItems();
		
		//MULTIPLAYER ABILITY
		NetworkRegistry.instance().registerGuiHandler(this, proxy); //Registers the class that deals with GUI data
	
	}
	
}