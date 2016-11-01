package pl.opackisebastian.businesslogic.user;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import pl.opackisebastian.businesslogic.player.ColorValue;
import pl.opackisebastian.businesslogic.filter.Filter;

/**
 * Created by seb on 13.08.16.
 */
@Component("userData")
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class User {

    private ColorValue color = ColorValue.NO_SET;

    private Filter filter;

    private String name;

    public Filter getFilter() {
        return filter;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    public ColorValue getColor() {
        return color;
    }

    public void setColor(ColorValue color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean waitingForOpponent(String name){
        if(filter.waitForOpponent()){
            filter.waitForOpponent(false);
            setFilter(filter);
            setName(name);
            return true;
        }

        return false;
    }
}
