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

    public KumaItem(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public KumaItem setAmount(int amount) {
        itemStack.setAmount(amount);
        return this;
    }

    public KumaItem setGlowing(boolean glowing) {
        if (!glowing)
            return null;
        itemStack.getItemMeta().addEnchant(Enchantment.DURABILITY, 1, false);
        itemStack.getItemMeta().addItemFlags(ItemFlag.HIDE_ENCHANTS);
        return this;
    }

    public KumaItem addEnchant(Enchantment enchantment, int level) {
        itemStack.addUnsafeEnchantment(enchantment, level);
        return this;
    }

    public KumaItem setName(String name) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(color(name));
        itemStack.setItemMeta(itemMeta);
        return this;
    }

    public KumaItem setLore(String... lore) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        for (String lines : lore) {
            Arrays.asList(lore).add(color(lines));
        }
        itemMeta.setLore(Arrays.asList(lore));
        itemStack.setItemMeta(itemMeta);
        return this;
    }

    public KumaItem setMaterial(Material material) {
        itemStack.setType(material);
        return this;
    }

    public ItemStack toItemStack() {
        return itemStack;
    }

    public KumaItem clone() {
        return new KumaItem(itemStack);
    }

}
