package com.company.alertsystem.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.BaseIntegerIdEntity;
import com.haulmont.cuba.core.entity.HasUuid;
import javax.validation.constraints.NotNull;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s %s|id,name")
@Table(name = "ALERTSYSTEM_PROCESS")
@Entity(name = "alertsystem$Process")
public class Process extends BaseIntegerIdEntity {
    private static final long serialVersionUID = -4249183795285587481L;

    @NotNull
    @Column(name = "NAME", nullable = false)
    protected String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }





}