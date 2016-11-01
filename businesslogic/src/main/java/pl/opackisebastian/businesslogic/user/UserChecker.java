package pl.opackisebastian.businesslogic.user;


import pl.opackisebastian.businesslogic.filter.Filter;

/**
 * Created by seb on 23.09.16.
 */
public class UserChecker {

    public boolean userSetName(Filter filter, String name) {
        if (filter.waitForOpponent() && name == null) {
            return true;
        }
        return false;
    }
}
