package net.maks.tmwmod;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;

public class Keybindings {
    public static final Keybindings INSTANCE = new Keybindings();

    private Keybindings() {

    }

    public static final String CATEGORY = "key.categories." + TmwMod.MOD_ID;

    public final KeyMapping exampleKey = new KeyMapping(
            "key." + TmwMod.MOD_ID + ".example_key",
            KeyConflictContext.IN_GAME,
            InputConstants.getKey(InputConstants.KEY_H, -1),
            CATEGORY
    );

    public final KeyMapping zKey = new KeyMapping(
            "key." + TmwMod.MOD_ID + ".example_key",
            KeyConflictContext.IN_GAME,
            InputConstants.getKey(InputConstants.KEY_Z, -1),
            CATEGORY
    );
}
