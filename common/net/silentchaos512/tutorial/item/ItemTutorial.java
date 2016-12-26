package net.silentchaos512.tutorial.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.silentchaos512.tutorial.Tutorial;
import net.silentchaos512.tutorial.lib.Names;

/**
 * A very basic item with no subtypes/variants (episode 3)
 */
public class ItemTutorial extends Item {

  /**
   * Called when the item is right-clicked. By overriding this method, we can changed the behavior of the item! Note
   * the @Override annotation. You should use these EVERY TIME you override a method. If the method signatures change
   * between Minecraft versions (and that happens fairly often), you will get a compiler error. This makes porting much,
   * much easier! Otherwise, you'll have a hard time figuring out why certain methods suddenly aren't being called.
   */
  @Override
  public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {

    if (!world.isRemote)
      player.sendMessage(new TextComponentString("You used my item!"));

    return super.onItemRightClick(world, player, hand);
  }

  /**
   * Returns the unlocalized the name for the item. Make sure to add a corresponding line to your localization file! You
   * could probably just call {@link Item#setUnlocalizedName(String)} as well, but I usually just override this.
   */
  @Override
  public String getUnlocalizedName(ItemStack stack) {

    return "item." + Tutorial.RESOURCE_PREFIX + Names.TUTORIAL_ITEM; // item.tutorial:tutorial_item
  }
}
