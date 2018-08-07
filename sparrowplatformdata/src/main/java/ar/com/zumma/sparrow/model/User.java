package ar.com.zumma.sparrow.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Document
public class User {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;

    @DBRef
    private Set<Role> roles = new HashSet<>();
}
