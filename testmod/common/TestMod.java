package stian838.testmod.common;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.SidedProxy;
import stian838.testmod.common.TestModCommonProxy;
import stian838.testmod.common.handlers.TestModServerPacketHandler;
import stian838.testmod.common.handlers.TestModClientPacketHandler;

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

@PreInit
public void PreInit(FMLPreInitializationEvent e){

}

@Init
public void InitTestMod(FMLInitializationEvent event){ //Your main initialization method

//MULTIPLAYER ABILITY
NetworkRegistry.instance().registerGuiHandler(this, proxy); //Registers the class that deals with GUI data

}
}