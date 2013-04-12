/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cyberiantiger.minecraft.scoreshare;

import org.cyberiantiger.minecraft.scoreshare.api.ObjectiveProviderFactory;
import org.cyberiantiger.minecraft.scoreshare.api.ObjectiveProvider;
import org.cyberiantiger.minecraft.scoreshare.api.AbstractObjectiveProvider;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.Criterias;

/**
 *
 * @author antony
 */
class HealthProvider extends AbstractObjectiveProvider<ScoreShare> implements ObjectiveProviderFactory<ScoreShare>, Listener {

    public HealthProvider(ScoreShare plugin) {
        super(plugin, "health", "Health", Criterias.HEALTH);
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @Override
    public Map<String, Integer> getScores() {
        Map<String, Integer> ret = new HashMap<String, Integer>();
        for (Player p : getPlugin().getServer().getOnlinePlayers()) {
            ret.put(p.getName(), p.getHealth());
        }
        return ret;
    }

    @Override
    public ObjectiveProvider<ScoreShare> getProvider(Player player) {
        if (player.hasPermission("scoreshare.objective.health")) {
            return this;
        } else {
            return null;
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        firePutScore(e.getPlayer().getName(), e.getPlayer().getHealth());
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        fireRemoveScore(e.getPlayer().getName());
    }
}
