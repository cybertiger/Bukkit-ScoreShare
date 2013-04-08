/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cyberiantiger.minecraft.scoreshare;

import java.util.Collection;
import org.bukkit.plugin.Plugin;

/**
 *
 * @author antony
 */
public abstract class AbstractTeamProvider<T extends Plugin> implements TeamProvider<T> {
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

    @Override
    public void addListener(TeamProviderListener listener) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeListener(TeamProviderListener listener) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
