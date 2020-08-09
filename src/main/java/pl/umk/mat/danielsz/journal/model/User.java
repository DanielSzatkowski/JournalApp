package pl.umk.mat.danielsz.journal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import java.util.List;

@Document(collection = "users")
@TypeAlias("user")
@Getter @Setter
@EqualsAndHashCode(callSuper = true)
public class User extends AbstractDocument {

    @Indexed(unique = true)
    private String login;

    @NotNull
    private String password;

    @Field("info")
    private String userInfo;

    @DBRef
    private List<Entry> entries;

    @PersistenceConstructor
    public User(String login, String password, String userInfo, List<Entry> entries) {
        this.login = login;
        this.password = password;
        this.userInfo = userInfo;
        this.entries = entries;
    }

    public void deleteEntry(Entry entry) {
        entries.remove(entry);
    }

    @JsonIgnore
    public String getPassword(){
        return password;
    }

    @JsonProperty
    public void setPassword(String password){
        this.password = password;
    }
}
