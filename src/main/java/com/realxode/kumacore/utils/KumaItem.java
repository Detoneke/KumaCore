package com.realxode.kumacore.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

import static com.realxode.kumacore.MessageManager.color;

public class KumaItem {

    private final ItemStack itemStack;
    private final ItemMeta itemMeta;

    public KumaItem(String name, Material material, int amount, boolean glowing, boolean enchanted, String[] lore) {
        itemStack = new ItemStack(material, amount);
        itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(color(name));
        for (String lines : lore) {
            Arrays.asList(lore).add(color(lines));
        }
        itemMeta.setLore(Arrays.asList(lore));

        if (glowing) {
            itemMeta.addEnchant(Enchantment.DURABILITY, 1, false);
            itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        itemStack.setItemMeta(itemMeta);
    }

    public void addEnchant(Enchantment enchantment, int level) {
        getItemStack().addUnsafeEnchantment(enchantment, level);
    }

    public void setName(String name) {
        itemMeta.setDisplayName(color(name));
        itemStack.setItemMeta(itemMeta);
    }

    public void setLore(String... lore) {
        for (String lines : lore) {
            Arrays.asList(lore).add(color(lines));
        }
        itemMeta.setLore(Arrays.asList(lore));
        itemStack.setItemMeta(itemMeta);
    }

    public void setMaterial(Material material) {
        itemStack.setType(material);
    }

    private ItemStack getItemStack() {
        return itemStack;
    }
}
