package mod.maximusbar.autowb.command;

import gg.essential.api.EssentialAPI;
import gg.essential.api.commands.Command;
import gg.essential.api.commands.DefaultHandler;
import mod.maximusbar.autowb.AutoWB;

public class AutoWBCommand extends Command {
    public AutoWBCommand() {
        super("autowb", true);
    }

    @DefaultHandler
    public void handle() {
        EssentialAPI.getGuiUtil().openScreen(AutoWB.config.gui());
    }
}
