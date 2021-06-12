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
import net.minecraft.client.Minecraft;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * User: Grothendieck
 * Date: 11/06/2021
 *
 */

public class ConnorsWindSchwert extends SwordItem
{
   public static final Logger logger = LogManager.getLogger();
   static private final int MAXIMUM_NUMBER_OF_SWORDS = 1; // maximum stack size
   public ConnorsWindSchwert()
   {

      super( ItemTier.GOLD, 15, 1.0F, 
//      super( ItemTier.GOLD, 1000000, 0.00001F, 
			new Item.Properties().maxStackSize(MAXIMUM_NUMBER_OF_SWORDS));
   }

   @Override
   public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
      ItemStack stack = player.getHeldItem(hand);
      // if (world.isRemote) {
      //    GuiNote.open();
      // }
      double x = player.chasingPosX;
//      logger.log(Level.INFO, "JUMPING!!");
//      logger.log(Level.INFO, player.chasingPosX);
//      logger.log(Level.INFO, player.chasingPosY);
//      logger.log(Level.INFO, player.chasingPosZ);
//      RayTraceResult mouseOver = Minecraft.getInstance().objectMouseOver;
//      if (mouseOver != null) {
//         if (mouseOver.getType() == RayTraceResult.Type.ENTITY) { .getBlockPos()
//      logger.log(Level.INFO,Minecraft.getInstance().objectMouseOver.getBlockPos());
      player.jump();

      return new ActionResult<>(ActionResultType.SUCCESS, stack);
   }
}
