package de.waffen.schwerter.schwert;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.item.ItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.util.Hand;

/**
 * User: Grothendieck
 * Date: 11/06/2021
 *
 */

public class StefansSchwert extends SwordItem
{
   static private final int MAXIMUM_NUMBER_OF_SWORDS = 1; // maximum stack size
   public StefansSchwert()
   {

      super( ItemTier.GOLD, 15, 1.0F, 
			new Item.Properties().maxStackSize(MAXIMUM_NUMBER_OF_SWORDS));
   }

   @Override
   public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
      ItemStack stack = player.getHeldItem(hand);
      // if (world.isRemote) {
      //    GuiNote.open();
      // }
      return new ActionResult<>(ActionResultType.SUCCESS, stack);
   }
}
