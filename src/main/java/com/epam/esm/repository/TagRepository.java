package com.epam.esm.repository;

import com.epam.esm.entity.Tag;

import java.util.List;

public interface TagRepository {
    Tag getTag(Long tagId);
    Tag addTag(Tag tag);
    void deleteTag(Tag tag);
    List<Tag> listTags();
}
