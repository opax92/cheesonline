package pl.opackisebastian.webui.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by seb on 15.08.16.
 */
@Service
public class FilterService {

    private final FilterRepository filterRepository;

    @Autowired
    public FilterService(FilterRepository filterRepository) {
        this.filterRepository = filterRepository;
    }

    public Filter findFilter(String filterStr){
        Filter filter = filterRepository.getFilter(filterStr);

        if(filter == null){
            throw new IllegalStateException();
        }

        return filter;
    }

    public void addFilter(Filter filter){
        filterRepository.addFilter(filter);
    }
}
