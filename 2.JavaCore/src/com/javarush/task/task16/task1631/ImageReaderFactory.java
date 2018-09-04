package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader Reader;
    public static ImageReader getImageReader(ImageTypes it) {
        if (it==ImageTypes.BMP) {
            Reader = new BmpReader();
        } else if (it==ImageTypes.JPG) {
            Reader = new JpgReader();
        } else if (it==ImageTypes.PNG) {
            Reader = new PngReader();
        } else {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }
        return Reader;
    }
}
