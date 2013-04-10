/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cyberiantiger.minecraft.scoreshare.api;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

/**
 * Factory for TeamProvider.
 *
 * @author antony
 */
public interface TeamProviderFactory<T extends Plugin> {

    /**
     * Gets the supplying plugin.
     * 
     * @return a plugin
     */
    public T getPlugin();

    /**
     * Creates a team provider for a specific player.
     * <p>
     * This may check permissions and return null if the provider is
     * not available to the player.
     * 
     * @param player the player to create the TeamProvider for
     * @return null or a TeamProvider
     */
    public TeamProvider<T> getTeamProvider(Player player);
    
}
