package mod.maximusbar.autowb;

import gg.essential.api.utils.Multithreading;
import mod.maximusbar.autowb.command.AutoWBCommand;
import mod.maximusbar.autowb.config.Config;

import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumChatFormatting;

import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;
import java.util.concurrent.TimeUnit;

//Some registering stuff

@Mod(modid = "autowb", name = "AutoWB", version = "4.0")

public class AutoWB {

    public static File modDir = new File(new File(Minecraft.getMinecraft().mcDataDir, "config"), "AutoWB");
    public static Config config;

    @Mod.Instance("autowb")
    public static AutoWB instance;

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
    //The chat receive event
    public void onChat(ClientChatReceivedEvent event){
        String msg = EnumChatFormatting.getTextWithoutFormattingCodes(event.message.getUnformattedText());
        //Trimming of the message so its left only with the name
        if (msg.startsWith("Guild > ") && msg.endsWith(" joined.") && (Config.toggle) && (Config.guildToggle)){
            String msgTrimmed = msg.replace("Guild > ","").replace(" joined.","");
            String message = Config.sendMessage1.replace("%player%", msgTrimmed);
            //What happens when you have random message enabled
            if (Config.random){
                while(true) {
                int r = (int) (Math.random()*10);
                String sendMessage = new String [] {
                        Config.sendMessage1,
                        Config.sendMessage2,
                        Config.sendMessage3,
                        Config.sendMessage4,
                        Config.sendMessage5,
                        Config.sendMessage6,
                        Config.sendMessage7,
                        Config.sendMessage8,
                        Config.sendMessage9,
                        Config.sendMessage10
                }[r].replace("%player%", msgTrimmed);
                    if (!sendMessage.equals("")){
                        Multithreading.schedule(() -> {
                            Minecraft.getMinecraft().thePlayer.sendChatMessage(
                                    "/gc " + sendMessage
                            );}, Config.sendSeconds, TimeUnit.SECONDS);
                        break;
                    }
                }
                //What happens when you have the random message disabled
            }else{ Multithreading.schedule(() -> {
                    Minecraft.getMinecraft().thePlayer.sendChatMessage(
                                "/gc " + message
                    );
                }, Config.sendSeconds, TimeUnit.SECONDS);
            }
        }

        if (msg.startsWith("Friend > ") && msg.endsWith(" joined.") && (Config.toggle) && (Config.friendsToggle)){
            String name = msg.replace("Friend > ","").replace(" joined.","");
            String message = Config.sendMessage1.replace("%player%", name);
            //What happens when you have random message enabled
            if (Config.random){
                while(true) {
                    int r = (int) (Math.random()*10);
                    String sendMessage = new String [] {
                            Config.sendMessage1,
                            Config.sendMessage2,
                            Config.sendMessage3,
                            Config.sendMessage4,
                            Config.sendMessage5,
                            Config.sendMessage6,
                            Config.sendMessage7,
                            Config.sendMessage8,
                            Config.sendMessage9,
                            Config.sendMessage10
                    }[r].replace("%player%", name);

                    if (!sendMessage.equals("")){
                        Multithreading.schedule(() -> {
                            Minecraft.getMinecraft().thePlayer.sendChatMessage(
                                    "/msg " + name + " " + sendMessage
                            );}, Config.sendSeconds, TimeUnit.SECONDS);
                        break;
                    }
                }
                //What happens when you have the random message disabled
            }else{ Multithreading.schedule(() -> {
                Minecraft.getMinecraft().thePlayer.sendChatMessage(
                        "/msg " + name + message
                    );
                }, Config.sendSeconds, TimeUnit.SECONDS);
            }
        }
    }
}