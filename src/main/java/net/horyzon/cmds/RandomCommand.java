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
    private ItemStack makeItem (Material material, int amount) {
        return new ItemStack(material, amount);
    }
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (commandSender instanceof Player) {
            Player player = (Player)commandSender;


            ItemStack diamondChestPlate = new ItemStack(Material.DIAMOND_CHESTPLATE);
            ItemStack goldenApple = new ItemStack(Material.GOLDEN_APPLE);
            ItemStack netheriteChest = new ItemStack(Material.NETHERITE_CHESTPLATE);
            ItemStack gapple = makeItem(Material.MELON, 2);
            goldenApple.setAmount(19);


            if (args.length == 0) {
                player.getInventory().addItem(diamondChestPlate, goldenApple);
            } else if (args.length == 1) {
                if (args[0].equals("1")) {
                    player.getInventory().addItem(netheriteChest);
                    player.getInventory().setChestplate(netheriteChest);
                } else if (args[0].equals("2")) {
                    player.getInventory().addItem(netheriteChest, diamondChestPlate, goldenApple);
                    player.getInventory().addItem(gapple);

                } else {
                    return false;
                }
            } else {
                return false;
            }


        } else {
            System.out.println("Womp Womp LIl BRo - ok seriously consoles like cant run ts");
        }
        return true;
    }
}