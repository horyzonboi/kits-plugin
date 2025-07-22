package net.horyzon.cmds;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.rmi.MarshalException;
import java.util.ArrayList;
import java.util.List;

public class RandomCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (commandSender instanceof Player) {
            Player player = (Player)commandSender;

            List<ItemStack> netheriteSet = new ArrayList<>();
            netheriteSet.add(new ItemStack(Material.NETHERITE_HELMET));
            netheriteSet.add(new ItemStack(Material.NETHERITE_CHESTPLATE));


            if (args.length == 0) {                         //iron for now, TODO remove this and return false  on NO args, so user has to pick one
                player.getInventory().addItem();
            } else if (args.length == 1) {
                if (args[0].equals("netherite")) {          //netherite kit
                    player.getInventory().setHelmet(netheriteSet.get(0));
                    player.getInventory().setChestplate(netheriteSet.get(1));
                    player.getInventory().addItem(netheriteSet.get(1));//just to check


                } else if (args[0].equals("diamond")) {     //diamond kit
                    player.getInventory().addItem();

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