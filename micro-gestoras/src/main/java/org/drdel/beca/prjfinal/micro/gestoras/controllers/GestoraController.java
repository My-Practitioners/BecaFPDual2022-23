package org.drdel.beca.prjfinal.micro.gestoras.controllers;

import org.drdel.beca.prjfinal.micro.gestoras.api.commons.AppController;
import org.drdel.beca.prjfinal.micro.gestoras.model.domain.GestoraDTO;
import org.drdel.beca.prjfinal.micro.gestoras.model.service.IGestoraService;
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
public class GestoraController extends AppController {

    private static final String MSG_RESPONSE_KEY_MENSAJE= "mensaje";
    private static final String MSG_RESPONSE_KEY_GESTORA = "gestora";
    private static final String MSG_RESPONSE_KEY_ERRORES= "errors";

    private static final String NO_VALIDO="Gestora no válido";
    private static final String ACTUALIZADO="Gestora actualizado con éxito";

    @Autowired
    private IGestoraService gestoraService;

    @GetMapping("/gestoras")
    public List<GestoraDTO> list(){
        return gestoraService.obtenerTodasGestoras();
    }

    @GetMapping("/gestoras/{id}")
    public ResponseEntity<Map<String, Object>> show(@PathVariable Long id){
        GestoraDTO gestoraDto;
        try {
            gestoraDto=gestoraService.obtenerGestora(id);
        }catch (Exception e){
            return gestionarExceptionResponse(e);
        }
        if (gestoraDto==null){
            return gestionarResponse(
                    "La gestora ID: ".concat(id.toString()).concat(" no existe en la BD"),
                    gestoraDto,HttpStatus.NOT_FOUND);
        }

        return gestionarResponse(
                "Gestora obtenida con éxito",
                gestoraDto,
                HttpStatus.OK);
    }

    @PostMapping(value={"/gestoras"})
    public ResponseEntity<Map<String, Object>> create(@Valid @RequestBody GestoraDTO gestoraDto,
                                                      BindingResult result) {

        if(result.hasErrors()) {
            return gestionarResponseNoValida(NO_VALIDO, result);
        }

        Long id;
        GestoraDTO gestoraGuardada;

        try {
            id = gestoraService.crearGestora(gestoraDto);
            gestoraGuardada = gestoraService.obtenerGestora(id);
        } catch (Exception e) {
            return gestionarExceptionResponse(e);
        }

        return gestionarResponse(
                "Gestora creada con éxito",
                gestoraGuardada,
                HttpStatus.CREATED);

    }


    @PutMapping("/gestoras/{id}")
    public ResponseEntity<Map<String, Object>> update(@PathVariable Long id,
                                                      @Valid @RequestBody GestoraDTO gestoraDto,
                                                      BindingResult result) {

        if(result.hasErrors()) {
            return gestionarResponseNoValida(NO_VALIDO, result);
        }

        GestoraDTO gestoraGuardada;

        try {
            gestoraService.actualizarGestora(gestoraDto);
            gestoraGuardada = gestoraService.obtenerGestora(id);
        } catch (Exception e) {
            return gestionarExceptionResponse(e);
        }

        return gestionarResponse(
                ACTUALIZADO,
                gestoraGuardada,
                HttpStatus.CREATED);

    }


    @PatchMapping("/gestoras/operative/{id}")
    public ResponseEntity<Map<String, Object>> updateOperative(@PathVariable Long id,
                                                               @Valid @RequestBody GestoraDTO gestoraDto,
                                                               BindingResult result) {

        if(result.hasErrors()) {
            return gestionarResponseNoValida(NO_VALIDO, result);
        }

        GestoraDTO gestoraGuardada;

        try {
            gestoraService.activarGestora(gestoraDto);
            gestoraGuardada = gestoraService.obtenerGestora(id);
        } catch (Exception e) {
            return gestionarExceptionResponse(e);
        }

        return gestionarResponse(
                ACTUALIZADO,
                gestoraGuardada,
                HttpStatus.CREATED);

    }

    @PatchMapping("/gestoras/canceled/{id}")
    public ResponseEntity<Map<String, Object>> updateCanceled(@PathVariable Long id,
                                                              @Valid @RequestBody GestoraDTO gestoraDto,
                                                              BindingResult result) {

        if(result.hasErrors()) {
            return gestionarResponseNoValida(NO_VALIDO, result);
        }

        GestoraDTO gestoraGuardada;

        try {
            gestoraService.cancelarGestora(gestoraDto);
            gestoraGuardada = gestoraService.obtenerGestora(id);
        } catch (Exception e) {
            return gestionarExceptionResponse(e);
        }

        return gestionarResponse(
                ACTUALIZADO,
                gestoraGuardada,
                HttpStatus.CREATED);

    }

    @PatchMapping("/gestoras/suspended/{id}")
    public ResponseEntity<Map<String, Object>> updateSuspended(@PathVariable Long id,
                                                               @Valid @RequestBody GestoraDTO gestoraDto,
                                                               BindingResult result) {

        if(result.hasErrors()) {
            return gestionarResponseNoValida(NO_VALIDO, result);
        }

        GestoraDTO gestoraGuardada;

        try {
            gestoraService.suspenderGestora(gestoraDto);
            gestoraGuardada = gestoraService.obtenerGestora(id);
        } catch (Exception e) {
            return gestionarExceptionResponse(e);
        }

        return gestionarResponse(
                ACTUALIZADO,
                gestoraGuardada,
                HttpStatus.CREATED);

    }

    @DeleteMapping("/gestoras/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id) {

        GestoraDTO gestoraDto;

        try {
            gestoraDto = gestoraService.obtenerGestora(id);
            if (gestoraDto != null)
                gestoraService.borrarGestora(id);
        } catch (Exception e) {
            return gestionarExceptionResponse(e);
        }

        if (gestoraDto != null)
            return gestionarResponse(
                    "Gestora eliminada con éxito",
                    gestoraDto,
                    HttpStatus.OK);
        else
            return gestionarResponse(
                    "Gestora inexistente: ".concat(id.toString()),
                    gestoraDto,
                    HttpStatus.NOT_FOUND);
    }



    private ResponseEntity<Map<String, Object>> gestionarResponse(String msg, GestoraDTO gestoraDto, HttpStatus status) {

        Map<String, Object> mapResult = new HashMap<>();

        mapResult.put(MSG_RESPONSE_KEY_MENSAJE, msg);
        if(gestoraDto != null)
            mapResult.put(MSG_RESPONSE_KEY_GESTORA, gestoraDto);

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
