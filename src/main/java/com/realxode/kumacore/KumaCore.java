package com.realxode.kumacore;

import com.realxode.kumacore.utils.MsgType;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import static com.realxode.kumacore.MessageManager.color;

public final class KumaCore extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(color("Plugin cargado.", MsgType.SUCCESSFUL));
        color("Plugin cargado.", MsgType.SUCCESSFUL);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
