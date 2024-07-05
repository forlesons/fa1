package net.maks.tmwmod;

import com.mojang.logging.LogUtils;
import net.maks.tmwmod.Engine.SuchetEngine;
import net.maks.tmwmod.item.ModCreativeModTabs;
import net.maks.tmwmod.item.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.CustomizeGuiOverlayEvent;
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

import java.util.concurrent.TimeUnit;

import static net.maks.tmwmod.TmwMod.nowTick;
import static net.maks.tmwmod.TmwMod.storyLine;

@Mod(TmwMod.MOD_ID)
@Mod.EventBusSubscriber(modid = TmwMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class Suchet {
    Minecraft minecraft = Minecraft.getInstance();
    LocalPlayer player = minecraft.player;
    LocalPlayer player1 = Minecraft.getInstance().player;

    static boolean startTurnCam = false;

    static boolean flagTry = false;

    static int rotXCam = 75;

    static int oldTick = 0;

    private static final Component EXAMPLE_KEY_PRESSED =
            Component.translatable("message." + TmwMod.MOD_ID + ".example_key_pressed");

    @SubscribeEvent
    public static void clientTick(TickEvent.ClientTickEvent event) throws InterruptedException {

        Minecraft minecraft = Minecraft.getInstance();

        Entity camera = minecraft.cameraEntity;

        if (storyLine == 1) {
            if (!flagTry) {
                minecraft.player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 80, 2, false, false));

                SuchetEngine.tpPlayer(6.462, 301, 39.523);

                startTurnCam = true;
            }

            if (nowTick == 19) {
                storyLine = 2;
            }
        }
        else if (storyLine == 2) {
            if (nowTick == 19) {
                minecraft.player.displayClientMessage(Component.literal("[???] Ну привет, хахаха"), false);
                storyLine = 3;
            }
        }
        else if (storyLine == 3) {
            if (nowTick == 19) {
                minecraft.player.displayClientMessage(Component.literal("[???] MrMord..."), false);
                storyLine = 4;
            }
        }

        if (startTurnCam) {
            //int num = SuchetEngine.setPlawXCam(75, 25, 5);
            System.out.print("ok");

            camera.setXRot(rotXCam);
            camera.xRotO = rotXCam;

            rotXCam -= 5;

            if (rotXCam <= 25) {
                startTurnCam = false;
            }
        }



        if (Keybindings.INSTANCE.zKey.isDown()) {
            if (storyLine == 0) {
                storyLine = 1;
            }
        }
    }
}
