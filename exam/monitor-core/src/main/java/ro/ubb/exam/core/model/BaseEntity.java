package ro.ubb.exam.core.model;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Generic class for a domain entity with an <code>id</code> attribute.
 * @param <ID> The identification attribute (key) of a domain entity.
 * */

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Data
public abstract class BaseEntity<ID extends Serializable> implements Serializable {
    @Id
    @GeneratedValue
    private ID id;
}