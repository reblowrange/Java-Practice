package org.example.threads.runners.runners;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class OneThreadAccess {
    private long amount;

    public void deduct(int amount) {
        this.amount -= amount;
    }

    public void add(int amount) {
        this.amount += amount;
    }
}
