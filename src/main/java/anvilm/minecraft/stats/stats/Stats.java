package anvilm.minecraft.stats.stats;

import anvilm.minecraft.stats.stats.events.StatsTrack;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Stats extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic


        Bukkit.getPluginManager().registerEvents(new StatsTrack(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
