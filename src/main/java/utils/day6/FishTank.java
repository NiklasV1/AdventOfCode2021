package utils.day6;

import java.util.List;

public class FishTank {
    public List<Fish> fishes;

    public FishTank(List<Fish> fishes) {
        this.fishes = fishes;
    }

    public void simulationStep() {
        int newFishes = 0;
        for (Fish fish : fishes) {
            newFishes += fish.age();
        }
        spawnFishes(newFishes);
    }

    public void spawnFishes(int amount) {
        for (int i = 0; i < amount; i++) {
            fishes.add(new Fish());
        }
    }

    public int countFish() {
        return fishes.size();
    }
}
