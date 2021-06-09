package de.waffen.schwerter;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(Schwerter.MODID)
public class Schwerter {
  // you also need to update the modid in two other places as well:
  //  build.gradle file (the version, group, and archivesBaseName parameters)
  //  resources/META-INF/mods.toml (the name, description, and version parameters)
  public static final String MODID = "schwerter";

  public Schwerter() {
    final boolean HIDE_CONSOLE_NOISE = false;  // todo get rid of all the noise from the console (after mod is constructed) to show warnings more clearly.
    if (HIDE_CONSOLE_NOISE) {
//      ForgeLoggerTweaker.setMinimumLevel(Level.WARN);
//      ForgeLoggerTweaker.applyLoggerFilter();
    }

    // Get an instance of the mod event bus
    final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

    // Get an instance of the event registrar that is used to bind events to the mod event bus
    // this is a separate class to allow us to use `safeRunWhenOn` instead of the deprecated
    // `runWhenOn` method on the DistExecuter.
//    final ClientSideOnlyModEventRegistrar clientSideOnlyModEventRegistrar = new ClientSideOnlyModEventRegistrar(modEventBus);

    // The event bus register method is used to specify classes used for receiving startup events:
    // The classes you register will be searched for methods which are interested in startup events
    //    (i.e. methods that are decorated with the @SubscribeEvent annotation)

    // Beware - there are two event busses: the MinecraftForge.EVENT_BUS, and your own ModEventBus.
    //  If you subscribe your event to the wrong bus, it will never get called.
    // likewise, beware of the difference between static and non-static methods, i.e.
    //  If you register a class, but the @SubscribeEvent is on a non-static method, it won't be called.  e.g.
    //  eventBus.register(MyClass.class);
    //  public class ServerLifecycleEvents {
    //    @SubscribeEvent
    //      public void onServerStartingEvent(FMLServerStartingEvent event) { // missing static! --> never gets called}
    //  }

    // Based on my testing: ModEventBus is used for setup events only, in the following order:
    // * RegistryEvent of all types
    // * ColorHandlerEvent for blocks & items
    // * ParticleFactoryRegisterEvent
    // * FMLCommonSetupEvent (multithreaded)
    // * TextureStitchEvent
    // * FMLClientSetupEvent or FMLDedicatedServerSetupEvent (multithreaded)
    // * ModelRegistryEvent
    // * Other ModLifecycleEvents such as InterModEnqueueEvent, InterModProcessEvent (multithreaded)
    // ModelBakeEvent

    // We need to split the registration of events into:
    // 1) "Common" events that are executed on a dedicated server and also on an integrated client + server installation
    // 2) "Client only" events that are not executed on a dedicated server.
    // If you aren't careful to split these into two parts, your mod will crash when installed on a dedicated server
    // It doesn't matter if your client-only code is never actually called; simply referencing the class is often enough to
    //   cause a crash.  I have also heard that the behavior depends on the particular implementation of the Java Virtual
    //   Machine (for example Windows vs Linux), so you can't necessarily rely on testing to be sure it works.
    //   See the comments in DistExecutor class for more context.
    //  This is the reason that the ClientOnlyEvents are split into a completely-separate class.

    registerCommonEvents(modEventBus);
//    DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> clientSideOnlyModEventRegistrar::registerClientOnlyEvents);
  }


  /**
   * Register common events for both dedicated servers and clients. This method is safe to call directly.
   */
  public void registerCommonEvents(IEventBus eventBus) {
    eventBus.register(de.waffen.schwerter.schwert.StartupCommon.class);

//    		.StartupCommon.class);

    //----------------
//    eventBus.register(minecraftbyexample.usefultools.debugging.StartupCommon.class);
  }
/*
  private void setup(final FMLClientSetupEvent event)
  {
    event.enqueueWork(() ->
    {
      ItemModelsProperties.registerProperty(de.waffen.schwerter.schwert.StefansSchwert, 
        new ResourceLocation(Schwerter.MODID, "pulling"), (stack, world, living) -> {
          return living != null && living.isHandActive() && living.getActiveItemStack() == stack ? 1.0F : 0.0F;
        });
    });
}
*/
}
