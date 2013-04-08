/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cyberiantiger.minecraft.scoreshare;

import java.util.Map;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.Plugin;

/**
 *
 * @author antony
 */
public interface ObjectiveProvider<T extends Plugin> {

    public T getPlugin();

    public String getName();

    public String getDisplayName();

    public String getCriteria();

    public Map<OfflinePlayer, Integer> getScores();

    public void addListener(ObjectiveProviderListener listener);

    public void removeListener(ObjectiveProviderListener listener);

}
