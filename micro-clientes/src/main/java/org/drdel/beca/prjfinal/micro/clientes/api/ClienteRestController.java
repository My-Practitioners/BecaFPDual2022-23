package org.drdel.beca.prjfinal.micro.clientes.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.drdel.beca.prjfinal.micro.clientes.common.api.AppController;
import org.drdel.beca.prjfinal.micro.clientes.model.domain.ClienteDTO;
import org.drdel.beca.prjfinal.micro.clientes.model.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ClienteRestController extends AppController {

    private static final String MSG_RESPONSE_KEY_MENSAJE = "mensaje";
    private static final String MSG_RESPONSE_KEY_CLIENTE = "cliente";
    private static final String MSG_RESPONSE_KEY_ERRORES = "errors";

    @Autowired
    private IClienteService clienteService;

    @GetMapping(value={"/clientes"})
    public List<ClienteDTO> list() {

        return clienteService.obtenerTodosClientes();
    }

    @GetMapping(value={"/clientes/{id}"})
    public ResponseEntity<Map<String, Object>> show(@PathVariable Long id) {

        ClienteDTO cliente;

        try {
            cliente = clienteService.obtenerCliente(id);
        } catch (Exception e) {
            return gestionarExceptionResponse(e);
        }

        if (cliente==null) {
            return gestionarResponse(
                    "El cliente ID: ".concat(id.toString()).concat(" no existe en la BD"),
                    cliente,
                    HttpStatus.NOT_FOUND);
        }

        return gestionarResponse(
                "Cliente obtenido con éxito",
                cliente,
                HttpStatus.OK);

    }

    @PostMapping(value={"/clientes"})
    public ResponseEntity<Map<String, Object>> create(@Valid @RequestBody ClienteDTO cliente,
                                                      BindingResult result) {

        if(result.hasErrors()) {
            return gestionarResponseNoValida("Cliente no válido", result);
        }

        Long id;
        ClienteDTO clienteGuardado;

        try {
            id = clienteService.crearCliente(cliente);
            clienteGuardado = clienteService.obtenerCliente(id);
        } catch (Exception e) {
            return gestionarExceptionResponse(e);
        }

        return gestionarResponse(
                "Cliente creado con éxito",
                clienteGuardado,
                HttpStatus.CREATED);

    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<Map<String, Object>> update(@PathVariable Long id,
                                                      @Valid @RequestBody ClienteDTO cliente,
                                                      BindingResult result) {

        if(result.hasErrors()) {
            return gestionarResponseNoValida("Cliente no válido", result);
        }

        ClienteDTO clienteGuardado = null;

        try {
            clienteService.actualizarCliente(cliente);
            clienteGuardado = clienteService.obtenerCliente(id);
        } catch (Exception e) {
            return gestionarExceptionResponse(e);
        }

        return gestionarResponse(
                "Cliente actualizado con éxito",
                clienteGuardado,
                HttpStatus.CREATED);

    }

    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id) {

        ClienteDTO cliente;

        try {
            cliente = clienteService.obtenerCliente(id);
            if (cliente != null)
                clienteService.borrarCliente(id);
        } catch (Exception e) {
            return gestionarExceptionResponse(e);
        }

        if (cliente != null)
            return gestionarResponse(
                    "Cliente eliminado con éxito",
                    cliente,
                    HttpStatus.OK);
        else
            return gestionarResponse(
                    "Cliente inexistente: ".concat(id.toString()),
                    cliente,
                    HttpStatus.NOT_FOUND);
    }


    private ResponseEntity<Map<String, Object>> gestionarResponse(String msg, ClienteDTO cliente, HttpStatus status) {

        Map<String, Object> mapResult = new HashMap<>();

        mapResult.put(MSG_RESPONSE_KEY_MENSAJE, msg);
        if(cliente != null)
            mapResult.put(MSG_RESPONSE_KEY_CLIENTE, cliente);

        return new ResponseEntity<>(mapResult, status);

    }

    private ResponseEntity<Map<String, Object>> gestionarResponseNoValida(String msg, BindingResult result) {

        Map<String, Object> mapResult = new HashMap<>();

        mapResult.put(MSG_RESPONSE_KEY_MENSAJE, msg);

        List<String> errors = result.getFieldErrors()
                .stream()
                .map(err -> err.getField() + " - " + err.getDefaultMessage())
                .collect(Collectors.toList());

        mapResult.put(MSG_RESPONSE_KEY_ERRORES, errors);

        return new ResponseEntity<>(mapResult, HttpStatus.BAD_REQUEST);

    }


}

