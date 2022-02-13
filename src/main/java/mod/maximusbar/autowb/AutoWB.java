package mod.maximusbar.autowb;


import gg.essential.vigilance.Vigilant;
import mod.maximusbar.autowb.command.AutoWBCommand;
import net.minecraft.client.Minecraft;
        import net.minecraftforge.client.event.ClientChatReceivedEvent;
        import net.minecraftforge.common.MinecraftForge;
        import net.minecraftforge.fml.common.Mod;
        import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import xyz.deftu.deftils.Multithreading;
import mod.maximusbar.autowb.config.Config;

import java.io.File;
import java.util.concurrent.TimeUnit;


@Mod(modid = "autowb", name = "AutoWB", version = "2.0")
public class AutoWB {

    private boolean running;
    public static final String NAME = "@NAME@", VER = "@VER@", ID = "@ID@";
    public static File jarFile;
    public static File modDir = new File(new File(Minecraft.getMinecraft().mcDataDir, "W-OVERFLOW"), NAME);
    public static Config config;



    @Mod.Instance("autowb")
    public static AutoWB instance;

    @Mod.EventHandler
    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
    @Mod.EventHandler
    protected void onFMLPreInitialization(FMLPreInitializationEvent event) {
        if (!modDir.exists()) modDir.mkdirs();
        jarFile = event.getSourceFile();
    }

    @Mod.EventHandler
    protected void onInitialization(FMLInitializationEvent event) {
        config = new Config();
        config.preload();
        new AutoWBCommand().register();
    }


    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onChat(ClientChatReceivedEvent event){
        String msg = event.message.getUnformattedText();
        if (msg.startsWith("Guild > ") && msg.endsWith(" joined.") && (Config.toggle)){
            String msgTrimmed = msg.replace("Guild > ","").replace(" joined.","");

            Multithreading.schedule(() -> {
                Minecraft.getMinecraft().thePlayer.sendChatMessage(
                        //"/gc Welcome back " + msgTrimmed + "!"
                        Config.sendmessage + msgTrimmed
                );
            }, 2, TimeUnit.SECONDS);



        }

    }


}

