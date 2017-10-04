package net.zonia3000.interceptors;

import java.util.Date;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Sonia Zorba <sonia at zonia3000.net>
 */
@Interceptor
@Profiled
public class ProfilingInterceptor {

    @AroundInvoke
    public Object intercettaMetodo(InvocationContext ctx) throws Exception {

        String className = ctx.getMethod().getDeclaringClass().getSimpleName();
        String methodName = ctx.getMethod().getName();

        System.out.println("Inizio profilazione di " + className + "." + methodName);

        long start = new Date().getTime();
        Object result = ctx.proceed();
        long end = new Date().getTime();

        System.out.println("Eseguito in: " + (end - start));

        return result;
    }
}
