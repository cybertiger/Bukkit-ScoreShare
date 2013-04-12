/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cyberiantiger.minecraft.scoreshare.api;

import java.util.HashSet;
import java.util.Set;
import org.bukkit.Bukkit;

/**
 * A concrete class to represent a Team.
 * 
 * @author antony
 */
public final class Team {
    private final String name;
    private final Set<String> members = new HashSet<String>();
    private String displayName;
    private String prefix = "";
    private String suffix = "";
    private boolean friendlyFire = true;
    private boolean seeInvisibleFriendlies = false;

    /**
     * Creates a new team with a name.
     * 
     * @param name the name of the team.
     */
    public Team(String name) {
        this.name = name;
        this.displayName = name;
    }

    /**
     * Gets the name of the team.
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the display name of the team.
     * 
     * @return the display name
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Sets the display name of the team.
     * 
     * @param displayName the display name
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Gets the members of the team.
     * 
     * @return the members of the team
     */
    public Set<String> getMemberNames() {
        return members;
    }

    /**
     * Sets the members of the team.
     * 
     * @param members the members of the team
     */
    public void setMemberNames(Set<String> members) {
        this.members.clear();
        this.members.addAll(members);
    }

    /**
     * Adds a member to the team.
     * 
     * @param player member to add
     */
    public void addMemberName(String name) {
        members.add(name);
    }

    /**
     * Removes a member from the team.
     * 
     * @param player member to remove
     */
    public void removeMemberName(String name) {
        this.members.remove(name);
    }

    /**
     * Gets the team prefix.
     * 
     * @return the prefix
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * Sets the team prefix.
     * 
     * @param prefix the prefix
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    /**
     * Gets the team suffix.
     * 
     * @return the suffix
     */
    public String getSuffix() {
        return suffix;
    }

    /**
     * Sets the team suffix.
     * 
     * @param suffix the suffix
     */
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    /**
     * Gets if friendly fire is allowed for the team.
     * 
     * @return true if friendly fire is allowed, false otherwise.
     */
    public boolean isFriendlyFire() {
        return friendlyFire;
    }

    /**
     * Sets if friendly fire is allowed for the team.
     * 
     * @param friendlyFire true if friendly fire is allowed, false otherwise.
     */
    public void setFriendlyFire(boolean friendlyFire) {
        this.friendlyFire = friendlyFire;
    }

    /**
     * Gets if team members can see other invisible team members.
     * 
     * @return true if team members can see other invisible team members, false otherwise.
     */
    public boolean isSeeInvisibleFriendlies() {
        return seeInvisibleFriendlies;
    }

    /**
     * Sets if team members can see other invisible team members.
     * 
     * @param seeInvisibleFriendlies true if team members can see invisible team members, false otherwise.
     */
    public void setSeeInvisibleFriendlies(boolean seeInvisibleFriendlies) {
        this.seeInvisibleFriendlies = seeInvisibleFriendlies;
    }

}
