package com.example.helloworld.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "blog")
@NamedQueries({
        @NamedQuery(
                name = "com.example.helloworld.core.Blog.findAll",
                query = "SELECT bl FROM Blog bl"
        )
})
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idBlog;

    @Column(name = "autor", nullable = false)
    public int autor;

    @Column(name = "tags", nullable = false)
    public char tags;
    
    public Blog() {
    }

    public Blog(int idBlog, int autor, char tags) {
    	this.idBlog = idBlog;
    	this.autor = autor;
        this.tags = tags;
    }

    public int getIdBlog() {
        return idBlog;
    }

    public void setIdBlog(int idBlog) {
        this.idBlog = idBlog;
    }

    public int getAutor() {
        return autor;
    }

    public void setAutor(int autor) {
        this.autor = autor;
    }

    public int getTags() {
        return tags;
    }

    public void setTags(int tags) {
        this.tags = tags;
    }
     
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Blog)) {
            return false;
        }

        final Blog that = (Blog) o;

        return Objects.equals(this.idBlog, that.idBlog) &&
                Objects.equals(this.autor, that.autor) &&
                Objects.equals(this.tags, that.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBlog, autor, tags);
    }
}
