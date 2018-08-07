package ar.com.zumma.sparrowplatform.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Document
public class Role {

    @Id
    private String id;
    private String name;
    private String description;
    private Integer level;
}
