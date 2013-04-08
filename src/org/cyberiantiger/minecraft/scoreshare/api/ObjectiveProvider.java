/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cyberiantiger.minecraft.scoreshare.api;

import java.util.Map;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.Plugin;

/**
 * A provider of a single scoreboard objective.
 * 
 * @author antony
 */
public interface ObjectiveProvider<T extends Plugin> {

    /**
     * Gets the plugin supplying this objective provider.
     * 
     * @return the plugin
     */
    public T getPlugin();

    /**
     * Gets the name of this objective provider.
     * 
     * @return the name
     */
    public String getName();

    /**
     * Gets the display name for this objective provider.
     * 
     * @return the display name
     */
    public String getDisplayName();

    /**
     * Gets the criteria name for this objective provider.
     * 
     * @return the criteria name
     */
    public String getCriteria();

    /**
     * Gets the current scores of players for this objective provider.
     * 
     * @return A map of player to score.
     */
    public Map<OfflinePlayer, Integer> getScores();

    /**
     * Add a listener to this ObjectiveProvider to be notified of any changes.
     * 
     * @param listener 
     */
    public void addListener(ObjectiveProviderListener listener);

    /**
     * Remove a listener from this ObjectiveProvider.
     * 
     * @param listener 
     */
    public void removeListener(ObjectiveProviderListener listener);

}
