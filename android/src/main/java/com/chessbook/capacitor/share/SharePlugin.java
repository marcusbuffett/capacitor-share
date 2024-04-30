package com.chessbook.capacitor.share;

import android.content.Intent;
import android.net.Uri;

import android.content.Context;
import androidx.core.content.FileProvider;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@CapacitorPlugin(name = "Share")
public class SharePlugin extends Plugin {
    @PluginMethod
    public void share(PluginCall call) {
        JSObject ret = new JSObject();
        ret.put("result", "success");
        String filename = call.getString("filename");
        String text = call.getString("text");
        Context context = getContext();

        File fileDir = context.getCacheDir();
        File file = new File(fileDir, filename);


        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(text.getBytes());
            fileOutputStream.close();

            Uri fileUri = FileProvider.getUriForFile(
                    context,
                    context.getPackageName() + ".fileprovider",
                    file
            );

            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("*/*");
            shareIntent.putExtra(Intent.EXTRA_STREAM, fileUri);
            shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

            Intent chooserIntent = Intent.createChooser(shareIntent, "Share File");
            chooserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            context.startActivity(chooserIntent);
        } catch (IOException e) {
            e.printStackTrace();
        }

        call.resolve(ret);
    }
}
