/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cyberiantiger.minecraft.scoreshare.api;

import org.bukkit.OfflinePlayer;

/**
 * ObjectiveProvider listener
 * 
 * @author antony
 */
public interface ObjectiveProviderListener {

    /**
     * Notifies this listener of a changed score.
     * 
     * @param player the player the score changed for
     * @param score the new score
     */
    public void putScore(OfflinePlayer player, int score);

    /**
     * Notifies this listener of a removed score.
     * 
     * @param player the player the score was removed for
     */
    public void removeScore(OfflinePlayer player);

}
