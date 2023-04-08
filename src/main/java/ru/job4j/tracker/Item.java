package ru.job4j.tracker;

import lombok.*;
import ru.job4j.toone.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "items")
@Getter
@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class Item {

    private static final DateTimeFormatter FORMATTER
            = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @ToString.Include
    private int id;

    @EqualsAndHashCode.Include
    @ToString.Include
    @NonNull
    private String name;

    private LocalDateTime created = LocalDateTime.now();

    @ManyToMany
    @JoinTable(/* Разберем аннотацию @JoinTable */
            /* name - указывает на таблицу, где идет связь вторичных ключей. */
            name = "participates",

            /* joinColumns - определяет ключ родительского объекта. В данном примере Item.id */
            joinColumns = { @JoinColumn(name = "item_id") },

            /* inverseJoinColumns - определяет ключ объекта,
            который мы загружаем в родительский объект. */
            inverseJoinColumns = { @JoinColumn(name = "user_id") }
    )
    private List<User> participates = new ArrayList<>();

    public Item(int id, @NonNull String name) {
        this.id = id;
        this.name = name;
    }

    public Item(int id, @NonNull String name, LocalDateTime created) {
        this.id = id;
        this.name = name;
        this.created = created;
    }

    @ToString.Include
    String created() {
        return FORMATTER.format(created);
    }
}
