package jukebox.jukeboxGUI;

import jukebox.Jukebox;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiLabel;
import net.minecraft.client.gui.GuiScreen;

public class JukeboxGuiLabel extends GuiLabel {
    JukeboxGuiLabel(GuiScreen guiScreen) {
        super(Minecraft.getMinecraft().fontRenderer, 1, guiScreen.width / 2 - 20, guiScreen.height / 2 + 40, 300,  20, 0xFFFFFF);
    }
}
