package mod.maximusbar.autowb.config;

import gg.essential.api.EssentialAPI;
import gg.essential.vigilance.Vigilant;
import gg.essential.vigilance.data.Property;
import gg.essential.vigilance.data.PropertyType;
import mod.maximusbar.autowb.AutoWB;

import java.io.File;

public class Config extends Vigilant {
    @Property(
            type = PropertyType.SWITCH,
            name = "Toggle Mod",
            description = "Toggle the mod's functionality.",
            category = "General"
    )
    public static boolean toggle = true;

    @Property(
            type = PropertyType.TEXT,
            name = "Message",
            description = "Chnages the message that gets send",
            category = "General"
    )
    public static String sendmessage= "Welcome Back! ";

    public Config() {
        super(new File(AutoWB.modDir, "autowb.toml"), "AutoWB");
        initialize();
    }

}
