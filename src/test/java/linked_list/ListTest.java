package linked_list;

import io.vavr.collection.List;
import io.vavr.control.Option;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class ListTest {

    @Test
    public void shouldGetSize() {
        List<Integer> list = List.of(1);
        assertThat(list).hasSize(1);
    }

    @Test
    public void shouldGetHead() {
        List<Integer> list = List.of(1);
        assertThat(list.head()).isEqualTo(1);
    }

    @Test
    public void shouldGetTail() {
        List<Integer> list = List.of(1);
        assertThat(list.tail()).isEqualTo(List.empty());
    }
    @Test
    public void shouldGetTailOption() {
        List<Integer> list = List.of(1);
        assertThat(list.tailOption().flatMap(List::tailOption)).isEqualTo(Option.none());
    }

    @Test
    public void shouldPrepend() {
        assertThat(List.of(1, 2, 3).tail().prepend(0)).isEqualTo(List.of(0, 2, 3));
    }

    @Test
    public void shouldFillWithElement() {
        assertThat(List.fill(4, "a")).isEqualTo(List.of("a", "a", "a", "a"));
    }

    @Test
    public void shouldFillWithSupplier() {
        assertThat(List.fill(3, () -> "a")).isEqualTo(List.of("a", "a", "a"));
    }

    @Test
    public void shouldCreateRange() {
        assertThat(List.range(0, 6)).isEqualTo(List.of(0, 1, 2, 3, 4, 5));
    }

    @Test
    public void shouldCreateRangeWithStep() {
        assertThat(List.rangeBy(0, 10, 2)).isEqualTo(List.of(0, 2, 4, 6, 8));
    }

    @Test
    public void shouldCreatedRangeClosed() {
        assertThat(List.rangeClosed(0, 5)).isEqualTo(List.of(0, 1, 2, 3, 4, 5));
    }
}