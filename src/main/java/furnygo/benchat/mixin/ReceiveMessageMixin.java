package furnygo.benchat.mixin;

import fi.dy.masa.malilib.config.options.ConfigBoolean;
import fi.dy.masa.malilib.config.options.ConfigString;
import furnygo.benchat.BenChatConfig;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.text.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.apache.commons.lang3.RandomStringUtils;

@Mixin(ChatHud.class)
public class ReceiveMessageMixin {
    @Inject(method = "addMessage(Lnet/minecraft/text/Text;I)V", at = @At("HEAD"))
    public void addMessage(Text text, int messageId, CallbackInfo info) {
        String randc1 = RandomStringUtils.randomAlphabetic(6); String randc2 = RandomStringUtils.randomNumeric(6);
        String random = "";
        String color = "";
        String hohoho = " Ho-Ho-Ho ";
        String yes = " Yes ";
        String no = " no ";
        String ugh = " Ugh ";
        String Gprefix = ((ConfigString) BenChatConfig.OPTIONS.get(1)).getStringValue();
        String Lprefix = ((ConfigString) BenChatConfig.OPTIONS.get(6)).getStringValue();
        String Cprefix = ((ConfigString) BenChatConfig.OPTIONS.get(11)).getStringValue();
        String Pprefix = ((ConfigString) BenChatConfig.OPTIONS.get(16)).getStringValue();
        String Gcommand = ((ConfigString) BenChatConfig.OPTIONS.get(2)).getStringValue();
        String Lcommand = ((ConfigString) BenChatConfig.OPTIONS.get(7)).getStringValue();
        String Ccommand = ((ConfigString) BenChatConfig.OPTIONS.get(12)).getStringValue();
        String Pcommand = ((ConfigString) BenChatConfig.OPTIONS.get(18)).getStringValue();
        String Parrow = ((ConfigString) BenChatConfig.OPTIONS.get(17)).getStringValue();
        int randomMessage = (int) (Math.random() * 4);
        if (((ConfigBoolean) BenChatConfig.OPTIONS.get(0)).getBooleanValue()) {
            if(!text.getString().toLowerCase().contains("ben")) {
                hohoho = " Хо-Хо-Хо ";
                yes = " Да ";
                no = " Нет ";
                ugh = " Фу ";
            }

            if (text.getString().startsWith(Gprefix)) {
                if (text.getString().toLowerCase().contains("~бен") || text.getString().toLowerCase().contains("~бэн") || text.getString().toLowerCase().contains("~ben")) {
                    return;
                }
             // System.out.println("get global");
                else if (text.getString().toLowerCase().contains("бен") || text.getString().toLowerCase().contains("бэн") || text.getString().toLowerCase().contains("ben")) {
                    if(((ConfigBoolean) BenChatConfig.OPTIONS.get(3)).getBooleanValue()) random = "["+randc1+randc2+"]";
                    if(((ConfigBoolean) BenChatConfig.OPTIONS.get(4)).getBooleanValue()) color = "&8";
                 // System.out.println("get ben"); Gprefix+"          "+color+random
                    if (randomMessage == 0) try {MinecraftClient.getInstance().player.sendChatMessage(Gcommand+hohoho+color+random);} catch (NullPointerException e){e.printStackTrace();}
                    else if (randomMessage == 1) try {MinecraftClient.getInstance().player.sendChatMessage(Gcommand+yes+color+random);} catch (NullPointerException e){e.printStackTrace();}
                    else if (randomMessage == 2) try {MinecraftClient.getInstance().player.sendChatMessage(Gcommand+no+color+random);} catch (NullPointerException e){e.printStackTrace();}
                    else if (randomMessage == 3) try {MinecraftClient.getInstance().player.sendChatMessage(Gcommand+ugh+color+random);} catch (NullPointerException e){e.printStackTrace();}
                }
            }
        }
        if (((ConfigBoolean) BenChatConfig.OPTIONS.get(5)).getBooleanValue()) {
            if (text.getString().startsWith(Lprefix)) {
                if (text.getString().toLowerCase().contains("~бен") || text.getString().toLowerCase().contains("~бэн") || text.getString().toLowerCase().contains("~ben")) {
                    return;
                }
               // System.out.println("get local");
                else if (text.getString().toLowerCase().contains("бен") || text.getString().toLowerCase().contains("бэн") || text.getString().toLowerCase().contains("ben")) {
                    if(((ConfigBoolean) BenChatConfig.OPTIONS.get(8)).getBooleanValue()) random = "["+randc1+randc2+"]";
                    if(((ConfigBoolean) BenChatConfig.OPTIONS.get(9)).getBooleanValue()) color = "&8";
                   // System.out.println("get ben");
                    if (randomMessage == 0) try {MinecraftClient.getInstance().player.sendChatMessage(Lcommand+hohoho+color+random);} catch (NullPointerException e){e.printStackTrace();}
                    else if (randomMessage == 1) try {MinecraftClient.getInstance().player.sendChatMessage(Lcommand+yes+color+random);} catch (NullPointerException e){e.printStackTrace();}
                    else if (randomMessage == 2) try {MinecraftClient.getInstance().player.sendChatMessage(Lcommand+no+color+random);} catch (NullPointerException e){e.printStackTrace();}
                    else if (randomMessage == 3) try {MinecraftClient.getInstance().player.sendChatMessage(Lcommand+ugh+color+random);} catch (NullPointerException e){e.printStackTrace();}
                }
            }
        }
        if (((ConfigBoolean) BenChatConfig.OPTIONS.get(10)).getBooleanValue()) {
            if (text.getString().toLowerCase().startsWith(Cprefix)) {
                if (text.getString().toLowerCase().contains("~бен") || text.getString().toLowerCase().contains("~бэн") || text.getString().toLowerCase().contains("~ben")) {
                    return;
                }
               // System.out.println("get clan");
                else if (text.getString().toLowerCase().contains("бен") || text.getString().toLowerCase().contains("бэн") || text.getString().toLowerCase().contains("ben")) {
                    if(((ConfigBoolean) BenChatConfig.OPTIONS.get(13)).getBooleanValue()) random = "["+randc1+randc2+"]";
                    if(((ConfigBoolean) BenChatConfig.OPTIONS.get(14)).getBooleanValue()) color = "&8";
                  // System.out.println("get ben");
                    if (randomMessage == 0) try {MinecraftClient.getInstance().player.sendChatMessage(Ccommand+hohoho+color+random);} catch (NullPointerException e){e.printStackTrace();}
                    else if (randomMessage == 1) try {MinecraftClient.getInstance().player.sendChatMessage(Ccommand+yes+color+random);} catch (NullPointerException e){e.printStackTrace();}
                    else if (randomMessage == 2) try {MinecraftClient.getInstance().player.sendChatMessage(Ccommand+no+color+random);} catch (NullPointerException e){e.printStackTrace();}
                    else if (randomMessage == 3) try {MinecraftClient.getInstance().player.sendChatMessage(Ccommand+ugh+color+random);} catch (NullPointerException e){e.printStackTrace();}
                }
            }
        }
        if (((ConfigBoolean) BenChatConfig.OPTIONS.get(15)).getBooleanValue()) {
            if (text.getString().toLowerCase().startsWith("| [ss]")){
                return;
            }
            else if (text.getString().toLowerCase().startsWith(Pprefix)) {
                if (text.getString().toLowerCase().contains("~бен") || text.getString().toLowerCase().contains("~бэн") || text.getString().toLowerCase().contains("~ben")) {
                    return;
                }
                // System.out.println("get clan");
                else if (text.getString().toLowerCase().contains("бен") || text.getString().toLowerCase().contains("бэн") || text.getString().toLowerCase().contains("ben")) {
                    if(((ConfigBoolean) BenChatConfig.OPTIONS.get(19)).getBooleanValue()) random = "["+randc1+randc2+"]";
                    if(((ConfigBoolean) BenChatConfig.OPTIONS.get(20)).getBooleanValue()) color = "&8";
                    String msg = text.getString();
                    int lengthPrefix = Pprefix.length();
                    int startNick = msg.indexOf(Pprefix) + lengthPrefix;
                    int endNick = msg.indexOf(Parrow) - 1;
                    String nick = msg.substring(startNick, endNick);
                    // System.out.println("get ben");
                    // System.out.println("Get nick: " + nick + " Get text: " + msg);
                    if (randomMessage == 0) try {MinecraftClient.getInstance().player.sendChatMessage(Pcommand+" "+nick+hohoho+color+random);} catch (NullPointerException e){e.printStackTrace();}
                    else if (randomMessage == 1) try {MinecraftClient.getInstance().player.sendChatMessage(Pcommand+" "+nick+yes+color+random);} catch (NullPointerException e){e.printStackTrace();}
                    else if (randomMessage == 2) try {MinecraftClient.getInstance().player.sendChatMessage(Pcommand+" "+nick+no+color+random);} catch (NullPointerException e){e.printStackTrace();}
                    else if (randomMessage == 3) try {MinecraftClient.getInstance().player.sendChatMessage(Pcommand+" "+nick+ugh+color+random);} catch (NullPointerException e){e.printStackTrace();}
                }
            }
        }
    }

    /*
     * Original source:
     * https://github.com/HotLava03/chat-utils
     */
}
