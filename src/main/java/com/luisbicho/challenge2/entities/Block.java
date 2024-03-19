package com.luisbicho.challenge2.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name="tb_block")
public class Block implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant initialMoment;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant finalMoment;

    @ManyToOne
    @JoinColumn(name="activity_id")
    private Activity activity;

    public Block() {
    }

    public Block(Integer id, Instant initialMoment, Instant finalMoment, Activity activity) {
        this.id = id;
        this.initialMoment = initialMoment;
        this.finalMoment = finalMoment;
        this.activity = activity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getInitialMoment() {
        return initialMoment;
    }

    public void setInitialMoment(Instant start) {
        this.initialMoment = start;
    }

    public Instant getFinalMoment() {
        return finalMoment;
    }

    public void setFinalMoment(Instant end) {
        this.finalMoment = end;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Block block = (Block) o;
        return Objects.equals(id, block.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
