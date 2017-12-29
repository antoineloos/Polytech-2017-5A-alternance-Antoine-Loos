package com.polytech.epulapp.tpandroidpolytech.services;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;

import com.polytech.epulapp.tpandroidpolytech.models.Beer;

import java.lang.ref.WeakReference;
import java.net.URL;


/**
 * Created by Epulapp on 29/12/2017.
 */

public class ThumbnailDownloadTask extends AsyncTask<URL, Void,Bitmap> {

    private final WeakReference<ImageView> imageViewReference;
    private Beer beer;
    public int progresspercent;

    public ThumbnailDownloadTask(ImageView thbView, Beer b)
    {
        imageViewReference = new WeakReference<ImageView>(thbView);
        this.beer = b;
    }

    @Override
    protected Bitmap doInBackground(URL... urls) {

           return Downloader.DownloadBitmap(urls[0]);
    }


    protected void onProgressUpdate(Integer... progress) {
        setProgressPercent(progress[0]);
    }


    @Override
    protected void onPostExecute(Bitmap bitmap) {
        if (isCancelled()) {
            bitmap = null;
        }



            ImageView imageView = imageViewReference.get();
            if (imageView != null) {
                if (bitmap != null) {
                    imageView.setImageBitmap(bitmap);
                    beer.setBeerThumbnail(bitmap);
                }
            }


    }

    private void  setProgressPercent(int percent)
    {
        this.progresspercent = percent;
    }

}
