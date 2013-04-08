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
public abstract class AbstractObjectiveProvider<T extends Plugin> implements ObjectiveProvider<T> {
    private final Set<ObjectiveProviderListener> listeners = Collections.newSetFromMap(new WeakHashMap<ObjectiveProviderListener, Boolean>());
    private final T plugin;
    private final String name;
    private final String displayName;
    private final String criteria;

    public AbstractObjectiveProvider(T plugin, String name, String displayName, String criteria) {
        this.plugin = plugin;
        this.name = name;
        this.displayName = displayName;
        this.criteria = criteria;
    }

    @Override
    public T getPlugin() {
        return plugin;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String getCriteria() {
        return criteria;
    }

    protected void firePutScore(OfflinePlayer player, int score) {
        for (ObjectiveProviderListener listener : listeners) {
            listener.putScore(player, score);
        }
    }

    protected void fireRemoveScore(OfflinePlayer player) {
        for (ObjectiveProviderListener listener : listeners) {
            listener.removeScore(player);
        }
    }

    @Override
    public void addListener(ObjectiveProviderListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeListener(ObjectiveProviderListener listener) {
        listeners.add(listener);
    }
}
