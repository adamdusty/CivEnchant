package com.gmail.sharpcastle33.repair;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ItemRepair {

	public ItemStack repairItem;
	public ItemStack[] stablizationPowder;
	public Player player;
	
	public ItemRepair(Player player, ItemStack repairItem, ItemStack[] powder) {
		this.repairItem = repairItem;
		this.player = player;
		this.stablizationPowder = powder;
	}
	
	
	public ItemStack repair() {
		return repairItem;
	}
	
	
}
