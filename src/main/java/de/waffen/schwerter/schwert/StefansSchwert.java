package de.waffen.schwerter.schwert;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemTier;
//import net.minecraft.item.Pr
/**
 * User: The Grey Ghost
 * Date: 30/12/2014
 *
 * ItemSimple is an ordinary two-dimensional item
 * For background information on item see here http://greyminecraftcoder.blogspot.com/2013/12/items.html
 *   and here http://greyminecraftcoder.blogspot.com.au/2014/12/item-rendering-18.html
 */

public class StefansSchwert extends SwordItem
{
  static private final int MAXIMUM_NUMBER_OF_SWORDS = 1; // maximum stack size
  public StefansSchwert()
  {
	  super( ItemTier.GOLD, 15, 1.0F, 
			  new Item.Properties().tab(ItemGroup.TAB_MISC).stacksTo(MAXIMUM_NUMBER_OF_SWORDS));
    // the item will appear on the Miscellaneous tab in creative>
  }
}
