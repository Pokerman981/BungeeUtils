package me.pokerman981.BungeeUtils;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.ComponentBuilder;

public class Utils {

    public static void msg(CommandSender sender, String msg) {
        sender.sendMessage(new ComponentBuilder(ChatColor.translateAlternateColorCodes('&', msg)).create());
    }

    public static String getText(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

}
