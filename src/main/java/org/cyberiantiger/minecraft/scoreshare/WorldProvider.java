/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cyberiantiger.minecraft.scoreshare;

import org.cyberiantiger.minecraft.scoreshare.api.TeamProviderFactory;
import org.cyberiantiger.minecraft.scoreshare.api.TeamProvider;
import org.cyberiantiger.minecraft.scoreshare.api.Team;
import org.cyberiantiger.minecraft.scoreshare.api.AbstractTeamProvider;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

/**
 *
 * @author antony
 */
class WorldProvider extends AbstractTeamProvider<ScoreShare> implements TeamProviderFactory<ScoreShare>, Listener {
    private Map<String, Team> worldTeams = new HashMap<String, Team>();

    public WorldProvider(ScoreShare scoreShare) {
        super(scoreShare, "worlds");
        ConfigurationSection config = getPlugin().getConfig().getConfigurationSection("teams.world");
        for (String s : config.getKeys(false)) {
            ConfigurationSection teamConfig = config.getConfigurationSection(s);
            Team team = new Team(s);
            team.setDisplayName(teamConfig.getString("display", s));
            team.setPrefix(teamConfig.getString("prefix", ""));
            team.setSuffix(teamConfig.getString("suffix", ""));
            worldTeams.put(s, team);
        }
        getPlugin().getServer().getPluginManager().registerEvents(this, scoreShare);
    }

    @Override
    public Collection<Team> getTeams() {
        for (Team team : worldTeams.values()) {
            team.setMembers(Collections.<OfflinePlayer>emptySet());
        }
        for (Player p : getPlugin().getServer().getOnlinePlayers()) {
            Team team = worldTeams.get(p.getWorld().getName());
            if (team != null) {
                team.addMember(p);
            }
        }
        return worldTeams.values();
    }

    @Override
    public TeamProvider<ScoreShare> getTeamProvider(Player player) {
        if (player.hasPermission("scoreshare.teams.worlds")) {
            return this;
        } else {
            return null;
        }
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        Team team = worldTeams.get(player.getWorld().getName());
        if (team != null) {
            fireAddTeamMember(player.getWorld().getName(), player);
        }
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onPlayerQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        Team team = worldTeams.get(player.getWorld().getName());
        if (team != null) {
            fireRemoveTeamMember(player.getWorld().getName(), player);
        }
    }

    private void changedWorld(World from, World to, Player player) {
        Team team = worldTeams.get(from.getName());
        if (team != null) {
            fireRemoveTeamMember(team.getName(), player);
        }
        team = worldTeams.get(to.getName());
        if (team != null) {
            fireAddTeamMember(team.getName(), player);
        }
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onPlayerTeleport(PlayerTeleportEvent e) {
        Player player = e.getPlayer();
        Location from = e.getFrom();
        Location to = e.getTo();
        if (from.getWorld() == to.getWorld()) {
            return;
        }
        changedWorld(from.getWorld(), to.getWorld(), player);
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onPlayerPortal(PlayerPortalEvent e) {
        Player player = e.getPlayer();
        Location from = e.getFrom();
        Location to = e.getTo();
        if (from.getWorld() == to.getWorld()) {
            return;
        }
        changedWorld(from.getWorld(), to.getWorld(), player);
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
                changedWorld(from.getWorld(), to.getWorld(), player);
            }
        });
    }

}
