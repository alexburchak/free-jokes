package net.abbreviations.core.domain;

import org.apache.commons.lang.StringUtils;
import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "user_role")
public class UserRole {
    @Embeddable
    public static class Id implements Serializable {
        private static final long serialVersionUID = 5768652673847706713L;

        @ManyToOne(optional = false)
        @JoinColumn(name = "user", nullable = false)
        @ForeignKey(name = "user_role_user_fk")
        @NotNull
        private User user;

        @Enumerated(EnumType.STRING)
        @Column(name = "role", nullable = false, length = 32)
        @NotNull
        private Role role;

        public User getUser() {
            return user;
        }

        public Role getRole() {
            return role;
        }

        @Override
        public int hashCode() {
            return getRole().hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this)
                return true;
            if (!(obj instanceof Id))
                return false;
            Id id = (Id) obj;
            return StringUtils.equals(getUser().getEmail(), id.getUser().getEmail())
                    && getRole() == id.getRole();
        }

        @Override
        public String toString() {
            return getUser().getEmail() + "(" + getRole() + ")";
        }
    }

    @EmbeddedId
    private Id id;

    public Id getId() {
        return id;
    }

    @Override
    public String toString() {
        return getId().toString();
    }
}
