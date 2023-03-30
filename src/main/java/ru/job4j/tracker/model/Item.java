package ru.job4j.tracker.model;

import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    @EqualsAndHashCode.Include
    @ToString.Include
    private int id;

    @EqualsAndHashCode.Include
    @ToString.Include
    @NonNull
    private String name;
    private LocalDateTime created = LocalDateTime.now();

    public Item(int id, @NonNull String name) {
        this.id = id;
        this.name = name;
    }

    @ToString.Include
    String created() {
        return FORMATTER.format(created);
    }

}