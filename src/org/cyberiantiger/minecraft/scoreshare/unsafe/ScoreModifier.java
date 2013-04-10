/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cyberiantiger.minecraft.scoreshare.unsafe;

import org.bukkit.OfflinePlayer;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Scoreboard;

/**
 * Not public API.
 * 
 * @author antony
 */
public interface ScoreModifier {
    public boolean isSet(Scoreboard scoreboard, DisplaySlot slot, OfflinePlayer player);

    public void reset(Scoreboard scoreboard, DisplaySlot slot, OfflinePlayer player);
}
