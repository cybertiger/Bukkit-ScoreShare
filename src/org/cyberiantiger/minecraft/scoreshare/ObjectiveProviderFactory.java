/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cyberiantiger.minecraft.scoreshare;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

/**
 *
 * @author antony
 */
public interface ObjectiveProviderFactory<T extends Plugin> {

    /**
     * Gets the plugin which provides this factory.
     * 
     * @return a plugin
     */
    public T getPlugin();

    /**
     * Gets the ObjectiveProvider for a specific Player.
     * <p>
     * The player will always be logged in, which will means you can check permissions.
     * 
     * @param player
     * @return null if this objective is not available to the player, or an ObjectiveProvider.
     */
    public ObjectiveProvider<T> getProvider(Player player);

}
