package net.maks.tmwmod.Handler;

import net.maks.tmwmod.Keybindings;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EventsHandler {
    @SubscribeEvent
    public static void registerKeys(RegisterKeyMappingsEvent event) {
        event.register(Keybindings.INSTANCE.exampleKey);
        event.register(Keybindings.INSTANCE.zKey);
    }
}
