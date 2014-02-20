package stian838.testmod.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockLimestone extends Block {
		
	public BlockLimestone (int par1) {
		
		super(par1, Material.rock); //You can set different materials, check them out!
	}
	
	public void registerIcons(IconRegister iconRegister) {
		
		blockIcon = iconRegister.registerIcon("testmod:limestone"); //Telling Forge where our texture is
		
	}

}
