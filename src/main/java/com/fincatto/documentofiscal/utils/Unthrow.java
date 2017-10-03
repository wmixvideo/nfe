package com.fincatto.documentofiscal.utils;

import com.fincatto.documentofiscal.nfe310.classes.lote.envio.NFLoteEnvio;

import java.util.stream.Stream;

/**
 * Throw unchecker
 * @author SeregaLBN from https://raw.githubusercontent.com/SeregaLBN/StreamUnthrower/master/src/main/java/utils/stream/Unthrow.java
 *
 * Utilizado para permitir lançar exceção em tempo de execução com java8 lambdas.
 * veja em {@link com.fincatto.documentofiscal.nfe310.webservices.WSLoteEnvio#getLoteAssinado(NFLoteEnvio)}
 *
 */
public class Unthrow {
    @SuppressWarnings("unchecked")
    static <R, E extends Exception> R rethrow(Exception ex) throws E {
        throw (E) ex;
    }

    public static<R, E extends Exception> Stream<R> of(Stream<R> stream) throws E {
        return stream;
    }
    public static<R, E1 extends Exception, E2 extends Exception> Stream<R> of2(Stream<R> stream) throws E1, E2 {
        return stream;
    }
    public static<R, E1 extends Exception, E2 extends Exception, E3 extends Exception> Stream<R> of3(Stream<R> stream) throws E1, E2, E3 {
        return stream;
    }
    public static<R, E1 extends Exception, E2 extends Exception, E3 extends Exception, E4 extends Exception> Stream<R> of4(Stream<R> stream) throws E1, E2, E3, E4 {
        return stream;
    }

    
    ////////////////////////////////// interfaces ProcedureN //////////////////////////////////

    /** like as {@link Runnable} */
    @FunctionalInterface
    public interface IProc0 {
        void accept() throws Exception;
    }

    /** like as {@link java.util.function.Consumer} */
    @FunctionalInterface
    public interface IProc1<T> {
        void accept(T t) throws Exception;
    }

    /** like as {@link java.util.function.BiConsumer} */
    @FunctionalInterface
    public interface IProc2<T1, T2> {
        void accept(T1 t1, T2 t2) throws Exception;
    }

    @FunctionalInterface
    public interface IProc3<T1, T2, T3> {
        void accept(T1 t1, T2 t2, T3 t3) throws Exception;
    }

    ////////////////////////////////// interfaces FunctionN //////////////////////////////////

    /** like as {@link java.util.concurrent.Callable} */
    @FunctionalInterface
    public interface IFunc0<R> {
        R apply() throws Exception;
    }

    /** like as {@link java.util.function.Function} */
    @FunctionalInterface
    public interface IFunc1<R, T> {
        R apply(T t) throws Exception;
    }

    /** like as {@link java.util.function.BiFunction} */
    @FunctionalInterface
    public interface IFunc2<R, T1, T2> {
        R apply(T1 t1, T2 t2) throws Exception;
    }

    @FunctionalInterface
    public interface IFunc3<R, T1, T2, T3> {
        R apply(T1 t1, T2 t2, T3 t3) throws Exception;
    }

    ////////////////////////////////// wrap Procedures //////////////////////////////////

    public static void wrapProc(IProc0 proc) {
        try {
            proc.accept();
        } catch (Exception ex) {
            rethrow(ex);
        }
    }

    public static <T> void wrapProc(IProc1<T> proc, T t) {
        try {
            proc.accept(t);
        } catch (Exception ex) {
            rethrow(ex);
        }
    }

    public static <T1, T2> void wrapProc(IProc2<T1, T2> proc, T1 t1, T2 t2) {
        try {
            proc.accept(t1, t2);
        } catch (Exception ex) {
            rethrow(ex);
        }
    }

    public static <T1, T2, T3> void wrapProc(IProc3<T1, T2, T3> proc, T1 t1, T2 t2, T3 t3) {
        try {
            proc.accept(t1, t2, t3);
        } catch (Exception ex) {
            rethrow(ex);
        }
    }

    ////////////////////////////////// wrap Functions //////////////////////////////////

    public static <R> R wrap(IFunc0<R> func) {
        try {
            return func.apply();
        } catch (Exception ex) {
            return rethrow(ex);
        }
    }

    public static <R, T> R wrap(IFunc1<R, T> func, T t) {
        try {
            return func.apply(t);
        } catch (Exception ex) {
            return rethrow(ex);
        }
    }

    public static <R, T1, T2> R wrap(IFunc2<R, T1, T2> func, T1 t1, T2 t2) {
        try {
            return func.apply(t1, t2);
        } catch (Exception ex) {
            return rethrow(ex);
        }
    }

    public static <R, T1, T2, T3> R wrap(IFunc3<R, T1, T2, T3> func, T1 t1, T2 t2, T3 t3) {
        try {
            return func.apply(t1, t2, t3);
        } catch (Exception ex) {
            return rethrow(ex);
        }
    }

}