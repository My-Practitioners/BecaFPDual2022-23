package org.drdel.beca.prjfinal.micro.operaciones.api;

import org.drdel.beca.prjfinal.micro.operaciones.common.api.configuration.AppController;
import org.drdel.beca.prjfinal.micro.operaciones.model.domain.FondosClienteHistoryDTO;
import org.drdel.beca.prjfinal.micro.operaciones.model.service.IFondosClienteHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class OperacionesRestController extends AppController {
    private static final String MSG_RESPONSE_KEY_MENSAJE= "mensaje";
    private static final String MSG_RESPONSE_KEY_FONDO_CLIENTE= "fondo";
    private static final String MSG_RESPONSE_KEY_ERRORES= "errors";

    private static final String NO_VALIDO="Fondo no válido";
    private static final String ACTUALIZADO="Fondo actualizado con éxito";

    @Autowired
    IFondosClienteHistoryService fondosClienteHistoryService;

    @GetMapping(value = {"/fondocliente/{id}"})
    public ResponseEntity<Map<String, Object>> show(@PathVariable Long id) {

        FondosClienteHistoryDTO fondosClienteHistoryDTO;

        try {
            fondosClienteHistoryDTO = fondosClienteHistoryService.obtenerFondoCliente(id);
        } catch (Exception e) {
            return gestionarExceptionResponse(e);
        }
        if (fondosClienteHistoryDTO==null) {
            return gestionarResponse(
                    "El fondo de cliente ID: ".concat(id.toString()).concat(" no existe en la BD"),
                    fondosClienteHistoryDTO,
                    HttpStatus.NOT_FOUND);
        }
        return gestionarResponse(
                "Fondo de cliente obtenido con éxito",
                fondosClienteHistoryDTO,
                HttpStatus.OK);
    }

    @PatchMapping("/fondocliente/canceled/{id}")
    public ResponseEntity<Map<String, Object>> updateCanceled(@PathVariable Long id,
                                                              @Valid @RequestBody FondosClienteHistoryDTO fondosClienteHistoryDTO,
                                                              BindingResult result) {

        if(result.hasErrors()) {
            return gestionarResponseNoValida(NO_VALIDO, result);
        }

        FondosClienteHistoryDTO fondosClienteHistoryGuardado;

        try {
            fondosClienteHistoryService.cancelarFondoCliente(fondosClienteHistoryDTO);
            fondosClienteHistoryGuardado = fondosClienteHistoryService.obtenerFondoCliente(id);
        } catch (Exception e) {
            return gestionarExceptionResponse(e);
        }

        return gestionarResponse(
                ACTUALIZADO,
                fondosClienteHistoryGuardado,
                HttpStatus.CREATED);

    }

    @PatchMapping("/fondocliente/suspended/{id}")
    public ResponseEntity<Map<String, Object>> updateSuspended(@PathVariable Long id,
                                                               @Valid @RequestBody FondosClienteHistoryDTO fondosClienteHistoryDTO,
                                                               BindingResult result) {

        if(result.hasErrors()) {
            return gestionarResponseNoValida(NO_VALIDO, result);
        }

        FondosClienteHistoryDTO fondosClienteHistoryGuardado;

        try {
            fondosClienteHistoryService.suspenderFondoCliente(fondosClienteHistoryDTO);
            fondosClienteHistoryGuardado = fondosClienteHistoryService.obtenerFondoCliente(id);
        } catch (Exception e) {
            return gestionarExceptionResponse(e);
        }

        return gestionarResponse(
                ACTUALIZADO,
                fondosClienteHistoryGuardado,
                HttpStatus.CREATED);

    }

    private ResponseEntity<Map<String, Object>> gestionarResponse(String msg, FondosClienteHistoryDTO fondosClienteHistoryDTO, HttpStatus status) {

        Map<String, Object> mapResult = new HashMap<>();

        mapResult.put(MSG_RESPONSE_KEY_MENSAJE, msg);
        if(fondosClienteHistoryDTO != null)
            mapResult.put(MSG_RESPONSE_KEY_FONDO_CLIENTE, fondosClienteHistoryDTO);

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
