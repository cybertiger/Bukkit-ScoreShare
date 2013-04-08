/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cyberiantiger.minecraft.scoreshare.api;

import java.util.Collection;
import org.bukkit.plugin.Plugin;

/**
 *
 * @author antony
 */
public interface TeamProvider<T extends Plugin> {

    /**
     * Gets the plugin providing these teams.
     * 
     * @return 
     */
    public T getPlugin();

    /**
     * Gets the name of the team provider.
     * 
     * @return 
     */
    public String getName();

    /**
     * Gets the initial set of Teams.
     * 
     */
    public Collection<Team> getTeams();

    /**
     * Adds a listener to this team provider.
     * 
     * @param listener the listener
     */
    public void addListener(TeamProviderListener listener);

    /**
     * Removes a listener from this team provider.
     * 
     * @param listener the listener
     */
    public void removeListener(TeamProviderListener listener);
}
