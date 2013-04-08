/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cyberiantiger.minecraft.scoreshare;

import org.bukkit.OfflinePlayer;

/**
 *
 * @author antony
 */
public interface ObjectiveProviderListener {

    public void putScore(OfflinePlayer player, int score);

    public void removeScore(OfflinePlayer player);

}
