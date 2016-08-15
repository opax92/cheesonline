package pl.opackisebastian.webui.filter;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by seb on 14.08.16.
 */
@Repository
public class FilterRepositoryImpl implements FilterRepository {

    private Map<String, Filter> filters = new HashMap<>();

    @Override
    public Filter getFilter(String filter) {
        return filters.get(filter);
    }

    @Override
    public void addFilter(Filter filter) {
        filters.put(filter.getId().toString(), filter);
    }
}
