package com.trivium.dto;

public class ReviewRequest {
    public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	private int rating;
    private String comment;
    
    
}

