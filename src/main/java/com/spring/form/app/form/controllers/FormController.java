package com.spring.form.app.form.controllers;

import javax.validation.Valid;

import com.spring.form.app.form.models.domain.Usuario;
import com.spring.form.app.form.validation.UsuarioValidador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("usuario")
public class FormController {

    @Autowired
    private UsuarioValidador validador;

    @GetMapping("/form")
    public String form(Model model) {
        Usuario usuario = new Usuario();
        usuario.setNombre("John");
        usuario.setApellido("Doe");
        usuario.setIdentificador("34.123.423-K");

        model.addAttribute("titulo", "Formulario usuarios");
        model.addAttribute("usuario", usuario);
        return "form";
    }

    @PostMapping("/form")
    public String procesa(Model model,@Valid Usuario usuario, BindingResult result, SessionStatus status) {
        validador.validate(usuario, result);

        if(result.hasErrors()){
            // Map<String, String> errores = new HashMap<>();
            // result.getFieldErrors().forEach(err -> {
            //     errores.put(err.getField(), "El campo "+err.getField()+" "+err.getDefaultMessage());
            // });
            // model.addAttribute("error", errores);
            return "form";
        }

        model.addAttribute("titulo", "Resultado form");
        model.addAttribute("usuario", usuario);
        status.setComplete();
        return "resultado";
    }
}
