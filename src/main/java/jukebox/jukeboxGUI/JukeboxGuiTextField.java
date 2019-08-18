package jukebox.jukeboxGUI;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;

public class JukeboxGuiTextField extends GuiTextField {
    JukeboxGuiTextField(GuiScreen guiScreen, FontRenderer fontRenderer, int position) {
        super(position, fontRenderer, guiScreen.width - 50, 20 + 20 * position, 20, 10);
        this.setFocused(true);
        this.setCanLoseFocus(true);
    }
}
