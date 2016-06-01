package com.crudwebapp.controller;

import com.crudwebapp.model.Album;
import com.crudwebapp.service.AlbumService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author nikesh.maharjan
 */
@RestController
@RequestMapping(value = "/albums")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @RequestMapping(method = GET)
    public ResponseEntity<List<Album>> showListOfAlbums() {
        List<Album> albumsList = albumService.readAlbums();

        if (albumsList == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        } else if (albumsList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }

        return new ResponseEntity<>(albumsList, HttpStatus.OK);

        //return "listAlbums";
    }

//    @RequestMapping(method = GET, value = "/add")
//    public String showAddPage() {
//        return "addAlbum";
//    }
    @RequestMapping(method = POST, value = "/add")
    public ResponseEntity<Void> processAdd(@RequestBody Album album) {
        Album addedAlbum = albumService.addAlbum(album);
        if (albumService.addAlbum(album) == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    @RequestMapping(method = DELETE, value = "/delete/{id}")
    public ResponseEntity<Integer> processDelete(@PathVariable int id) {
        int deleteAlbum = albumService.deleteAlbum(id);
        if (deleteAlbum == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(id, HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = GET, value = "/update/{id}")
    public String showUpdatePage(@PathVariable int id, Model model, RedirectAttributes redir) {
        Album album = albumService.findAlbumById(id);
        if (album == null) {
            redir.addFlashAttribute("errorMessage", "Failed to find information about album.");
            return "redirect:/albums";
        }
        model.addAttribute("album", album);

        return "updateAlbum";
    }

    @RequestMapping(method = POST, value = "/update/{id}")
    public String processUpdate(Album album, RedirectAttributes redir) {
        Album a = albumService.updateAlbum(album);
        if (a == null) {
            redir.addFlashAttribute("errorMessage", "Failed to update album info.");

        }
        return "redirect:/albums";
    }

}
