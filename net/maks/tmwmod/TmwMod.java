package net.maks.tmwmod;

import com.mojang.logging.LogUtils;
import net.maks.tmwmod.entity.ModEntites;
import net.maks.tmwmod.entity.custom.nnnpcEntity;
import net.maks.tmwmod.entity.client.nnNpcModel;
import net.maks.tmwmod.item.ModCreativeModTabs;
import net.maks.tmwmod.item.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import java.io.File;
import java.io.IOException;

import static java.lang.ref.Cleaner.create;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TmwMod.MOD_ID)
@Mod.EventBusSubscriber(modid = TmwMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class TmwMod
{
    Minecraft minecraft = Minecraft.getInstance();
    LocalPlayer player = minecraft.player;

    //Entity entity = Entity;
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "tmwmod";

    public static String main_magic= "None";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public static int nowTick = 0;

    public static int storyLine = 0;

    static boolean flag = true;

    //static String forFile = "";

    public TmwMod()
    {
        MinecraftForge.EVENT_BUS.register(this);
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModEntites.REGISTRY.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        //MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    public static void getMain_magic() {
        if (main_magic != "None") {
            System.out.println("YAAAAAAAAAAAA");
        }
    }

    //Minecraft minecraft = Minecraft.getInstance();
    //LocalPlayer player = minecraft.player;

    private static final Component EXAMPLE_KEY_PRESSED =
            Component.translatable("message." + TmwMod.MOD_ID + ".example_key_pressed");

    @SubscribeEvent
    public static void clientTick(TickEvent.ClientTickEvent event) throws InterruptedException {
        Suchet.clientTick(event);

        nowTick += 1;

        if (nowTick == 20) { nowTick = 0; }
    }

    @SubscribeEvent
    public void onPlayerJoin(PlayerEvent.PlayerLoggedInEvent event) throws InterruptedException {
        //TimeUnit.SECONDS.sleep(10);
        File file = new File("savedata.txt");
        try {
            if (file.createNewFile()) {
                System.out.println("Файл создан");
            } else {
                System.out.println("Файл уже существует");
            }
        } catch (IOException e) {
            System.out.print("error!");
        }
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.MAGIGSTICK);
        }
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            //EntityRenderers.register(ModEntites.NNNPC.get(), EntityRendererProvider<nnNpcModel>);
        }
    }
}
