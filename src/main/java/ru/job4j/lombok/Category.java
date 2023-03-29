package ru.job4j.lombok;

import lombok.*;

@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@RequiredArgsConstructor
public class Category {
    @NonNull
    @EqualsAndHashCode.Include
    @Getter
    private int id;

    @Getter
    @Setter
    private String name;
}