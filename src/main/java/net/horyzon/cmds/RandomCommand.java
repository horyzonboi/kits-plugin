package net.horyzon.cmds;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.jetbrains.annotations.NotNull;

import java.rmi.MarshalException;
import java.util.ArrayList;
import java.util.List;

public class RandomCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        List<ItemStack> netheriteSet = new ArrayList<>();
        netheriteSet.add(new ItemStack(Material.NETHERITE_HELMET));
        netheriteSet.add(new ItemStack(Material.NETHERITE_CHESTPLATE));
        netheriteSet.add(new ItemStack(Material.NETHERITE_LEGGINGS));
        netheriteSet.add(new ItemStack(Material.NETHERITE_BOOTS));
        List<ItemStack> diamondSet = new ArrayList<>();
        diamondSet.add(new ItemStack(Material.DIAMOND_HELMET));
        diamondSet.add(new ItemStack(Material.DIAMOND_CHESTPLATE));
        diamondSet.add(new ItemStack(Material.DIAMOND_LEGGINGS));
        diamondSet.add(new ItemStack(Material.DIAMOND_BOOTS));

        if (commandSender instanceof Player) {
            Player player = (Player)commandSender;

            if (args.length == 0) {
                commandSender.sendMessage("Please state a kit: Netherite | Diamond");
            } else if (args.length == 1) {
                if (args[0].equals("netherite")) {          //netherite kit
                    player.getInventory().setHelmet(netheriteSet.get(0));
                    player.getInventory().setChestplate(netheriteSet.get(1));
                    player.getInventory().setLeggings(netheriteSet.get(2));
                    player.getInventory().setBoots(netheriteSet.get(3));
                } else if (args[0].equals("diamond")) {     //diamond kit
                    player.getInventory().setHelmet(diamondSet.get(0));

                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            String playerName = args[1];
            Player player = Bukkit.getPlayerExact(playerName);
            if (args.length == 2) {
                if (player != null && player.isOnline()) {
                    if (args[0].equalsIgnoreCase("Netherite")) {
                        player.getInventory().setHelmet(netheriteSet.get(0));
                        player.getInventory().setChestplate(netheriteSet.get(1));
                        player.getInventory().setLeggings(netheriteSet.get(2));
                        player.getInventory().setBoots(netheriteSet.get(3));
                    } else if (args[0].equalsIgnoreCase("Diamond")) {
                        player.getInventory().setHelmet(diamondSet.get(0));
                        player.getInventory().setChestplate(diamondSet.get(1));

                    } else {
                        commandSender.sendMessage("Only valid kits are <Diamond | Netherite");
                    }
                } else {
                    commandSender.sendMessage("Player either Offline or Inaccessible ");
                }
            } else {
                if (commandSender instanceof ConsoleCommandSender) {
                    commandSender.sendMessage(ChatColor.ITALIC + "In order to execute through console, use the following parameters!");
                    commandSender.sendMessage("/kit <Netherite | Diamond> <PlayerName>");
                } else {
                    commandSender.sendMessage(ChatColor.RED + "To execute: /kit <Netherite | Diamond> <PlayerName>");
                }
            }
        }
        return true;
    }
}