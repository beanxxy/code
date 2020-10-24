package com.bgy.gateway.model.kafka;

import com.bgy.gateway.enums.*;
import com.bgy.gateway.model.message.Message;
import com.bgy.gateway.model.message.cold.ColdSimpleChineseFoodIn;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class ColdSimpleChineseFoodDischarge {

    private int header;
    private MessageType messageType;
    private int uniqueKey;
    private DeviceType deviceType;
    private int deviceId;
    private int deviceSubType;
    private ControlMode controlMode;
    private DeviceStatus deviceStatus;
    private ExceptionStatus exceptionStatus;
    private int request;
    private List<Integer> warningInfo;
    private long missionId;
    private int productId;
    private int row;
    private int column;
    private int dischargeStatus;
    private int missionStatus;

    public ColdSimpleChineseFoodDischarge (Message<ColdSimpleChineseFoodIn> msg) {
        this.header = msg.getHeader();
        this.messageType = msg.getMessageType();
        this.uniqueKey = msg.getUniqueKey();
        this.deviceType = msg.getDeviceType();
        this.deviceId = msg.getDeviceId();
        this.deviceSubType = msg.getExtraData().getDeviceSubType();
        this.controlMode = msg.getExtraData().getControlMode();
        this.deviceStatus = msg.getExtraData().getDeviceStatus();
        this.exceptionStatus = msg.getExtraData().getExceptionStatus();
        this.request = msg.getExtraData().getRequest();
        this.warningInfo = msg.getExtraData().getErrorList();
        this.missionId = msg.getExtraData().getMissionId();
        this.productId = msg.getExtraData().getProductId();
        this.row = msg.getExtraData().getRow();
        this.column = msg.getExtraData().getColumn();
        this.dischargeStatus = msg.getExtraData().getDischargeStatus();
        this.missionStatus = msg.getExtraData().getMissionStatus();
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    public int getHeader() {
        return header;
    }

    public void setHeader(int header) {
        this.header = header;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public int getUniqueKey() {
        return uniqueKey;
    }

    public void setUniqueKey(int uniqueKey) {
        this.uniqueKey = uniqueKey;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public int getDeviceSubType() {
        return deviceSubType;
    }

    public void setDeviceSubType(int deviceSubType) {
        this.deviceSubType = deviceSubType;
    }

    public ControlMode getControlMode() {
        return controlMode;
    }

    public void setControlMode(ControlMode controlMode) {
        this.controlMode = controlMode;
    }

    public DeviceStatus getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(DeviceStatus deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    public ExceptionStatus getExceptionStatus() {
        return exceptionStatus;
    }

    public void setExceptionStatus(ExceptionStatus exceptionStatus) {
        this.exceptionStatus = exceptionStatus;
    }

    public int getRequest() {
        return request;
    }

    public void setRequest(int request) {
        this.request = request;
    }

    public List<Integer> getWarningInfo() {
        return warningInfo;
    }

    public void setWarningInfo(List<Integer> warningInfo) {
        this.warningInfo = warningInfo;
    }

    public long getMissionId() {
        return missionId;
    }

    public void setMissionId(long missionId) {
        this.missionId = missionId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getDischargeStatus() {
        return dischargeStatus;
    }

    public void setDischargeStatus(int dischargeStatus) {
        this.dischargeStatus = dischargeStatus;
    }

    public int getMissionStatus() {
        return missionStatus;
    }

    public void setMissionStatus(int missionStatus) {
        this.missionStatus = missionStatus;
    }
}
