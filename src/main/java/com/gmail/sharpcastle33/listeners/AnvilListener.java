package com.gmail.sharpcastle33.listeners;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class AnvilListener implements Listener {
	

	public static final String REPAIR_INVENTORY_NAME = "Item Repair";
	public static final String REPAIR_GUICMD = "repair";

	@EventHandler
	public void onAnvilOpen(PlayerInteractEvent event) {
		
		// Check if interaction block is an anvil
		if (event.getClickedBlock().getType() != Material.ANVIL) {
			return;
		}
		
		Player player = event.getPlayer();
		
		// Open GUI

		if (player instanceof Player) {
				Inventory repair = Bukkit.getServer().createInventory(player, 9, REPAIR_INVENTORY_NAME);
				
				
				ItemStack repairItem = new ItemStack(Material.ANVIL);
				ItemMeta repairItemMeta = repairItem.hasItemMeta() ?
						repairItem.getItemMeta() : Bukkit.getItemFactory().getItemMeta(repairItem.getType());

				repairItemMeta.setDisplayName("Repair");
				repairItem.setItemMeta(repairItemMeta);
				
				
				ItemStack help = new ItemStack(Material.PAPER);
				ItemMeta helpMeta = help.hasItemMeta() ? 
						help.getItemMeta() : Bukkit.getItemFactory().getItemMeta(Material.PAPER);
				
				ArrayList<String> helpLore = new ArrayList<>();
				helpLore.add(ChatColor.GREEN + "Place item to be repaired to the right");
				helpLore.add(ChatColor.GREEN + "Then click 'Repair'");
				
				helpMeta.setLore(helpLore);
				
				help.setItemMeta(helpMeta);
				
				repair.setItem(0, repairItem);
				repair.setItem(1, help);
		}
	}
}


