package jukeboxer;

import jukeboxer.gui.JukeboxGui;
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

        keys[0] = new KeyBinding("Jukeboxer Mod Settings", Keyboard.KEY_O, Jukeboxer.NAME);
        keys[1] = new KeyBinding("Play Next Track", Keyboard.KEY_P, Jukeboxer.NAME);
        keys[2] = new KeyBinding("Stop Current Track", Keyboard.KEY_L, Jukeboxer.NAME);
        keys[3] = new KeyBinding("Pause/Play Current Track", Keyboard.KEY_K, Jukeboxer.NAME);

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
            Jukeboxer.ticker.playMusic(minecraft.getAmbientMusicType());
        }
        if (keys[2].isKeyDown()) {
            System.out.println("key is down");
            Jukeboxer.ticker.stopMusic();
        }
        if (keys[3].isKeyDown()) {
            Jukeboxer.ticker.pauseMusic();
        }
    }
}
