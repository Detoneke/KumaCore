package com.realxode.kumacore.utils;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;

public class YamlCreator {

    private final Plugin main;
    private final File file;
    private final String fileName;
    private final YamlConfiguration fileConfig;

    public YamlCreator(Plugin main, String fileName) {
        this.fileName = fileName;
        this.main = main;
        file = new File(main.getDataFolder(), fileName + "yml");
        fileConfig = YamlConfiguration.loadConfiguration(file);
        if (!file.exists()) {
            main.saveResource(fileName, false);
        }
    }

    public YamlConfiguration getConfig() {
        return fileConfig;
    }
}