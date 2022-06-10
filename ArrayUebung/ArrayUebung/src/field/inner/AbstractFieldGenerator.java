package field.inner;

import field.FieldGenerator;
import number.NumberGenerator;

import java.util.function.Supplier;

public abstract class AbstractFieldGenerator implements FieldGenerator {

    private int [] field;

    protected int[] getField() {
        return field;
    }

    @Override
    public int[] createPopulatedFieldWithSize(int size) {

        field = new int[size];
        fill();
        return field;

    }
    protected abstract void fill();

}
