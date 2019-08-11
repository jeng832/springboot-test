package com.hashbrown.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserInfoViewList {
	@JsonProperty("draw")
	private int draw;
	@JsonProperty("recordsTotal")
	private Long recordsTotal;
	@JsonProperty("recordsFiltered")
	private Long recordsFiltered;
	
	
	@JsonProperty("data")
	private List<UserInfoView> data;

	public UserInfoViewList(List<UserInfoView> data) {
		this.data = data;
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public Long getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(Long recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public Long getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(Long recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public List<UserInfoView> getData() {
		return data;
	}

	public void setData(List<UserInfoView> data) {
		this.data = data;
	}
	
	
}
