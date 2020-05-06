package space.dubovitsky.intruder.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "t_user")
@Getter @Setter
public class User implements UserDetails, Serializable, AbstractModelWithPhoto { //! UserDetails - как бы прослойка между Бд и Security

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private boolean active;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    @OneToMany(mappedBy = "user") //* mappedBy = "user" - имя свойства в классе Declaration
    private List<Declaration> declarations;

    private String photo;

    private String email;

    private String activationCode;

    public boolean isInspector() { //* Является ли пользователь инспектором
        return roles.contains(Role.INSPECTOR);
    }

    public User() {
    }

    public User(String username, String password, boolean active, Set<Role> roles, List<Declaration> declarations) {
        this.username = username;
        this.password = password;
        this.active = active;
        this.roles = roles;
        this.declarations = declarations;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive();
    }
}
