import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class BidirectionalConverter<A, B> extends Converter<A, B> {

    protected abstract A doRevert(B item);

    public A revert(B item) {
        return item != null ? doRevert(item) : null;
    }

    public List<A> revertAll(Collection<B> items) {
        if (items != null) {
            return items.stream().map(this::revert).filter(Objects::nonNull).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }


}
