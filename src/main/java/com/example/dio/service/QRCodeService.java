package com.example.dio.service;

import com.google.zxing.WriterException;

import java.io.IOException;

public interface QRCodeService {
    byte[] generateQRCode(String text, int width, int height) throws WriterException, IOException;
}
