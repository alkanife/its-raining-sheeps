package fr.alkanife.rainingsheeps;

import org.bukkit.Bukkit;
import org.bukkit.entity.Sheep;
import org.bukkit.scheduler.BukkitRunnable;

public class KillingSheepRunnable extends BukkitRunnable {

    private Sheep sheep;

    public KillingSheepRunnable(Sheep sheep) {
        this.sheep = sheep;
    }

    @Override
    public void run() {
        Bukkit.getWorlds().get(0).createExplosion(sheep.getLocation(), 3F, false, false);
        sheep.remove();
    }
}
