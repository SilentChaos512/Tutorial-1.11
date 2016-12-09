package net.silentchaos512.tutorial;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.silentchaos512.tutorial.init.ModItems;

public class CommonProxy {

  public void preInit(FMLPreInitializationEvent event) {

    ModItems.init();
  }

  public void init(FMLInitializationEvent event) {

  }

  public void postInit(FMLPostInitializationEvent event) {

  }
}
