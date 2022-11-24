package com.lkarlason.beerwithme.server.friend;

import java.time.OffsetDateTime;

import com.lkarlason.beerwithme.server.types.FriendRequest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "friends")
@Getter
@Setter
@NoArgsConstructor
public class Friend {
    @Id
    @GeneratedValue
    private Long id;

    private FriendRequest status;

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;

    @Override
    public String toString() {
        return "Friend{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", createdAt='" + createdAt + '\'' +
                "updatedAt='" + updatedAt + '\'' +
                '}';
    }

}
