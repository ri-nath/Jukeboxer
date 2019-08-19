package jukeboxer.ticker;

import jukeboxer.Constants;
import net.minecraft.client.audio.MusicTicker.MusicType;

import java.util.HashMap;

public class DelayHandler extends HashMap<MusicType, Integer> {
    private static DelayHandler instance = null;

    private DelayHandler() {
        this.putAll(Constants.DEFAULT_DELAYS);
    }

    public static DelayHandler getInstance() {
        if (instance == null)
            instance = new DelayHandler();

        return instance;
    }

    public DelayHandler getDelays() {
        return this;
    }

    public void resetDelays() {
        this.putAll(Constants.DEFAULT_DELAYS);
    }
}