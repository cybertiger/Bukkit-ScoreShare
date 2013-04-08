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
import org.bukkit.OfflinePlayer;
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
    public Map<OfflinePlayer, Integer> getScores() {
        Map<OfflinePlayer, Integer> ret = new HashMap<OfflinePlayer, Integer>();
        for (Player p : getPlugin().getServer().getOnlinePlayers()) {
            ret.put(p, p.getHealth());
        }
        return ret;
    }

    @Override
    public ObjectiveProvider<ScoreShare> getProvider(Player player) {
        return this;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        firePutScore(e.getPlayer(), e.getPlayer().getHealth());
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        fireRemoveScore(e.getPlayer());
    }
}
