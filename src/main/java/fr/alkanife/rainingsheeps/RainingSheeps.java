package fr.alkanife.rainingsheeps;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class RainingSheeps extends JavaPlugin implements @NotNull Listener {

    public static RainingSheeps INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent playerJoinEvent) {
        new SheepRunnable().runTaskTimer(this, 5, 5);
    }

}