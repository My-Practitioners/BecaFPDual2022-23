package org.drdel.beca.prjfinal.micro.gestoras.controllers;

import org.drdel.beca.prjfinal.micro.gestoras.api.commons.AppController;
import org.drdel.beca.prjfinal.micro.gestoras.model.domain.FondoInversionDTO;
import org.drdel.beca.prjfinal.micro.gestoras.model.service.IFondoInversionService;
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
public class FondoInversionController extends AppController {
    private static final String MSG_RESPONSE_KEY_MENSAJE= "mensaje";
    private static final String MSG_RESPONSE_KEY_CLIENTE= "Fondo";
    private static final String MSG_RESPONSE_KEY_ERRORES= "errors";

    private static final String NO_VALIDO="Fondo no válido";
    private static final String ACTUALIZADO="Fondo actualizado con éxito";

    @Autowired
    private IFondoInversionService fondoService;

    @GetMapping("/fondos")
    public List<FondoInversionDTO> list(){
        return fondoService.obtenerTodosFondoInversion();
    }

    @GetMapping("/fondos/{cod}")
    public ResponseEntity<Map<String, Object>> show(@PathVariable String cod){
        FondoInversionDTO fondoInversionDTO;
        try {
            fondoInversionDTO=fondoService.obtenerFondoInversion(cod);
        }catch (Exception e){
            return gestionarExceptionResponse(e);
        }
        if (fondoInversionDTO==null){
            return gestionarResponse(
                    "El fondo COD: ".concat(cod.toString()).concat(" no existe en la BD"),
                    fondoInversionDTO, HttpStatus.NOT_FOUND);
        }

        return gestionarResponse(
                "Fondo obtenido con éxito",
                fondoInversionDTO,
                HttpStatus.OK);
    }

    @PostMapping(value={"/fondos"})
    public ResponseEntity<Map<String, Object>> create(@Valid @RequestBody FondoInversionDTO fondoInversionDTO,
                                                      BindingResult result) {

        if(result.hasErrors()) {
            return gestionarResponseNoValida(NO_VALIDO, result);
        }

        String cod;
        FondoInversionDTO fondoGuardado;

        try {
            cod = fondoService.crearFondoInversion(fondoInversionDTO);
            fondoGuardado = fondoService.obtenerFondoInversion(cod);
        } catch (Exception e) {
            return gestionarExceptionResponse(e);
        }

        return gestionarResponse(
                "Fondo de inversion creado con éxito",
                fondoGuardado,
                HttpStatus.CREATED);

    }


    @PutMapping("/fondos/{cod}")
    public ResponseEntity<Map<String, Object>> update(@PathVariable String cod,
                                                      @Valid @RequestBody FondoInversionDTO fondoInversionDTO,
                                                      BindingResult result) {

        if(result.hasErrors()) {
            return gestionarResponseNoValida(NO_VALIDO, result);
        }

        FondoInversionDTO fondoGuardado;

        try {
            fondoService.actualizarFondoInversion(fondoInversionDTO);
            fondoGuardado = fondoService.obtenerFondoInversion(cod);
        } catch (Exception e) {
            return gestionarExceptionResponse(e);
        }

        return gestionarResponse(
                ACTUALIZADO,
                fondoGuardado,
                HttpStatus.CREATED);

    }


    @PatchMapping("/fondos/operative/{cod}")
    public ResponseEntity<Map<String, Object>> updateOperative(@PathVariable String cod,
                                                               @Valid @RequestBody FondoInversionDTO fondoInversionDTO,
                                                               BindingResult result) {

        if(result.hasErrors()) {
            return gestionarResponseNoValida(NO_VALIDO, result);
        }

        FondoInversionDTO fondoGuardado;

        try {
            fondoService.activarFondoInversion(fondoInversionDTO);
            fondoGuardado = fondoService.obtenerFondoInversion(cod);
        } catch (Exception e) {
            return gestionarExceptionResponse(e);
        }

        return gestionarResponse(
                ACTUALIZADO,
                fondoGuardado,
                HttpStatus.CREATED);

    }

    @PatchMapping("/fondos/canceled/{cod}")
    public ResponseEntity<Map<String, Object>> updateCanceled(@PathVariable String cod,
                                                              @Valid @RequestBody FondoInversionDTO fondoInversionDTO,
                                                              BindingResult result) {

        if(result.hasErrors()) {
            return gestionarResponseNoValida(NO_VALIDO, result);
        }

        FondoInversionDTO fondoGuardado;

        try {
            fondoService.cancelarFondoInversion(fondoInversionDTO);
            fondoGuardado = fondoService.obtenerFondoInversion(cod);
        } catch (Exception e) {
            return gestionarExceptionResponse(e);
        }

        return gestionarResponse(
                ACTUALIZADO,
                fondoGuardado,
                HttpStatus.CREATED);

    }

    @PatchMapping("/fondos/suspended/{cod}")
    public ResponseEntity<Map<String, Object>> updateSuspended(@PathVariable String cod,
                                                               @Valid @RequestBody FondoInversionDTO fondoInversionDTO,
                                                               BindingResult result) {

        if(result.hasErrors()) {
            return gestionarResponseNoValida(NO_VALIDO, result);
        }

        FondoInversionDTO fondoGuardado;

        try {
            fondoService.suspenderFondoInversion(fondoInversionDTO);
            fondoGuardado = fondoService.obtenerFondoInversion(cod);
        } catch (Exception e) {
            return gestionarExceptionResponse(e);
        }

        return gestionarResponse(
                ACTUALIZADO,
                fondoGuardado,
                HttpStatus.CREATED);

    }

    @DeleteMapping("/fondos/{cod}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable String cod) {

        FondoInversionDTO fondoInversionDTO;

        try {
            fondoInversionDTO = fondoService.obtenerFondoInversion(cod);
            if (fondoInversionDTO != null)
                fondoService.borrarFondoInversion(cod);
        } catch (Exception e) {
            return gestionarExceptionResponse(e);
        }

        if (fondoInversionDTO != null)
            return gestionarResponse(
                    "Fondo eliminado con éxito",
                    fondoInversionDTO,
                    HttpStatus.OK);
        else
            return gestionarResponse(
                    "Fondo inexistente: ".concat(cod),
                    fondoInversionDTO,
                    HttpStatus.NOT_FOUND);
    }



    private ResponseEntity<Map<String, Object>> gestionarResponse(String msg, FondoInversionDTO fondoInversionDTO, HttpStatus status) {

        Map<String, Object> mapResult = new HashMap<>();

        mapResult.put(MSG_RESPONSE_KEY_MENSAJE, msg);
        if(fondoInversionDTO != null)
            mapResult.put(MSG_RESPONSE_KEY_CLIENTE, fondoInversionDTO);

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
