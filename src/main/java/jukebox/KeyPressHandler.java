package jukebox;

import jukebox.Jukebox;
import jukebox.gui.JukeboxGui;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;

public class KeyPressHandler {
    public static KeyBinding[] keys;

    public static void registerKey() {
        keys = new KeyBinding[1];

        keys[0] = new KeyBinding("Jukebox Mod Settings", Keyboard.KEY_O, Jukebox.NAME);

        for (KeyBinding key : keys) {
            ClientRegistry.registerKeyBinding(key);
        }
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void onEvent(KeyInputEvent event) {
        if (keys[0].isKeyDown()) {
            Minecraft.getMinecraft().displayGuiScreen(new JukeboxGui());
        }
    }
}
