package pl.opackisebastian.webui.filter;

/**
 * Created by seb on 14.08.16.
 */
public interface FilterRepository {

    Filter getFilter(String filter);

    void addFilter(Filter filter);
}
