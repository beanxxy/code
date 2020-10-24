package com.vsdata.melsec.message.e.subheader;

/**
 * @author xxybean
 */
public class Frame4EBinaryResponseSubheader extends AbstractFrame4EBinarySubheader {

    public Frame4EBinaryResponseSubheader() {
    }

    public Frame4EBinaryResponseSubheader(int serialNo) {
        super(serialNo);
    }

    @Override
    protected byte[] getFrontCodes() {
        return new byte[]{(byte) 0xD4, 0x00};
    }

    @Override
    protected byte[] getEndCodes() {
        return new byte[]{0x00, 0x00};
    }
}
