package com.company.alertsystem.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.cuba.core.entity.BaseIntegerIdEntity;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name = "ALERTSYSTEM_ALERT_SNOOZE")
@Entity(name = "alertsystem$AlertSnooze")
public class AlertSnooze extends BaseIntegerIdEntity {
    private static final long serialVersionUID = 3488842279562746700L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ALERT_TYPE_ID")
    protected AlertType alertTypeID;

    @Column(name = "SAMPLE_ORDER_ID", nullable = false)
    protected Integer sampleOrderId;

    @Column(name = "DURATION", nullable = false)
    protected Integer duration;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_TIME", nullable = false)
    protected Date createTime;

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return createTime;
    }


    public void setAlertTypeID(AlertType alertTypeID) {
        this.alertTypeID = alertTypeID;
    }

    public AlertType getAlertTypeID() {
        return alertTypeID;
    }

    public void setSampleOrderId(Integer sampleOrderId) {
        this.sampleOrderId = sampleOrderId;
    }

    public Integer getSampleOrderId() {
        return sampleOrderId;
    }


}