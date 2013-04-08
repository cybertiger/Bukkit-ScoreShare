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
public interface TeamProviderFactory<T extends Plugin> {

    public T getPlugin();

    public TeamProvider<T> getTeamProvider(Player player);
    
}
