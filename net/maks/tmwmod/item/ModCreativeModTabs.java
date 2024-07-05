package net.maks.tmwmod.item;

import net.maks.tmwmod.TmwMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TmwMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TMW_TAB = CREATIVE_MODE_TABS.register("tmw_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MAGIGSTICK.get()))
                    .title(Component.translatable("creativetab.tmw_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.MAGIGSTICK.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
