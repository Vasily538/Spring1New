package ru.ankudinov.spring1.domain;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "task", schema = "todo")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@NotEmpty(message = "description should not be empty!")
    @Column(name = "description")
    private String description;
   // @NotEmpty(message = "status should not be empty!")
    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private Status status;

    public Task() {
    }

    public Task(String description, Status status) {
        this.description = description;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
