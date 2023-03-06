package models;

import java.sql.Timestamp;

public class Showtime {
	private int id, movieId;
	private Timestamp startTime, endTime, createdAt; 
	private Movie movie;
}
