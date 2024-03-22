package net.ictcampus.apithena.model.models;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Entity //tells spring, that this is an entity of a Database
public class User {
    /**
     * Autogenerated ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) /* autogenerate the ID instead of setting it.
     Apparently the reason there is no need for id in sign-up*/
    private Integer id;

    @NotBlank(message = "Username can't be empty")
    @NotNull(message = "Username must be provided")
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) //Password can only be written, but never retrieved from db.
    @NotNull(message = "Password is needed")
    @NotBlank(message = "Please provide password")
    //@Length(min=6,max = 255)
    private String password;

//    private String fullName; todo integrate somehow

    public User() {}

    //getter and setter
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
//    public String getFullName() {
//        return username;
//    }
//    public void setFullName(String fullName) {
//        this.fullName = fullName;
//    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


}

/*
Bezüglich 1:M beziehungen (Ein Genre/Film, viele Filme/Genre).
..:1 (Einzigartiges z.b. genre) enthält die Annotation @OneToMany

@OneToMany(mappedBy="genre")
@JsonBackReference
private set<Movie> movies = new HashSet<>();

----
M:.... (Vielfaches z.B. Movies):
es wird ein Genre erstellt mit annotation @ManyToOne und join-column (angeben wo die Info für :1 ist)

@ManyToOne
@JoinColumn(name = "genre_id")
private Genre genre;
 */

