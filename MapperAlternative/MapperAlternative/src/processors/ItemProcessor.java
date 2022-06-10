package processors;

import com.sun.istack.internal.Nullable;

public interface ItemProcessor<I, O> {



    O process(I item) throws Exception;

}