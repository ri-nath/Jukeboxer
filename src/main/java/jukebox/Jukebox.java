package jukebox;

import jukebox.musicTicker.JukeboxTicker;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

import java.lang.reflect.Field;

@Mod(modid = Jukebox.MODID, version = Jukebox.VERSION)
public class Jukebox {
    static final String MODID = "jukebox";
    static final String VERSION = "1.0";

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        try {
            Field ticker = Minecraft.getMinecraft().getClass().getDeclaredField("mcMusicTicker");
            ticker.setAccessible(true);
            ticker.set(Minecraft.getMinecraft(), new JukeboxTicker(Minecraft.getMinecraft()));
        } catch (Exception error) {
            error.printStackTrace();
        }
    }
}
