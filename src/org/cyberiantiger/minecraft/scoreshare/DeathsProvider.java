/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cyberiantiger.minecraft.scoreshare;

import java.util.Collections;
import java.util.Map;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Criterias;

/**
 *
 * @author antony
 */
class DeathsProvider extends AbstractObjectiveProvider<ScoreShare> implements ObjectiveProviderFactory<ScoreShare> {

    public DeathsProvider(ScoreShare scoreShare) {
        super(scoreShare, "deaths", "Deaths", Criterias.DEATHS);
    }

    @Override
    public Map<OfflinePlayer, Integer> getScores() {
        return Collections.EMPTY_MAP;
    }

    @Override
    public ObjectiveProvider<ScoreShare> getProvider(Player player) {
        return this;
    }
    
    // TODO
    
}
