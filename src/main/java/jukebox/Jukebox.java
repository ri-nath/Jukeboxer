package jukebox;

import jukebox.jukeboxGUI.GuiKey;
import jukebox.musicTicker.JukeboxTicker;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.lang.reflect.Field;

@Mod(modid = Jukebox.MODID, version = Jukebox.VERSION, name = Jukebox.NAME)
public class Jukebox {
    public static final String MODID = "jukebox";
    public static final String NAME = "Jukebox";
    public static final String VERSION = "1.0";

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        GuiKey.registerKey();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

        MinecraftForge.EVENT_BUS.register(GuiKey.class);

        try {
            Field ticker = Minecraft.getMinecraft().getClass().getDeclaredField("mcMusicTicker");
            ticker.setAccessible(true);
            ticker.set(Minecraft.getMinecraft(), new JukeboxTicker(Minecraft.getMinecraft()));
        } catch (Exception error) {
            error.printStackTrace();
        }
    }
}
