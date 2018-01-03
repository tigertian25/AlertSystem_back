package com.company.alertsystem.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.cuba.core.entity.BaseIntegerIdEntity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Column;

@Table(name = "ALERTSYSTEM_ALERT_TYPE")
@Entity(name = "alertsystem$AlertType")
public class AlertType extends BaseIntegerIdEntity {
    private static final long serialVersionUID = 3438269097848885701L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FROM_PROCESS_ID")
    protected Process fromProcessId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TO_PROCESS_ID")
    protected Process toProcessId;

    @Column(name = "ALLOWED_DURATION")
    protected Integer allowedDuration;

    @Column(name = "SINGLE_MAX_DURATION", nullable = false)
    protected Integer singleMaxDuration;

    @Column(name = "TOTAL_MAX_DURATION", nullable = false)
    protected Integer totalMaxDuration;

    public void setToProcessId(Process toProcessId) {
        this.toProcessId = toProcessId;
    }

    public Process getToProcessId() {
        return toProcessId;
    }

    public void setAllowedDuration(Integer allowedDuration) {
        this.allowedDuration = allowedDuration;
    }

    public Integer getAllowedDuration() {
        return allowedDuration;
    }

    public void setSingleMaxDuration(Integer singleMaxDuration) {
        this.singleMaxDuration = singleMaxDuration;
    }

    public Integer getSingleMaxDuration() {
        return singleMaxDuration;
    }

    public void setTotalMaxDuration(Integer totalMaxDuration) {
        this.totalMaxDuration = totalMaxDuration;
    }

    public Integer getTotalMaxDuration() {
        return totalMaxDuration;
    }


    public void setFromProcessId(Process fromProcessId) {
        this.fromProcessId = fromProcessId;
    }

    public Process getFromProcessId() {
        return fromProcessId;
    }


}