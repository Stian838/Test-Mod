package stian838.testmod.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockBrynjar extends Block {
	
	public BlockBrynjar (int par1) {
		
		super(par1, Material.iron);
	}
	public void registerIcons(IconRegister iconRegister) {
		
		blockIcon = iconRegister.registerIcon("testmod:brynjar");
	}

}
