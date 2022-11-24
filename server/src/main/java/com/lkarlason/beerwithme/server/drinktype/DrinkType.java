package com.lkarlason.beerwithme.server.drinktype;

import java.time.OffsetDateTime;
import java.util.List;

import com.lkarlason.beerwithme.server.drink.Drink;
import com.lkarlason.beerwithme.server.image.Image;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "drink_types")
@Getter
@Setter
@NoArgsConstructor
public class DrinkType {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;

    @OneToMany(mappedBy = "drinkType", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Drink> drinks;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "image_id", nullable = true)
    private Image image;

    @Override
    public String toString() {
        return "DrinkType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdAt='" + createdAt + '\'' +
                "updatedAt='" + updatedAt + '\'' +
                '}';
    }

}
