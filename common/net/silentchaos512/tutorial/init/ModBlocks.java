package net.silentchaos512.tutorial.init;

import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.silentchaos512.tutorial.Tutorial;
import net.silentchaos512.tutorial.block.BlockTutorial;
import net.silentchaos512.tutorial.lib.Names;

/**
 * This class handles Block registration. It's very similar to ModItems. Registering a Block is similar to an Item, but
 * takes a couple extra steps. Again, init is client and server and initClient is client-side only.
 * 
 * Episode 4
 *
 */
public class ModBlocks {

  /*
   * Block references for easy access (for adding recipes and such).
   */
  public static BlockTutorial tutorialBlock;

  /**
   * The common initializer. Registers blocks, but not models. Should be called during preInit.
   */
  public static void init() {

    // Store resource location since we need it twice.
    ResourceLocation location = new ResourceLocation(Tutorial.MOD_ID, Names.TUTORIAL_BLOCK);
    // Initialize the block and store the reference.
    tutorialBlock = new BlockTutorial();
    // Setting the registry name is how Forge tells blocks apart.
    tutorialBlock.setRegistryName(location);
    // Register the block. But we also need to...
    GameRegistry.register(tutorialBlock);
    // ...register an ItemBlock for the block as well!. An ItemBlock is an Item that represents a Block. When you mine a
    // block and pick it up, you are actually getting an ItemBlock in your inventory. We are using the basic vanilla
    // ItemBlock, but you could create your own if necessary.
    GameRegistry.register(new ItemBlock(tutorialBlock), location);
  }

  /**
   * The client-side initializer. Here we handle model registration. Don't forget the @SideOnly annotation! This should
   * be called during init.
   */
  @SideOnly(Side.CLIENT)
  public static void initClient(ItemModelMesher mesher) {

    // We can only register models for Items, so get the item for the block. Maybe you could save a reference to the
    // ItemBlock in init? I haven't tried it, but we likely wouldn't use it anywhere else, so it's not worth doing.
    Item item = Item.getItemFromBlock(tutorialBlock);
    // Everything past this point is identical to registering models for items.
    ModelResourceLocation model = new ModelResourceLocation(
        Tutorial.RESOURCE_PREFIX + Names.TUTORIAL_BLOCK, "inventory");
    ModelLoader.registerItemVariants(item, model);
    mesher.register(item, 0, model);
  }
}
