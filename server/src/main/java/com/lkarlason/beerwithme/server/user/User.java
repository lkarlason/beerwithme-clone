package com.lkarlason.beerwithme.server.user;

import java.time.OffsetDateTime;
import java.util.List;

import com.lkarlason.beerwithme.server.drink.Drink;
import com.lkarlason.beerwithme.server.types.Session;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String username;

    private String nickname;

    private String password;

    private Boolean isDrinking;

    private Session session;

    private Double latitude;

    private Double longitude;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Drink> drinks;

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", isDrinking=" + isDrinking +
                ", session='" + session + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", createdAt='" + createdAt + '\'' +
                "updatedAt='" + updatedAt + '\'' +
                '}';
    }

}
