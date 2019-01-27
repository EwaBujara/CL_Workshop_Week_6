package pl.coderslab.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NotEmpty
//    @Size(min = 6, max = 32)
//    @Column(unique = true)
    private String username;

//    @Email
//    @NotEmpty
//    @Column(unique = true)
    private String email;

//    @Size(min = 6, max = 32)
//    @NotEmpty
    private String password;

    @Transient
    private String passwordConfirm;

    private String location;

    private String description;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Meow> meows = new ArrayList<>();


    @OneToMany
    private List<PrivateMeow> sentPrivateMeows = new ArrayList<>();

    @OneToMany
    private List<PrivateMeow> receivedPrivateMeows = new ArrayList<>();

    private boolean enabled;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Meow> getMeows() {
        return meows;
    }

    public void setMeows(List<Meow> meows) {
        this.meows = meows;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PrivateMeow> getSentPrivateMeows() {
        return sentPrivateMeows;
    }

    public void setSentPrivateMeows(List<PrivateMeow> sentPrivateMeows) {
        this.sentPrivateMeows = sentPrivateMeows;
    }

    public List<PrivateMeow> getReceivedPrivateMeows() {
        return receivedPrivateMeows;
    }

    public void setReceivedPrivateMeows(List<PrivateMeow> receivedPrivateMeows) {
        this.receivedPrivateMeows = receivedPrivateMeows;
    }
}
