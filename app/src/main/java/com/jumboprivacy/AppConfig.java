package com.jumboprivacy;

import android.content.Context;
import android.content.SharedPreferences;

public class AppConfig {

    private String FILE_NAME = "config_file";
    private String KEY_VERSION = "version";
    private String KEY_CONTENT = "content";

    private SharedPreferences sharedPreferences;

    public AppConfig(Context context) {
        sharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
    }

    public String getVersion() {
        return sharedPreferences.getString(KEY_VERSION, null);
    }

    public void setVersion(String version) {
        sharedPreferences.edit().putString(KEY_VERSION, version).apply();
    }

    /**
     * @return decoded payload content
     */
    public String getContent() {
        return sharedPreferences.getString(KEY_CONTENT, null);
    }

    /**
     * @param content decoded content
     */
    public void setContent(String content) {
        sharedPreferences.edit().putString(KEY_CONTENT, content).apply();
    }
}
