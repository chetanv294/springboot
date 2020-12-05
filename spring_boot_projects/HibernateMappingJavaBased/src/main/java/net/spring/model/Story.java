package net.spring.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "stories")
public class Story implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
  
	
  private int id;
  private String info;
  private StoryListGroup storylistgroup;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "story_group_id", nullable = false)
  public StoryListGroup getStorylistgroup() {
	return this.storylistgroup;
}

public void setStorylistgroup(StoryListGroup storylistgroup) {
	this.storylistgroup = storylistgroup;
}

public Story(){
  }

  public Story(String info ) {
    this.info = info;
  }
  public Story(String info , StoryListGroup storylistgroup ) {
	    this.info = info;
	    this.storylistgroup = storylistgroup ;
	  }

  public void setId(int i) {
	  this.id = i;
  }

    @Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "storyid", unique = true, nullable = false)
  public int getId() {
    return  this.id;
  }

  public void setInfo(String n) {
	  this.info = n;
  }

  @Column(name = "story_name", unique = true, nullable = false, length = 20)
  public String getInfo() {
    return  this.info;
  }
}
