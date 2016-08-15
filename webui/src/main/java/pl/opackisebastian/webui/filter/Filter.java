package pl.opackisebastian.webui.filter;

/**
 * Created by seb on 14.08.16.
 */
public class Filter {

    private Integer id;
    private Boolean waitForOpponent = true;

    public Filter(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Filter{" +
                "id=" + id +
                '}';
    }

    public Boolean waitForOpponent() {
        return waitForOpponent;
    }

    public void waitForOpponent(Boolean waitForOpponent) {
        this.waitForOpponent = waitForOpponent;
    }
}
