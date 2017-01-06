package net.silentchaos512.tutorial.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.silentchaos512.tutorial.Tutorial;
import net.silentchaos512.tutorial.lib.Names;

public class BlockTutorial extends Block {

  public BlockTutorial() {

    // The Material determines some properties of the block.
    super(Material.ROCK);
    // The hardness determines how long a block takes to break. 5 is a bit high, most are around 2-3.
    setHardness(5.0f);
    // Resistance to explosions.
    setResistance(10.0f);
    // Sound type effects placing, breaking, and step sounds.
    setSoundType(SoundType.LADDER);
    // This method can be used to set a specific tool type and harvest level. Remove if you don't need any restrictions.
    setHarvestLevel("pickaxe", 1);
  }

  @Override
  public String getUnlocalizedName() {

    return "tile." + Tutorial.RESOURCE_PREFIX + Names.TUTORIAL_BLOCK; // tile.tutorial:tutorial_block
  }
}
