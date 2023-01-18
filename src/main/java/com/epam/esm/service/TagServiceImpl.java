package com.epam.esm.service;


import com.epam.esm.entity.Tag;
import com.epam.esm.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public Tag getTag(Long tagId) {
        return tagRepository.getTag(tagId);
    }

    @Override
    public Tag addTag(Tag tag) {
        return tagRepository.addTag(tag);
    }

    @Override
    public void deleteTag(Tag tag) {
        tagRepository.deleteTag(tag);
    }

    @Override
    public List<Tag> listTags() {
        return tagRepository.listTags();
    }
}
