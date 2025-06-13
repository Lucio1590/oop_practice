package org.lucian.module7.exercise2;

public class Main {
    public static void main(String[] args) {
        DownloadManager manager = new DownloadManager(3);
        Thread t1 = new Thread(new FileDownloader("image.jpg", manager));
        Thread t2 = new Thread(new FileDownloader("video.mp4", manager));
        Thread t3 = new Thread(new FileDownloader("document.pdf", manager));

        t1.start();
        t2.start();
        t3.start();
    }
}
