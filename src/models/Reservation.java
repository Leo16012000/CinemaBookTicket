package models;

import java.sql.Timestamp;

public class Reservation {
	private int id, userId, showtimeId;
	private Timestamp createdAt;
	private User user;
	private Showtime showtime;
}
