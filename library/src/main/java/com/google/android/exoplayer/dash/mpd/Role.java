package com.google.android.exoplayer.dash.mpd;


public class Role {
    public final String schemeIdUri;
    public final String value;

    public Role(String schemeIdUri, String value) {
        this.schemeIdUri = schemeIdUri;
        this.value = value;
    }
}
