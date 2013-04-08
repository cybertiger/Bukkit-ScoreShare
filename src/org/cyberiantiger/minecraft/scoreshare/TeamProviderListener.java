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
public interface TeamProviderListener {

    public void addTeam(String name);

    public void removeTeam(String name);

    public void modifyTeamDisplayName(String team, String displayName);

    public void modifyTeamPrefix(String team, String prefix);

    public void modifyTeamSuffix(String team, String suffix);

    public void modifyTeamFriendlyFire(String team, boolean friendlyFire);

    public void modifyTeamSeeInvisibleFriendlies(String team, boolean seeInvisibleFriendlies);

    public void addTeamMember(String team, OfflinePlayer member);

    public void removeTeamMember(String team, OfflinePlayer member);
}
