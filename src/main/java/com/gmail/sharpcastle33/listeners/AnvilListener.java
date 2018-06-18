package com.gmail.sharpcastle33.listeners;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class AnvilListener implements Listener {

	public static final String REPAIR_INVENTORY_NAME = "Item Repair";
	public static final String REPAIR_ITEM_NAME = "Repair";
	public static final String HELP_ITEM_NAME = "Help";

	@EventHandler
	public void onAnvilOpen(PlayerInteractEvent event) {

		// Check if interaction block is an anvil
		if (event.getClickedBlock().getType() != Material.ANVIL) {
			return;
		}

		Player player = event.getPlayer();

		// Open GUI

		if (player instanceof Player) {
			
			event.setCancelled(true);

			Inventory repair = Bukkit.getServer().createInventory(player, 9, REPAIR_INVENTORY_NAME);

			ItemStack repairItem = new ItemStack(Material.ANVIL);
			ItemMeta repairItemMeta = repairItem.hasItemMeta() ? repairItem.getItemMeta()
					: Bukkit.getItemFactory().getItemMeta(repairItem.getType());

			repairItemMeta.setDisplayName(REPAIR_ITEM_NAME);
			repairItem.setItemMeta(repairItemMeta);

			ItemStack help = new ItemStack(Material.PAPER);
			ItemMeta helpMeta = help.hasItemMeta() ? help.getItemMeta()
					: Bukkit.getItemFactory().getItemMeta(Material.PAPER);
			
			helpMeta.setDisplayName(HELP_ITEM_NAME);
			
			ArrayList<String> helpLore = new ArrayList<>();
			helpLore.add(ChatColor.GREEN + "Place item and stablization powder to the right");
			helpLore.add(ChatColor.GREEN + "Click 'Repair'");

			helpMeta.setLore(helpLore);

			help.setItemMeta(helpMeta);

			repair.setItem(0, repairItem);
			repair.setItem(1, help);

			player.sendMessage("You've clicked on an anvil, it should open a new gui.");
			player.openInventory(repair);
		}
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		if(!event.getInventory().getName().equals(REPAIR_INVENTORY_NAME)) {
			return;
		}
		
		ItemStack clickedItem = event.getCurrentItem();
		
		// Handle repair item clicked
		if(clickedItem.getItemMeta().getDisplayName().equals(REPAIR_ITEM_NAME)) {
			event.setCancelled(true);
		}
		
		// Handle help item clicked
		if(clickedItem.getItemMeta().getDisplayName().equals(HELP_ITEM_NAME)) {
			event.setCancelled(true);
		}
		
		
		
	}
}

























