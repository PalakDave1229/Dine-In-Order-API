package com.example.dio.service.impl;

import com.example.dio.service.QRCodeService;
import com.example.dio.util.QRCodeGenerator;
import com.google.zxing.WriterException;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class QRCodeServiceImpl implements QRCodeService {

    @Override
    public byte[] generateQRCode(String text, int width, int height) throws WriterException, IOException{
        return QRCodeGenerator.generateQRCodeImage(text, width, height);
    }
}
