package jukebox;

import net.minecraft.client.audio.MusicTicker.MusicType;

import java.util.HashMap;

public final class Constants {
    public static final HashMap<MusicType, Integer> DEFAULT_DELAYS;
    static {
        DEFAULT_DELAYS = new HashMap<>();
        DEFAULT_DELAYS.put(MusicType.MENU, 320);
        DEFAULT_DELAYS.put(MusicType.GAME, 18000);
        DEFAULT_DELAYS.put(MusicType.CREATIVE, 2400);
        DEFAULT_DELAYS.put(MusicType.NETHER, 2400);
        DEFAULT_DELAYS.put(MusicType.END, 15000);
    }

    public static final HashMap<Integer, MusicType> POSITION_MAP;
    static {
        POSITION_MAP = new HashMap<>();
        POSITION_MAP.put(0, MusicType.MENU);
        POSITION_MAP.put(1, MusicType.GAME);
        POSITION_MAP.put(2, MusicType.CREATIVE);
        POSITION_MAP.put(3, MusicType.NETHER);
        POSITION_MAP.put(4, MusicType.END);
    }

    private Constants() {
        throw new AssertionError();
    }
}
