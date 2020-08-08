package pl.umk.mat.danielsz.journal.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter @Setter
@EqualsAndHashCode
@NoArgsConstructor
public abstract class AbstractDocument {

    @Id
    private String id;
}
