package jukebox.gui;

import jukebox.Jukebox;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;

public class GuiKey {
    public static KeyBinding open;

    public static void registerKey() {
        System.out.println("BOUND!");
        open = new KeyBinding("Jukebox Mod Settings", Keyboard.KEY_O, Jukebox.NAME);
        ClientRegistry.registerKeyBinding(open);
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void onEvent(KeyInputEvent event) {
        System.out.println("Key event");
        if (open.isKeyDown()) {
            Minecraft.getMinecraft().displayGuiScreen(new JukeboxGui());
        }
    }
}
