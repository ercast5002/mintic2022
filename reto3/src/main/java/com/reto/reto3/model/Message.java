package com.reto.reto3.model;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
@Entity
@Table(name ="messege")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;

    private String messegeText;

    @ManyToOne
    @JoinColumn(name = "partyroomId")
    @JsonIgnoreProperties({"message", "reservations"})
    private Partyroom partyroom;

    @ManyToOne
    @JoinColumn(name = "clientId")
    @JsonIgnoreProperties({"message", "reservations"})
    private Client client;

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessegeText() {
        return messegeText;
    }

    public void setMessegeText(String messegeText) {
        this.messegeText = messegeText;
    }

    public Partyroom getPartyroom() {
        return partyroom;
    }

    public void setPartyroom(Partyroom partyroom) {
        this.partyroom = partyroom;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    
    
}
