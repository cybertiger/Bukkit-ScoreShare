/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cyberiantiger.minecraft.scoreshare.api;

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import org.bukkit.plugin.Plugin;

/**
 * Abstract Implementation of TeamProvider
 * 
 * @author antony
 */
public abstract class AbstractTeamProvider<T extends Plugin> implements TeamProvider<T> {
    private final Set<TeamProviderListener> listeners = Collections.newSetFromMap(new WeakHashMap<TeamProviderListener, Boolean>());
    private final T plugin;
    private final String name;

    /**
     * Creates a new AbstractTeamProvider.
     * 
     * @param plugin the plugin supplying this TeamProvider.
     * @param name the name of this TeamProvider
     */
    public AbstractTeamProvider(T plugin, String name) {
        this.plugin = plugin;
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final T getPlugin() {
        return plugin;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final String getName() {
        return name;
    }

    /**
     * Notify listeners to add a new team.
     * 
     * @param teamName the team to add.
     */
    protected void fireAddTeam(String teamName) {
        for (TeamProviderListener listener : listeners) {
            listener.addTeam(teamName);
        }
    }

    /**
     * Notify listeners to remove a team.
     * 
     * @param teamName the team to rmeove.
     */
    protected void fireRemoveTeam(String teamName) {
        for (TeamProviderListener listener : listeners) {
            listener.removeTeam(teamName);
        }
    }

    /**
     * Notify listeners to update a team's display name.
     * 
     * @param teamName name of team to update
     * @param displayName new display name for team
     */
    protected void fireModifyTeamDisplayName(String teamName, String displayName) {
        for (TeamProviderListener listener : listeners) {
            listener.modifyTeamDisplayName(teamName, displayName);
        }
    }

    /**
     * Notify listeners to update a team's prefix.
     * 
     * @param teamName name of team to update
     * @param prefix new prefix for team
     */
    protected void fireModifyTeamPrefix(String teamName, String prefix) {
        for (TeamProviderListener listener : listeners) {
            listener.modifyTeamPrefix(teamName, prefix);
        }
    }

    /**
     * Notify listeners to update a team's suffix.
     * 
     * @param teamName name of team to update
     * @param suffix new suffix for team
     */
    protected void fireModifyTeamSuffix(String teamName, String suffix) {
        for (TeamProviderListener listener : listeners) {
            listener.modifyTeamSuffix(teamName, suffix);
        }
    }

    /**
     * Notify listeners to update a team's friendlyFire flag.
     * 
     * @param teamName name of team to update
     * @param friendlyFire new value of friendlyFire flag
     */
    protected void fireModifyTeamFriendlyFire(String teamName, boolean friendlyFire) {
        for (TeamProviderListener listener : listeners) {
            listener.modifyTeamFriendlyFire(teamName, friendlyFire);
        }
    }

    /**
     * Notify listeners to update a team's seeInvisibleFriendlies flag.
     * 
     * @param teamName name of team to update
     * @param seeInvisibleFriendlies new value of seeInvisibleFriendlies flag
     */
    protected void fireModifyTeamSeeInvisibleFriendlies(String teamName, boolean seeInvisibleFriendlies) {
        for (TeamProviderListener listener : listeners) {
            listener.modifyTeamSeeInvisibleFriendlies(teamName, seeInvisibleFriendlies);
        }
    }

    /**
     * Notify listeners to add a new team member to a team.
     * 
     * @param teamName name of team to add member to
     * @param member member to add to team
     */
    protected void fireAddTeamMember(String teamName, String member) {
        for (TeamProviderListener listener : listeners) {
            listener.addTeamMember(teamName, member);
        }
    }

    /**
     * Notify listeners to remove a team member from a team.
     * 
     * @param teamName name of team to remove member from
     * @param member member to remove from team
     */
    protected void fireRemoveTeamMember(String teamName, String member) {
        for (TeamProviderListener listener : listeners) {
            listener.removeTeamMember(teamName, member);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addListener(TeamProviderListener listener) {
        listeners.add(listener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeListener(TeamProviderListener listener) {
        listeners.remove(listener);
    }
    
}
