/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cyberiantiger.minecraft.scoreshare.api;

import org.bukkit.OfflinePlayer;

/**
 * A listener for a TeamProvider.
 * 
 * @author antony
 */
public interface TeamProviderListener {

    /**
     * Receive notification that a team has been added.
     * 
     * @param name the team
     */
    public void addTeam(String name);

    /**
     * Receive notification that a team has been removed.
     * 
     * @param name the team
     */
    public void removeTeam(String name);

    /**
     * Receive notification that a team's display name has been changed.
     * @param team the team
     * @param displayName the new display name
     */
    public void modifyTeamDisplayName(String team, String displayName);

    /**
     * Receive notification that a team's prefix has been changed.
     * 
     * @param team the team
     * @param prefix the new prefix
     */
    public void modifyTeamPrefix(String team, String prefix);

    /**
     * Receive notification that a team's suffix has been changed.
     * 
     * @param team the team
     * @param suffix the new suffix
     */
    public void modifyTeamSuffix(String team, String suffix);

    /**
     * Receive notification that a team's friendlyFire flag has changed.
     * 
     * @param team the team
     * @param friendlyFire the new value of the friendlyFire flag
     */
    public void modifyTeamFriendlyFire(String team, boolean friendlyFire);

    /**
     * Receive notification that a team's seeInvisibleFriendlies flag has changed.
     * 
     * @param team the team
     * @param seeInvisibleFriendlies the new value of the seeInvisibleFriendlies flag
     */
    public void modifyTeamSeeInvisibleFriendlies(String team, boolean seeInvisibleFriendlies);

    /**
     * Receive notification that a team member has been added.
     * 
     * @param team the team
     * @param member the new member
     */
    public void addTeamMember(String team, OfflinePlayer member);

    /**
     * Receive notification that a team member has been removed.
     * 
     * @param team the team
     * @param member the removed member
     */
    public void removeTeamMember(String team, OfflinePlayer member);
}
