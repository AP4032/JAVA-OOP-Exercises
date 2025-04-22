# Theme Park Management System 🎢

## Overview
This project is a simple **Theme Park Management System** implemented in Java, following **Object-Oriented Programming (OOP)** principles such as **encapsulation, inheritance, and polymorphism**.

## Features
- Visitors can join a queue for rides.
- Rides have capacity and duration.
- VIP visitors get priority access.
- Admins can add and remove rides.

## Classes & Structure
```plaintext
ThemePark
 ├── Ride
 ├── Visitor
 ├── VIPVisitor (extends Visitor)
 ├── Admin
 └── Main (Runner)
```

## Implementation

### `Ride.java`
```java
import java.util.LinkedList;
import java.util.Queue;

public class Ride {
    private String name;
    private int capacity;
    private int duration;
    private Queue<Visitor> queue;

    public Ride(String name, int capacity, int duration) {
        this.name = name;
        this.capacity = capacity;
        this.duration = duration;
        this.queue = new LinkedList<>();
    }

    public void addVisitor(Visitor visitor) {
        if (queue.size() < capacity) {
            queue.add(visitor);
            System.out.println(visitor.getName() + " joined the queue for " + name);
        } else {
            System.out.println("Queue is full for " + name);
        }
    }

    public void startRide() {
        System.out.println("Starting ride: " + name);
        for (int i = 0; i < capacity && !queue.isEmpty(); i++) {
            Visitor v = queue.poll();
            System.out.println(v.getName() + " is enjoying " + name);
        }
    }
}
```

### `Visitor.java`
```java
public class Visitor {
    private String name;

    public Visitor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
```

### `VIPVisitor.java`
```java
public class VIPVisitor extends Visitor {
    public VIPVisitor(String name) {
        super(name);
    }

    public void getPriorityAccess(Ride ride) {
        System.out.println(getName() + " gets priority access to " + ride);
    }
}
```

### `Admin.java`
```java
import java.util.ArrayList;
import java.util.List;

public class Admin {
    private List<Ride> rides;

    public Admin() {
        this.rides = new ArrayList<>();
    }

    public void addRide(Ride ride) {
        rides.add(ride);
        System.out.println("Ride " + ride + " added to the park.");
    }
}
```

### `Main.java`
```java
public class Main {
    public static void main(String[] args) {
        Ride rollerCoaster = new Ride("Roller Coaster", 5, 3);
        Visitor john = new Visitor("John");
        VIPVisitor alice = new VIPVisitor("Alice");

        rollerCoaster.addVisitor(john);
        rollerCoaster.addVisitor(alice);
        rollerCoaster.startRide();
    }
}
```

## How to Run
1. If you use new versions of java you can compile and run your code with this command in the terminal that is in your folder path:
   ```bash
   java fileName.java
   ```

## Future Enhancements
- Implement ticketing system
- Add more ride types
- Introduce real-time ride scheduling

---
🎡 **Enjoy the ride!** 🚀
