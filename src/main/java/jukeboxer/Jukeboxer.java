package jukeboxer;

import jukeboxer.ticker.JukeboxTicker;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.lang.reflect.Field;

@Mod(modid = Jukeboxer.MODID, version = Jukeboxer.VERSION, name = Jukeboxer.NAME)
public class Jukeboxer {
    public static final String MODID = "jukeboxer";
    public static final String NAME = "Jukeboxer";
    public static final String VERSION = "1.1";
    public static JukeboxTicker ticker;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ticker = new JukeboxTicker(Minecraft.getMinecraft());
        KeyPressHandler.registerKeys();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

        MinecraftForge.EVENT_BUS.register(KeyPressHandler.class);

        try {
            Field field = Minecraft.getMinecraft().getClass().getDeclaredField("mcMusicTicker");
            field.setAccessible(true);
            field.set(Minecraft.getMinecraft(), ticker);
        } catch (Exception error) {
            error.printStackTrace();
        }
    }
}
