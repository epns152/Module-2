package com.epam.esm.service;


import com.epam.esm.entity.Tag;

import java.util.List;

public interface TagService {
    Tag getTag(Long tagId);
    Tag addTag(Tag tag);
    void deleteTag(Tag tag);
    List<Tag> listTags();
}
