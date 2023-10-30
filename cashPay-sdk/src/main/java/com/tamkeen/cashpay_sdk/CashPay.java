package com.tamkeen.cashpay_sdk;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.Objects;

public class CashPay extends BottomSheetDialogFragment {
    OnReply onReply;
    String url;
    ProgressBar progressBar;
    JavascriptHandler javascriptHandler;

    public CashPay(String url, OnReply onReply) {
        this.onReply = onReply;
        this.url = url;
        javascriptHandler = new JavascriptHandler();
    }

    /**
     * @param url pass iframeUrl
     * @param onReply
     * @return
     */
    public static CashPay getInstance(String url, OnReply onReply) {
        return new CashPay(url, onReply);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.cash_pay_ifream, container, false);
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.BaseBottomSheetDialog);
    }


    @SuppressLint("JavascriptInterface")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Objects.requireNonNull(getDialog()).getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,
                WindowManager.LayoutParams.FLAG_SECURE);
        WebView webView = view.findViewById(R.id.web);
        progressBar = view.findViewById(R.id.progressBar);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);


        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {

                progressBar.setVisibility(View.VISIBLE);
            }
            @Override
            public void onPageCommitVisible(WebView view, String url) {
                progressBar.setVisibility(View.GONE);
            }
        });
        webView.addJavascriptInterface(javascriptHandler, "android");

        webView.loadUrl(url);
        this.setCancelable(false);
        webView.clearCache(true);
    }


    public class JavascriptHandler {
        public JavascriptHandler() {
        }

        @JavascriptInterface
        public void postMessage(String mes) {

            if (mes.equals("Cancel")) {
                onReply.onCancel();
                dismiss();
            } else if (mes.equals("NEEDTOCHECK")) {
                onReply.onNeedToCheck();
                dismiss();
            }
//            return false;
        }

    }
}
