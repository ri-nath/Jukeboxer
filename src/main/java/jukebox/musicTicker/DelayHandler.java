package jukebox.musicTicker;

import net.minecraft.client.audio.MusicTicker.MusicType;

import java.util.HashMap;

public class DelayHandler extends HashMap<MusicType, Integer> {
    public DelayHandler() {
        this.put(MusicType.MENU, 320);
        this.put(MusicType.GAME, 18000);
        this.put(MusicType.CREATIVE, 2400);
        this.put(MusicType.NETHER, 2400);
        this.put(MusicType.END, 15000);
    }
}
