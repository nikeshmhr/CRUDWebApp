package com.crudwebapp.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.crudwebapp.model.Album;
import com.crudwebapp.service.AlbumService;

/**
 *
 * @author nikesh.maharjan
 */
@Repository
public class AlbumDAO implements AlbumService {

	@Autowired
	private JdbcOperations jdbc;

	@Override
	public Album addAlbum(Album album) {
		try {
			jdbc.update("INSERT INTO album VALUES(?, ?, ?, ?)", album.getAlbumTitle(), album.getBand(), album.getYear(),
					album.getNoOfTracks());
		} catch (DataAccessException ex) {
			System.out.println("Add Album Exception: " + ex.getMessage());
			return null;
		}
		return album;
	}

	@Override
	public Album updateAlbum(Album albumUpdate) {
		try {
			jdbc.update("UPDATE album SET title=?, band=?, year=?, no_of_tracks=? WHERE id=?",
					albumUpdate.getAlbumTitle(), albumUpdate.getBand(), albumUpdate.getYear(),
					albumUpdate.getNoOfTracks(), albumUpdate.getId());
		} catch (DataAccessException ex) {
			return null;
		}
		return albumUpdate;
	}

	@Override
	public Album deleteAlbum(Album deleteAlbum) {
		return null;

	}

	@Override
	public int deleteAlbum(int albumId) {
		try {
			return jdbc.update("DELETE FROM album WHERE id=?", albumId);
		} catch (DataAccessException ex) {
			return 0;
		}
	}

	@Override
	public List<Album> readAlbums() {
		try {
			List<Album> listOfAlbums = jdbc.query("SELECT * FROM album", new RowMapper<Album>() {
				@Override
				public Album mapRow(ResultSet rs, int rowNum) throws SQLException {
					Album a = new Album(rs.getString("title"), rs.getString("band"), rs.getString("year"),
							rs.getInt("no_of_tracks"));
					a.setId(rs.getInt("id"));
					return a;
				}
			});
			return listOfAlbums;
		} catch (EmptyResultDataAccessException ex) {
			return null;
		}
	}

	@Override
	public Album findAlbumById(int id) {
		final int localId = id;
		try {
			Album album = jdbc.queryForObject("SELECT * FROM album WHERE id=?", new RowMapper<Album>() {
				@Override
				public Album mapRow(ResultSet rs, int rowNum) throws SQLException {
					Album a = new Album(rs.getString("title"), rs.getString("band"), rs.getString("year"),
							rs.getInt("no_of_tracks"));
					a.setId(localId);
					return a;
				}
			}, id);
			return album;
		} catch (DataAccessException ex) {
			System.out.println("Find Album By Id Exception: " + ex.getMessage());
			return null;
		}
	}
}
