package de.waffen.schwerter.schwert;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

/**
 * User: Grothendieck
 * Date: 11/06/2021
 *
 */
public class StartupCommon
{
  public static ConnorsWindSchwert schwert;  // this holds the unique instance of your block

  @SubscribeEvent
  public static void onItemsRegistration(final RegistryEvent.Register<Item> itemRegisterEvent) {
	schwert = new ConnorsWindSchwert();
	schwert.setRegistryName("connor_wind_schwert");
    itemRegisterEvent.getRegistry().register(schwert);
  }

  @SubscribeEvent
  public static void onCommonSetupEvent(FMLCommonSetupEvent event) {
    // not actually required for this example....
  }
}
