package utils.day6;

public class Fish {
    public int timer;

    public Fish() {
        timer = 8;
    }

    public int age() {
        timer--;
        if (timer < 0) {
            timer = 6;
            return 1;
        }
        return 0;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }
}
