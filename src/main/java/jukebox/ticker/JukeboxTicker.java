package jukebox.ticker;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.MusicTicker;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.util.math.MathHelper;

import java.util.Random;

public class JukeboxTicker extends MusicTicker {

    private final DelayHandler delayHandler;
    private final Random rand = new Random();
    private final Minecraft minecraft;
    private ISound currentMusic;
    private int timeUntilNextMusic = 100;

    public JukeboxTicker(Minecraft minecraft) {
        super(minecraft);
        this.minecraft = minecraft;
        delayHandler = DelayHandler.getInstance();
    }

    @Override
    public void update() {
        JukeboxTicker.MusicType musicticker$musictype = this.minecraft.getAmbientMusicType();

        // checks if music is still being played
        if (this.currentMusic != null)
        {

            // if music is being played in the wrong dimension or game mode, stops the music
            if (!musicticker$musictype.getMusicLocation().getSoundName().equals(this.currentMusic.getSoundLocation()))
            {
                this.minecraft.getSoundHandler().stopSound(this.currentMusic);
                this.timeUntilNextMusic = MathHelper.getInt(this.rand, 0, findDelay(musicticker$musictype, false) / 2);
            }

            // if no music is being played, starts timer for next music
            if (!this.minecraft.getSoundHandler().isSoundPlaying(this.currentMusic))
            {
                this.currentMusic = null;
                this.timeUntilNextMusic = Math.min(MathHelper.getInt(this.rand, findDelay(musicticker$musictype, false), findDelay(musicticker$musictype, true)), this.timeUntilNextMusic);
            }
        }

        // ensures that the time until next music doesn't exceed the maximum delay
        this.timeUntilNextMusic = Math.min(this.timeUntilNextMusic, findDelay(musicticker$musictype, true));

        // if no music is being played and it's time to play music, plays music
        if (this.currentMusic == null && this.timeUntilNextMusic-- <= 0)
        {
            this.playMusic(musicticker$musictype);
        }
    }

    @Override
    public void playMusic(MusicType requestedMusicType) {
        this.currentMusic = PositionedSoundRecord.getMusicRecord(requestedMusicType.getMusicLocation());
        this.minecraft.getSoundHandler().playSound(this.currentMusic);
        this.timeUntilNextMusic = Integer.MAX_VALUE;
    }

    private int findDelay(MusicType requestedMusicType, boolean max) {
        if (delayHandler.getDelays().containsKey(requestedMusicType)) {
            return delayHandler.getDelays().get(requestedMusicType);
        }
        if (max) {
            return requestedMusicType.getMaxDelay();
        } else {
            return requestedMusicType.getMinDelay();
        }
    }
}


