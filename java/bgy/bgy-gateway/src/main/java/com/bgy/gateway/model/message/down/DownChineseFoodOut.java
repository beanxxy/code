package com.bgy.gateway.model.message.down;

import com.bgy.gateway.enums.CommandType;
import com.bgy.gateway.model.message.RequestMessageIn;
import com.bgy.gateway.util.NettyUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.buffer.ByteBuf;


/**
 * @author caijunwei
 * date 2020/1/3 17:10
 */
public class DownChineseFoodOut extends RequestMessageIn {


    private  int command;
    private  Long missionId;
    private  int size;// 1 大  2 中  3  小
    private  int tableId;
    @Override
    public int calcLength() {
        switch (command){
            case 2: return  14;
            case 3: return  10;
            default:
                break;
        }
        return 0;
    }


    @Override
    public void decode(ByteBuf in, boolean isBigEndian) {
        // skip
    }

    @Override
    public void encode(ByteBuf out, boolean isBigEndian) {
        if(CommandType.TWO.getStatus()==command ){
            NettyUtil.writeShort(out, isBigEndian, command);
            NettyUtil.writeLong(out, isBigEndian, missionId);
            NettyUtil.writeShort(out, isBigEndian, size);
            NettyUtil.writeShort(out, isBigEndian, tableId);
        }else if(CommandType.THREE.getStatus()==command){
            NettyUtil.writeShort(out, isBigEndian, command);
            NettyUtil.writeLong(out, isBigEndian, missionId);
        }
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

    public int getCommand() {
        return command;
    }

    public void setCommand(int command) {
        this.command = command;
    }

    public Long getMissionId() {
        return missionId;
    }

    public void setMissionId(Long missionId) {
        this.missionId = missionId;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }
}
