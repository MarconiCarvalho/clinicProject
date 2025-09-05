package com.project.clinic.model.consultation;

import com.project.clinic.model.dtos.ConsultationRequestDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "CONSULTATION_TABLE")
@Table(name = "CONSULTATION_TABLE")
@NoArgsConstructor
@EqualsAndHashCode(of = "consultationId")
public class ConsultationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID consultationId;
    private LocalDate date;
    private String timer;
    private String status;
    private UUID createBy;
    private LocalDateTime createAt;
    private UUID updateBy;
    private LocalDateTime updateAt;


    public ConsultationModel(ConsultationRequestDTO data){
        this.date = data.date();
        this.timer = data.timer();
        this.status = data.status();
        this.createBy = data.createBy();
        this.createAt = data.createAt();
        this.updateBy = data.updateBy();
        this.updateAt = data.updateAt();
    }

    public UUID getConsultationId() {
        return consultationId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTimer() {
        return timer;
    }

    public void setTimer(String timer) {
        this.timer = timer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UUID getCreateBy() {
        return createBy;
    }

    public void setCreateBy(UUID createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public UUID getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(UUID updateBy) {
        this.updateBy = updateBy;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }
}
