package de.waffen.schwerter.schwert;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

/**
 * User: Grothendieck
 * Date: 11/06/2021
 * 
 *  No client-only events are needed for this example
 *  See MinecraftByExample class for more information
 */
public class StartupClientOnly
{
  @SubscribeEvent
  public static void onClientSetupEvent(FMLClientSetupEvent event) {
    // not actually required for this example....
  }
}
