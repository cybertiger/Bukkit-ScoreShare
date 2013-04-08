/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cyberiantiger.minecraft.scoreshare;

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.Plugin;

/**
 *
 * @author antony
 */
public abstract class AbstractTeamProvider<T extends Plugin> implements TeamProvider<T> {
    private final Set<TeamProviderListener> listeners = Collections.newSetFromMap(new WeakHashMap<TeamProviderListener, Boolean>());
    private final T plugin;
    private final String name;

    public AbstractTeamProvider(T plugin, String name) {
        this.plugin = plugin;
        this.name = name;
    }

    @Override
    public final T getPlugin() {
        return plugin;
    }

    @Override
    public final String getName() {
        return name;
    }

    protected void fireAddTeam(String teamName) {
        for (TeamProviderListener listener : listeners) {
            listener.addTeam(teamName);
        }
    }

    protected void fireRemoveTeam(String teamName) {
        for (TeamProviderListener listener : listeners) {
            listener.removeTeam(teamName);
        }
    }

    protected void fireModifyTeamDisplayName(String teamName, String displayName) {
        for (TeamProviderListener listener : listeners) {
            listener.modifyTeamDisplayName(teamName, displayName);
        }
    }

    protected void fireModifyTeamPrefix(String teamName, String prefix) {
        for (TeamProviderListener listener : listeners) {
            listener.modifyTeamPrefix(teamName, prefix);
        }
    }

    protected void fireModifyTeamSuffix(String teamName, String suffix) {
        for (TeamProviderListener listener : listeners) {
            listener.modifyTeamSuffix(teamName, suffix);
        }
    }

    protected void fireModifyTeamFriendlyFire(String teamName, boolean friendlyFire) {
        for (TeamProviderListener listener : listeners) {
            listener.modifyTeamFriendlyFire(teamName, friendlyFire);
        }
    }

    protected void fireModifyTeamSeeInvisibleFriendlies(String teamName, boolean seeInvisibleFriendlies) {
        for (TeamProviderListener listener : listeners) {
            listener.modifyTeamSeeInvisibleFriendlies(teamName, seeInvisibleFriendlies);
        }
    }

    protected void fireAddTeamMember(String teamName, OfflinePlayer member) {
        for (TeamProviderListener listener : listeners) {
            listener.addTeamMember(teamName, member);
        }
    }

    protected void fireRemoveTeamMember(String teamName, OfflinePlayer member) {
        for (TeamProviderListener listener : listeners) {
            listener.removeTeamMember(teamName, member);
        }
    }

    @Override
    public void addListener(TeamProviderListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeListener(TeamProviderListener listener) {
        listeners.remove(listener);
    }
    
}
