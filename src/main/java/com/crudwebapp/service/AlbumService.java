package com.crudwebapp.service;

import java.util.List;

import com.crudwebapp.model.Album;

/**
 *
 * @author nikesh.maharjan
 */
public interface AlbumService {

	Album addAlbum(Album album);

	List<Album> readAlbums();

	Album updateAlbum(Album albumUpdate);

	Album deleteAlbum(Album deleteAlbum);

	int deleteAlbum(int albumId);

	Album findAlbumById(int id);

}
