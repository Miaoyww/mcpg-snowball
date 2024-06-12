package com.miaoyww.snowball;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.tags.ItemTagType;

public class Listener implements org.bukkit.event.Listener {

    public ItemStack GetReadyItem() {
        NamespacedKey key = new NamespacedKey("ready", "is_ready");
        ItemStack item = new ItemStack(Material.LIME_DYE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§a已准备");
        meta.getCustomTagContainer().setCustomTag(key, ItemTagType.STRING, "true");
        item.setItemMeta(meta);
        return item;
    }
    
    public ItemStack GetUnreadyItem() {
        NamespacedKey key = new NamespacedKey("ready", "is_ready");
        ItemStack item = new ItemStack(Material.RED_DYE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§c未准备");
        meta.getCustomTagContainer().setCustomTag(key, ItemTagType.STRING, "false");
        item.setItemMeta(meta);
        return item;
    }
    
    @EventHandler
    public void onItemDrop(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        ItemStack droppedItem = event.getItemDrop().getItemStack();
        NamespacedKey key = new NamespacedKey("ready", "is_ready");
        // 检查丢弃的物品是否符合条件
        if (droppedItem.getItemMeta().getCustomTagContainer().hasCustomTag(key, ItemTagType.STRING)) {
            if(droppedItem.getType()==Material.LIME_DYE) {
                player.getInventory().setItem(8, GetUnreadyItem());
                TeamManager.removePlayerFromReadyTeam(player);
                player.playSound(player.getLocation(), "entity.experience_orb.pickup", 1, 1);
            }
            else if(droppedItem.getType()==Material.RED_DYE) {
                player.getInventory().setItem(8, GetReadyItem());
                TeamManager.addPlayerToReadyTeam(player);
                player.playSound(player.getLocation(), "entity.experience_orb.pickup", 1, 1);
            }
            event.getItemDrop().setHealth(0);
        }
    }
}
