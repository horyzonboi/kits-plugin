package net.horyzon.cmds;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class RandomCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (commandSender instanceof Player) {
            Player player = (Player)commandSender;
            ItemStack diamondChestPlate = new ItemStack(Material.DIAMOND_CHESTPLATE);
            ItemStack goldenApple = new ItemStack(Material.GOLDEN_APPLE);
            ItemStack netheriteChest = new ItemStack(Material.NETHERITE_CHESTPLATE);
            goldenApple.setAmount(19);


            if (args.length == 0) {
                player.getInventory().addItem(diamondChestPlate, goldenApple);
            } else if (args.length == 1) {
                if (args[0].equals("1")) {
                    player.getInventory().addItem(netheriteChest);
                } else if (args[0].equals("2")) {
                    player.getInventory().addItem(netheriteChest, diamondChestPlate, goldenApple);

                } else {
                    return false;
                }
            } else {
                return false;
            }


        }
        return true;
    }
}