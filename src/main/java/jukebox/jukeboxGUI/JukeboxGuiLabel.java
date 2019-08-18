package jukebox.jukeboxGUI;

import jukebox.Jukebox;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiLabel;
import net.minecraft.client.gui.GuiScreen;

class JukeboxGuiLabel extends GuiLabel {
    JukeboxGuiLabel(GuiScreen guiScreen, int position) {
        super(Minecraft.getMinecraft().fontRenderer, 1, 30, 15 + 20 * position, 300,  20, 0xFFFFFF);
    }

    GuiLabel getLabel(String text) {
        this.addLine(text);
        return this;
    }
}
