package FilmManagementSystem;

import java.text.DecimalFormat;

public class Queue<T> {
    public Node<T> front;
    public Node<T> rear;
    public int size;

    public Queue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    // Add an element to the queue
    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    // Remove and return the front element
    public T dequeue() {
        if (front == null) {
            return null;
        }
        T data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return data;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Queue.java
    public void printQueue() {
        System.out.println("\n====================== Current Screening Schedule ======================");
        if (front == null) {
            System.out.println("No films scheduled.");
        } else {
            Node<T> current = front;
            while (current != null) {
                System.out.println("Film: " + current.data);
                current = current.next;
            }
        }
        System.out.println("===========================================================================");
    }

    // RevenueSimulation.java
    public void simulateScreening() {
        if (screenings.isEmpty()) {
            System.out.println("\nNo films scheduled for screening.\n");
            return;
        }

        Film film = screenings.dequeue();
        int viewerCount = film.getViewerCount();
        double ticketPrice = film.getTicketPrice();
        double revenue = viewerCount * ticketPrice;

        // Format revenue to display without scientific notation
        DecimalFormat df = new DecimalFormat("#,###.00");
        String formattedRevenue = df.format(revenue);

        revenueHistory.push(new RevenueData(film.getFilmName(), revenue));

        System.out.println("\n==================== Screening Result ======================");
        System.out.printf("Screened Film: %-30s | Revenue Generated: $%-10s\n", film.getFilmName(), formattedRevenue);
        System.out.println("=============================================================\n");
    }

    // RevenueData.java
    @Override
    public String toString() {
        return String.format("%-30s | $%-10.2f", filmName, revenue);
    }

    // ViewerFeedbackSystem.java
    public void displayFilmDetails(int uniqueFilmID) {
        Film film = getFilm(uniqueFilmID);
        if (film != null) {
            System.out.println("\n======================== Film Details ========================");
            System.out.printf("Film Name: %-30s | Film ID: %-4d | Genre: %-15s | Release Year: %-4d\n",
                    film.getFilmName(), film.getUniqueFilmID(), film.getGenre(), film.getReleaseYear());
            System.out.printf("Total Revenue: $%-10s\n", film.getTotalRevenue());
            System.out.println("---------------------------------------------------------------");
            System.out.print("Actors: ");
            Node<Actor> currentActor = film.getActors().head;
            while (currentActor != null) {
                System.out.print(currentActor.data.getActorName() + (currentActor.next != null ? " -> " : ""));
                currentActor = currentActor.next;
            }
            System.out.println("\n===============================================================");
        } else {
            System.out.println("Film not found.");
        }
    }

    public void displayPopularityRanking() {
        System.out.println("\n==================== Film Popularity Rankings ====================");
        if (popularityRanking.isEmpty()) {
            System.out.println("No films to display.");
        } else {
            for (int i = 0; i < popularityRanking.size(); i++) {
                Film film = popularityRanking.get(i);
                double avgRating = getAverageRating(film.getUniqueFilmID());
                int reviewCount = getReviewCount(film.getUniqueFilmID());
                System.out.printf("%-3d. %-30s | Avg Rating: %-5.2f | Total Reviews: %-3d\n",
                        (i + 1), film.getFilmName(), avgRating, reviewCount);
            }
        }
        System.out.println("=================================================================");
    }

}
