package processors;





import com.sun.istack.internal.Nullable;

import java.util.Arrays;
import java.util.List;

public class CompositeItemProcessor<I, O> implements ItemProcessor<I, O> {

    private List<? extends ItemProcessor<?, ?>> delegates;

    /**
     * Default constrcutor
     */
    public CompositeItemProcessor() {

    }

    /**
     * Convenience constructor for setting the delegates.
     * @param delegates array of {@link ItemProcessor} delegates that will work on the
     * item.
     */
    public CompositeItemProcessor(ItemProcessor<?, ?>... delegates) {
        this(Arrays.asList(delegates));
    }

    /**
     * Convenience constructor for setting the delegates.
     * @param delegates list of {@link ItemProcessor} delegates that will work on the
     * item.
     */
    public CompositeItemProcessor(List<? extends ItemProcessor<?, ?>> delegates) {
        setDelegates(delegates);
    }

    @Nullable
    @Override
    @SuppressWarnings("unchecked")
    public O process(I item) throws Exception {
        Object result = item;

        for (ItemProcessor<?, ?> delegate : delegates) {
            if (result == null) {
                return null;
            }

            result = processItem(delegate, result);
        }
        return (O) result;
    }

    /*
     * Helper method to work around wildcard capture compiler error: see
     * https://docs.oracle.com/javase/tutorial/java/generics/capture.html The method
     * process(capture#1-of ?) in the type ItemProcessor<capture#1-of ?,capture#2-of ?> is
     * not applicable for the arguments (Object)
     */
    @SuppressWarnings("unchecked")
    private <T> Object processItem(ItemProcessor<T, ?> processor, Object input) throws Exception {
        return processor.process((T) input);
    }



    /**
     * Establishes the {@link ItemProcessor} delegates that will work on the item to be
     * processed.
     * @param delegates list of {@link ItemProcessor} delegates that will work on the
     * item.
     */
    public void setDelegates(List<? extends ItemProcessor<?, ?>> delegates) {
        this.delegates = delegates;
    }

}