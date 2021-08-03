package com.realxode.kumacore;

import com.realxode.kumacore.utils.MsgType;
import org.bukkit.ChatColor;

public class MessageManager {

    private static final String prefix = "&d&lKUMACORE ";

    public static String color(String message, MsgType type) {
        switch (type) {
            case ERROR:
                return ChatColor.translateAlternateColorCodes('&',
                        prefix + "&4&l&nERROR&8 ❘ &r" + message);
            case LOADING:
                return ChatColor.translateAlternateColorCodes('&',
                        prefix + "&b&l&nLOADING&8 ❘ &r" + message);
            case SUCCESSFUL:
                return ChatColor.translateAlternateColorCodes('&',
                        prefix + "&2&l&nSUCCESSFUL&8 ❘ &r" + message);
            case WARNING:
                return ChatColor.translateAlternateColorCodes('&',
                        prefix + "&6&l&nWARNING&8 ❘ &r" + message);
            case INFO:
                return ChatColor.translateAlternateColorCodes('&',
                        prefix + "&f&l&nINFO&8 ❘ &r" + message);
            case NORMAL:
                return ChatColor.translateAlternateColorCodes('&',
                        message);
        }
        return null;
    }


}
