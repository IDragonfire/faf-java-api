package com.faforever.api.data.domain;

import com.yahoo.elide.annotation.CreatePermission;
import com.yahoo.elide.annotation.Include;
import com.yahoo.elide.annotation.UpdatePermission;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "clan_list")
@Include(rootLevel = true, type = "clan")
@UpdatePermission(expression = "is leader")
@Data
public class Clan {

  private int clanId;
  private Timestamp createDate;
  private int status;
  private String clanName;
  private String clanTag;
  private Player clanFounder;
  private Player clanLeader;
  private String clanDesc;
  private String clanTagColor;
  @Setter
  private List<Player> members;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "clan_id")
  public int getClanId() {
    return clanId;
  }

  @Column(name = "create_date")
  public Timestamp getCreateDate() {
    return createDate;
  }

  @Column(name = "status")
  public int getStatus() {
    return status;
  }

  @Column(name = "clan_name")
  public String getClanName() {
    return clanName;
  }


  @Column(name = "clan_tag")
  public String getClanTag() {
    return clanTag;
  }

  @ManyToOne
  @JoinColumn(name = "clan_founder_id")
  public Player getClanFounder() {
    return clanFounder;
  }

  @ManyToOne
  @JoinColumn(name = "clan_leader_id")
  public Player getClanLeader() {
    return clanLeader;
  }

  @Column(name = "clan_desc")
  public String getClanDesc() {
    return clanDesc;
  }

  @Column(name = "clan_tag_color")
  public String getClanTagColor() {
    return clanTagColor;
  }

  @ManyToMany
  @JoinTable(
          name = "clan_membership",
          joinColumns = @JoinColumn(name = "clan_id", referencedColumnName = "clan_id"),
          inverseJoinColumns = @JoinColumn(name = "player_id", referencedColumnName = "id"))
  public List<Player> getMembers() {
    return this.members;
  }
}
