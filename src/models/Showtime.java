package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Showtime {
	private int id, movieId;
	private Timestamp startTime, endTime, createdAt;
	private Movie movie;

	public static Showtime getFromResultSet(ResultSet rs) throws SQLException {
		Showtime s = new Showtime();
		s.setId(rs.getInt("id"));
		s.setMovieId(rs.getInt("movieId"));
		s.setStartTime(rs.getTimestamp("startTime"));
		s.setEndTime(rs.getTimestamp("endTime"));
		s.setCreatedAt(rs.getTimestamp("createdAt"));
		return s;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;t
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
}
