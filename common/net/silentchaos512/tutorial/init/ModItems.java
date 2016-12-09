package net.silentchaos512.tutorial.init;

import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.silentchaos512.tutorial.Tutorial;
import net.silentchaos512.tutorial.item.ItemTutorial;
import net.silentchaos512.tutorial.lib.Names;

public class ModItems {

  public static ItemTutorial tutorialItem;

  public static void init() {

    tutorialItem = new ItemTutorial();
    tutorialItem.setRegistryName(new ResourceLocation(Tutorial.MOD_ID, Names.TUTORIAL_ITEM));
    GameRegistry.register(tutorialItem);
  }

  @SideOnly(Side.CLIENT)
  public static void initClient(ItemModelMesher mesher) {

    ModelResourceLocation model = new ModelResourceLocation(Tutorial.RESOURCE_PREFIX + Names.TUTORIAL_ITEM, "inventory");
    ModelLoader.registerItemVariants(tutorialItem, model);
    mesher.register(tutorialItem, 0, model);
  }
}
