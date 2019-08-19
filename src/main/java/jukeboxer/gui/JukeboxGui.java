package jukeboxer.gui;

import jukeboxer.gui.components.JukeboxGuiLabel;
import jukeboxer.gui.components.JukeboxGuiTextField;
import jukeboxer.ticker.DelayHandler;

import com.google.common.collect.Lists;
import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.*;

import java.io.IOException;
import java.util.List;

public class JukeboxGui extends GuiScreen {

    private DelayHandler delayHandler;
    private List<JukeboxGuiTextField> textFieldList;
    private GuiButton confirm, reset;
    private final FontRenderer fontRenderer = Minecraft.getMinecraft().fontRenderer;

    @Override
    public void initGui() {
        delayHandler = DelayHandler.getInstance();

        textFieldList = Lists.<JukeboxGuiTextField>newArrayList();

        labelList.add(new JukeboxGuiLabel(0).getLabel("Menu"));
        labelList.add(new JukeboxGuiLabel(1).getLabel("Survival"));
        labelList.add(new JukeboxGuiLabel(2).getLabel("Creative"));
        labelList.add(new JukeboxGuiLabel(3).getLabel("Nether"));
        labelList.add(new JukeboxGuiLabel(4).getLabel("End"));

        buttonList.add(confirm = new GuiButton(0, 30, 140, "Confirm"));
        buttonList.add(reset = new GuiButton(1, 30, 160, "Reset"));

        for (int i = 0; i < labelList.size(); i++) {
            textFieldList.add(new JukeboxGuiTextField(fontRenderer, i));
        }

        super.initGui();
    }

    @Override
    protected void actionPerformed(GuiButton button) {
        if (button == confirm) {
            for (JukeboxGuiTextField text : textFieldList) {
                text.confirmValue();
            }
        } else
        if (button == reset) {
            delayHandler.resetDelays();
            for (JukeboxGuiTextField text : textFieldList) {
                text.resetValue();
            }
        }
    }

    @Override
    protected void keyTyped(char par1, int par2) throws IOException {
        for (GuiTextField text : textFieldList) {
            text.textboxKeyTyped(par1, par2);
        }
        if (!(par2== Keyboard.KEY_E)) {
            super.keyTyped(par1, par2);
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
    protected void mouseClicked(int x, int y, int btn) throws IOException {
        for (GuiTextField textField : textFieldList) {
            textField.mouseClicked(x, y, btn);
        }

        super.mouseClicked(x, y, btn);
    }
}
