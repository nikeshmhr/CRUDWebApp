package com.crudwebapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.crudwebapp.data.AlbumDAO;
import com.crudwebapp.model.Album;
import com.crudwebapp.service.AlbumService;

/**
 *
 * @author nikesh.maharjan
 */
@Service
@Primary
public class AlbumServiceImpl implements AlbumService {

	@Autowired
	private AlbumDAO jdbc;

	@Override
	public Album addAlbum(Album album) {
		return jdbc.addAlbum(album);
	}

	@Override
	public Album updateAlbum(Album albumUpdate) {
		return jdbc.updateAlbum(albumUpdate);
	}

	@Override
	public Album deleteAlbum(Album deleteAlbum) {
		throw new UnsupportedOperationException("Not supported yet."); // To
																		// change
																		// body
																		// of
																		// generated
																		// methods,
																		// choose
																		// Tools
																		// |
																		// Templates.
	}

	@Override
	public int deleteAlbum(int albumId) {
		return jdbc.deleteAlbum(albumId);
	}

	@Override
	public List<Album> readAlbums() {
		return jdbc.readAlbums();
	}

	@Override
	public Album findAlbumById(int id) {
		return jdbc.findAlbumById(id);
	}

}
