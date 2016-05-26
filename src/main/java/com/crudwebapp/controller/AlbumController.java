package com.crudwebapp.controller;

import com.crudwebapp.model.Album;
import com.crudwebapp.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author nikesh.maharjan
 */
@Controller
@RequestMapping(value = "/albums")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @RequestMapping(method = GET)
    public String showListOfAlbums(Model model) {
        model.addAttribute(albumService.readAlbums());

        return "listAlbums";
    }

    @RequestMapping(method = GET, value = "/add")
    public String showAddPage() {
        return "addAlbum";
    }

    @RequestMapping(method = POST, value = "/add")
    public String processAdd(Album album, RedirectAttributes redir) {
        if (albumService.addAlbum(album) == null) {
            redir.addFlashAttribute("errorMessage", "Failed to add album.");
            return "redirect:/albums/add";
        } else {
            return "redirect:/albums";
        }
    }

    @RequestMapping(method = GET, value = "/delete/{id}")
    public String processDelete(@PathVariable int id, RedirectAttributes redir) {
        if (albumService.deleteAlbum(id) == 0) {
            redir.addFlashAttribute("errorMessage", "Failed to delete album with id " + id);
        }
        return "redirect:/albums";
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
