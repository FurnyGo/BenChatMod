package furnygo.benchat.mixin;

import fi.dy.masa.malilib.config.options.ConfigBoolean;
import fi.dy.masa.malilib.config.options.ConfigString;
import furnygo.benchat.BenChatConfig;
import net.md_5.bungee.api.ChatColor;
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
        if (((ConfigBoolean) BenChatConfig.OPTIONS.get(5)).getBooleanValue()) {
            if (text.getString().startsWith(((ConfigString) BenChatConfig.OPTIONS.get(6)).getStringValue())) {
             // System.out.println("get global");
                if (text.getString().toLowerCase().contains("бен") || text.getString().toLowerCase().contains("бэн") || text.getString().toLowerCase().contains("ben")) {
                    String randc1 = RandomStringUtils.randomAlphabetic(6); String randc2 = RandomStringUtils.randomNumeric(6); String random = randc1 + randc2;
                    int randomMessage = (int) (Math.random() * 4);
                 // System.out.println("get ben");
                    if (randomMessage == 0) try {MinecraftClient.getInstance().player.sendChatMessage("!Ho-Ho-Ho &8["+random+"]");} catch (NullPointerException e){e.printStackTrace();}
                    else if (randomMessage == 1) try {MinecraftClient.getInstance().player.sendChatMessage("!Yes &8["+random+"]");} catch (NullPointerException e){e.printStackTrace();}
                    else if (randomMessage == 2) try {MinecraftClient.getInstance().player.sendChatMessage("!No &8["+random+"]");} catch (NullPointerException e){e.printStackTrace();}
                    else if (randomMessage == 3) try {MinecraftClient.getInstance().player.sendChatMessage("!Ugh &8["+random+"]");} catch (NullPointerException e){e.printStackTrace();}
                }
            }
        }
        if (((ConfigBoolean) BenChatConfig.OPTIONS.get(7)).getBooleanValue()) {
            if (text.getString().startsWith(((ConfigString) BenChatConfig.OPTIONS.get(8)).getStringValue())) {
               // System.out.println("get local");
                if (text.getString().toLowerCase().contains("бен") || text.getString().toLowerCase().contains("бэн") || text.getString().toLowerCase().contains("ben")) {
                    String randc1 = RandomStringUtils.randomAlphabetic(6); String randc2 = RandomStringUtils.randomNumeric(6); String random = randc1 + randc2;
                    int randomMessage = (int) (Math.random() * 4);
                   // System.out.println("get ben");
                    if (randomMessage == 0) try {MinecraftClient.getInstance().player.sendChatMessage("Ho-Ho-Ho &8["+random+"]");} catch (NullPointerException e){e.printStackTrace();}
                    else if (randomMessage == 1) try {MinecraftClient.getInstance().player.sendChatMessage("Yes &8["+random+"]");} catch (NullPointerException e){e.printStackTrace();}
                    else if (randomMessage == 2) try {MinecraftClient.getInstance().player.sendChatMessage("No &8["+random+"]");} catch (NullPointerException e){e.printStackTrace();}
                    else if (randomMessage == 3) try {MinecraftClient.getInstance().player.sendChatMessage("Ugh &8["+random+"]");} catch (NullPointerException e){e.printStackTrace();}
                }
            }
        }
        if (((ConfigBoolean) BenChatConfig.OPTIONS.get(9)).getBooleanValue()) {
            if (text.getString().toLowerCase().startsWith(((ConfigString) BenChatConfig.OPTIONS.get(10)).getStringValue())) {
               // System.out.println("get clan");
                if (text.getString().toLowerCase().contains("бен") || text.getString().toLowerCase().contains("бэн") || text.getString().toLowerCase().contains("ben")) {
                    String randc1 = RandomStringUtils.randomAlphabetic(6); String randc2 = RandomStringUtils.randomNumeric(6); String random = randc1 + randc2;
                    int randomMessage = (int) (Math.random() * 4);
                  // System.out.println("get ben");
                    if (randomMessage == 0) try {MinecraftClient.getInstance().player.sendChatMessage("/cc Ho-Ho-Ho ["+random+"]");} catch (NullPointerException e){e.printStackTrace();}
                    else if (randomMessage == 1) try {MinecraftClient.getInstance().player.sendChatMessage("/cc Yes ["+random+"]");} catch (NullPointerException e){e.printStackTrace();}
                    else if (randomMessage == 2) try {MinecraftClient.getInstance().player.sendChatMessage("/cc No ["+random+"]");} catch (NullPointerException e){e.printStackTrace();}
                    else if (randomMessage == 3) try {MinecraftClient.getInstance().player.sendChatMessage("/cc Ugh ["+random+"]");} catch (NullPointerException e){e.printStackTrace();}
                }
            }
        }
        if (((ConfigBoolean) BenChatConfig.OPTIONS.get(11)).getBooleanValue()) {
            if (text.getString().toLowerCase().startsWith("| [ss]")){
                return;
            }
            else if (text.getString().toLowerCase().startsWith(((ConfigString) BenChatConfig.OPTIONS.get(12)).getStringValue())) {
                // System.out.println("get clan");
                if (text.getString().toLowerCase().contains("бен") || text.getString().toLowerCase().contains("бэн") || text.getString().toLowerCase().contains("ben")) {
                    String randc1 = RandomStringUtils.randomAlphabetic(6); String randc2 = RandomStringUtils.randomNumeric(6); String random = randc1 + randc2;
                    int randomMessage = (int) (Math.random() * 4);
                    String msg = text.getString();
                    int lengthPrefix = ((ConfigString) BenChatConfig.OPTIONS.get(12)).getStringValue().length();
                    int startNick = msg.indexOf(((ConfigString) BenChatConfig.OPTIONS.get(12)).getStringValue()) + lengthPrefix;
                    // int lengthArrow = ((ConfigString) BenChatConfig.OPTIONS.get(13)).getStringValue().length();
                    int endNick = msg.indexOf(((ConfigString) BenChatConfig.OPTIONS.get(13)).getStringValue()) - 1;
                    String nick = msg.substring(startNick, endNick);
                    // System.out.println("get ben");
                    // System.out.println("Get nick: " + nick + " Get text: " + msg);
                    if (randomMessage == 0) try {MinecraftClient.getInstance().player.sendChatMessage("/tell "+nick+" Ho-Ho-Ho ["+random+"]");} catch (NullPointerException e){e.printStackTrace();}
                    else if (randomMessage == 1) try {MinecraftClient.getInstance().player.sendChatMessage("/tell "+nick+" Yes ["+random+"]");} catch (NullPointerException e){e.printStackTrace();}
                    else if (randomMessage == 2) try {MinecraftClient.getInstance().player.sendChatMessage("/tell "+nick+" No ["+random+"]");} catch (NullPointerException e){e.printStackTrace();}
                    else if (randomMessage == 3) try {MinecraftClient.getInstance().player.sendChatMessage("/tell "+nick+" Ugh ["+random+"]");} catch (NullPointerException e){e.printStackTrace();}
                }
            }
        }
        String tooltip;
        String toCopy = text.getString();
        if (!((ConfigBoolean) BenChatConfig.OPTIONS.get(2)).getBooleanValue()) {
            toCopy = ChatColor.stripColor(toCopy);
        }

        if (((ConfigBoolean) BenChatConfig.OPTIONS.get(1)).getBooleanValue()) {
            tooltip = ChatColor.translateAlternateColorCodes('&',
                    ((ConfigString) BenChatConfig.OPTIONS.get(0)).getStringValue() + "\n\n&9Preview:\n&f" +
                            toCopy);
        } else {
            tooltip = ChatColor.translateAlternateColorCodes('&',
                    ((ConfigString) BenChatConfig.OPTIONS.get(0)).getStringValue());
        }

        Style style = text.getStyle()
                .withClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/clipboard " + toCopy));
        if (((ConfigBoolean) BenChatConfig.OPTIONS.get(3)).getBooleanValue()) {
            style = style.withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                    new LiteralText(tooltip)));
        }

        if (text.getStyle().getClickEvent() == null && ((ConfigBoolean) BenChatConfig.OPTIONS.get(4)).getBooleanValue()) {
            ((MutableText) text).setStyle(style);
        }
    }

    /*
     * Original source:
     * https://github.com/HotLava03/chat-utils
     */
}
