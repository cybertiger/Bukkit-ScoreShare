/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cyberiantiger.minecraft.scoreshare.unsafe.v1_5_R2;

import com.google.common.collect.ImmutableSet;
import java.util.EnumMap;
import java.util.Map;
import net.minecraft.server.v1_5_R2.ScoreboardObjective;
import net.minecraft.server.v1_5_R2.ScoreboardScore;
import org.bukkit.OfflinePlayer;
import org.bukkit.craftbukkit.v1_5_R2.scoreboard.CraftScoreboard;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

/**
 *
 * @author antony
 */
public class ScoreModifier implements org.cyberiantiger.minecraft.scoreshare.unsafe.ScoreModifier {

    private static final Map<DisplaySlot, Integer> translation = new EnumMap<DisplaySlot, Integer>(DisplaySlot.class);

    static {
        translation.put(DisplaySlot.BELOW_NAME, 2);
        translation.put(DisplaySlot.PLAYER_LIST, 0);
        translation.put(DisplaySlot.SIDEBAR, 1);
    }

    @Override
    public boolean isSet(Scoreboard scoreboard, DisplaySlot slot, OfflinePlayer player) {
        CraftScoreboard cs = (CraftScoreboard) scoreboard;
        ScoreboardObjective objectiveForSlot = cs.getHandle().getObjectiveForSlot(translation.get(slot));
        if (objectiveForSlot == null)
            return false;
        Map playerObjectives = cs.getHandle().getPlayerObjectives(player.getName());
        return playerObjectives.containsKey(objectiveForSlot);
    }

    @Override
    public void reset(Scoreboard scoreboard, DisplaySlot slot, OfflinePlayer player) {
        CraftScoreboard cs = (CraftScoreboard) scoreboard;
        ScoreboardObjective objectiveForSlot = cs.getHandle().getObjectiveForSlot(translation.get(slot));
        if (objectiveForSlot == null)
            return;
        Map<ScoreboardObjective, ScoreboardScore> playerObjectives = cs.getHandle().getPlayerObjectives(player.getName());

        if (playerObjectives.remove(objectiveForSlot) == null) {
            // If they don't have a score to delete, don't delete it.
            return;
        }
        cs.getHandle().resetPlayerScores(player.getName());
        for (Map.Entry<ScoreboardObjective, ScoreboardScore> e : playerObjectives.entrySet()) {
            cs.getHandle().getPlayerScoreForObjective(player.getName(), e.getKey()).setScore(e.getValue().getScore());
        }
    }


}
