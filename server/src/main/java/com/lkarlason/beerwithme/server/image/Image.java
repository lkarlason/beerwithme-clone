package com.lkarlason.beerwithme.server.image;

import java.time.OffsetDateTime;

import com.lkarlason.beerwithme.server.drinktype.DrinkType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "images")
@Getter
@Setter
@NoArgsConstructor
public class Image {
    @Id
    @GeneratedValue
    private Long id;

    private String url;

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "image")
    private DrinkType drinkType;

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", createdAt='" + createdAt + '\'' +
                "updatedAt='" + updatedAt + '\'' +
                '}';
    }
}
