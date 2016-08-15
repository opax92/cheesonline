package pl.opackisebastian.webui.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.opackisebastian.webui.user.UserData;

import java.util.Random;

/**
 * Created by seb on 13.08.16.
 */
@Component
public class FilterCreator {

    private final UserData userData;

    @Autowired
    public FilterCreator(UserData userData) {
        this.userData = userData;
    }

    public Filter createNewFilter() {
        Filter filter = new Filter(new Random().nextInt(500000));
        return  filter;
    }
}
