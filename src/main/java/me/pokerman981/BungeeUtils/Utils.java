package me.pokerman981.BungeeUtils;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class Utils {

    public static void msg(CommandSender sender, String msg) {
        sender.sendMessage(new ComponentBuilder(color(msg)).create());
    }

    public static void msg(CommandSender sender, String msg, String hoverText) {
        TextComponent textComponent = new TextComponent(color(msg));
        HoverEvent hoverEvent = new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(color(hoverText)).create());

        textComponent.setHoverEvent(hoverEvent);
        sender.sendMessage(textComponent);
    }


    public static String getText(String msg) {
        return color(msg);
    }

    public static String color(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

}
