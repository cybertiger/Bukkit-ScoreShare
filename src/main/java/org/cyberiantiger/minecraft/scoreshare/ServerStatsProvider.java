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

/**
 *
 * @author antony
 */
class ServerStatsProvider extends AbstractObjectiveProvider<ScoreShare> implements ObjectiveProviderFactory<ScoreShare> {
    private static final int MB = 1024 * 1024;

    public ServerStatsProvider(ScoreShare scoreShare) {
        super(scoreShare, "serverStats", "Server Statistics", "dummy");
        int delay = getPlugin().getConfig().getInt("objectives.serverstats.delay", 100);
        getPlugin().getServer().getScheduler().runTaskTimer(getPlugin(), new Runnable() {

            @Override
            public void run() {
                for (Map.Entry<String, Integer> e : getScores().entrySet()) {
                    firePutScore(e.getKey(), e.getValue());
                }
            }
        }, delay, delay);
    }

    @Override
    public Map<String, Integer> getScores() {

        Map<String, Integer> result = new HashMap<String, Integer>();
        result.put("Total Memory", (int) (Runtime.getRuntime().totalMemory() / MB));
        result.put("Max Memory", (int) (Runtime.getRuntime().maxMemory() / MB));
        result.put("Free Memory", (int) (Runtime.getRuntime().freeMemory() / MB));
        return result;
    }

    @Override
    public ObjectiveProvider<ScoreShare> getProvider(Player player) {
        if (player.hasPermission("scoreshare.objective.serverstats")) {
            return this;
        } else {
            return null;
        }
    }
    
}
