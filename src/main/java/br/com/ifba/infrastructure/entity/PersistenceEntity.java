package br.com.ifba.infrastructure.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Objects;

/**
 * Classe base para todas as entidades persistentes.
 * Define ID autogerado e implementa Serializable, equals e hashCode.
 */
@MappedSuperclass
public abstract class PersistenceEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ===== GETTERS E SETTERS =====

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // ===== EQUALS E HASHCODE =====

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersistenceEntity)) return false;
        PersistenceEntity that = (PersistenceEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
