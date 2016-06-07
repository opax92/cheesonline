package pl.opackisebastian.businesslogic.trace;

import pl.opackisebastian.businesslogic.exceptions.GenerateTraceException;

import java.util.Collection;

/**
 * Created by seb on 09.03.16.
 */
public interface TraceGenerator<T> {
    Collection<T> generateTrace(T source, T destination) throws GenerateTraceException;
}