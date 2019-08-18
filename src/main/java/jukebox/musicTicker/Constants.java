package jukebox.musicTicker;

import net.minecraft.client.audio.MusicTicker.MusicType;

import java.util.HashMap;

public class Constants {
    public static HashMap<MusicType, Integer> DELAY_HANDLER;
    static {
        DELAY_HANDLER.put(MusicType.MENU, 320);
        DELAY_HANDLER.put(MusicType.GAME, 18000);
        DELAY_HANDLER.put(MusicType.CREATIVE, 2400);
        DELAY_HANDLER.put(MusicType.NETHER, 2400);
        DELAY_HANDLER.put(MusicType.END, 15000);
    }

    public static HashMap<Integer, MusicType> POSITION_MAP;
    static {
        POSITION_MAP = new HashMap<>();
        POSITION_MAP.put(1, MusicType.MENU);
        POSITION_MAP.put(2, MusicType.GAME);
        POSITION_MAP.put(3, MusicType.CREATIVE);
        POSITION_MAP.put(4, MusicType.NETHER);
        POSITION_MAP.put(5, MusicType.END);
    }
}
