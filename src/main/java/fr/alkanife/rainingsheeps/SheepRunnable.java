package fr.alkanife.rainingsheeps;

import com.google.common.base.Preconditions;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class SheepRunnable extends BukkitRunnable {

    @Override
    public void run() {
        World world = Bukkit.getWorlds().get(0);
        Location start = new Location(world, -86, 72, -126);
        Location min = new Location(world, start.getX()+50, start.getY()+25, start.getZ()+50);
        Location max = new Location(world, start.getX()-50, start.getY()+25, start.getZ()-50);
        Location location = randomLocation(min, max);

        Entity entity = world.spawnEntity(location, EntityType.SHEEP);
        entity.customName(Component.text("jeb_"));
        entity.setCustomNameVisible(false);

        Sheep sheep = (Sheep) entity;
        sheep.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 200, 2, false, false));

        new KillingSheepRunnable(sheep).runTaskLater(RainingSheeps.INSTANCE, 100);
    }

    public Location randomLocation(Location min, Location max)
    {
        Location range = new Location(min.getWorld(), Math.abs(max.getX() - min.getX()), min.getY(), Math.abs(max.getZ() - min.getZ()));
        return new Location(min.getWorld(), (Math.random() * range.getX()) + (min.getX() <= max.getX() ? min.getX() : max.getX()), range.getY(), (Math.random() * range.getZ()) + (min.getZ() <= max.getZ() ? min.getZ() : max.getZ()));
    }

}
