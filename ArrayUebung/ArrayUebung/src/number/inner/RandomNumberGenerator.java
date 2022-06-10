package number.inner;

import number.NumberGenerator;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private final Random random = new Random();

    @Override
    public int nextNumber() {
        return random.nextInt();
    }
}
