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

/**
 * This is where we handle Item registration. Typically, you should also store references to your items for quick
 * access. Note there are two initialization methods here, init (common, both client and server) and initClient
 * (client-side only).
 */
public class ModItems {

  /*
   * Item references for easy access.
   */

  public static ItemTutorial tutorialItem;

  /**
   * The common initializer. Registers items, but not models. The game will crash if we try to do anything with models
   * on the server, as those classes don't even exist on that side!
   * 
   * This should be called during preInit.
   */
  public static void init() {

    // Initialize the item and store the reference. Can be done on the line the variable is declared, do whatever makes
    // the most sense to you.
    tutorialItem = new ItemTutorial();
    // Setting the registry name is how Forge tells items apart.
    tutorialItem.setRegistryName(new ResourceLocation(Tutorial.MOD_ID, Names.TUTORIAL_ITEM));
    // Finally, register the item! Must be done AFTER setting the registry name.
    GameRegistry.register(tutorialItem);
  }

  /**
   * Here we should call the addRecipes method for all items that have one. Should be called during the init phase.
   */
  public static void initRecipes() {

    tutorialItem.addRecipes();
  }

  /**
   * The client-side initializer. Here we handle model registration. Note the @SideOnly annotation. This causes the method
   * to exist only on the client-side, preventing servers from crashing.
   * 
   * This should be called during init, calling during preInit will crash.
   */
  @SideOnly(Side.CLIENT)
  public static void initClient(ItemModelMesher mesher) {

    // Create a MRL for the model. Note we have two parameters and the second must be "inventory". We can reuse this
    // variable for each item of course, since most Java variables just contain a reference to an object.
    ModelResourceLocation model = new ModelResourceLocation(
        Tutorial.RESOURCE_PREFIX + Names.TUTORIAL_ITEM, "inventory");
    // Here we list all models the item can possibly have. An array will work, or just list each MRL for the final
    // parameters.
    ModelLoader.registerItemVariants(tutorialItem, model);
    // Finally, we associate each MRL (model) with different metadata values for the item. This must be called for each
    // variant! And even if the variants don't depend on metadata, I believe each variant must be registered to a unique
    // meta... In this case, there are no other variants, so we just pass in a metadata of zero.
    mesher.register(tutorialItem, 0, model);
  }
}
