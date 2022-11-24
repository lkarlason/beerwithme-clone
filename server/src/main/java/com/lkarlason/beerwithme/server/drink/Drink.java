package com.lkarlason.beerwithme.server.drink;

import java.time.OffsetDateTime;

import com.lkarlason.beerwithme.server.drinktype.DrinkType;
import com.lkarlason.beerwithme.server.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "drinks")
@Getter
@Setter
@NoArgsConstructor
public class Drink {
    @Id
    @GeneratedValue
    private Long id;

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "drink_type_id", nullable = true)
    private DrinkType drinkType;

    @Override
    public String toString() {
        return "Drink{" +
                "id=" + id +
                ", createdAt='" + createdAt + '\'' +
                "updatedAt='" + updatedAt + '\'' +
                '}';
    }
}
