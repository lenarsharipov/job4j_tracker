package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenComparatorByDescNameAndDescPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName()
                .thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByDescNameAndAscPriority() {
        Comparator<Job> cmpDescNameAscPriority = new JobDescByName()
                .thenComparing(new JobAscByPriority());
        int rsl = cmpDescNameAscPriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByAscNameAndDescPriority() {
        Comparator<Job> cmpAscNameDescPriority = new JobAscByName()
                .thenComparing(new JobDescByPriority());
        int rsl = cmpAscNameDescPriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByAscNameAndAscPriority() {
        Comparator<Job> cmpAscNameAscPriority = new JobAscByName()
                .thenComparing(new JobAscByPriority());
        int rsl = cmpAscNameAscPriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorDescByName() {
        Comparator<Job> cmpDescByName = new JobDescByName();
        int rsl = cmpDescByName.compare(
                new Job("Reboot server", 1),
                new Job("Check logs", 3)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorAscByName() {
        Comparator<Job> cmpAscByName = new JobAscByName();
        int rsl = cmpAscByName.compare(
                new Job("Reboot server", 1),
                new Job("Check logs", 3)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorDescByPriority() {
        Comparator<Job> cmpDescByName = new JobDescByPriority();
        int rsl = cmpDescByName.compare(
                new Job("Reboot server", 1),
                new Job("Check logs", 3)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorAscByPriority() {
        Comparator<Job> cmpAscByName = new JobAscByPriority();
        int rsl = cmpAscByName.compare(
                new Job("Reboot server", 1),
                new Job("Check logs", 3)
        );
        assertThat(rsl, lessThan(0));
    }
}