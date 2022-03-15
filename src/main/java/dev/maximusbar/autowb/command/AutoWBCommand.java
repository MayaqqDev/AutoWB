package dev.maximusbar.autowb.command;

import dev.maximusbar.autowb.AutoWB;

import gg.essential.api.EssentialAPI;
import gg.essential.api.commands.Command;
import gg.essential.api.commands.DefaultHandler;

public class AutoWBCommand extends Command {
    public AutoWBCommand() {
        super("autowb", true);
    }

    @DefaultHandler
    public void handle() {
        EssentialAPI.getGuiUtil().openScreen(AutoWB.config.gui());
    }
}
