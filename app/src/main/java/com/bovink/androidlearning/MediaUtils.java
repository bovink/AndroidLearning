package com.bovink.androidlearning;

import android.media.MediaExtractor;
import android.media.MediaFormat;

import java.io.IOException;

/**
 * @author bovink
 * @since 2018/12/24
 */
public class MediaUtils {

    private String TAG = "MediaUtils";

    enum MediaType {Video, Audio}

    public static MediaFormat getMediaFormat(MediaExtractor mediaExtractor, MediaType mediaType, String mediaPath) {
        MediaFormat mediaFormat;

        try {
            mediaExtractor.setDataSource(mediaPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int track = 0;
        String type;
        if (mediaType == MediaType.Video) {
            type = "video/";
        } else {
            type = "audio/";
        }
        int trackCount = mediaExtractor.getTrackCount();
        for (int i = 0; i < trackCount; i++) {
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
            String mineType = trackFormat.getString(MediaFormat.KEY_MIME);
            // video or audio track
            if (mineType.startsWith(type)) {
                track = i;
            }
        }

        mediaExtractor.selectTrack(track);
        mediaFormat = mediaExtractor.getTrackFormat(track);


        return mediaFormat;
    }
}
