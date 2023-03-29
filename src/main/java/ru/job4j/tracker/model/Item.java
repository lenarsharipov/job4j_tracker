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
public class Item {
    private static final DateTimeFormatter FORMATTER
            = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    @EqualsAndHashCode.Include
    private int id;

    @EqualsAndHashCode.Include
    @NonNull
    private String name;
    private LocalDateTime created = LocalDateTime.now();

    public Item(int id, @NonNull String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("id: %s, name: %s, created: %s", id, name, FORMATTER.format(created));
    }
}