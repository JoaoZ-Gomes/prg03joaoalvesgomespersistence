package br.com.ifba.curso.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable; // Importe Serializable para que a entidade possa ser serializada

/**
 * Esta é a classe de entidade 'Curso'.
 * Ela representa a tabela 'Curso' no banco de dados.
 *
 * Anotações JPA utilizadas:
 * - @Entity: Marca esta classe como uma entidade JPA, significando que ela será mapeada para uma tabela no banco de dados.
 * - @Table: (Opcional, mas recomendado) Especifica o nome da tabela no banco de dados. Se omitido, o nome da classe será usado.
 * - @Id: Marca o campo como a chave primária da entidade.
 * - @GeneratedValue: Configura a estratégia de geração de valores para a chave primária.
 * - GenerationType.IDENTITY: Usa uma coluna de identidade do banco de dados (auto-incremento).
 * - GenerationType.AUTO: Deixa o provedor de persistência (Hibernate) decidir a melhor estratégia.
 *
 * É uma boa prática implementar Serializable para entidades.
 */
@Entity
@Table(name = "Curso") // Define o nome da tabela no banco de dados como 'Curso'
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L; // Necessário para Serializable

    @Id // Marca este campo como a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configura a estratégia de auto-incremento para o ID
    private Long id; // Chave primária da tabela Curso

    private String nome;        // Nome do curso
    private String descricao;   // Descrição do curso
    private int cargaHoraria;   // Carga horária do curso em horas

    // Construtor padrão (sem argumentos) é obrigatório para JPA
    public Curso() {
    }

    // Construtor com argumentos para facilitar a criação de objetos Curso
    public Curso(String nome, String descricao, int cargaHoraria) {
        this.nome = nome;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
    }

    // --- Getters e Setters para todos os campos ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    ;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    // --- Métodos hashCode() e equals() (recomendado para entidades JPA) ---
    // Essenciais para comparar objetos Curso, especialmente em coleções.
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    // --- Método toString() para facilitar a depuração ---
    @Override
    public String toString() {
        return "Curso{" + "id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", cargaHoraria=" + cargaHoraria + '}';
    }
}
