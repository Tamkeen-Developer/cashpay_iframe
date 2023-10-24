package com.tamkeen.cashpaysdk;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class CashPay extends BottomSheetDialogFragment {
    OnReply onReply;
    String url;

    public CashPay(String url, OnReply onReply) {
        this.onReply = onReply;
        this.url = url;
    }

    public static CashPay getInstance(String url, OnReply onReply) {
        return new CashPay(url, onReply);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.cash_pay_ifream, container, false);
    }

    @Override
    public int getTheme() {
        return R.style.BaseBottomSheetDialog;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //getDialog().getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,
        //     WindowManager.LayoutParams.FLAG_SECURE);
        WebView webView = view.findViewById(R.id.web);
//        webView.loadUrl(url);
        webView.loadUrl("https://www.geeksforgeeks.org");
        // this will enable the javascript.
//        webView.getSettings().setJavaScriptEnabled(true);

        // WebViewClient allows you to handle
        // onPageFinished and override Url loading.
        webView.setWebViewClient(new WebViewClient());

    }

}
