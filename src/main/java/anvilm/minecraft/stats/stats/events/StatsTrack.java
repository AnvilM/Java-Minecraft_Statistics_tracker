package anvilm.minecraft.stats.stats.events;

import anvilm.minecraft.stats.stats.utils.http;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDropItemEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class StatsTrack implements Listener {

    private String domain = "http://localhost";

    @EventHandler
    public void onDeath(PlayerDeathEvent event){
        String killed = event.getEntity().getName();

        http.get(domain + "/api/player/"+killed+"/death");


        String killer = event.getEntity().getKiller().getName();

        http.get(domain + "/api/player/"+killer+"/kill");
    }

    @EventHandler
    public void onPickUp(EntityPickupItemEvent event){
        if(event.getEntity() instanceof Player){
            String nickname = event.getEntity().getName();

            http.get(domain + "/api/player/"+nickname+"/pick_up");

        }
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent event){
        String nickname = event.getPlayer().getName();

        http.get(domain + "/api/player/"+nickname+"/drop");

    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        String nickname = event.getPlayer().getName();

        http.get(domain + "/api/player/"+nickname+"/add");

    }

}
