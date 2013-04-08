/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cyberiantiger.minecraft.scoreshare.api;

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.Plugin;

/**
 * Abstract implementation of ObjectiveProvider.
 * 
 * @author antony
 */
public abstract class AbstractObjectiveProvider<T extends Plugin> implements ObjectiveProvider<T> {
    private final Set<ObjectiveProviderListener> listeners = Collections.newSetFromMap(new WeakHashMap<ObjectiveProviderListener, Boolean>());
    private final T plugin;
    private final String name;
    private final String displayName;
    private final String criteria;

    /**
     * Creates a new AbstractObjectiveProvider.
     * 
     * @param plugin The plugin supplying this ObjectiveProvider.
     * @param name The name of this ObjectiveProvider.
     * @param displayName The display name of this ObjectiveProvider.
     * @param criteria The criteria name of this ObjectiveProvider.
     */
    public AbstractObjectiveProvider(T plugin, String name, String displayName, String criteria) {
        this.plugin = plugin;
        this.name = name;
        this.displayName = displayName;
        this.criteria = criteria;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T getPlugin() {
        return plugin;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String getCriteria() {
        return criteria;
    }

    /**
     * Inform listeners of a modified score.
     * 
     * @param player the player to update the score for
     * @param score the new score
     */
    protected void firePutScore(OfflinePlayer player, int score) {
        for (ObjectiveProviderListener listener : listeners) {
            listener.putScore(player, score);
        }
    }

    /**
     * Inform listeners of a removed score.
     * 
     * @param player the player to remove the score from
     */
    protected void fireRemoveScore(OfflinePlayer player) {
        for (ObjectiveProviderListener listener : listeners) {
            listener.removeScore(player);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addListener(ObjectiveProviderListener listener) {
        listeners.add(listener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeListener(ObjectiveProviderListener listener) {
        listeners.add(listener);
    }
}
