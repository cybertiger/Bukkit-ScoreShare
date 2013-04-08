/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cyberiantiger.minecraft.scoreshare;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.world.WorldLoadEvent;
import org.bukkit.event.world.WorldUnloadEvent;

/**
 *
 * @author antony
 */
class WorldProvider extends AbstractTeamProvider<ScoreShare> implements TeamProviderFactory<ScoreShare>, Listener {

    public WorldProvider(ScoreShare scoreShare) {
        super(scoreShare, "worlds");
        getPlugin().getServer().getPluginManager().registerEvents(this, scoreShare);
    }

    @Override
    public Collection<Team> getTeams() {
        Map<String, Team> teams = new HashMap<String, Team>();
        for (World w : getPlugin().getServer().getWorlds()) {
            Team team = new Team(w.getName());
            teams.put(w.getName(), team);
            team.setPrefix('[' + StringUtil.clampSize(w.getName(),14) + ']');
        }
        for (Player p : getPlugin().getServer().getOnlinePlayers()) {
            Team team = teams.get(p.getWorld().getName());
            team.addMember(p);
        }
        return teams.values();
    }

    @Override
    public TeamProvider<ScoreShare> getTeamProvider(Player player) {
        return this;
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onWorldLoad(WorldLoadEvent e) {
        World newWorld = e.getWorld();
        fireAddTeam(newWorld.getName());
        fireModifyTeamPrefix(newWorld.getName(), '[' + StringUtil.clampSize(newWorld.getName(), 14) + ']');
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onWorldUnload(WorldUnloadEvent e) {
        World oldWorld = e.getWorld();
        fireRemoveTeam(oldWorld.getName());
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        fireAddTeamMember(player.getWorld().getName(), player);
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onPlayerQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        fireRemoveTeamMember(player.getWorld().getName(), player);
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onPlayerTeleport(PlayerTeleportEvent e) {
        Player player = e.getPlayer();
        Location from = e.getFrom();
        Location to = e.getTo();
        if (from.getWorld() == to.getWorld()) {
            return;
        }
        fireRemoveTeamMember(from.getWorld().getName(), player);
        fireAddTeamMember(to.getWorld().getName(), player);
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onPlayerPortal(PlayerPortalEvent e) {
        Player player = e.getPlayer();
        Location from = e.getFrom();
        Location to = e.getTo();
        if (from.getWorld() == to.getWorld()) {
            return;
        }
        fireRemoveTeamMember(from.getWorld().getName(), player);
        fireAddTeamMember(to.getWorld().getName(), player);
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onPlayerRespawn(PlayerRespawnEvent e) {
        final Player player = e.getPlayer();
        final Location from = player.getLocation();
        final Location to = e.getRespawnLocation();
        if (from.getWorld() == to.getWorld()) {
            return;
        }
        getPlugin().getServer().getScheduler().runTask(getPlugin(), new Runnable() {

            @Override
            public void run() {
                fireRemoveTeamMember(from.getWorld().getName(), player);
                fireAddTeamMember(to.getWorld().getName(), player);
            }
        });
    }

}
