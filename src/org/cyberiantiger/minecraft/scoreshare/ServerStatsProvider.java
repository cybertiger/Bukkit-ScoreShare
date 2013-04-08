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

/**
 *
 * @author antony
 */
class ServerStatsProvider extends AbstractObjectiveProvider<ScoreShare> implements ObjectiveProviderFactory<ScoreShare> {
    private static final int MB = 1024 * 1024;
    private static final long DELAY = 20 * 30; // 30 seconds.

    public ServerStatsProvider(ScoreShare scoreShare) {
        super(scoreShare, "serverStats", "Server Statistics", "dummy");
        getPlugin().getServer().getScheduler().runTaskTimer(getPlugin(), new Runnable() {

            @Override
            public void run() {
                for (Map.Entry<OfflinePlayer, Integer> e : getScores().entrySet()) {
                    firePutScore(e.getKey(), e.getValue());
                }
            }
        }, DELAY, DELAY);
    }

    @Override
    public Map<OfflinePlayer, Integer> getScores() {
        OfflinePlayer totalMemory = getPlugin().getServer().getOfflinePlayer("Total Memory");
        OfflinePlayer freeMemory = getPlugin().getServer().getOfflinePlayer("Free Memory");
        OfflinePlayer maxMemory = getPlugin().getServer().getOfflinePlayer("Max Memory");

        Map<OfflinePlayer, Integer> result = new HashMap<OfflinePlayer, Integer>();
        result.put(totalMemory, (int) (Runtime.getRuntime().totalMemory() / MB));
        result.put(maxMemory, (int) (Runtime.getRuntime().maxMemory() / MB));
        result.put(freeMemory, (int) (Runtime.getRuntime().freeMemory() / MB));
        return result;
    }

    @Override
    public ObjectiveProvider<ScoreShare> getProvider(Player player) {
        if (player.hasPermission("scoreshare.objective.serverStats")) {
            return this;
        } else {
            return null;
        }
    }
    
}
