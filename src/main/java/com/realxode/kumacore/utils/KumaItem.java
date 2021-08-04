package com.realxode.kumacore.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.realxode.kumacore.MessageManager.color;

public class KumaItem {

    private final ItemStack itemStack;

    public KumaItem(String name, Material material, int amount, boolean glowing, String[] lore) {
        itemStack = new ItemStack(material, amount);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(color(name));
        List<String> list = new ArrayList<>();
        for (String lines : lore) {
            list.add(color(lines));
        }
        itemMeta.setLore(list);

        if (glowing) {
            itemMeta.addEnchant(Enchantment.DURABILITY, 1, false);
            itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        itemStack.setItemMeta(itemMeta);
    }

    public KumaItem(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public void addEnchant(Enchantment enchantment, int level) {
        itemStack.addUnsafeEnchantment(enchantment, level);
    }

    public void setName(String name) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(color(name));
        itemStack.setItemMeta(itemMeta);
    }

    public void setLore(String... lore) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        for (String lines : lore) {
            Arrays.asList(lore).add(color(lines));
        }
        itemMeta.setLore(Arrays.asList(lore));
        itemStack.setItemMeta(itemMeta);
    }

    public void setMaterial(Material material) {
        itemStack.setType(material);
    }

    public ItemStack toItemStack() {
        return itemStack;
    }

    public KumaItem clone() {
        return new KumaItem(itemStack);
    }

}
