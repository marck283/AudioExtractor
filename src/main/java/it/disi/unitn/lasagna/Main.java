package it.disi.unitn.lasagna;

import it.disi.unitn.FFMpeg;
import it.disi.unitn.FFMpegBuilder;
import it.disi.unitn.exceptions.InvalidArgumentException;
import it.disi.unitn.videocreator.transcoder.VideoTranscoder;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String @NotNull [] args) {
        if(args.length < 2) {
            System.err.println("Not enough arguments!");
            System.exit(1);
        }

        try {
            FFMpegBuilder builder = new FFMpegBuilder("ffmpeg");
            VideoTranscoder transcoder = new VideoTranscoder(builder, args[1]);
            transcoder.addInput(args[0]);
            transcoder.enableAudioExtraction();
            transcoder.createCommand();

            FFMpeg ffmpeg = builder.build();
            ffmpeg.executeCMD(1, TimeUnit.MINUTES, "./", null);
        } catch (InvalidArgumentException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}