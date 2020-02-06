package queue;


import io.vavr.Tuple2;
import io.vavr.collection.Queue;
import io.vavr.control.Option;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
public class QueueTest {

    @Test
    public void shouldEnqueue(){
        Queue <Integer> queue = Queue.of(1,2,3).enqueue(4).enqueue(5);
        assertThat(queue).isEqualTo(Queue.range(1,6));
    }

    @Test
    public void shouldDequeue(){
        Queue <Integer> queue = Queue.of(1,2,3).enqueue(4).enqueue(5);
        Tuple2<Integer, Queue<Integer>> dequeued = queue.dequeue();

        assertThat(dequeued._1).isEqualTo(1);
        assertThat(dequeued._2).isEqualTo(Queue.of(2,3,4,5));
    }

    @Test
    public void shouldDequeueOption(){
        Queue <Integer> queue = Queue.of(1);

        Option<Tuple2<Integer, Queue<Integer>>> dequeued = queue.dequeueOption();

        assertThat(dequeued.map(Tuple2::_1)).isEqualTo(Option.of(1));
        assertThat(dequeued.map(Tuple2::_2)).isEqualTo(Option.some(Queue.empty()));
    }
}
