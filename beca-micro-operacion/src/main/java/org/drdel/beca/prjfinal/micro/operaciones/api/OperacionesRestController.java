package org.drdel.beca.prjfinal.micro.operaciones.api;

import org.drdel.beca.prjfinal.micro.operaciones.common.api.configuration.AppController;
import org.drdel.beca.prjfinal.micro.operaciones.model.domain.FondoClienteHistoryDTO;
import org.drdel.beca.prjfinal.micro.operaciones.model.service.IFondoClienteHistoryService;
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
    IFondoClienteHistoryService fondosClienteHistoryService;

    @GetMapping(value = {"/fondo-cliente/{id}"})
    public ResponseEntity<Map<String, Object>> show(@PathVariable Long id) {

        FondoClienteHistoryDTO fondoClienteHistoryDTO;

        try {
            fondoClienteHistoryDTO = fondosClienteHistoryService.obtenerFondoCliente(id);
        } catch (Exception e) {
            return gestionarExceptionResponse(e);
        }
        if (fondoClienteHistoryDTO ==null) {
            return gestionarResponse(
                    "El fondo de cliente ID: ".concat(id.toString()).concat(" no existe en la BD"),
                    fondoClienteHistoryDTO,
                    HttpStatus.NOT_FOUND);
        }
        return gestionarResponse(
                "Fondo de cliente obtenido con éxito",
                fondoClienteHistoryDTO,
                HttpStatus.OK);
    }


    @GetMapping(value = {"/fondo-cliente"})
    public List<FondoClienteHistoryDTO> list(){
        return fondosClienteHistoryService.obtenerTodosFondoCliente();
    }


    @PatchMapping("/fondo-cliente/operative/{id}")
    public ResponseEntity<Map<String, Object>> updateOperative(@PathVariable Long id,
                                                               @Valid @RequestBody FondoClienteHistoryDTO fondoClienteHistoryDto,
                                                               BindingResult result){
        if (result.hasErrors())
            return gestionarResponseNoValida(NO_VALIDO,result);

        FondoClienteHistoryDTO dtoGuardado;
        try {
            fondosClienteHistoryService.activarFondoCliente(fondoClienteHistoryDto);
            dtoGuardado = fondosClienteHistoryService.obtenerFondoCliente(id);
        }catch (Exception e){
            return gestionarExceptionResponse(e);
        }
        return gestionarResponse(
                ACTUALIZADO,
                dtoGuardado,
                HttpStatus.OK);
    }



    @PatchMapping("/fondo-cliente/canceled/{id}")
    public ResponseEntity<Map<String, Object>> updateCanceled(@PathVariable Long id,
                                                              @Valid @RequestBody FondoClienteHistoryDTO fondoClienteHistoryDto,
                                                              BindingResult result) {

        if(result.hasErrors()) {
            return gestionarResponseNoValida(NO_VALIDO, result);
        }

        FondoClienteHistoryDTO dtoGuardado;

        try {
            fondosClienteHistoryService.cancelarFondoCliente(fondoClienteHistoryDto);
            dtoGuardado = fondosClienteHistoryService.obtenerFondoCliente(id);
        } catch (Exception e) {
            return gestionarExceptionResponse(e);
        }

        return gestionarResponse(
                ACTUALIZADO,
                dtoGuardado,
                HttpStatus.OK);

    }

    @PatchMapping("/fondo-cliente/suspended/{id}")
    public ResponseEntity<Map<String, Object>> updateSuspended(@PathVariable Long id,
                                                               @Valid @RequestBody FondoClienteHistoryDTO fondoClienteHistoryDto,
                                                               BindingResult result) {

        if(result.hasErrors()) {
            return gestionarResponseNoValida(NO_VALIDO, result);
        }

        FondoClienteHistoryDTO dtoGuardado;

        try {
            fondosClienteHistoryService.suspenderFondoCliente(fondoClienteHistoryDto);
            dtoGuardado = fondosClienteHistoryService.obtenerFondoCliente(id);
        } catch (Exception e) {
            return gestionarExceptionResponse(e);
        }

        return gestionarResponse(
                ACTUALIZADO,
                dtoGuardado,
                HttpStatus.OK);

    }



    private ResponseEntity<Map<String, Object>> gestionarResponse(String msg, FondoClienteHistoryDTO fondoClienteHistoryDto, HttpStatus status) {

        Map<String, Object> mapResult = new HashMap<>();

        mapResult.put(MSG_RESPONSE_KEY_MENSAJE, msg);
        if(fondoClienteHistoryDto != null)
            mapResult.put(MSG_RESPONSE_KEY_FONDO_CLIENTE, fondoClienteHistoryDto);

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
