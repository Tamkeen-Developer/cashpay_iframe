package com.tamkeen.cashpay_sdk;

public interface OnReply {
    /**
     * تم الدفع بنجاح يرجى التحقق من عملية الدفع
     */
    public void onNeedToCheck();


    /**
     * الغاء عملية الدفع
     */
    public void onCancel();

}
