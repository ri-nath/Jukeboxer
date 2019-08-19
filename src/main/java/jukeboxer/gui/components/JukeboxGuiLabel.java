package jukeboxer.gui.components;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiLabel;

public class JukeboxGuiLabel extends GuiLabel {
    public JukeboxGuiLabel(int position) {
        super(Minecraft.getMinecraft().fontRenderer, 1, 90, 15 + 20 * position, 500,  20, 0xFFFFFF);
    }

    public GuiLabel getLabel(String text) {
        this.addLine(text);
        return this;
    }
}
