package com.leilao.leilaoSite.domain.adesao.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue(value = "admin")
public class ModeloAdmin extends UserModel{
    
}
