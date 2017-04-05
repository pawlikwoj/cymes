package pl.pawlik.cymes.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by pawlik on 20.03.2017.
 */

@Entity
public class Role {
    @Id
    long roleId;
    String name;

    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "roleId",referencedColumnName = "roleId"),
            inverseJoinColumns = @JoinColumn(name="permissionId", referencedColumnName="permissionId")
    )
    Collection<Permission> permissions;

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public Collection<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Collection<Permission> permissions) {
        this.permissions = permissions;
    }
}
