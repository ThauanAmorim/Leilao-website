package com.leilao.leilaoSite.domain.adesao.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@Entity
@DiscriminatorValue(value = "admin")
@Table(name = "TB_ADMIN")
public class ModeloAdmin extends UserModel {

    public ModeloAdmin() {
        
    }
}
