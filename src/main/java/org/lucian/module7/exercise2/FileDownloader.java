package org.lucian.module7.exercise2;

/**
 * FileDownloader simulates downloading a file by printing progress and sleeping.
 */
public class FileDownloader implements Runnable {
    private final String fileName;
    private final DownloadManager manager;

    public FileDownloader(String fileName, DownloadManager manager) {
        this.fileName = fileName;
        this.manager = manager;
    }

    @Override
    public void run() {
        manager.updateProgress(fileName, "Starting download: " + fileName);
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(200 + (int)(Math.random() * 300)); // Simulate variable download chunk time
            } catch (InterruptedException e) {
                manager.updateProgress(fileName, fileName + " download interrupted");
                return;
            }
            manager.updateProgress(fileName, fileName + " - Downloaded " + (i * 10) + "%");
        }
        manager.updateProgress(fileName, "Download complete: " + fileName);
    }
}
