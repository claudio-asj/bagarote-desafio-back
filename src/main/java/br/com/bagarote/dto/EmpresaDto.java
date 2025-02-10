package br.com.bagarote.dto;

import br.com.bagarote.model.Empresa;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpresaDto {

    private Long idEmpresa;
    private String nomeFantasia;

    public EmpresaDto(Empresa empresa){
        this.idEmpresa = empresa.getIdEmpresa();
        this.nomeFantasia = empresa.getNomeFantasia();
    }
}
