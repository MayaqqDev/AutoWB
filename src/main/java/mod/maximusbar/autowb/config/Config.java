package mod.maximusbar.autowb.config;

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
            description = "Chnages the primary message that gets send when someone joins in your guild (Also when the random messages are blank).",
            category = "General"
    )
    public static String sendMessage1= "Welcome Back! ";

    @Property(
            type = PropertyType.SWITCH,
            name = "Random messages",
            description = "Enables random messages.",
            category = "General", subcategory = "Random messages"
    )
    public static boolean toggle2 = false;

    @Property(
            type = PropertyType.TEXT,
            name = "First random message",
            description = "The random message that has chance to be send (leave blank to disable).",
            category = "General", subcategory = "Random messages"
    )
    public static String sendMessage2= "Welcome back General ";

    @Property(
            type = PropertyType.TEXT,
            name = "First random message",
            description = "The random message that has chance to be send (leave blank to disable).",
            category = "General", subcategory = "Random messages"
    )
    public static String sendMessage3= "WB! ";

    @Property(
            type = PropertyType.TEXT,
            name = "First random message",
            description = "The random message that has chance to be send (leave blank to disable).",
            category = "General", subcategory = "Random messages"
    )
    public static String sendMessage4= "Greetings! ";

    @Property(
            type = PropertyType.TEXT,
            name = "First random message",
            description = "The random message that has chance to be send (leave blank to disable).",
            category = "General", subcategory = "Random messages"
    )
    public static String sendMessage5= "Thanks for coming back to hell >:) ";

    @Property(
            type = PropertyType.TEXT,
            name = "First random message",
            description = "The random message that has chance to be send (leave blank to disable).",
            category = "General", subcategory = "Random messages"
    )
    public static String sendMessage6= "Its nice having you here today ";



    public Config() {
        super(new File(AutoWB.modDir, "autowb.toml"), "AutoWB");
        initialize();
    }

}
