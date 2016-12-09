package net.silentchaos512.tutorial;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.silentchaos512.tutorial.init.ModItems;

public class ClientProxy extends CommonProxy {

  @Override
  public void preInit(FMLPreInitializationEvent event) {

    super.preInit(event);
  }

  @Override
  public void init(FMLInitializationEvent event) {

    super.init(event);

    ModItems.initClient(Minecraft.getMinecraft().getRenderItem().getItemModelMesher());
  }

  @Override
  public void postInit(FMLPostInitializationEvent event) {

    super.postInit(event);
  }
}