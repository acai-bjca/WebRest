package eci.ieti.WebRest;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador de recursos: Maneja las solicitudes HTTP En lugar de confiar en
 * una tecnología de visualización para realizar la representación del lado del
 * servidor de los datos de saludo a HTML, este controlador de servicio web
 * RESTful rellena y devuelve un Greetingobjeto.
 *
 * @author Amalia
 */
@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
