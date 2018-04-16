package com.bovink.androidlearning.socket.bean;

/**
 * @author Retina975
 * @since 2017/07/14
 */

public class SendSocketMsg {

    private String messNote;
    private String messType;
    private String groupId;
    private String receiverUid;
    private String dateStr;

    public String getMessNote() {
        return messNote;
    }

    public void setMessNote(String messNote) {
        this.messNote = messNote;
    }

    public String getMessType() {
        return messType;
    }

    public void setMessType(String messType) {
        this.messType = messType;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getReceiverUid() {
        return receiverUid;
    }

    public void setReceiverUid(String receiverUid) {
        this.receiverUid = receiverUid;
    }

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }
}
