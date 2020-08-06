package pl.umk.mat.danielsz.journal.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter @Setter
@EqualsAndHashCode
public abstract class AbstractDocument {

    @Id
    private String id;
}
