package com.example.gpgpBack.addables;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="addables")
public class Addables {
    @Id
    @SequenceGenerator(
        name="addables_seq",
        sequenceName = "addables_seq",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "addables_seq"
    )
    private Long id;
    private String item_Type;
    private boolean sizable;
    private boolean meats;
    private boolean cheeses;
    private boolean sauces;
    private boolean extras;
    private boolean removables;

    public Addables() {
    }

    public Addables(String item_Type, boolean sizable, boolean meats, boolean cheeses, boolean sauces, boolean extras, boolean removables) {
        this.item_Type = item_Type;
        this.sizable = sizable;
        this.meats = meats;
        this.cheeses = cheeses;
        this.sauces = sauces;
        this.extras = extras;
        this.removables = removables;
    }

    public Addables(Long id, String item_Type, boolean sizable, boolean meats, boolean cheeses, boolean sauces, boolean extras, boolean removables) {
        this.id = id;
        this.item_Type = item_Type;
        this.sizable = sizable;
        this.meats = meats;
        this.cheeses = cheeses;
        this.sauces = sauces;
        this.extras = extras;
        this.removables = removables;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {    
        this.id = id;
    }

    public String getItem_Type() {
        return this.item_Type;
    }

    public void setItem_Type(String item_Type) {
        this.item_Type = item_Type;
    }

    public boolean isSizable() {
        return this.sizable;
    }

    public boolean getSizable() {
        return this.sizable;
    }

    public void setSizable(boolean sizable) {
        this.sizable = sizable;
    }

    public boolean isMeats() {
        return this.meats;
    }

    public boolean getMeats() {
        return this.meats;
    }

    public void setMeats(boolean meats) {
        this.meats = meats;
    }

    public boolean isCheeses() {
        return this.cheeses;
    }

    public boolean getCheeses() {
        return this.cheeses;
    }

    public void setCheeses(boolean cheeses) {
        this.cheeses = cheeses;
    }

    public boolean isSauces() {
        return this.sauces;
    }

    public boolean getSauces() {
        return this.sauces;
    }

    public void setSauces(boolean sauces) {
        this.sauces = sauces;
    }

    public boolean isExtras() {
        return this.extras;
    }

    public boolean getExtras() {
        return this.extras;
    }

    public void setExtras(boolean extras) {
        this.extras = extras;
    }

    public boolean isRemovables() {
        return this.removables;
    }

    public boolean getRemovables() {
        return this.removables;
    }

    public void setRemovables(boolean removables) {
        this.removables = removables;
    }

}
