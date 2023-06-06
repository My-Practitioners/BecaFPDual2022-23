package org.drdel.beca.prjfinal.micro.operaciones.api;

import org.drdel.beca.prjfinal.micro.operaciones.common.api.configuration.AppController;
import org.drdel.beca.prjfinal.micro.operaciones.model.domain.FondoClienteDTO;
import org.drdel.beca.prjfinal.micro.operaciones.model.domain.FondoClienteHistoryDTO;
import org.drdel.beca.prjfinal.micro.operaciones.model.service.IFondoClienteHistoryService;
import org.drdel.beca.prjfinal.micro.operaciones.model.service.IFondoClienteService;
import org.drdel.beca.prjfinal.micro.operaciones.model.service.IOperacionContratacionService;
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
    IFondoClienteHistoryService iFondoClienteHistoryService;
    @Autowired
    IOperacionContratacionService iOperacionContratacionService;
    @Autowired
    IFondoClienteService iFondoClienteService;




    @GetMapping(value = {"/fondo-cliente/{id}"})
    public ResponseEntity<Map<String, Object>> obtenerFondoCliente(@PathVariable Long id) {

        FondoClienteDTO fondoClienteDTO;

        try {
            fondoClienteDTO = iFondoClienteService.obtenerFondoCliente(id);
        } catch (Exception e) {
            return gestionarExceptionResponse(e);
        }
        if (fondoClienteDTO ==null) {
            return gestionarResponse(
                    "El fondo de cliente ID: ".concat(id.toString()).concat(" no existe en la BD"),
                    fondoClienteDTO,
                    HttpStatus.NOT_FOUND);
        }
        return gestionarResponse(
                "Fondo de cliente obtenido con éxito",
                fondoClienteDTO,
                HttpStatus.OK);
    }

    @GetMapping(value = {"/fondo-cliente"})
    public List<FondoClienteDTO> obtenerFondoTodosCliente(){
        return iFondoClienteService.obtenerTodosFondoCliente();
    }



    @GetMapping(value = {"/fondo-cliente-history/{id}"})
    public ResponseEntity<Map<String, Object>> obtenerFondoClienteHistory(@PathVariable Long id) {

        FondoClienteHistoryDTO fondoClienteHistoryDTO;

        try {
            fondoClienteHistoryDTO = iFondoClienteHistoryService.obtenerFondoClienteHistory(id);
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


    @GetMapping(value = {"/fondo-cliente-history"})
    public List<FondoClienteHistoryDTO> obtenerFondoTodosClienteHistory(){
        return iFondoClienteHistoryService.obtenerTodosFondoClienteHistory();
    }

    @PostMapping(value = {"/fondo-cliente/{idCliente}/{codIsin}"})
    public ResponseEntity<Map<String,Object>> contratarFondo(@PathVariable Integer idCliente, @PathVariable String codIsin,
                                                             @Valid @RequestBody FondoClienteDTO fondoClienteDTO,
                                                             BindingResult result){
        if (result.hasErrors()){
            return gestionarResponseNoValida(NO_VALIDO,result);
        }
            Long id;
            FondoClienteDTO fondoClienteGuardado;
            try{
                id = iOperacionContratacionService.contratarFondo(idCliente, codIsin, fondoClienteDTO);
                fondoClienteGuardado = iFondoClienteService.obtenerFondoCliente(id);
            } catch (Exception e){
                return gestionarExceptionResponse(e);
            }

        return gestionarResponse(
                "El fondo ha sido contratado",
                fondoClienteGuardado,
                HttpStatus.OK);
    }

    @PatchMapping("/fondo-cliente/operative/{id}")
    public ResponseEntity<Map<String, Object>> updateOperative(@PathVariable Long id,
                                                               @Valid @RequestBody FondoClienteHistoryDTO fondoClienteHistoryDto, @Valid @RequestBody FondoClienteDTO fondoClienteDTO,
                                                               BindingResult result){
        if (result.hasErrors())
            return gestionarResponseNoValida(NO_VALIDO,result);

        FondoClienteHistoryDTO dtoGuardado;
        try {
            iOperacionContratacionService.activarFondoCliente(fondoClienteHistoryDto);
            dtoGuardado = iFondoClienteHistoryService.obtenerFondoClienteHistory(id);
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
            iOperacionContratacionService.cancelarFondoCliente(fondoClienteHistoryDto);
            dtoGuardado = iFondoClienteHistoryService.obtenerFondoClienteHistory(id);
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
            iOperacionContratacionService.suspenderFondoCliente(fondoClienteHistoryDto);
            dtoGuardado = iFondoClienteHistoryService.obtenerFondoClienteHistory(id);
        } catch (Exception e) {
            return gestionarExceptionResponse(e);
        }

        return gestionarResponse(
                ACTUALIZADO,
                dtoGuardado,
                HttpStatus.OK);

    }

    @PatchMapping("/fondo-cliente/modificarImporte/{id}/{importe}")
    public ResponseEntity<Map<String, Object>> updateImporte(@PathVariable Long id, @PathVariable Double importe,
                                                               @Valid @RequestBody FondoClienteHistoryDTO fondoClienteHistoryDto,
                                                               BindingResult result) {

        if(result.hasErrors()) {
            return gestionarResponseNoValida(NO_VALIDO, result);
        }

        FondoClienteHistoryDTO dtoGuardado;

        try {
            iOperacionContratacionService.modificarImporte(fondoClienteHistoryDto, importe);
            dtoGuardado = iFondoClienteHistoryService.obtenerFondoClienteHistory(id);
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

    private ResponseEntity<Map<String, Object>> gestionarResponse(String msg, FondoClienteDTO fondoClienteDto, HttpStatus status) {

        Map<String, Object> mapResult = new HashMap<>();

        mapResult.put(MSG_RESPONSE_KEY_MENSAJE, msg);
        if(fondoClienteDto != null)
            mapResult.put(MSG_RESPONSE_KEY_FONDO_CLIENTE, fondoClienteDto);

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
