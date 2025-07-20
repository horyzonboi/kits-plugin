package net.horyzon.cmds;

import org.bukkit.plugin.java.JavaPlugin;

public final class Cmds extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("Kit").setExecutor(new RandomCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
