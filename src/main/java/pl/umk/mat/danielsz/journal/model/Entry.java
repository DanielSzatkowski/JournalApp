package pl.umk.mat.danielsz.journal.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "entries")
@TypeAlias("entry")
@Getter @Setter
@EqualsAndHashCode(callSuper = true)
public class Entry extends AbstractDocument {

    @Field("content")
    private String content;

    @Field("date")
    private Date date;

    @Field("rating")
    private Integer rating;

    @PersistenceConstructor
    public Entry(String content, Date date, Integer rating) {
        this.content = content;
        this.date = date;
        this.rating = rating;
    }
}
