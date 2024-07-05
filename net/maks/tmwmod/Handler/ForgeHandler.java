package net.maks.tmwmod.Handler;

import net.maks.tmwmod.TmwMod;
import net.maks.tmwmod.Keybindings;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.network.chat.Component;
import org.slf4j.Logger;

import java.util.concurrent.TimeUnit;

@Mod.EventBusSubscriber(modid = TmwMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ForgeHandler {
    private static final Component EXAMPLE_KEY_PRESSED =
            Component.translatable("message." + TmwMod.MOD_ID + ".example_key_pressed");
    @SubscribeEvent
    public static void clientTick(TickEvent.ClientTickEvent event) {
        Minecraft minecraft = Minecraft.getInstance();
        if (Keybindings.INSTANCE.exampleKey.isDown()) {
            TmwMod.main_magic = "nice";
            minecraft.player.displayClientMessage(EXAMPLE_KEY_PRESSED, false);

            var xz = minecraft.player.getInventory().getSelected();

            System.out.println(xz);

            //minecraft.player.displayClientMessage(Component.literal("[???] Ну привет, хахаха"), true);
            //TimeUnit.SECONDS.sleep(1);

            //minecraft.player.displayClientMessage(Component.literal("[???] MrMord"), true);
            //TimeUnit.SECONDS.sleep(1);
        }
    }
}
