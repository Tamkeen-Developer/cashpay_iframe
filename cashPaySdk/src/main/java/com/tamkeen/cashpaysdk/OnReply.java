package com.tamkeen.cashpaysdk;

public interface OnReply {
    public void onSuccess(String message);
    public void onCancel(String message);
    public void onError(String message);
}
