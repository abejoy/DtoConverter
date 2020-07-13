import java.util.*;

public abstract class Converter<A, B> {
    protected abstract B doConvert(A item);

    public B convert(A item) {
        if (item != null) {
            return doConvert(item);
        }
        return null;
    }

    public List<B> convertAll(A[] items) {
        return convertAll(Arrays.asList(items));
    }

    public List<B> convertAll(Collection<A> items) {
        if (items != null) {
            final List<B> list = new ArrayList<>();

            for (A item : items) {
                final B converted = convert(item);

                if (converted != null) {
                    list.add(converted);
                }
            }

            return list;
        }

        return Collections.emptyList();
    }

    public static class ConversionFailedException extends RuntimeException {
        private static final long serialVersionUID = -8235837602666844270L;

        public ConversionFailedException(String message, Throwable cause) {
            super(message, cause);
        }

        public ConversionFailedException(String message) {
            super(message);
        }

        public ConversionFailedException(Throwable cause) {
            super(cause);
        }
    }
}

