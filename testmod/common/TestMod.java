package stian838.testmod.common;

import net.minecraft.block.Block;
import stian838.testmod.common.blocks.BlockLimestone;
import stian838.testmod.common.handlers.TestModClientPacketHandler;
import stian838.testmod.common.handlers.TestModServerPacketHandler;
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
@Mod(modid="TestMod",name="Test Mod",version="Dev")

public class TestMod {

	@Instance("TestMod") //The instance, this is very important later on
	public static TestMod instance = new TestMod();
	
	@SidedProxy(clientSide = "stian838.testmod.client.TestModClientProxy", serverSide = "stian838.testmod.common.TestModCommonProxy") //Tells Forge the location of your proxies
	public static TestModCommonProxy proxy;
	
	//BLOCKS
	public static Block Limestone;
	
	@PreInit
	public void PreInit(FMLPreInitializationEvent e){
		
		//BLOCKS
		Limestone = new BlockLimestone(3000).setUnlocalizedName("Limestone"); //3000 is its ID
		
	}
	
	@Init
	public void InitTestMod(FMLInitializationEvent event){ //Your main initialization method
		
		//BLOCKS (METHOD)
		proxy.registerBlocks(); //Calls the registerBlocks method -- This wasn't here before, so don't skip over this!
		
		//MULTIPLAYER ABILITY
		NetworkRegistry.instance().registerGuiHandler(this, proxy); //Registers the class that deals with GUI data
	
	}
}