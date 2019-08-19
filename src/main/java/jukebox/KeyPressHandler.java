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
    private static KeyBinding[] keys;
    private static Minecraft minecraft;

    static void registerKeys() {
        keys = new KeyBinding[4];
        minecraft = Minecraft.getMinecraft();

        keys[0] = new KeyBinding("Jukebox Mod Settings", Keyboard.KEY_O, Jukebox.NAME);
        keys[1] = new KeyBinding("Play Next Track", Keyboard.KEY_P, Jukebox.NAME);
        keys[2] = new KeyBinding("Stop Current Track", Keyboard.KEY_L, Jukebox.NAME);
        keys[3] = new KeyBinding("Pause/Play Current Track", Keyboard.KEY_K, Jukebox.NAME);

        for (KeyBinding key : keys) {
            ClientRegistry.registerKeyBinding(key);
        }
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void onEvent(KeyInputEvent event) {
        if (keys[0].isKeyDown()) {
            minecraft.displayGuiScreen(new JukeboxGui());
        }
        if (keys[1].isKeyDown()) {
            Jukebox.ticker.playMusic(minecraft.getAmbientMusicType());
        }
        if (keys[2].isKeyDown()) {
            System.out.println("key is down");
            Jukebox.ticker.stopMusic();
        }
        if (keys[3].isKeyDown()) {
            Jukebox.ticker.pauseMusic();
        }
    }
}
