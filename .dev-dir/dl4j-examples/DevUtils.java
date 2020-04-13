package org.deeplearning4j.examples.utils;

import org.apache.commons.io.FileUtils;
import org.bytedeco.javacpp.Pointer;
import org.nd4j.linalg.factory.Nd4j;

import java.util.concurrent.atomic.AtomicLong;

public class DevUtils {

    private DevUtils() {
    }

    public static void logMemoryConfig() {

        long mb = Pointer.maxBytes();
        long mpb = Pointer.maxPhysicalBytes();
        long xmx = Runtime.getRuntime().maxMemory();

        System.out.println("JavaCPP max bytes:          " + FileUtils.byteCountToDisplaySize(mb));
        System.out.println("JavaCPP max physical bytes: " + FileUtils.byteCountToDisplaySize(mpb));
        System.out.println("JVM XMX:                    " + FileUtils.byteCountToDisplaySize(xmx));
    }


    public static AtomicLong[] startMemoryLoggingThread(final long msFreq) {
        Nd4j.create(1);

        final AtomicLong maxPhysBytes = new AtomicLong(Pointer.physicalBytes());
        final AtomicLong maxBytes = new AtomicLong(Pointer.totalBytes());
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(msFreq);
                        ;
                    } catch (InterruptedException e) {
                    }
                    long b = Pointer.totalBytes();
                    long pb = Pointer.physicalBytes();
                    maxBytes.set(b);
                    maxPhysBytes.set(pb);
                    System.out.println("JavaCPP Memory: "+b+ "total, "+pb+" physical");
                }
            }
        });
        t.setDaemon(true);
        t.start();

        return new AtomicLong[]{maxBytes, maxPhysBytes};
    }
}

