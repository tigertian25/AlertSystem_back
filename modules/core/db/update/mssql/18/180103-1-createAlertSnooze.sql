create table ALERTSYSTEM_ALERT_SNOOZE (
    ID integer,
    --
    ALERT_TYPE_ID integer,
    SAMPLE_ORDER_ID integer not null,
    DURATION integer not null,
    CREATE_TIME datetime not null,
    --
    primary key (ID)
);
