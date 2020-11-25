package fr.worldbuilding.necromentiacore;

import fr.worldbuilding.necromentiacore.Listeners.CommandListener;
import fr.worldbuilding.necromentiacore.Listeners.MainEventListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class NecromentiaCore extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("Plugin démarré");


        this.getCommand("nc").setExecutor(new CommandListener(this));
        this.getServer().getPluginManager().registerEvents(new MainEventListener(this), this);
    }
}
