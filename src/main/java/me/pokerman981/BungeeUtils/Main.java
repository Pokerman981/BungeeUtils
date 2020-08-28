/*
 * Copyright © 2020. Troy Gidney
 * All rights reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 * File Last Modified: 8/28/20, 6:00 AM
 * File: Main.java
 * Project: BungeeUtils
 */

package me.pokerman981.BungeeUtils;

import me.pokerman981.BungeeUtils.commands.StaffChatCommand;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;

import java.util.HashMap;
import java.util.Map;

public class Main extends Plugin {

    public static Main instance;
    public static ConfigAccessor config;

    public static Map<String, String> messages = new HashMap<>();

    @Override
    public void onEnable() {
        Main.instance = this;
        config = new ConfigAccessor(this);

        registerCommands();
        loadConfigurationSettings();
    }

    private void loadConfigurationSettings() {
        Configuration configuration = Main.config.getConfig().getSection("messages");
        configuration.getKeys().forEach(key -> {
            if (key != null)
                Main.messages.put(key, (String) configuration.get(key));
        });
    }

    private void registerCommands() {
        getProxy().getPluginManager().registerCommand(this, new StaffChatCommand("adminchat", "bungeeutils.adminchat", "a", "ac", "sc", "staffchat"));
    }

    @Override
    public void onDisable() {

    }
}
