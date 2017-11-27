package model.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Abstract Entity
 *
 * @author gandrieu
 * @version 1.0
 */

@MappedSuperclass
public class AbstractEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    /**
     * HashCode
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * initialization
     *
     * @param id
     * @return
     */
    public AbstractEntity build(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Equals
     *
     * @param entity
     * @return
     */
    @Override
    public boolean equals(Object entity) {
        String class1 = this.getClass().getName();
        String class2 = entity.getClass().getName();
        if (!class2.equals(class1) || entity==null) {
            return false;
        }
        AbstractEntity other = (AbstractEntity) entity;
        return this.id.longValue() == other.id.longValue();
    }

    // Getters / Setters
    public static long getSerialVersionUID() { return serialVersionUID; }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }
}
