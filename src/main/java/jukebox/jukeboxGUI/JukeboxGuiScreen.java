package jukebox.jukeboxGUI;

import com.google.common.collect.Lists;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.*;
import net.minecraftforge.fml.client.config.GuiConfig;
import org.lwjgl.input.Keyboard;

import java.util.List;

public class JukeboxGuiScreen extends GuiScreen {

    private GuiTextField text1;
    private GuiTextField text2;
    private List<GuiTextField> textFieldList;
    private GuiLabel label1;
    private GuiLabel label2;
    private FontRenderer fontRenderer;

    @Override
    public void initGui() {
        fontRenderer = Minecraft.getMinecraft().fontRenderer;

        label1 = new JukeboxGuiLabel(this, 0).getLabel("This is a Label");
        label2 = new JukeboxGuiLabel(this, 1).getLabel("Last but not least!");
        labelList.add(label1);
        labelList.add(label2);

        text1 = new JukeboxGuiTextField(this, fontRenderer, 0);
        text2 = new JukeboxGuiTextField(this, fontRenderer, 1);

        textFieldList = Lists.<GuiTextField>newArrayList();
        textFieldList.add(text1);
        textFieldList.add(text2);
        super.initGui();
    }

    @Override
    protected void keyTyped(char par1, int par2) {
        try {
            for (GuiTextField text : textFieldList) {
                text.textboxKeyTyped(par1, par2);
            }

            if (!(par2== Keyboard.KEY_E)) super.keyTyped(par1, par2);

        } catch (Exception error) {
            error.printStackTrace();
        }

    }

    @Override
    public void updateScreen() {
        for (GuiTextField textField : textFieldList) {
            textField.updateCursorCounter();
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();

        for (GuiTextField textField : textFieldList) {
            textField.drawTextBox();
        }

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void mouseClicked(int x, int y, int btn) {
        for (GuiTextField textField : textFieldList) {
            textField.mouseClicked(x, y, btn);
        }
    }
}
