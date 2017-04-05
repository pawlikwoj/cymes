
package pl.pawlik.cymes.entities;

import java.util.Collection;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author pawlik
 */
@Entity
public class User {
    @Id
    private long userId;
    private String name;
    private String password;
    @OneToMany(mappedBy = "owner")
    private List<Page> pages;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(
                    name = "userId", referencedColumnName = "userId"),
            inverseJoinColumns = @JoinColumn(
                    name = "roleId", referencedColumnName = "roleId"))
    private Collection<Role> roles;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Page> getPages() {
        return pages;
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}
