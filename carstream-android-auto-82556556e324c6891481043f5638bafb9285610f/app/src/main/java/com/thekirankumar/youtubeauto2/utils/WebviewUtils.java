package com.thekirankumar.youtubeauto2.utils;

import android.util.Log;
import android.webkit.WebView;

import com.thekirankumar.youtubeauto2.webview.VideoEnabledWebView;

/**
 * Created by kiran.kumar on 06/01/18.
 */

public class WebviewUtils {
    private static final String FILE_BROWSER_SCRIPT_PATH = "file:///android_asset/filebrowser.js";
    private static final String FILE_BROWSER_CSS_PATH = "file:///android_asset/filebrowser.css";

    public static void injectCustomSelectDropDown(WebView webView) {
        Log.d("DropDown", "Yep");
        String injection = ("javascript:for(i=0;i<document.getElementsByTagName('select').length;i++){" +
                "document.getElementsByTagName('select')[i].onclick=function(){" +
                "if(this.selectedIndex < this.options.length-1) {" +
                "this.selectedIndex++" +
                "} else {" +
                "this.selectedIndex=0" +
                "}" +
                "this.dispatchEvent(new Event('change', { bubbles: true }));" +
                "};}");
        webView.loadUrl(injection);

    }
    public static void injectQualityControl(WebView webView) {
        String url = webView.getUrl();
        if (url != null) {
            Log.d("InjectedQualityControl", url);
            String injection = (
                    "var bool_url;\n"+
                    //"document.addEventListener('click', function(){setTimeout(s, 1000);});\n"+
                    "function s(){\n"+
                    //"let b = document.getElementsByTagName('c3-material-button')[0].cloneNode(true);\n" +
                    //"while (b.firstChild){b.removeChild(b.firstChild);}\n" +
                            "let m = document.getElementsByTagName('ytm-menu')[0];\n" +
                        //"b.appendChild(m.getElementsByTagName('button')[0]);\n" +
                        "document.getElementsByClassName('slim-video-metadata-actions')[0].appendChild(m);}\n" +
                            "function b(){"+
                            "let url = window.location.href;\n"+
                            "if (url.includes('watch') && !bool_url){ bool_url=1; s(); } else bool_url=0;}\n" +
                            "setInterval(function(){ b(); }, 500);\n");
            webView.loadUrl("javascript:" + injection);
        }
    }
    public static void injectNightModeCss(WebView webView){
        String url = webView.getUrl();
        Log.d("NightModeInjected", url);
        if (url != null) {
            String injection = ("javascript:var css = 'html {background-color: #000 !important;}\n" +
                    "div.page-container{ color: #fff !important;}\n" +
                    "div.mobile-topbar-header-content{ color: hsla(0, 0%, 100%, 0.6) !important;}\n" +
                    "ytm-mobile-topbar-renderer.sticky-player {background-color: #000 !important;}\n" +
                    "c3-icon.mobile-topbar-logo{ color: #fff !important;}\n" +
                    "ytm-pivot-bar-renderer{ background-color: #000 !important; color: #fff !important;}\n" +
                    "div.slim-video-metadata-actions{color:hsla(0, 33.3%, 97.1%, 0.6);}\n" +
                    "ytm-app.sticky-player {padding-top: 10px !important;}\n" +
                    ".player-container.sticky-player {top: 0px !important;}';\n" +
                    "var head  = document.getElementsByTagName('head')[0];\n" +
                    "var style  = document.createElement('style');\n" +
                    "style.type = 'text/css';\n" +
                    "document.getElementsByTagName(\"ytm-mobile-topbar-renderer\")[0].style.display = 'none';\n" +
                    "style.appendChild(document.createTextNode(css));\n"+
                    "head.appendChild(style);");
            webView.loadUrl(injection);
        }
    }

    public static void injectFileListingHack(VideoEnabledWebView webView) {
        String url = webView.getUrl();
        Log.d("FileListing", url);
        if (url != null && url.startsWith("file:///") && url.endsWith("/")) {

            String js = ("javascript:var oldHead = document.head.innerHTML;" +
                    "    var head  = document.body;\n" +
                    "    var link  = document.createElement('link');\n" +
                    "    link.rel  = 'stylesheet';\n" +
                    "    link.type = 'text/css';\n" +
                    "    link.href = '" + FILE_BROWSER_CSS_PATH+"';\n" +
                    "    link.media = 'all';\n" +
                    "    head.appendChild(link);\n" +
                    "var script = document.createElement('script');" +
                    "script.src = '" + FILE_BROWSER_SCRIPT_PATH + "';" +
                    "head.appendChild(script);"+
                    "document.body.innerHTML+= '<h3 id=\"header\">LOCATION</h1><div id=\"parentDirLinkBox\" style=\"display:none\"><a id=\"parentDirLink\" class=\"icon up\"><span id=\"parentDirText\">[parent directory]</span></a> </div> <table> <thead> <tr class=\"header\" id=\"theader\"><th onclick=\"javascript:sortTable(0);\">Name</th><th class=\"detailsColumn\" onclick=\"javascript:sortTable(1);\">Size </th> <th class=\"detailsColumn\" onclick=\"javascript:sortTable(2);\">Date Modified </th> </tr> </thead> <tbody id=\"tbody\"> </tbody> </table>';" +
                    "document.body.innerHTML+= oldHead;");
            webView.loadUrl(js);
        }
    }

}
