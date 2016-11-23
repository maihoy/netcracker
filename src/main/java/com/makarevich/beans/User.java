package com.makarevich.beans;

/**
 * Created by j on 10.11.16.
 */
public class User extends Entity {
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private Long idRole;
    private Long idState;

    public User(Long id, String firstName, String lastName,
                String password, String email, Long role, Long state) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.idState = state;
        this.idRole=role;
    }

    public User(){}

    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    public Long getIdState() {
        return idState;
    }

    public void setIdState(Long idState) {
        this.idState = idState;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        if (!super.equals(o)) return false;

        User user = (User) o;

        if (!getFirstName().equals(user.getFirstName())) return false;
        if (!getLastName().equals(user.getLastName())) return false;
        if (!getPassword().equals(user.getPassword())) return false;
        if (!getEmail().equals(user.getEmail())) return false;
        if (!getIdRole().equals(user.getIdRole())) return false;
        return getIdState().equals(user.getIdState());

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getFirstName().hashCode();
        result = 31 * result + getLastName().hashCode();
        result = 31 * result + getPassword().hashCode();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getIdRole().hashCode();
        result = 31 * result + getIdState().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", idRole=" + idRole +
                ", idState=" + idState +
                '}';
    }

}
