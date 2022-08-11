package com.gft.palavra.dto.etiqueta;

import java.util.ArrayList;
import java.util.List;

import com.gft.palavra.entities.Etiqueta;

public class EtiquetaMapper {

    public static Etiqueta fromDTO(RegistroEtiquetaDTO dto){

        return new Etiqueta(null, dto.getEtiqueta(), null);
    }

    public static ConsultaEtiquetaDTO fromEntity(Etiqueta etiqueta){
        List<String> palavrasNome = new ArrayList<>();

        if(etiqueta.getPalavras() != null){
            etiqueta.getPalavras().forEach(palavra -> {
                String palavraNome = palavra.getPalavra();
                palavrasNome.add(palavraNome);
            });
        }

        return new ConsultaEtiquetaDTO(etiqueta.getId(), etiqueta.getEtiqueta(), palavrasNome);
    }
}
