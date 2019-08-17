package jukebox.jukeboxGUI;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.*;
import net.minecraftforge.fml.client.config.GuiConfig;

public class JukeboxGuiScreen extends GuiScreen {

    private FontRenderer fontRenderer;

    @Override
    public void initGui() {
        fontRenderer = Minecraft.getMinecraft().fontRenderer;

        super.initGui();
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();

        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}
