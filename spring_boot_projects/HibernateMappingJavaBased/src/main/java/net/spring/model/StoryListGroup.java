package net.spring.model;
 
import static javax.persistence.GenerationType.IDENTITY;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "story_group")
public class StoryListGroup implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	
  private int id;
  private String name;
  private List<Story> stories;

  public StoryListGroup(){
  }

  public StoryListGroup(String name) {
    this.name = name;
  }
  public StoryListGroup(String name , List<Story> stories) {
	    this.name = name;
	    this.stories = stories ;
	  }

  public void setId(int i) {
	  this.id = i;
  }
  
  @Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
  public int getId() {
    return  this.id;
  }

  public void setName(String n) {
    this.name = n;
  }

  @Column(name = "NAME", unique = true, nullable = false, length = 50)
  public String getName() {
    return  this.name;
  }

  public void setStories(List<Story> l) {
    this.stories = l;
  }

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "storylistgroup")
  public List<Story> getStories() {
    return this.stories;
  }
}

