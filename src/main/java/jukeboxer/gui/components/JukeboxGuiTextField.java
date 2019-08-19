package jukeboxer.gui.components;

import jukeboxer.Constants;
import jukeboxer.ticker.DelayHandler;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.audio.MusicTicker.MusicType;

public class JukeboxGuiTextField extends GuiTextField {
    private MusicType musicType;
    private DelayHandler delayHandler;

    public JukeboxGuiTextField(FontRenderer fontRenderer, int position) {
        super(position, fontRenderer, 30, 20 + 20 * position, 40, 10);

        this.musicType = Constants.POSITION_MAP.get(position);
        this.delayHandler = DelayHandler.getInstance();
        this.writeText(Integer.toString(delayHandler.getDelays().get(musicType)));

        this.setFocused(true);
        this.setCanLoseFocus(true);
    }

    public void confirmValue() {
        try {
            delayHandler.replace(musicType, Integer.parseInt(this.getText()));
        } catch (Exception e) {
            delayHandler.replace(musicType, 0);
            this.writeText("0");
        }
    }

    public void resetValue() {
        this.setText(Integer.toString(Constants.DEFAULT_DELAYS.get(musicType)));
    }

    @Override
    public void writeText(String textToWrite) {
        super.writeText(textToWrite.replaceAll("\\D+",""));
    }
}
