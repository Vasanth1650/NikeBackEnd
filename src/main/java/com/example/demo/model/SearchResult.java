/**
 * SearchResult Entity Helps Us To Store Every Search Result Into A Database And With That The Most Searched Product
 * Will Be Obtained According To The We Can Design UserExperience
 * @author Vasanth
 **/

package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="search")
public class SearchResult {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String search;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public SearchResult() {
		super();
	}

	
	//ToString Returns The Value Given To It In String Format
	@Override
	public String toString() {
		return "SearchResult [id=" + id + ", search=" + search + "]";
	}
	
	

}
