package com.example.demo.dto;



public class SearchResultDto {
	

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

	public SearchResultDto() {
		super();
	}

	
	//ToString Returns The Value Given To It In String Format
	@Override
	public String toString() {
		return "SearchResult [id=" + id + ", search=" + search + "]";
	}
	
	

}
