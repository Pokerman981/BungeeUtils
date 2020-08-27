package me.pokerman981.BungeeUtils;

import net.md_5.bungee.api.plugin.Plugin;

public class Main extends Plugin {

    public static Main instance;

    public static ConfigAccessor config;

    @Override
    public void onEnable() {
        Main.instance = this;
        config = new ConfigAccessor(this);



    }

    @Override
    public void onDisable() {
        
    }
}
