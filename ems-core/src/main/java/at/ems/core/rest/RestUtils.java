package at.ems.core.rest;

import org.apache.logging.log4j.util.TriConsumer;
import org.springframework.http.ResponseEntity;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class RestUtils {
    public static <R> ResponseEntity<R> request(Supplier<R> request) {
        try {
            return ResponseEntity.ok(request.get());
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.notFound().header(ex.getMessage()).build();
        } catch (Exception ex) {
            return ResponseEntity.badRequest().header(ex.getMessage()).build();
        }
    }

    public static <R, T> ResponseEntity<R> request(Function<T, R> request, T parameter) {
        try {
            return ResponseEntity.ok(request.apply(parameter));
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.notFound().header(ex.getMessage()).build();
        } catch (Exception ex) {
            return ResponseEntity.badRequest().header(ex.getMessage()).build();
        }
    }

    public static <T> ResponseEntity<?> voidRequest(Consumer<T> request, T parameter) {
        try {
            request.accept(parameter);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.notFound().header(ex.getMessage()).build();
        } catch (Exception ex) {
            return ResponseEntity.badRequest().header(ex.getMessage()).build();
        }
    }

    public static <T1, T2> ResponseEntity<?> voidRequest(BiConsumer<T1, T2> request, T1 p1, T2 p2) {
        try {
            request.accept(p1, p2);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.notFound().header(ex.getMessage()).build();
        } catch (Exception ex) {
            return ResponseEntity.badRequest().header(ex.getMessage()).build();
        }
    }

    public static <T1, T2, T3> ResponseEntity<?> voidRequest(TriConsumer<T1, T2, T3> request, T1 p1, T2 p2, T3 p3) {
        try {
            request.accept(p1, p2, p3);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.notFound().header(ex.getMessage()).build();
        } catch (Exception ex) {
            return ResponseEntity.badRequest().header(ex.getMessage()).build();
        }
    }
}
