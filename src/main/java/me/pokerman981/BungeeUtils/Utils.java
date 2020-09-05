/*
 * Copyright © 2020. Troy Gidney
 * All rights reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 * File Last Modified: 9/5/20, 2:45 AM
 * File: Utils.java
 * Project: BungeeUtils
 */

package me.pokerman981.BungeeUtils;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class Utils {

    public static void msg(CommandSender sender, String msg, ChatColor overrideColor) {
        TextComponent textComponent = new TextComponent(getText(msg));
        textComponent.setColor(overrideColor);
        sender.sendMessage(textComponent);
    }

    public static void msg(CommandSender sender, String msg, ChatColor overrideColor, String hoverText) {
        TextComponent textComponent = new TextComponent(getText(msg));
        HoverEvent hoverEvent = new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(getText(hoverText)).create());
        textComponent.setColor(overrideColor);

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
