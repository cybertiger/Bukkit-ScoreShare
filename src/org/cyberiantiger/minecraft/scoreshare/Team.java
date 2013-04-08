/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cyberiantiger.minecraft.scoreshare;

import java.util.HashSet;
import java.util.Set;
import org.bukkit.OfflinePlayer;

/**
 *
 * @author antony
 */
public final class Team {
    private final String name;
    private final Set<OfflinePlayer> members = new HashSet<OfflinePlayer>();
    private String displayName;
    private String prefix = "";
    private String suffix = "";
    private boolean friendlyFire = true;
    private boolean seeInvisibleFriendlies = false;

    public Team(String name) {
        this.name = name;
        this.displayName = name;
    }

    public String getName() {
        return name;
    }

    public Set<OfflinePlayer> getMembers() {
        return members;
    }

    public void setMembers(Set<OfflinePlayer> members) {
        this.members.clear();
        this.members.addAll(members);
    }

    public void addMember(OfflinePlayer player) {
        this.members.add(player);
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public boolean isFriendlyFire() {
        return friendlyFire;
    }

    public void setFriendlyFire(boolean friendlyFire) {
        this.friendlyFire = friendlyFire;
    }

    public boolean isSeeInvisibleFriendlies() {
        return seeInvisibleFriendlies;
    }

    public void setSeeInvisibleFriendlies(boolean seeInvisibleFriendlies) {
        this.seeInvisibleFriendlies = seeInvisibleFriendlies;
    }

    /* pp */ void apply(org.bukkit.scoreboard.Team team) {
        team.setDisplayName(displayName);
        team.setPrefix(prefix);
        team.setSuffix(suffix);
        team.setAllowFriendlyFire(friendlyFire);
        team.setCanSeeFriendlyInvisibles(seeInvisibleFriendlies);
        for (OfflinePlayer p : members) {
            team.addPlayer(p);
        }
    }
}
