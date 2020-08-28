package me.pokerman981.BungeeUtils.commands;

import me.pokerman981.BungeeUtils.Main;
import me.pokerman981.BungeeUtils.Utils;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

public class StaffChatCommand extends Command {

    public StaffChatCommand(String name, String permission, String... aliases) {
        super(name, permission, aliases);
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        if (!commandSender.hasPermission(super.getPermission())) {
            Utils.msg(commandSender, Main.messages.getOrDefault("no-perm", "Config Error!"));
            return;
        }
        if (strings.length <= 0) return;

        String messageToSend = String.join(" ", strings);

        Utils.msg(Main.instance.getProxy().getConsole(), Main.messages.getOrDefault("admin-chat", "Config Error!")
                .replaceAll("%player%", commandSender.getName())
                .replaceAll("%message%", messageToSend));


        Main.instance.getProxy().getPlayers().forEach(proxiedPlayer -> {
            if (proxiedPlayer.hasPermission(super.getPermission()))
                Utils.msg(proxiedPlayer, Main.messages.getOrDefault("admin-chat", "Config Error!")
                        .replaceAll("%player%", commandSender.getName())
                        .replaceAll("%message%", messageToSend));
        });

    }
}
