package com.epam.esm.controller;

import com.epam.esm.entity.Tag;
import com.epam.esm.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public class TagController {
    @Autowired
    TagService tagService;

    @RequestMapping(value = "/tag", method = RequestMethod.GET)
    public ResponseEntity<List<Tag>> listTags() {
        List<Tag> tags = tagService.listTags();
        if (tags != null) {
            return new ResponseEntity<List<Tag>>(tags, HttpStatus.OK);
        }
        return new ResponseEntity<List<Tag>>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/tag/{tagId}", method = RequestMethod.GET)
    public ResponseEntity<Tag> getTag(@PathVariable("tagId") Long tagId) {
        Tag tag = tagService.getTag(tagId);
        if (tag != null) {
            return new ResponseEntity<Tag>(tag, HttpStatus.OK);
        }
        return new ResponseEntity<Tag>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/tag", method = RequestMethod.POST)
    public ResponseEntity<Tag> createTag(@RequestBody Tag tag) {
        tag = tagService.addTag(tag);
        return new ResponseEntity<Tag>(tag, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/tag/{tagId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteTag(@PathVariable("tagId") Long tagId) {
        Tag tag = tagService.getTag(tagId);
        if (tag != null) {
            tagService.deleteTag(tag);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
}
