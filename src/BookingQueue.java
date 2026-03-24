public boolean isEmpty() {
    return queue.isEmpty();
}

public Reservation getNextRequest() {
    return queue.poll(); // dequeue (FIFO)
}