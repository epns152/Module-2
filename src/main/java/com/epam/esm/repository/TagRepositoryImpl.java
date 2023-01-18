package com.epam.esm.repository;

import com.epam.esm.entity.Tag;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TagRepositoryImpl implements TagRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public Tag getTag(Long tagId) {
        Session session = this.sessionFactory.getCurrentSession();
        Tag tag = (Tag) session.get(Tag.class, tagId);
        return tag;
    }

    @Override
    public Tag addTag(Tag tag) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(tag);
        return tag;
    }

    @Override
    public void deleteTag(Tag tag) {
        Session session = this.sessionFactory.getCurrentSession();
        session.delete(tag);
    }

    @Override
    public List<Tag> listTags() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Tag> tags = session.createQuery("from tag").list();
        return tags;
    }
}
