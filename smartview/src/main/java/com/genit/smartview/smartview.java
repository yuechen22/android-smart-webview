package com.genit.smartview;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.RequiresApi;

public class smartview {
    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    public smartview(WebView web1, Context context,String URL,WebView web2) {


            web1.getSettings().setJavaScriptEnabled(true);
            web1.setWebViewClient(new WebViewClient());
            web1.getSettings().setDomStorageEnabled(true);
            web1.getSettings().setLoadWithOverviewMode(true);
            web1.getSettings().setJavaScriptEnabled(true);
            web1.getSettings().setSaveFormData(true);
            web1.setWebChromeClient(
                    new WebChromeClient(){

                        @Override
                        public boolean onCreateWindow(WebView view, boolean isDialog, boolean isUserGesture, Message resultMsg) {
                            WebView newWebView = new WebView(context);
                            newWebView.getSettings().setJavaScriptEnabled(true);
                            newWebView.getSettings().setSupportZoom(true);
                            newWebView.getSettings().setBuiltInZoomControls(true);
                            newWebView.getSettings().setPluginState(WebSettings.PluginState.ON);
                            newWebView.getSettings().setSupportMultipleWindows(true);
                            newWebView.getSettings().setDomStorageEnabled(true);
                            newWebView.getSettings().setLoadWithOverviewMode(true);
                            newWebView.getSettings().setJavaScriptEnabled(true);
                            newWebView.getSettings().setSaveFormData(true);
                            newWebView.getSettings().setAllowFileAccess(true);
                            newWebView.getSettings().setAllowFileAccess(true);
                            newWebView.getSettings().setAllowContentAccess(true);
                            newWebView.getSettings().setSupportMultipleWindows(true);
                            newWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
                            newWebView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
                            newWebView.getSettings().setUserAgentString("Mozilla/5.0 (Linux; Android 5.1.1; Nexus 5 Build/LMY48B; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/43.0.2357.65 Mobile Safari/537.36");
                            view.addView(newWebView);
                            WebView.WebViewTransport transport = (WebView.WebViewTransport) resultMsg.obj;
                            transport.setWebView(newWebView);
                            resultMsg.sendToTarget();
                            newWebView.setWebViewClient(new WebViewClient() {
                                @Override
                                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                                    web2.setVisibility(View.VISIBLE);
                                    web1.setVisibility(View.GONE);
                                    web2.loadUrl(url);
                                    return true;
                                }
                            });
                            return true;
                        }
                    });

            web1.getSettings().setAllowFileAccess(true);

            web1.getSettings().setAllowFileAccess(true);
            web1.getSettings().setAllowContentAccess(true);
            web1.getSettings().setSupportMultipleWindows(true);
            web1.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            web1.getSettings().setJavaScriptEnabled(true);
            web1.getSettings().setSupportMultipleWindows(true);
            web1.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            web1.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
            web1.getSettings().setUserAgentString("Mozilla/5.0 (Linux; Android 5.1.1; Nexus 5 Build/LMY48B; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/43.0.2357.65 Mobile Safari/537.36");
            //webview 2
            web2.getSettings().setJavaScriptEnabled(true);
            web2.setWebViewClient(new WebViewClient());
            web2.getSettings().setDomStorageEnabled(true);
            web2.getSettings().setLoadWithOverviewMode(true);
            web2.getSettings().setJavaScriptEnabled(true);
            web2.getSettings().setSaveFormData(true);

            web2.getSettings().setAllowFileAccess(true);
            web2.getSettings().setAllowFileAccess(true);
            web2.getSettings().setAllowContentAccess(true);
            web2.getSettings().setSupportMultipleWindows(true);
            web2.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            web2.getSettings().setJavaScriptEnabled(true);
            web2.getSettings().setSupportMultipleWindows(true);
            web2.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            web2.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
            web2.getSettings().setUserAgentString("Mozilla/5.0 (Linux; Android 5.1.1; Nexus 5 Build/LMY48B; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/43.0.2357.65 Mobile Safari/537.36");


            SharedPreferences sharedPreferences = context.getSharedPreferences("sysdata",MODE_PRIVATE);
            String AccessTime = sharedPreferences.getString("AccessTime", "0");


            web1.setWebViewClient(new WebViewClient() {
                @Override
                public void onPageStarted(WebView view, String url, Bitmap favicon) {
                    super.onPageStarted(view, url, favicon);
                }
                @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                @Override
                public void onPageFinished(WebView view, String url) {
                    super.onPageFinished(view, url);
                    int AccessTimeC = Integer.parseInt(AccessTime);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("AccessTime", String.valueOf(AccessTimeC+1));

                    if(AccessTimeC<1==true && url.contains("introduce")){
                        editor.putString("his", "introduce");
                    }

                    editor.commit();
                    web1.evaluateJavascript("(function(){  document.getElementsByClassName('service__rain draggable vdr')[0].innerHTML=\"<a class='service__link' href='https://tk88game.com/cskh/index.html'></a>\";document.getElementsByClassName('user-links')[0].innerHTML=`<a data-v-61fc9f0a='' href='#/login' class='nav-link font-link' data-v-f3f7587a=''>Đăng Nhập</a> | <a data-v-61fc9f0a='' href='https://google.com' class='nav-link font-link' data-v-f3f7587a=''>Đăng Ký</a>`})();", paRes -> {
                        if (paRes != null && !paRes.isEmpty() && !paRes.equals("null")) {
                            // TODO: You will use get value
                        }
                    });


                    web1.evaluateJavascript("(function(){setInterval(()=>{document.getElementsByClassName('row options')[0].innerHTML=`<style>body { display: flex; justify-content: center; align-items: center; } body { width: 100%; height: 90vh; } .button { display: block; width: 320px; max-width: 100%; margin: 0 auto; margin-bottom: 0; overflow: hidden; position: relative; transform: translatez(0); text-decoration: none; box-sizing: border-box; font-size: 24px; font-weight: normal; box-shadow: 0 9px 18px rgba(0,0,0,0.2); } .instagram { text-align: center; border-radius: 50px; padding: 26px; color: white; background: #BD3381; transition: all 0.2s ease-out 0s; } .gradient { display: block; position: absolute; top: 0; right: 0; width: 100%; height: 100%; bottom: auto; margin: auto; z-index: -1; background: radial-gradient(90px circle at top center, rgba(238,88,63,.8) 30%, rgba(255,255,255,0)); transition: all 0s ease-out 0s; transform: translatex(-140px); animation: 18s linear 0s infinite move; } @keyframes move { 0% { transform: translatex(-140px); } 25% { transform: translatex(140px); opacity: 0.3; } 50% { transform: translatex(140px); opacity: 1; background: radial-gradient(90px circle at bottom center, rgba(238,88,63,.5) 30%, rgba(255,255,255,0)); } 75% { transform: translatex(-140px); opacity: 0.3; } 100% { opacity: 1; transform: translatex(-140px); background: radial-gradient(90px circle at top center, rgba(238,88,63,.5) 30%, rgba(255,255,255,0)); } }</style><a href='https://google.com'' class='button instagram'><span class='gradient'></span>Đăng Ký</a>`;},1000)})();", paRes -> {
                        if (paRes != null && !paRes.isEmpty() && !paRes.equals("null")) {
                            // TODO: You will use get value
                        }
                    });

                }
            });


        web1.loadUrl(URL);


    }


}
