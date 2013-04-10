/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cyberiantiger.minecraft.scoreshare.api;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.DisplaySlot;

/**
 * API for manipulating player's scoreboards.
 * 
 * Subject to change in future.
 * 
 * @author antony
 */
public interface ScoreShareAPI {

    /**
     * Resets all player's scoreboards.
     */
    public void reset();

    /**
     * Resets the scoreboard for the player to the default.
     * 
     * @param player 
     */
    public void reset(Player player);

    /**
     * Sets the team provider for all players.
     * 
     * @param source plugin supplying the team provider
     * @param name name of the team provider
     */
    public void setTeamProvider(Plugin source, String name);

    /**
     * Sets the team provider for a player.
     * 
     * @param player player to modify the scoreboard of
     * @param source plugin supplying the team provider
     * @param name name of the team provider
     */
    public void setTeamProvider(Player player, Plugin source, String name);

    /**
     * Sets the objective provider for all players.
     * 
     * @param slot slot to modify.
     * @param source plugin supplying the objective provider
     * @param name name of the objective provider
     */
    public void setObjectiveProvider(DisplaySlot slot, Plugin source, String name);

    /**
     * Sets the objective provider for a specific player.
     * 
     * @param player player to modify the scoreboard of
     * @param slot slot to modify
     * @param source plugin supplying the objective provider
     * @param name name of the objective provider
     */
    public void setObjectiveProvider(Player player, DisplaySlot slot, Plugin source, String name);
    
}
