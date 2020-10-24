package com.vsdata.melsec.message.e.subheader;

/**
 * @author xxybean
 */
public class Frame4EAsciiResponseSubheader extends AbstractFrame4EAsciiSubheader {

    public Frame4EAsciiResponseSubheader() {
    }

    public Frame4EAsciiResponseSubheader(int serialNo) {
        super(serialNo);
    }

    @Override
    protected byte[] getFrontCodes() {
        return new byte[]{0x44, 0x34, 0x30, 0x30};
    }

    @Override
    protected byte[] getEndCodes() {
        return new byte[]{0x30, 0x30, 0x30, 0x30};
    }
}
