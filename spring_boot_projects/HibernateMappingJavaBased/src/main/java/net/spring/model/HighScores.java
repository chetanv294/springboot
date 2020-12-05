package net.spring.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "games_high_score")
public class HighScores implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", nullable = false)	
  private int id;
	
	@Column(name = "NAME", nullable = false, length = 50)
  private String name;
	
	@OneToMany(fetch = FetchType.EAGER, cascade={CascadeType.ALL},targetEntity=net.spring.model.GameScore.class )
  private Set<GameScore> games;

  public HighScores() {
  }

  public HighScores(String name) {
    this.name = name;
  }

  public void setId(int i) {
    id = i;
  }

  public int getId() {
    return id;
  }

  public void setName(String n) {
    name = n;
  }

  public String getName() {
    return name;
  }

  public void setGames(Set<GameScore> games) {
    this.games = games;
  }

  public Set<GameScore> getGames() {
    return games;
  }
}

