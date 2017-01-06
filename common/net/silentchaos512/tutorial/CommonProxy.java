package net.silentchaos512.tutorial;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.silentchaos512.tutorial.init.ModBlocks;
import net.silentchaos512.tutorial.init.ModItems;

/**
 * The common version of the proxy. Everything in here is done on both the client AND the server!
 */
public class CommonProxy {

  public void preInit(FMLPreInitializationEvent event) {

    // Register blocks (not models)
    ModBlocks.init();
    // Register items (not models)
    ModItems.init();
  }

  public void init(FMLInitializationEvent event) {

  }

  public void postInit(FMLPostInitializationEvent event) {

  }
}
